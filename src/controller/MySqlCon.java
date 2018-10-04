/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class MySqlCon {

    private final static String HOST_NAME = "localhost";
    private final static String DB_NAME = "test";
    private final static String PORT_NUMBER = "3306";
    private final static String USER_NAME = "root";
    private final static String PASSwORD = "";

    public Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Cấu trúc URL Connection dành cho MySQL
            // Ví dụ: jdbc:mysql://localhost:3306/simplehr
            String connectionURL = "jdbc:mysql://" + HOST_NAME + ":"
                    + PORT_NUMBER + "/" + DB_NAME;

            conn = DriverManager.getConnection(connectionURL, USER_NAME,
                    PASSwORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
