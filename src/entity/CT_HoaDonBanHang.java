package entity;

public class CT_HoaDonBanHang {
	private HoaDonBanHang hoaDonBanHang;
	private SanPham sanPham;
	private int soLuong;
	private double donGia;
	
	public CT_HoaDonBanHang() {
		// TODO Auto-generated constructor stub
	}

	public CT_HoaDonBanHang(int soLuong, double donGia) {
		super();
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public HoaDonBanHang getHoaDonBanHang() {
		return hoaDonBanHang;
	}

	public void setHoaDonBanHang(HoaDonBanHang hoaDonBanHang) {
		this.hoaDonBanHang = hoaDonBanHang;
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
		return "CT_HoaDonBanHang{" +
				"hoaDonBanHang=" + hoaDonBanHang +
				", sanPham=" + sanPham +
				", soLuong=" + soLuong +
				", donGia=" + donGia +
				'}';
	}
}
