package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载驱动");
        }
        catch (Exception e) {
            System.out.println("失败");
            e.printStackTrace();
        }
        Connection con = null;
        String url = "jdbc:mysql:// localhost/负责人";
        String user = "root";
        String password = "chs222200318";
        try {
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("成功链接数据库");
        }
        catch (Exception e) {
            System.out.println("失败");
            e.printStackTrace();
        }

        return con;
    }

}
