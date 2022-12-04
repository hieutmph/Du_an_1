/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class NhanVienRP {
    public NhanVien getNhanVienByMa(String maNV)
            throws Exception {
        String sql = "Select * from KHACHHANG Where MaNV = ?";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maNV);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString("MANV"));
                    nv.setTenNV(rs.getString("TENNV"));
                    nv.setGioiTinh("GIOITINH");
                    nv.setDiaChi("DIACHI");
                    nv.setEmail("EMAIL");
                    nv.setDienThoai("DIENTHOAI");
                    return nv;
                }
            }
            return null;
        }
    }
}
