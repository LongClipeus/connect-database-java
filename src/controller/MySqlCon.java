/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.JType;

/**
 *
 * @author root
 */
public class MySqlCon {

    private final static String DRIVER = "com.mysql.jdbc.Driver";

    private final static String HOST_NAME = "localhost";
    private final static String DB_NAME = "test_db";
    private final static String PORT_NUMBER = "3306";
    private final static String USER_NAME = "root";
    private final static String PASSwORD = "";

    public Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {

        Connection conn = null;
        try {
            String url = "jdbc:mysql://" + HOST_NAME + ":"
                    + PORT_NUMBER + "/" + DB_NAME;
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, USER_NAME, PASSwORD);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Object> select() {
        String query = "SELECT * FROM man_hinh";
        List<Object> listJ = new ArrayList<>();
        
        try {
            Statement st = getMySQLConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String text = rs.getString("text");

                JType jType = new JType(id, type, text);
                listJ.add(jType);
            }
            st.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlCon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listJ;
    }

}
