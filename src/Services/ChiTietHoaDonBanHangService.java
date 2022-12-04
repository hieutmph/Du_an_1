/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.ChiTietHoaDonBanHangRP;
import Repositories.HoaDonBanHangRP;
import entity.CT_HoaDonBanHang;
import entity.HoaDonBanHang;

/**
 *
 * @author LENOVO
 */
public class ChiTietHoaDonBanHangService {
    private ChiTietHoaDonBanHangRP chiTietHoaDonBanHangRP = new ChiTietHoaDonBanHangRP();
    
    public void insertCTHoaDonBanHang(CT_HoaDonBanHang cT_HoaDonBanHang) {
        chiTietHoaDonBanHangRP.addCTHoaDonBanHang(cT_HoaDonBanHang);
    }
}
