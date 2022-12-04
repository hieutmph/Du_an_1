/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import entity.HoaDonBanHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class HoaDonBanHangRP {
    Connection con = null;
    public HoaDonBanHangRP() {
        con = DBconect.getConnection();
    }
    
    public boolean addHoaDonBanHang(HoaDonBanHang hoaDonBanHang) {
        try {
            PreparedStatement sanphamAdd = con.prepareStatement("INSERT INTO HoaDonBanHang ([MAHDBH],[MAKH],[MANV],[NGAYLAPHD],[TONGTIEN]) "
                    + "VALUES(?,?,?,?,?)");
            sanphamAdd.setString(1, hoaDonBanHang.getMaHDBH());
            sanphamAdd.setString(2, hoaDonBanHang.getKhachHang().getMaKH());
            sanphamAdd.setString(3, hoaDonBanHang.getNhanVien().getMaNV());
            sanphamAdd.setDate(4, hoaDonBanHang.getNgayLapHD());
            sanphamAdd.setDouble(5, hoaDonBanHang.getTongTien());
            int n = sanphamAdd.executeUpdate();
            if (n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
