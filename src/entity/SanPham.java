package entity;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private LoaiSanPham loaiSanPham;
	private ChatLieu chatLieu;
	private MauSac mauSac;
	private float trongLuong;
	private String donViTinh;
	private String xuatXu;
	private int soLuong;
	private double giaBan;
	private String sizeSP;

	public SanPham() {
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSanPham, String tenSanPham, float trongLuong, String donViTinh, String xuatXu, int soLuong, double giaBan, String sizeSP) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.trongLuong = trongLuong;
		this.donViTinh = donViTinh;
		this.xuatXu = xuatXu;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.sizeSP = sizeSP;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public ChatLieu getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(ChatLieu chatLieu) {
		this.chatLieu = chatLieu;
	}

	public MauSac getMauSac() {
		return mauSac;
	}

	public void setMauSac(MauSac mauSac) {
		this.mauSac = mauSac;
	}

	public float getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(float trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getSizeSP() {
		return sizeSP;
	}

	public void setSizeSP(String sizeSP) {
		this.sizeSP = sizeSP;
	}

	@Override
	public String toString() {
		return "SanPham{" +
				"maSanPham='" + maSanPham + '\'' +
				", tenSanPham='" + tenSanPham + '\'' +
				", loaiSanPham=" + loaiSanPham +
				", chatLieu=" + chatLieu +
				", mauSac=" + mauSac +
				", trongLuong=" + trongLuong +
				", donViTinh='" + donViTinh + '\'' +
				", xuatXu='" + xuatXu + '\'' +
				", soLuong=" + soLuong +
				", giaBan=" + giaBan +
				", size='" + sizeSP + '\'' +
				'}';
	}
}
