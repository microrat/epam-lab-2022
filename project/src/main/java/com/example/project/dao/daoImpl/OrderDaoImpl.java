package com.example.project.dao.daoImpl;

import com.example.project.dao.OrderDao;
import com.example.project.entity.Car;
import com.example.project.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.project.dbConnection.getConnection;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void create(Order order) {
        String sql = "INSERT INTO `order` (`order_id`, `user_id`, `car_id`, `passport`, `date_start`, `term`, `status`, `reject_reason`, `cost`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, order.getId());
            s.setLong(2, order.getUser_id());
            s.setLong(3, order.getCar_id());
            s.setString(4,order.getPassport());
            s.setDate(5, (Date) order.getDateStart());
            s.setInt(6,order.getTerm());
            s.setString(7,order.getStatus());
            s.setString(8,order.getRejectReason());
            s.setFloat(9,order.getCost());
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
    public Order read(Long id) {
        String sql = "SELECT `order_id`, `user_id`, `car_id`, `passport`, `date_start`, `term`, `status`, `reject_reason`, `cost` FROM `order` WHERE `order_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, id);
            r = s.executeQuery();
            Order order=null;
            while (r.next()) {
                order = new Order();
                order.setId(r.getLong("order_id"));
                order.setUser_id(r.getLong("user_id"));
                order.setCar_id(r.getLong("car_id"));
                order.setPassport(r.getString("passport"));
                order.setDateStart(r.getDate("date_start"));
                order.setTerm(r.getInt("term"));
                order.setStatus(r.getString("status"));
                order.setRejectReason(r.getString("reject_reason"));
                order.setCost(r.getFloat("cost"));
            }
            return order;
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
        String sql = "SELECT `order_id`, `user_id`, `car_id`, `passport`, `date_start`, `term`, `status`, `reject_reason`, `cost` FROM `order` ";

        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (r.next()) {
                Order order = new Order();
                order.setId(r.getLong("order_id"));
                order.setUser_id(r.getLong("user_id"));
                order.setCar_id(r.getLong("car_id"));
                order.setPassport(r.getString("passport"));
                order.setDateStart(r.getDate("date_start"));
                order.setTerm(r.getInt("term"));
                order.setStatus(r.getString("status"));
                order.setRejectReason(r.getString("reject_reason"));
                order.setCost(r.getFloat("cost"));
                orders.add(order);
            }
            return orders;
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
    public void update(Order order) throws SQLException {
        String sql = "UPDATE `order` SET  `user_id` = ?, `car_id` = ?, `passport` = ?, `date_start` = ?, `term` = ?, `status` = ?, `reject_reason` = ?, `cost` = ? WHERE `order_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, order.getUser_id());
            s.setLong(2, order.getCar_id());
            s.setString(3,order.getPassport());
            s.setDate(4, (Date) order.getDateStart());
            s.setInt(5,order.getTerm());
            s.setString(6,order.getStatus());
            s.setString(7,order.getRejectReason());
            s.setFloat(8,order.getCost());
            s.setLong(9, order.getId());
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
        String sql = "DELETE FROM `order` WHERE `order_id` = ?";
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
    public List<Order> readByUserConfirmed(Long user_id) {
        String sql = "SELECT `order_id`, `user_id`, `car_id`, `passport`, `date_start`, `term`, `status`, `reject_reason`, `cost` FROM `order` WHERE `user_id` = ? AND `status` = 'ok' ";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, user_id);
            r = s.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (r.next()) {
                Order order = new Order();
                order.setId(r.getLong("order_id"));
                order.setUser_id(r.getLong("user_id"));
                order.setCar_id(r.getLong("car_id"));
                order.setPassport(r.getString("passport"));
                order.setDateStart(r.getDate("date_start"));
                order.setTerm(r.getInt("term"));
                order.setStatus(r.getString("status"));
                order.setRejectReason(r.getString("reject_reason"));
                order.setCost(r.getFloat("cost"));
                orders.add(order);
            }
            return orders;
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
    public List<Order> readByUserRejected(Long user_id) {
        String sql = "SELECT `order_id`, `user_id`, `car_id`, `passport`, `date_start`, `term`, `status`, `reject_reason`, `cost` FROM `order` WHERE `user_id` = ? AND `status` = 'rejected' ";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, user_id);
            r = s.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (r.next()) {
                Order order = new Order();
                order.setId(r.getLong("order_id"));
                order.setUser_id(r.getLong("user_id"));
                order.setCar_id(r.getLong("car_id"));
                order.setPassport(r.getString("passport"));
                order.setDateStart(r.getDate("date_start"));
                order.setTerm(r.getInt("term"));
                order.setStatus(r.getString("status"));
                order.setRejectReason(r.getString("reject_reason"));
                order.setCost(r.getFloat("cost"));
                orders.add(order);
            }
            return orders;
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
    public List<Order> readByUserUncheked(Long user_id) {
        String sql = "SELECT `order_id`, `user_id`, `car_id`, `passport`, `date_start`, `term`, `status`, `reject_reason`, `cost` FROM `order` WHERE `user_id` = ? AND `status` = '' ";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, user_id);
            r = s.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (r.next()) {
                Order order = new Order();
                order.setId(r.getLong("order_id"));
                order.setUser_id(r.getLong("user_id"));
                order.setCar_id(r.getLong("car_id"));
                order.setPassport(r.getString("passport"));
                order.setDateStart(r.getDate("date_start"));
                order.setTerm(r.getInt("term"));
                order.setStatus(r.getString("status"));
                order.setRejectReason(r.getString("reject_reason"));
                order.setCost(r.getFloat("cost"));
                orders.add(order);
            }
            return orders;
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


}
