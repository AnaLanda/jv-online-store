package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.exceptions.DataProcessingException;
import com.internet.shop.model.Product;
import com.internet.shop.util.ConnectionUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductDaoJDBCImpl implements ProductDao {
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
        String query = "SELECT * FROM products WHERE id = ?";
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product update(Product item) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
