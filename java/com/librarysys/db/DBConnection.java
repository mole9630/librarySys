package com.librarysys.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    public Connection getDBConnection() {
            Connection con = null;
        try {
            Properties prop = new Properties();
            System.out.println(System.getProperty("user.dir"));
            prop.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/librarysys/db/druid.properties"));
            // 获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            // 获取对应数据库连接Connection
            con = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return con;
        }
    }

    public void closeDB(Connection con, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 测试连接
    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();
        Connection con = null;
        con = dbc.getDBConnection();
        if (con != null){
            System.out.println("连接成功!");
        }
    }
}
