/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.ChucVu;
import Responsitorys.ChucVuRepon;
import java.util.List;

/**
 *
 * @author p50
 */
public class ChucVuService {

    private final ChucVuRepon chucVuRepon;

    public ChucVuService() {
        this.chucVuRepon = new ChucVuRepon();
    }

    public List<ChucVu> getallChucVu() {
        return chucVuRepon.getallChucVu();
    }

    public Integer addChucVu(ChucVu cv) {
        return chucVuRepon.addChucVu(cv);
    }

    public Integer updateChucVu(ChucVu cv) {
        return chucVuRepon.updateChucVu(cv);
    }

    public Integer deleteChucVu(Integer maCV) {
        return chucVuRepon.deleteChucVu(maCV);
    }

}
