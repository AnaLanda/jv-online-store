package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.exceptions.DataProcessingException;
import com.internet.shop.model.Product;
import com.internet.shop.util.ConnectionUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoJdbcImpl implements ProductDao {
    @Override
    public Product create(Product item) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "INSERT * INTO products (name, price) VALUES (?, ?)";
            PreparedStatement statement =
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getName());
            statement.setBigDecimal(2, BigDecimal.valueOf(item.getPrice()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                item.setId(resultSet.getLong(1));
            }
            return item;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add " + item + " to the database.", e);
        }
    }

    @Override
    public Optional<Product> getById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM products WHERE id = ?";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return Optional.of(retrieveProductFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find product with id " + id + " in the database.", e);
        }
    }

    @Override
    public List<Product> getAll() {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM products";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(retrieveProductFromResultSet(resultSet));
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't retrieve products from the database.", e);
        }
    }

    @Override
    public Product update(Product item) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "UPDATE products SET name = ?, price = ? WHERE id = ?";
            PreparedStatement statement =
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getName());
            statement.setBigDecimal(2, BigDecimal.valueOf(item.getPrice()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                item.setId(resultSet.getLong(1));
            }
            return item;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add " + item + " to the database.", e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "DELETE FROM products WHERE id = ?";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery(query);
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete product with id " + id + " from the database.", e);
        }
    }

    private Product retrieveProductFromResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product(resultSet.getString("name"), resultSet.getBigDecimal("price").doubleValue());
        product.setId(resultSet.getLong("product_id"));
        return product;
    }
}
