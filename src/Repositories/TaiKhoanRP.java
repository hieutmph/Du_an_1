/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DO VAN DAO
 */
public class TaiKhoanRP {

    public boolean insert(TaiKhoan kh) throws Exception {
        String sql = "INSERT INTO [dbo].[TaiKhoan]\n"
                + "           ([MATK]\n"
                + "           ,[TENDN]\n"
                + "           ,[MATKHAU]\n"
                + "           ,[MANV])\n"
                + "     VALUES(?,?,?,?)";
        try (
                Connection con = DBconnect.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, kh.getMaTaiKhoan());
            pstm.setString(2, kh.getTenDangNhap());
            pstm.setString(3, kh.getMatKhau());
            pstm.setString(4, kh.getNhanVien());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean update(TaiKhoan kh) throws Exception {
        String sql = "UPDATE [dbo].[TaiKhoan]\n"
                + "   SET     [TENDN] = ?"
                + "      ,[MATKHAU] = ?"
                + "      ,[MANV] = ?"
                + " WHERE [MATK] = ?";
        try (
                Connection con = DBconnect.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(4, kh.getMaTaiKhoan());
            pstm.setString(1, kh.getTenDangNhap());
            pstm.setString(2, kh.getMatKhau());
            pstm.setString(3, kh.getNhanVien());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean detele(String maTK) throws Exception {
        String sql = "DELETE FROM TAIKHOAN\n"
                + "      WHERE [MATK] = ?";
        try (
                Connection con = DBconnect.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maTK);
            return pstm.executeUpdate() > 0;
        }
    }

    public TaiKhoan search(String maTK) throws Exception {
        String sql = "Select * from TAIKHOAN Where MaTK = ?";
        try (
                Connection con = DBconnect.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maTK);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    TaiKhoan kh = new TaiKhoan();
                    kh.setMaTaiKhoan(rs.getString("MATK"));
                    kh.setTenDangNhap(rs.getString("TENDN"));
                    kh.setMatKhau("MATKHAU");
                    kh.setNhanVien("MANV");
                    return kh;
                }
            }
            return null;
        }
    }

    public List<TaiKhoan> loadTB()
            throws Exception {
        String sql = "SELECT * FROM TAIKHOAN";
        try (
                Connection con = DBconnect.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<TaiKhoan> list = new ArrayList<>();
                while (rs.next()) {
                    TaiKhoan sc = new TaiKhoan();
                    sc.setMaTaiKhoan(rs.getString("MATK"));
                    sc.setTenDangNhap(rs.getString("TENDN"));
                    sc.setMatKhau(rs.getString("MATKHAU"));
                    sc.setNhanVien(rs.getString("MANV"));
                    list.add(sc);
                }
                return list;
            }
        }
    }
}
