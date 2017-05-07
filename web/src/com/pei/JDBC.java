package com.pei;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBC {

//    连接数据库
//   有配置文件版
//    private static String jdbcDriver = "";      //定义连接信息
//    private static String jdbcUrl = "";
//    private static String jdbcUser = "";
//    private static String jdbcPasswd = "";
//    static{
//        try {
//            InputStream in = JDBC.class.getClassLoader().getResourceAsStream("database.properties");   //加载database.properties文件
//            Properties p = new Properties ();
//            p.load(in);
//            jdbcDriver = p.getProperty("jdbcDriver");    //赋值
//            jdbcUrl = p.getProperty("jdbcUrl");
//            jdbcUser = p.getProperty("jdbcUser");
//            jdbcPasswd = p.getProperty("jdbcPasswd");
//            if(in != null){
//                try {
//                    in.close();   //  关闭is
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    protected static Connection getConn() {
//        Connection conn = null;
//        try {
//            Class.forName(jdbcDriver);
//            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPasswd);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

//   无配置文件版
    protected static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            return (Connection)DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //数据插入
    protected  static boolean insert(User user) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into user(id,name,sex,age,tel,address) values(?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getSex());
            pstmt.setInt(4, user.getAge());
            pstmt.setString(5, user.getTelephone());
            pstmt.setString(6, user.getAddress());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //更新数据
    protected static boolean update(User user) {
        Connection conn = getConn();
        String sql = "update user set age='" + user.getAge() + "',name='" + user.getName() + "',sex='" + user.getSex() + "',tel='" + user.getTelephone() + "',address='" + user.getAddress() + "' where id='" + user.getId() + "'";
        PreparedStatement pstmt = null;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //查询数据
    @Nullable
    public static List<User> getAll(){
        List<User> list= new ArrayList<User> ();
        Connection conn = getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from user";
        try {
            ps= (PreparedStatement) conn.prepareStatement(sql);
            rs=ps.executeQuery();
            User user= new User ();
            while(rs.next()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setTelephone(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                list.add(user);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Nullable
    public static List<User> getOne(String id){
        List<User> list= new ArrayList<User> ();
        Connection conn = getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from user where id = '" + id + "'";
        try {
            User user = new User ();
            ps= (PreparedStatement) conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setTelephone(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                list.add(user);
                ps.close();
                conn.close();
                }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    //删除数据
    protected static boolean Delete(String id) {
        Connection conn = getConn();
        String sql = "delete from user where id='" + id + "'";
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}