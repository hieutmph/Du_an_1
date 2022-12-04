/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.KhachHangRP;
import entity.KhachHang;

/**
 *
 * @author LENOVO
 */
public class KhachHangService {
    private KhachHangRP khachHangRP;
    
    public KhachHang getKhachHangByMa(String maKH) throws Exception {
        return khachHangRP.getKhachHangByMa(maKH);
    }
}
