/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import entity.CT_HoaDonBanHang;
import entity.HoaDonBanHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class ChiTietHoaDonBanHangRP {
    Connection con = null;
    public ChiTietHoaDonBanHangRP() {
        con = DBconect.getConnection();
    }
    
    public boolean addCTHoaDonBanHang(CT_HoaDonBanHang chiTietHoaDon) {
        try {
            PreparedStatement sanphamAdd = con.prepareStatement("INSERT INTO Ct_HoaDonBanHang ([MAHDBH],[MASP],[SOLUONG],[DONGIA]) "
                    + "VALUES(?,?,?,?)");
            sanphamAdd.setString(1, chiTietHoaDon.getHoaDonBanHang().getMaHDBH());
            sanphamAdd.setString(2, chiTietHoaDon.getSanPham().getMaSanPham());
            sanphamAdd.setInt(3, chiTietHoaDon.getSoLuong());
            sanphamAdd.setDouble(4, chiTietHoaDon.getDonGia());
            int n = sanphamAdd.executeUpdate();
            if (n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
