package com.example.project.dao.daoImpl;

import com.example.project.entity.User;
import com.example.project.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.project.dbConnection.getConnection;

public class UserDaoImpl implements UserDao {
    @Override
    public void create(User user) {
        String sql = "INSERT INTO `user` (`user_id`, `name`, `surname`, `role`, `login`, `password`) VALUES (?, ?, ?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, user.getId());
            s.setString(2, user.getName());
            s.setString(3, user.getSurname());
            s.setString(4, user.getRole());
            s.setString(5, user.getLogin());
            s.setString(6, user.getPassword());
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
    }

    @Override
    public User read(Long id) {
        String sql = "SELECT `user_id`, `name`, `surname`, `role`, `login`, `password` FROM `user` WHERE `user_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, id);
            r = s.executeQuery();
            User user=null;
            while (r.next()) {
                user = new User();
                user.setId(r.getLong("user_id"));
                user.setName(r.getString("name"));
                user.setSurname(r.getString("surname"));
                user.setRole(r.getString("role"));
                user.setLogin(r.getString("login"));
                user.setPassword(r.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
        return null;
    }



    @Override
    public List readAll() {
        String sql = "SELECT `user_id`, `name`, `surname`, `role`, `login`, `password` FROM `user` ";

        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while (r.next()) {
                User user = new User();
                user.setId(r.getLong("user_id"));
                user.setName(r.getString("name"));
                user.setSurname(r.getString("surname"));
                user.setRole(r.getString("role"));
                user.setLogin(r.getString("login"));
                user.setPassword(r.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
            }
        }

        return null;
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "UPDATE `user` SET `name` = ?, `surname` = ?, `role` = ?, `login` = ?, `password` = ? WHERE `user_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, user.getName());
            s.setString(2, user.getSurname());
            s.setString(3, user.getRole());
            s.setString(4, user.getLogin());
            s.setString(5, user.getPassword());
            s.setLong(6, user.getId());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }


    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM `user` WHERE `user_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, id);
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
    }

    @Override
    public User readByLoginAndPassword(String login, String password) {
        String sql = "SELECT `user_id`, `name`, `surname`, `role` FROM `user` WHERE `login` = ? AND `password` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, login);
            s.setString(2, password);
            r = s.executeQuery();
            User user = null;
            while (r.next()) {
                user = new User();
                user.setId(r.getLong("user_id"));
                user.setName(r.getString("name"));
                user.setSurname(r.getString("surname"));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(r.getString("role"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
        return null;
    }}
