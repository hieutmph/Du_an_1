/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

import Repositories.DBconect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc acer
 */
public class JDBCHelper {
     //Result
    //Xây dựng phương thức excutequery trả về resultSet
    public static ResultSet excuteQuery(String sql, Object... args) {
        Connection cn = null;
        //Thực thi câu truy vấn có tham số  
        PreparedStatement pstm = null;
        //Nhận dữ liệu kết quả dữ liệu của đâu truy vấn
        ResultSet rs = null;
        //Thực hiện truy vấn 
        cn = DBconect.getConnection();
        try {
            pstm = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i + 1, args[i]);
            }
            //thi hành statement và trả kết quả về resultSet
            rs = pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static Integer excuteUpdate(String sql, Object... args) {
        Integer row = 0;
        Connection cn = null;
        PreparedStatement pstm = null;
        cn = DBconect.getConnection();
        try {
            pstm = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i + 1, args[i]);
            }
            //thi hành statement và trả kết quả về resultSet
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
