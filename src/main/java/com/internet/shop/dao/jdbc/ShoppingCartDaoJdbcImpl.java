package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.exceptions.DataProcessingException;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
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
public class ShoppingCartDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        String query = "INSERT INTO shopping_carts (user_id) VALUES (?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, shoppingCart.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                shoppingCart.setId(resultSet.getLong(1));
            }
            statement.close();
            addProductsToCart(shoppingCart, connection);
            return shoppingCart;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add " + shoppingCart + " to the database.", e);
        }
    }

    @Override
    public Optional<ShoppingCart> getById(Long userId) {
        String query = "SELECT * FROM shopping_carts "
                + "WHERE user_id = ? AND deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            ShoppingCart cart = null;
            if (resultSet.next()) {
                cart = retrieveCartFromResultSet(resultSet, connection);
            }
            statement.close();
            Long cartId = cart.getId();
            cart.setProducts(getProductsInCart(cartId, connection));
            return Optional.ofNullable(cart);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find the shopping cart for user id " + userId
                    + " in the database.", e);
        }
    }

    @Override
    public List<ShoppingCart> getAll() {
        String query = "SELECT * FROM shopping_carts WHERE deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<ShoppingCart> carts = new ArrayList<>();
            while (resultSet.next()) {
                carts.add(retrieveCartFromResultSet(resultSet, connection));
            }
            statement.close();
            for (ShoppingCart cart : carts) {
                Long cartId = cart.getId();
                cart.setProducts(getProductsInCart(cartId, connection));
            }
            return carts;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't retrieve shoppingCarts from the database.", e);
        }
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        String query = "DELETE FROM shopping_carts_products WHERE cart_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setLong(1, shoppingCart.getId());
            statement.executeUpdate();
            statement.close();
            addProductsToCart(shoppingCart, connection);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update shopping cart "
                    + shoppingCart, e);
        }
        return shoppingCart;
    }

    @Override
    public boolean deleteById(Long id) {
        String query = "UPDATE shopping_carts SET deleted = true "
                + "WHERE cart_id = ? AND deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete the shopping cart with id " + id
                    + " from the database.", e);
        }
    }

    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        Long id = shoppingCart.getId();
        return deleteById(id);
    }

    private void addProductsToCart(ShoppingCart shoppingCart, Connection connection)
            throws SQLException {
        String query = "INSERT INTO shopping_carts_products (cart_id, product_id) "
                + "VALUES (?, ?);";
        for (Product product : shoppingCart.getProducts()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, shoppingCart.getId());
            statement.setLong(2, product.getId());
            statement.executeUpdate();
            statement.close();
        }
    }

    private List<Product> getProductsInCart(Long cartId, Connection connection)
            throws SQLException {
        String query = "SELECT * FROM products p JOIN shopping_carts_products sp "
                + "ON p.product_id = sp.product_id "
                + "WHERE cart_id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, cartId);
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getBigDecimal("price").doubleValue();
            Product product = new Product(name, price);
            product.setId(resultSet.getLong("product_id"));
            products.add(product);
        }
        statement.close();
        return products;
    }

    private ShoppingCart retrieveCartFromResultSet(ResultSet resultSet, Connection connection)
            throws SQLException {
        Long cartId = resultSet.getLong("cart_id");
        Long userId = resultSet.getLong("user_id");
        ShoppingCart shoppingCart = new ShoppingCart(userId);
        shoppingCart.setId(cartId);
        return shoppingCart;
    }
}
