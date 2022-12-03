/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

import Responsitorys.DBconnext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p50
 */
public class JDBChelper {

    public static ResultSet excuteQuery(String sql, Object... args) {
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement psm = null;

        cn = DBconnext.getConnection();
        try {
            psm = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                psm.setObject(i + 1, args[1]);
            }
            rs = psm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBChelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static Integer excuteUpdate(String sql, Object... args) {
        Integer row = 0;
        Connection cn = null;
        PreparedStatement psm = null;

        cn = DBconnext.getConnection();
        try {
            psm = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                psm.setObject(i + 1, args[1]);
            }
            row = psm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBChelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
