package com.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management_system", "root", "root");
            //System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
