package com.example.project.dao.daoImpl;

import com.example.project.dao.CarDao;
import com.example.project.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.project.dbConnection.getConnection;

public class CarDaoImpl implements CarDao {
    @Override
    public void create(Car car) {
        String sql = "INSERT INTO `car` (`car_id`, `brand`, `model`, `available`, `day_price`)" +
                " VALUES (?, ?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, car.getId());
            s.setString(2,car.getBrand());
            s.setString(3,car.getModel());
            s.setBoolean(4,car.isAvailable());
            s.setFloat(5,car.getDayPrice());
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
    public Car read(Long id) {
        String sql = "SELECT `car_id`, `brand`, `model`, `available`, `day_price` FROM `car` WHERE `car_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setLong(1, id);
            r = s.executeQuery();
            Car car=null;
            while (r.next()) {
                car = new Car();
                car.setId(r.getLong("car_id"));
                car.setBrand(r.getString("brand"));
                car.setModel(r.getString("model"));
                car.setAvailable(r.getBoolean("available"));
                car.setDayPrice(r.getFloat("day_price"));
            }
            return car;
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
        String sql = "SELECT `car_id`, `brand`, `model`, `available`, `day_price` FROM `car` ";

        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            List<Car> cars = new ArrayList<>();
            while (r.next()) {
                Car car = new Car();
                car.setId(r.getLong("car_id"));
                car.setBrand(r.getString("brand"));
                car.setModel(r.getString("model"));
                car.setAvailable(r.getBoolean("available"));
                car.setDayPrice(r.getFloat("day_price"));
                cars.add(car);
            }
            return cars;
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
    public void update(Car car) throws SQLException {
        String sql = "UPDATE `car` SET `brand` = ?, `model` = ?, `available` = ?, `day_price` = ? WHERE `car_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, car.getBrand());
            s.setString(2, car.getModel());
            s.setBoolean(3, car.isAvailable());
            s.setFloat(4, car.getDayPrice());
            s.setLong(5, car.getId());
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
        String sql = "DELETE FROM `car` WHERE `car_id` = ?";
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
    public void changeAvailability(Car car, Boolean available) {
        String sql = "UPDATE `car` SET `available` = ? WHERE `car_id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setBoolean(1,available);
            s.setLong(2, car.getId());
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }
}
