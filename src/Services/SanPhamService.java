/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.SanPham;
import Responsitorys.SanPhamRespon;
import java.util.List;

/**
 *
 * @author p50
 */
public class SanPhamService {

    private final SanPhamRespon sanPhamRespon;

    public SanPhamService() {
        this.sanPhamRespon = new SanPhamRespon();
    }

    public List<SanPham> getAllSanPham() {
        return sanPhamRespon.getAllSanPham();
    }

    public Integer addSanPham(SanPham sp) {
        return sanPhamRespon.addSanPham(sp);
    }

    public Integer updateSanPham(SanPham sp) {
        return sanPhamRespon.updateSanPham(sp);
    }

    public Integer deleteSanPham(Integer maSP) {
        return sanPhamRespon.deleteSanPham(maSP);
    }

}
