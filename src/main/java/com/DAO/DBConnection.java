package com.DAO;

import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    private DBConnection() { }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DBConnection.class) {
                if (connection == null) {
                    JdbcDataSource dataSource = new JdbcDataSource();
                    dataSource.setURL("jdbc:h2:tcp://localhost/~/escrim");
                    dataSource.setUser("escrim");
                    dataSource.setPassword("escrim");
                    try {
                        connection = dataSource.getConnection();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
