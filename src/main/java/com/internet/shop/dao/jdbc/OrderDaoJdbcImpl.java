package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.OrderDao;
import com.internet.shop.exceptions.DataProcessingException;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import com.internet.shop.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class OrderDaoJdbcImpl implements OrderDao {
    @Override
    public List<Order> getUserOrders(Long userId) {
        String query = "SELECT o.order_id, o.user_id, o.deleted FROM orders o"
                + " INNER JOIN users u ON o.user_id = u.user_id"
                + " WHERE o.user_id = ? AND o.deleted = false AND u.deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(retrieveOrderFromResultSet(resultSet, connection));
            }
            return orders;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get orders for user with id " + userId, e);
        }
    }

    @Override
    public Order create(Order order) {
        String query = "INSERT INTO orders (user_id) VALUES (?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, order.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getLong(1));
            }
            addProductsToOrder(order, connection);
            return order;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't complete the order " + order, e);
        }
    }

    @Override
    public Optional<Order> getById(Long id) {
        String query = "SELECT * FROM orders "
                + "WHERE order_id = ? AND deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(retrieveOrderFromResultSet(resultSet, connection));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find the order with id " + id
                    + " in the database.", e);
        }
    }

    @Override
    public List<Order> getAll() {
        String query = "SELECT * FROM orders WHERE deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(retrieveOrderFromResultSet(resultSet, connection));
            }
            return orders;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't retrieve orders from the database.", e);
        }
    }

    @Override
    public Order update(Order order) {
        String query = "DELETE FROM orders_products WHERE order_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, order.getId());
            statement.executeUpdate();
            addProductsToOrder(order, connection);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update order "
                    + order, e);
        }
        return order;
    }

    @Override
    public boolean deleteById(Long id) {
        String query = "UPDATE orders SET deleted = true "
                + "WHERE order_id = ? AND deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete the order with id " + id
                    + " from the database.", e);
        }
    }

    private void addProductsToOrder(Order order, Connection connection) throws SQLException {
        String query = "INSERT INTO orders_products (order_id, product_id) VALUES (?, ?);";
        for (Product product : order.getProducts()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, order.getId());
            statement.setLong(2, product.getId());
            statement.executeUpdate();
        }
    }

    private List<Product> getProductsInOrder(Long id, Connection connection) throws SQLException {
        String query = "SELECT * FROM products p JOIN orders_products op "
                + "ON p.product_id = op.product_id "
                + "WHERE order_id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getBigDecimal("price").doubleValue();
            Product product = new Product(name, price);
            product.setId(resultSet.getLong("product_id"));
            products.add(product);
        }
        return products;
    }

    private Order retrieveOrderFromResultSet(ResultSet resultSet, Connection connection)
            throws SQLException {
        Long orderId = resultSet.getLong("order_id");
        Long userId = resultSet.getLong("user_id");
        Order order = new Order(userId);
        order.setId(orderId);
        order.setProducts(getProductsInOrder(orderId, connection));
        return order;
    }
}
