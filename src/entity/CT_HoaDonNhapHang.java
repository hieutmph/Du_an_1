package entity;

public class CT_HoaDonNhapHang {
	private HoaDonNhapHang hoaDonNhapHang;
	private SanPham sanPham;
	private int soLuong;
	private double donGia;
	
	public CT_HoaDonNhapHang() {
		// TODO Auto-generated constructor stub
	}

	public CT_HoaDonNhapHang(int soLuong, double donGia) {
		super();
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public HoaDonNhapHang getHoaDonNhapHang() {
		return hoaDonNhapHang;
	}

	public void setHoaDonNhapHang(HoaDonNhapHang hoaDonNhapHang) {
		this.hoaDonNhapHang = hoaDonNhapHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "CT_HoaDonNhapHang{" +
				"hoaDonNhapHang=" + hoaDonNhapHang +
				", sanPham=" + sanPham +
				", soLuong=" + soLuong +
				", donGia=" + donGia +
				'}';
	}
}