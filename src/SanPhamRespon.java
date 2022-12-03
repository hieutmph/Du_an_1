/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitorys;

import Model.ChatLieu;
import Model.LoaiSanPham;
import Model.MauSac;
import Model.SanPham;
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
public class SanPhamRespon {

    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPhams = new ArrayList<>();
        String sql = "select SANPHAM.MASP, TENSANPHAM, LoaiSanPham.TENLOAI, MAUSAC.TENMAUSAC, SOLUONG, TRONGLUONG, CHATLIEU.TENCHATLIEU, XUATXU, GIABAN, SIZE from SANPHAM inner join CHATLIEU on CHATLIEU.MACHATLIEU=SANPHAM.MACHATLIEU \n"
                + "inner join MAUSAC on MAUSAC.MAMAUSAC = SANPHAM.MAMAUSAC\n"
                + "inner join LoaiSanPham on LoaiSanPham.MALOAI = SANPHAM.MALOAI";

        ResultSet rs = JDBChelper.excuteQuery(sql);

        try {
            while (rs.next()) {
                sanPhams.add(new SanPham(rs.getString(1), rs.getNString(2), new LoaiSanPham(rs.getNString(3)), new ChatLieu(rs.getNString(4)), new MauSac(rs.getString(5)), rs.getFloat(6), rs.getNString(7),
                        rs.getInt(8), rs.getFloat(9), rs.getString(10)));
            }
            return sanPhams;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRespon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer addSanPham(SanPham sp) {
        String sql = "insert into SanPham values (?,?,?,?,?,?,?,?,?,?)";
        Integer row = JDBChelper.excuteUpdate(sql, sp.getMaSanPham(), sp.getTenSanPham(), sp.getLoaiSanPham(), sp.getMauSac(), sp.getSoLuong(), sp.getDonViTinh(),
                sp.getChatLieu(), sp.getXuatXu(), sp.getGiaBan(), sp.getSizeSP());

        return row;
    }

    public Integer updateSanPham(SanPham sp) {
        String sql = "update SanPham set TENSANPHAM=?, TENLOAI=?,TENMAUSAC=?,SOLUONG=?,TRONGLUONG=?,TENCHATLIEU=?,XUATXU=?,GIABAN=?,SIZE=? where MASP=?";
        Integer row = JDBChelper.excuteUpdate(sql, sp.getTenSanPham(), sp.getLoaiSanPham(), sp.getMauSac(), sp.getSoLuong(), sp.getDonViTinh(),
                sp.getChatLieu(), sp.getXuatXu(), sp.getGiaBan(), sp.getSizeSP(), sp.getMaSanPham());

        return row;
    }

    public Integer deleteSanPham(Integer maSP) {
        String sql = "delete from SanPham where MASP=?";
        Integer row = JDBChelper.excuteUpdate(sql, maSP);

        return row;
    }

}
