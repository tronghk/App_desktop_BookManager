package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.billBUS;
import BUS.billDetailBUS;
import BUS.bookBUS;
import BUS.bookDistributorBUS;
import BUS.couponBUS;
import BUS.customerBUS;
import BUS.detailCouponBUS;
import BUS.detailPromotionBUS;
import BUS.employeeBUS;
import BUS.linkImageBUS;
import BUS.promotionBUS;
import BUS.publishingCompanyBUS;
import BUS.typeBookBUS;
import DTO.detailCoupon;
import DTO.employee;
import DTO.linkImage;
import DTO.typeBook;

public class menuManager extends JFrame{
	public menuManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setTitle("QUẢN LÝ BÁN SÁCH");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		SetPane();
		offPn();
	}
	private JPanel contentPane;
	private PanelLeftGUI pnLeft;
	static typeBookBUS typeBookBUS = new typeBookBUS();
	static bookDistributorBUS distributorBUS = new bookDistributorBUS();
	public static bookBUS bookBUS = new bookBUS();
	static couponBUS couponBUS = new couponBUS();
	public static billBUS billBUS = new billBUS();
	public static billDetailBUS billDTBUS = new billDetailBUS();
	static customerBUS customerBUS = new customerBUS();
	public static promotionBUS promotionBUS = new promotionBUS();
	public static detailPromotionBUS DTPromotionBUS = new detailPromotionBUS();
	public static linkImageBUS link = new linkImageBUS();
	static publishingCompanyBUS pubBUS = new publishingCompanyBUS();
	public static employeeBUS emBUS = new employeeBUS();
	public static detailCouponBUS dtCoupon = new detailCouponBUS();
	private void  SetPane() {
		pnLeft = new PanelLeftGUI();
		contentPane.add(pnLeft);
		contentPane.add(pnLeft.getPnBanHang());
		contentPane.add(pnLeft.getPnSanPham());
		contentPane.add(pnLeft.getPnKhuyenMai());
		contentPane.add(pnLeft.getPnNhanVien());
		contentPane.add(pnLeft.getPnNhapHang());
		contentPane.add(pnLeft.getPnThongKe());
		contentPane.add(pnLeft.getPnKhachHang());
		contentPane.add(pnLeft.getPn_ThongTinKH());
		contentPane.add(pnLeft.getPn_ChiTietKM());
		
	}
	public void offPn() {
		pnLeft.pn_ChiTietKM.setVisible(false);
		pnLeft.pn_ThongTinKH.setVisible(false);
		pnLeft.pnKhachHang.setVisible(false);
		pnLeft.pnKhuyenMai.setVisible(false);
		pnLeft.pnNhanVien.setVisible(false);
		pnLeft.pnNhapHang.setVisible(false);
		pnLeft.pnThongKe.setVisible(false);
		pnLeft.pnSanPham.setVisible(false);
	}

	
}
