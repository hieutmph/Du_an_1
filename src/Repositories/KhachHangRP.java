/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import entity.KhachHang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DO VAN DAO
 */
public class KhachHangRP {

    ResultSet rs;

    public boolean insertKH(KhachHang kh) throws Exception {
        String sql = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([MAKH]\n"
                + "           ,[TENKH]\n"
                + "           ,[GIOITINH]\n"
                + "           ,[EMAIL]\n"
                + "           ,[DIENTHOAI]\n"
                + "           ,[DIACHI])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, kh.getMaKH());
            pstm.setString(2, kh.getTenKH());
            pstm.setString(3, kh.getGioiTinh());
            pstm.setString(4, kh.getEmail());
            pstm.setString(5, kh.getDienThoai());
            pstm.setString(6, kh.getDiaChi());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean upDateKh(KhachHang kh) throws Exception {
        String sql = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [TENKH] = ?"
                + "      ,[GIOITINH] = ?"
                + "      ,[EMAIL] = ?"
                + "      ,[DIENTHOAI] = ?"
                + "      ,[DIACHI] = ?"
                + " WHERE MAKH = ?";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(6, kh.getMaKH());
            pstm.setString(1, kh.getTenKH());
            pstm.setString(2, kh.getGioiTinh());
            pstm.setString(3, kh.getEmail());
            pstm.setString(4, kh.getDienThoai());
            pstm.setString(5, kh.getDiaChi());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean deteleKH(String maKH) throws Exception {
        String sql = "DELETE FROM [dbo].[KHACHHANG]\n"
                + "      WHERE [MAKH] = ?";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maKH);
            return pstm.executeUpdate() > 0;
        }
    }

    public KhachHang getKhachHangByMa(String maKH)
            throws Exception {
        String sql = "Select * from KHACHHANG Where MaKH = ?";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maKH);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("MAKH"));
                    kh.setTenKH(rs.getString("TENKH"));
                    kh.setGioiTinh("GIOITINH");
                    kh.setDiaChi("DIACHI");
                    kh.setEmail("EMAIL");
                    kh.setDienThoai("DIENTHOAI");
                    return kh;
                }
            }
            return null;
        }
    }

    public List<KhachHang> loadTB()
            throws Exception {
        String sql = "SELECT * FROM KHACHHANG";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<KhachHang> list = new ArrayList<>();
                while (rs.next()) {
                    KhachHang sc = new KhachHang();
                    sc.setMaKH(rs.getString("MAKH"));
                    sc.setTenKH(rs.getString("TENKH"));
                    sc.setGioiTinh(rs.getString("GIOITINH"));
                    sc.setDiaChi(rs.getString("DIACHI"));
                    sc.setEmail(rs.getString("EMAIL"));
                    sc.setDienThoai(rs.getString("DIENTHOAI"));
                    list.add(sc);
                }
                return list;
            }
        }
    }
}
