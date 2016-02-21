package com.dukal.database;

/**
 * Created by dukal on 21.02.2016.
 */
import java.sql.*;

public class DBEditor {

    private static final String HOST = "jdbc:mysql://localhost:3306/shops_db?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    private Connection connection;

    public DBEditor() {
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public  Connection getConnection(){
        return connection;
    }
}
