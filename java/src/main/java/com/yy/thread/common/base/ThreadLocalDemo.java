package com.yy.thread.common.base;

import cn.hutool.db.DbUtil;
import com.yy.orm.jdbc.DBUtil;

import java.sql.SQLException;
import java.util.stream.IntStream;

/**
 * @description: ThreadLocal
 * @author: yy
 * @date: 2020/8/1 10:20
 */
public class ThreadLocalDemo {

    public void insert() throws SQLException {
        // 获取连接
        System.out.println("insert " + Thread.currentThread().getName()+ DBUtil.getConnection());
    }

    public void update() throws SQLException {
        // 获取连接
        System.out.println("update " + Thread.currentThread().getName()+ DBUtil.getConnection());
    }

    public void delete() throws SQLException {
        // 获取连接
        System.out.println("delete " + Thread.currentThread().getName()+ DBUtil.getConnection());
    }

    public void query() throws SQLException {
        // 获取连接
        System.out.println("query " + Thread.currentThread().getName()+ DBUtil.getConnection());
    }

    public static void main(String[] args) throws Exception{
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        IntStream.range(0,3).forEach(i -> new Thread(() -> {
            try {
                threadLocalDemo.insert();
                threadLocalDemo.update();
                threadLocalDemo.delete();
                threadLocalDemo.query();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start());
    }
}
