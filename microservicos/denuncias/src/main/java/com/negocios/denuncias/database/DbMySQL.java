package com.negocios.denuncias.database;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbMySQL {


    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_NAME = "efa0124_ms_denuncia";
    private static final String SERVER = "62.28.39.135";
    private static final String PORT = ":3306/";
    private static final String USER = "efa0124";
    private static final String PASSWORD = "123.Abc";
    private static final String URL = "jdbc:mysql://" + SERVER + PORT + DB_NAME;


    public Connection getConn() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(MYSQL_DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
