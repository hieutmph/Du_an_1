/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc acer
 */
public class DBconect {
     private static String USERNAME = "sa";
    private static String PASSWORD = "123";
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLBH1;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
// Khai Báo Khối static
    static {
        try {
            //Khởi tạo trình điều khiển JDBC bằng phương thức Class.forName.Bao bằng try catch khi có ngoại lệ!
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Xây dựng phương thức trả về connection
    public static Connection getConnection() {
        //Khai báo connection
        Connection cn = null;
        try {
            //Thực hiện kết nối connection.Bao bằng try catch khi có ngoại lệ!
            cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBconect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public static void main(String[] args) {
        //Khai cáo connection , gọi phương thức getconnection()  
        Connection cn = getConnection();
        if(cn!= null){
            System.out.println("Ket noi thanh cong");
        }else{
            System.out.println("Lỗi Kết nối");
        }
    }
}
