/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.NhanVienRP;
import entity.KhachHang;
import entity.NhanVien;

/**
 *
 * @author LENOVO
 */
public class NhanVienService {
    private NhanVienRP nhanVienRP;
    
    public NhanVien getNhanVienByMa(String maNV) throws Exception {
        return nhanVienRP.getNhanVienByMa(maNV);
    }
}
