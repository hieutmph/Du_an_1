/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import entity.KhachHang;
import java.sql.Connection;
import java.sql.ResultSet;
import entity.NhaCungCap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DO VAN DAO
 */
public class NhaCCRP {

    ResultSet rs;

    public boolean insert(NhaCungCap kh) throws Exception {
        String sql = "INSERT INTO [dbo].[NhaCungCap]\n"
                + "           ([MANHACC]\n"
                + "           ,[TENNHACC]\n"
                + "           ,[DIACHI]\n"
                + "           ,[SODT]\n"
                + "           ,[EMAIL])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, kh.getMaNhaCC());
            pstm.setString(2, kh.getTenNhaCC());
            pstm.setString(3, kh.getDiaChi());
            pstm.setString(4, kh.getSoDT());
            pstm.setString(5, kh.geteMail());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean update(NhaCungCap kh) throws Exception {
        String sql = "UPDATE [dbo].[NhaCungCap]\n"
                + "   SET [TENNHACC] = ?"
                + "      ,[DIACHI] = ?"
                + "      ,[SODT] = ?"
                + "      ,[EMAIL] = ?"
                + " WHERE [MANHACC] = ?";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(5, kh.getMaNhaCC());
            pstm.setString(1, kh.getTenNhaCC());
            pstm.setString(2, kh.getDiaChi());
            pstm.setString(3, kh.getSoDT());
            pstm.setString(4, kh.geteMail());
            return pstm.executeUpdate() > 0;
        }
    }

    public boolean detele(String maNhaCC) throws Exception {
        String sql = "DELETE FROM [dbo].[NhaCungCap]\n"
                + "      WHERE [MANHACC] = ?";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maNhaCC);
            return pstm.executeUpdate() > 0;
        }
    }

    public NhaCungCap search(String maNCC)
            throws Exception {
        String sql = "Select * from [NhaCungCap] Where [MANHACC] = ?";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, maNCC);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    NhaCungCap kh = new NhaCungCap();
                    kh.setMaNhaCC(rs.getString("MANHACC"));
                    kh.setTenNhaCC(rs.getString("TENNHACC"));
                    kh.setDiaChi(rs.getString("DIACHI"));
                    kh.setSoDT(rs.getString("SODT"));
                    kh.seteMail(rs.getString("EMAIL"));
                    return kh;
                }
            }
            return null;
        }
    }
    public List<NhaCungCap> loadTB()
            throws Exception {
        String sql = "SELECT * FROM NhaCungCap";
        try (
                Connection con = DBconect.getConnection();
                java.sql.PreparedStatement pstm = con.prepareStatement(sql);) {

            try (ResultSet rs = pstm.executeQuery()) {
                List<NhaCungCap> list = new ArrayList<>();
                while (rs.next()) {
                    NhaCungCap kh = new NhaCungCap();
                    kh.setMaNhaCC(rs.getString("MANHACC"));
                    kh.setTenNhaCC(rs.getString("TENNHACC"));
                    kh.setDiaChi(rs.getString("DIACHI"));
                    kh.setSoDT(rs.getString("SODT"));
                    kh.seteMail(rs.getString("EMAIL"));
                    list.add(kh);
                }
                return list;
            }
        }
    }
}
