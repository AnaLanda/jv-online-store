package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.UserDao;
import com.internet.shop.exceptions.DataProcessingException;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;
import com.internet.shop.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Dao
public class UserDaoJdbcImpl implements UserDao {
    @Override
    public User create(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "INSERT INTO users (name, login, password) VALUES (?, ?, ?);";
            PreparedStatement statement =
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
            }
            addUserRoles(user);
            return user;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add " + user + " to the database.", e);
        }
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM users WHERE login = ? AND deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(retrieveUserFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find the user with login " + login
                    + " in the database.", e);
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM users JOIN users_roles "
                    + "ON users.user_id = users_roles.user_id "
                    + "JOIN roles ON users_roles.role_id = roles.role_id "
                    + "WHERE users.user_id = ? AND deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(retrieveUserFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find the user with id " + id
                    + " in the database.", e);
        }
    }

    @Override
    public List<User> getAll() {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT * FROM users WHERE deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(retrieveUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't retrieve users from the database.", e);
        }
    }

    @Override
    public User update(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "UPDATE users SET name = ?, login = ?, password = ? "
                    + "WHERE user_id = ? AND deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update " + user + " in the database.", e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "UPDATE users SET deleted = true "
                    + "WHERE user_id = ? AND deleted = false;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete the user with id " + id
                    + " from the database.", e);
        }
    }

    private void addUserRoles(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "INSERT INTO users_roles (user_id, role_id) VALUES (?, ?);";
            for (Role role : user.getRoles()) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, user.getId());
                statement.setLong(2, getRoleId(role.getRoleName()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add roles for the user " + user, e);
        }
    }

    private Set<Role> getUserRoles(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT role_name FROM roles JOIN users_roles "
                    + "ON users_roles.role_id = roles.role_id "
                    + "WHERE user_id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Set<Role> roles = new HashSet<>();
            while (resultSet.next()) {
                roles.add(Role.of(resultSet.getString("role_name")));
            }
            return roles;
        } catch (SQLException exception) {
            throw new DataProcessingException(exception.getMessage(), exception);
        }
    }

    private Long getRoleId(Role.RoleName roleName) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "SELECT role_id FROM roles WHERE role_name = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, roleName.name());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Long roleId = resultSet.getLong("role_id");
            return roleId;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get the role id for role " + roleName, e);
        }
    }

    private User retrieveUserFromResultSet(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        Long id = resultSet.getLong("user_id");
        Set<Role> roles = getUserRoles(id);
        User user = new User(name, login, password);
        user.setId(id);
        user.setRoles(roles);
        return user;
    }
}
