package com.yy.orm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: 连接池管理类
 * @author: yy
 * @date: 2020/8/1 10:47
 */
public class DBUtil {

    private static ThreadLocal<Connection> connectionContainer = new ThreadLocal<>();

    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        if(conn == null){
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall?serverTimezone=UTC","root","root");
        }
        return conn;
    }

    public static void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
