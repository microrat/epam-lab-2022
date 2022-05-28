package com.example.project;

import java.sql.*;
import java.util.logging.Logger;

public class dbConnection {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/cars?useUnicode=true&characterEncoding=UTF-8";
    static String userName = "root";
    static String password = "root";

    public static void init() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName, password);
            if (conn != null)
                System.out.println("Приложение подключилось к БД !");
            else
                System.out.println("Приложение НЕ подключилось к БД ?");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
