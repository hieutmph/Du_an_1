/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.SanPhamRP;
import entity.SanPham;
import java.util.List;

/**
 *
 * @author pc acer
 */
public class SanPhamService {
    private final SanPhamRP  sanPhamRP;

    public SanPhamService() {
        this.sanPhamRP = new SanPhamRP();
    }
    public List<SanPham> getAllSanPham(){
        return sanPhamRP.getAllSanPham();
    }
    
    public boolean insertSanPham(SanPham sanPham) {
        return sanPhamRP.addSanPham(sanPham);
    }
    
    
}
