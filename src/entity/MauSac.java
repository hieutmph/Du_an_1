package entity;

public class MauSac {
    protected String maMau;
    protected String tenMau;

    public MauSac() {
    }

    public MauSac(String maMau, String tenMau) {
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return "MauSac{" +
                "maMau='" + maMau + '\'' +
                ", tenMau='" + tenMau + '\'' +
                '}';
    }
}
