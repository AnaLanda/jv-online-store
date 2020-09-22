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
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "INSERT INTO shopping_carts (user_id) VALUES (?);";
            PreparedStatement statement =
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, shoppingCart.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                shoppingCart.setId(resultSet.getLong(1));
            }
            addProductsToCart(shoppingCart);
            return shoppingCart;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add " + shoppingCart + " to the database.", e);
        }
    }

    @Override
    public Optional<ShoppingCart> getById(Long userId) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM shopping_carts "
                    + "WHERE user_id = ? AND deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(retrieveCartFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find the shopping cart for user id " + userId
                    + " in the database.", e);
        }
    }

    @Override
    public List<ShoppingCart> getAll() {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM shopping_carts WHERE deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<ShoppingCart> carts = new ArrayList<>();
            while (resultSet.next()) {
                carts.add(retrieveCartFromResultSet(resultSet));
            }
            return carts;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't retrieve shoppingCarts from the database.", e);
        }
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        String query = "DELETE FROM internet_shop.shopping_carts_products WHERE cart_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, shoppingCart.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update shopping cart "
                    + shoppingCart, e);
        }
        addProductsToCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "UPDATE shopping_carts SET deleted = true "
                    + "WHERE cart_id = ? AND deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete the product with id " + id
                    + " from the database.", e);
        }
    }

    @Override
    public boolean delete(ShoppingCart shoppingCart) {
        Long id = shoppingCart.getId();
        return deleteById(id);
    }

    private void addProductsToCart(ShoppingCart shoppingCart) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "INSERT INTO shopping_carts_products (cart_id, product_id) "
                    + "VALUES (?, ?);";
            for (Product product : shoppingCart.getProducts()) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, shoppingCart.getId());
                statement.setLong(2, product.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add products to the cart " + shoppingCart, e);
        }
    }

    private List<Product> getProductsInCart(Long cartId) {
        try (Connection connection = ConnectionUtil.getConnection()) {
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
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get products from cart with id" + cartId, e);
        }
    }

    private ShoppingCart retrieveCartFromResultSet(ResultSet resultSet)
            throws SQLException {
        Long cartId = resultSet.getLong("cart_id");
        Long userId = resultSet.getLong("user_id");
        ShoppingCart shoppingCart = new ShoppingCart(userId);
        shoppingCart.setId(cartId);
        shoppingCart.setProducts(getProductsInCart(cartId));
        return shoppingCart;
    }
}
