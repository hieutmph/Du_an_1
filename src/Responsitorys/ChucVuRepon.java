/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitorys;

import Model.ChucVu;
import Ultility.JDBChelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p50
 */
public class ChucVuRepon {

    public List<ChucVu> getallChucVu() {
        List<ChucVu> chucVus = new ArrayList<>();
        String sql = "select * from chucvu";
        ResultSet rs = JDBChelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                chucVus.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
            return chucVus;
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuRepon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer addChucVu(ChucVu cv) {
        String sql = "insert into ChucVu values (?,?,?)";
        Integer row = JDBChelper.excuteUpdate(sql, cv.getMaChucVu(), cv.getTenChucVu(), cv.getHeSoLuong());
        return row;
    }

    public Integer updateChucVu(ChucVu cv) {
        String sql = "update ChucVu set TENCV=?, HESOLUONG=? where MACV=?";
        Integer row = JDBChelper.excuteUpdate(sql, cv.getTenChucVu(), cv.getHeSoLuong(), cv.getMaChucVu());
        return row;
    }

    public Integer deleteChucVu(Integer maCV) {
        String sql = "delete from ChucVu where maCV";
        Integer row = JDBChelper.excuteUpdate(sql, maCV);
        return row;
    }
}
