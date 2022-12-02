/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponse;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienRP {

    public boolean insertNV(NhanVien nv) throws Exception {
        String sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([MANV]\n"
                + "           ,[MACV]\n"
                + "           ,[TENNV]\n"
                + "           ,[GIOITINH]\n"
                + "           ,[NGAYSINH]\n"
                + "           ,[EMAIL]\n"
                + "           ,[DIENTHOAI]\n"
                + "           ,[CCCD]\n"
                + "           ,[DIACHI]\n"
                + "           ,[NGAYVAOLAM])\n"
                + "     VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (
                Connection con = DBconnection.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, nv.getMaNV());
             pstm.setString(2, nv.getMaCV());
            pstm.setString(3, nv.getTenNV());
            pstm.setString(4, nv.getGioiTinh());
            pstm.setDate(5, nv.getNgaySinh());
            pstm.setString(6, nv.getEmail());
            pstm.setString(7, nv.getDienThoai());
            pstm.setInt(8, nv.getCCCD());
            pstm.setString(9, nv.getDiaChi());
            pstm.setDate(10, nv.getNgayVaoLam());

            return pstm.executeUpdate() > 0;
        }
    }

    public boolean upDateNV(NhanVien nv) throws Exception {
        String sql = "UPDATE [dbo].[NhanVien]\n"
                + "   SET[[TENNV] = ?"
                + "           ,[MACV]\n"
                + "      ,[GIOITINH] = ?"
                + "      ,[NGAYSINH] = ?"
                + "      ,[EMAIL] =?"
                + "      ,[DIENTHOAI] = ?"
                 + "           ,[CCCD]\n"
                + "      ,[DIACHI] = ?"
                + "      ,[NGAYVAOLAM] = ?"
                + " WHERE MANV=?";

        try (
                Connection con = DBconnection.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setString(1, nv.getMaNV());
             pstm.setString(2, nv.getMaCV());
            pstm.setString(3, nv.getTenNV());
            pstm.setString(4, nv.getGioiTinh());
            pstm.setDate(5, nv.getNgaySinh());
            pstm.setString(6, nv.getEmail());
            pstm.setString(7, nv.getDienThoai());
            pstm.setInt(8, nv.getCCCD());
            pstm.setString(9, nv.getDiaChi());
            pstm.setDate(10, nv.getNgayVaoLam());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean deteleNV(NhanVien nv) throws Exception {
        String sql = "DELETE FROM [dbo].[NhanVien]"
                + "      WHERE [MANV] = ?";
        try (
                Connection con = DBconnection.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, nv.getMaNV());
            return pstm.executeUpdate() > 0;
        }
    }

    public NhanVien searchMaNV(String maNV)
            throws Exception {
        String sql = "Select * from NHANVIEN Where MaNV = ?";
        try (
                Connection con = DBconnection.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maNV);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString("MANV"));
                     nv.setMaCV(rs.getString("MACV"));
                    nv.setTenNV(rs.getString("TENNV"));
                    nv.setGioiTinh("GIOITINH");
                    nv.setNgaySinh(Date.valueOf("NGAYSINH"));
                    nv.setDienThoai("DIENTHOAI");  
                    nv.setEmail("EMAIL");
                    nv.setDienThoai("DIENTHOAI");
                    nv.setCCCD(Integer.parseInt("CCCD"));
                    nv.setDiaChi("DIACHI");
                    nv.setNgayVaoLam(Date.valueOf("NGAYVAOLAM"));
                    return nv;
                }
            }
            return null;
        }
    }
    
    public List<NhanVien> loadTB()
            throws Exception {
        String sql = "SELECT * FROM NHANVIEN";
        try (
                Connection con = DBconnection.openConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<NhanVien> list = new ArrayList<>();
                while (rs.next()) {
                    NhanVien sc = new NhanVien();
                    sc.setMaNV(rs.getString("MANV"));
                    sc.setMaCV(rs.getString("MACV"));
                    sc.setTenNV(rs.getString("TENNV"));
                     sc.setNgaySinh(rs.getDate("NGAYSINH"));
                    sc.setGioiTinh(rs.getString("GIOITINH"));
                    sc.setDiaChi(rs.getString("DIACHI"));
                    sc.setEmail(rs.getString("EMAIL"));
                    sc.setDienThoai(rs.getString("DIENTHOAI"));
                     sc.setCCCD(rs.getInt("CCCD"));
                    list.add(sc);
                }
                return list;
            }
        }
    }
}
