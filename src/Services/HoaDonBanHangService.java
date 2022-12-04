/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.HoaDonBanHangRP;
import entity.HoaDonBanHang;

/**
 *
 * @author LENOVO
 */
public class HoaDonBanHangService {
    private HoaDonBanHangRP hoaDonBanHangRP = new HoaDonBanHangRP();
    
    public void insertHoaDonBanHang(HoaDonBanHang hoaDonBanHang) {
        hoaDonBanHangRP.addHoaDonBanHang(hoaDonBanHang);
    }
}
