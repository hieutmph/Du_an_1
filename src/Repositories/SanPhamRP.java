/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Ultility.JDBCHelper;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc acer
 */
public class SanPhamRP {

    Connection con = null;
    public SanPhamRP() {
        con = DBconect.getConnection();
    }

    
    public List<SanPham> getAllSanPham() {
        List<SanPham> sanPham = new ArrayList<>();
        String sql = "select * From SanPham";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSP"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                sp.setMaLoai(rs.getString("MaLoai"));
                sp.setChatLieu(rs.getString("MaChatLieu"));
                sp.setMauSac(rs.getString("MaMauSac"));
                sp.setTrongLuong(rs.getFloat("TrongLuong"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setXuatXu(rs.getString("XuatXu"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setGiaBan(rs.getDouble("GiaBan"));
                sp.setSizeSP(rs.getString("Size"));
                sanPham.add(sp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPham;
    }
    
    public boolean addSanPham(SanPham sanPham) {
        try {
            PreparedStatement sanphamAdd = con.prepareStatement("INSERT INTO SanPham ([MALOAI],[MACHATLIEU],[MAMAUSAC],[TENSANPHAM],[TRONGLUONG]," +
                    "[DONVITINH],[XUATXU],[SOLUONG],[GIABAN],[SIZE],[MASP]) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            sanphamAdd.setString(1, sanPham.getMaLoai());
            sanphamAdd.setString(2, sanPham.getChatLieu());
            sanphamAdd.setString(3, sanPham.getMauSac());
            sanphamAdd.setString(4, sanPham.getTenSanPham());
            sanphamAdd.setFloat(5, sanPham.getTrongLuong());
            sanphamAdd.setString(6, sanPham.getDonViTinh());
            sanphamAdd.setString(7, sanPham.getXuatXu());
            sanphamAdd.setInt(8, sanPham.getSoLuong());
            sanphamAdd.setDouble(9, sanPham.getGiaBan());
            sanphamAdd.setString(10, sanPham.getSizeSP());
            sanphamAdd.setString(11, sanPham.getMaSanPham());

            int n = sanphamAdd.executeUpdate();
            if (n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
