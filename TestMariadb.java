package testMariadb;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class TestMariadb {
    private static String DB_URL = "jdbc:mysql://localhost:3306/database1";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    static Connection conn;
    public static void main(String[] args) {
         conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        if(conn != null){
            System.out.println("true");
        }else System.out.println("False");
        
        String sql = "Select namee from book where id = ?";
        try{
            String a ="";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"3");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            a = rs.getString("namee"); 
            }
            System.out.println(a);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
}

