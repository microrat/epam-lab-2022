package com.example.project.dao.daoImpl;

import com.example.project.dao.RefundDao;
import com.example.project.entity.Refund;
import com.example.project.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.project.dbConnection.getConnection;

public class RefundDaoImpl implements RefundDao {
    @Override
    public void create(Refund refund) {
        String sql = "INSERT INTO `refund` (`refund_id`, `order_id`, `damage`, `repair`) VALUES (?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, refund.getId());
            s.setLong(2, refund.getOrder_id());
            s.setString(3, refund.getDamage());
            s.setFloat(4, refund.getRepair());
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
    public Refund read(Long id) {
        String sql = "SELECT `refund_id`, `order_id`, `damage`, `repair` FROM `refund` WHERE `refund_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, id);
            r = s.executeQuery();
            Refund refund=null;
            while (r.next()) {
                refund = new Refund();
                refund.setId(r.getLong("refund_id"));
                refund.setOrder_id(r.getLong("order_id"));
                refund.setDamage(r.getString("damage"));
                refund.setRepair(r.getFloat("repair"));
            }
            return refund;
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
        String sql = "SELECT `refund_id`, `order_id`, `damage`, `repair` FROM `refund` ";

        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            List<Refund> refunds = new ArrayList<>();
            while (r.next()) {
                Refund refund = new Refund();
                refund.setId(r.getLong("refund_id"));
                refund.setOrder_id(r.getLong("order_id"));
                refund.setDamage(r.getString("damage"));
                refund.setRepair(r.getFloat("repair"));
                refunds.add(refund);
            }
            return refunds;
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
    public void update(Refund refund) throws SQLException {
        String sql = "UPDATE `refund` SET `order_id` = ?, `damage` = ?, `repair` = ? WHERE `refund_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, refund.getOrder_id());
            s.setString(2, refund.getDamage());
            s.setFloat(3, refund.getRepair());
            s.setLong(4, refund.getId());
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
        String sql = "DELETE FROM `refund` WHERE `refund_id` = ?";
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

   }
