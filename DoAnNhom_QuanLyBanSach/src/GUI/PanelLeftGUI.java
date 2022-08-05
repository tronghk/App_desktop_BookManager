package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLeftGUI extends JPanel {
	public PanelLeftGUI() {
		this.setLayout(null);
		this.setBounds(0, 0,230, 800);
		GiaoDienQuanLy();
		
		pnSanPham = new pn_Manager_SanPham();
		pnBanHang = new pn_Manager_BanHang();
		pnKhuyenMai = new pn_KhuyenMai();
		pnKhachHang = new pn_KhachHang();
		pnNhanVien = new pn_Manager_NhanVien();
		pnThongKe = new pn_Manager_ThongKe();
		pnNhapHang = new pn_Manager_NhapHang();
		
		
		setFalseFuction();
		// đẩy các thành phần vào arr để xét sự kiện
		addPn();
		addBtn();
		openBtn(txt_BanHang);
		openPn(pnBanHang);
		// mở trước chức năng bán hàng 
		
		event();
	}
	
	private JLabel image_BackGround;
	private JLabel image_Logo;
	private JButton txt_BanHang;
	private JButton txt_SanPham;
	private JButton txt_NhapHang;
	private JButton txt_KhachHang;
	private JButton txt_NhanVien;
	private JButton txt_ThongKe;
	private JButton txt_KhuyenMai;
	
	
	static pn_Manager_SanPham pnSanPham;
	static pn_KhachHang pnKhachHang;
	static pn_Manager_BanHang pnBanHang;
	static pn_Manager_NhanVien pnNhanVien;
	static pn_KhuyenMai pnKhuyenMai;
	static pn_Manager_NhapHang pnNhapHang;
	static pn_Manager_ThongKe pnThongKe;
	static pn_ThongTinKH pn_ThongTinKH = new pn_ThongTinKH();
	static pn_ChiTietKhuyenMai pn_ChiTietKM = new pn_ChiTietKhuyenMai();
	
	// chuyển tất cả panel chức năng riêng về false
	public void setFalseFuction() {
		pn_ThongTinKH.setVisible(false);
	}
	
	private ArrayList<JPanel> arrPn = new ArrayList<JPanel>();
	private ArrayList<JButton> arrBtn = new ArrayList<JButton>();
	
	public pn_ThongTinKH getPn_ThongTinKH() {
		return pn_ThongTinKH;
	}
	public pn_Manager_SanPham getPnSanPham() {
		return pnSanPham;
	}
	public pn_KhachHang getPnKhachHang() {
		return pnKhachHang;
	}
	public pn_Manager_BanHang getPnBanHang() {
		return pnBanHang;
	}
	public pn_Manager_NhanVien getPnNhanVien() {
		return pnNhanVien;
	}
	public pn_KhuyenMai getPnKhuyenMai() {
		return pnKhuyenMai;
	}
	public pn_Manager_NhapHang getPnNhapHang() {
		return pnNhapHang;
	}
	public pn_Manager_ThongKe getPnThongKe() {
		return pnThongKe;
	}
	
	public static pn_ChiTietKhuyenMai getPn_ChiTietKM() {
		return pn_ChiTietKM;
	}
	public void GiaoDienQuanLy() {
		Font font = new Font("Arial", Font.BOLD, 21);
		//khởi tạo
		image_BackGround = new JLabel();
		image_Logo = new JLabel();
		txt_BanHang = new JButton();
		txt_KhachHang = new JButton();
		txt_KhuyenMai = new JButton();
		txt_NhanVien = new JButton();
		txt_NhapHang = new JButton();
		txt_SanPham = new JButton();
		txt_ThongKe = new JButton();
		
		// thiết lập cấu trúc
		image_BackGround.setBounds(0, 0, 230, 800);
		image_BackGround.setIcon(new ImageIcon("image//BackGroundMenuLeft.png"));
		
		image_Logo.setBounds(-5, 5, 200, 200);
		image_Logo.setIcon(new ImageIcon("image//Logo.png"));
		
		txt_BanHang.setText("Bán hàng     ");
		txt_BanHang.setFont(font);
		txt_BanHang.setBounds(0, 260, 230, 40);
		txt_BanHang.setHorizontalAlignment(0);
		txt_BanHang.setForeground(Color.white);
		txt_BanHang.setBackground(Color.black);
		txt_BanHang.setFocusable(false);
		txt_BanHang.setIconTextGap(10);
		txt_BanHang.setOpaque(false);
		txt_BanHang.setBorder(null);
		txt_BanHang.setIcon(new ImageIcon("image//ImageDisplayManagerLeft//Sell.png"));
		
		txt_KhuyenMai.setText("Khuyến mãi");
		txt_KhuyenMai.setFont(font);
		txt_KhuyenMai.setBounds(0, 300, 230, 40);
		txt_KhuyenMai.setHorizontalAlignment(JButton.CENTER);
		txt_KhuyenMai.setForeground(Color.white);
		txt_KhuyenMai.setBackground(Color.red);
		txt_KhuyenMai.setOpaque(false);
		txt_KhuyenMai.setFocusable(false);
		txt_KhuyenMai.setIconTextGap(10);
		txt_KhuyenMai.setBorder(null);
		txt_KhuyenMai.setIcon(new ImageIcon("image//ImageDisplayManagerLeft//icon_promotion.png"));
		
		txt_SanPham.setText("Sản phẩm   ");
		txt_SanPham.setFont(font);
		txt_SanPham.setBounds(0, 340, 230, 40);
		txt_SanPham.setForeground(Color.white);
		txt_SanPham.setBackground(Color.red);
		txt_SanPham.setOpaque(false);
		txt_SanPham.setFocusable(false);
		txt_SanPham.setIconTextGap(10);
		txt_SanPham.setBorder(null);
		txt_SanPham.setIcon(new ImageIcon("image//ImageDisplayManagerLeft//Product.png"));
		
		txt_KhachHang.setText("Khách hàng");
		txt_KhachHang.setFont(font);
		txt_KhachHang.setBounds(0, 380, 230, 40);
		txt_KhachHang.setForeground(Color.white);
		txt_KhachHang.setBackground(Color.red);
		txt_KhachHang.setOpaque(false);
		txt_KhachHang.setFocusable(false);
		txt_KhachHang.setIconTextGap(10);
		txt_KhachHang.setBorder(null);
		txt_KhachHang.setIcon(new ImageIcon("image//ImageDisplayManagerLeft//Customer.png"));
		
		txt_NhanVien.setText("Nhân viên   ");
		txt_NhanVien.setFont(font);
		txt_NhanVien.setOpaque(false);
		txt_NhanVien.setBounds(0, 420, 230, 40);
		txt_NhanVien.setForeground(Color.white);
		txt_NhanVien.setBackground(Color.red);
		txt_NhanVien.setFocusable(false);
		txt_NhanVien.setIconTextGap(10);
		txt_NhanVien.setBorder(null);
		txt_NhanVien.setIcon(new ImageIcon("image//ImageDisplayManagerLeft//Employee.png"));
		
		txt_NhapHang.setText("Nhập kho    ");
		txt_NhapHang.setFont(font);
		txt_NhapHang.setOpaque(false);
		txt_NhapHang.setBounds(0, 460, 230, 40);
		txt_NhapHang.setForeground(Color.white);
		txt_NhapHang.setBackground(Color.red);
		txt_NhapHang.setFocusable(false);
		txt_NhapHang.setIconTextGap(10);
		txt_NhapHang.setBorder(null);
		txt_NhapHang.setIcon(new ImageIcon("image//ImageDisplayManagerLeft//VanChuyen.png"));
		
		txt_ThongKe.setText("Thống kê    ");
		txt_ThongKe.setFont(font);
		txt_ThongKe.setBounds(0, 500, 230, 40);
		txt_ThongKe.setForeground(Color.white);
		txt_ThongKe.setBackground(Color.red);
		txt_ThongKe.setFocusable(false);
		txt_ThongKe.setOpaque(false);
		txt_ThongKe.setBorder(null);
		txt_ThongKe.setIconTextGap(10);
		txt_ThongKe.setIcon(new ImageIcon("image//ImageDisplayManagerLeft//Icon_thongke.png"));
		
		this.add(image_Logo);
		this.add(txt_BanHang);
		this.add(txt_KhuyenMai);
		this.add(txt_SanPham);
		this.add(txt_KhachHang);
		this.add(txt_NhanVien);
		this.add(txt_NhapHang);
		this.add(txt_ThongKe);
		this.add(image_BackGround);
	}
	
	public void addPn() {
		arrPn.add(pnKhuyenMai);
		arrPn.add(pnBanHang);
		arrPn.add(pnKhachHang);
		arrPn.add(pnSanPham);
		arrPn.add(pnNhanVien);
		arrPn.add(pnNhapHang);
		arrPn.add(pnThongKe);
	}
	public void addBtn() {
		arrBtn.add(txt_KhuyenMai);
		arrBtn.add(txt_BanHang);
		arrBtn.add(txt_SanPham);
		arrBtn.add(txt_KhachHang);
		arrBtn.add(txt_NhanVien);
		arrBtn.add(txt_NhapHang);
		arrBtn.add(txt_ThongKe);
	}
	
	//đóng tất cả panel và mở panel có chức năng hiện tại
	public void openPn(JPanel pn) {
		for(JPanel value: arrPn) {
			value.setVisible(false);
		}
		pn.setVisible(true);
	}
	public void openBtn(JButton btn) {
		for(JButton value: arrBtn) {
			value.setBackground(Color.red);
			value.setOpaque(false);
		}
		btn.setOpaque(true);
		btn.setBackground(Color.green);
	}
	
	public void event() {
		eventBtnBanHang();
		eventBtnKhuyenMai();
		eventBtnSanPham();
		eventBtnKhachHang();
		eventBtnNhanVien();
		eventBtnNhapHang();
		eventBtnThongKe();
	}
	
	public void eventBtnBanHang() {
		txt_BanHang.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				openBtn(txt_BanHang);
				openPn(pnBanHang);
				pnBanHang.pn_HoaDon.setVisible(false);
				PanelLeftGUI.pnBanHang.pn_ThanhToan.setVisible(false);
				pnBanHang.pn_BanHang.setVisible(true);
				pnBanHang.restart();
				pnThongKe.pn_ChiTietThongKe.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.setVisible(false);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelLeftGUI.pnBanHang.pn_HoaDon.restart();
				pn_ThongTinKH.setVisible(false);
				pn_ChiTietKM.setVisible(false);
				pnThongKe.pn_ChiTietThongKe.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.setVisible(false);
				
			}
		});
	}
	public void eventBtnKhuyenMai() {
		txt_KhuyenMai.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!pnBanHang.pn_BanHang.checkSave()) {
				openBtn(txt_KhuyenMai);
				openPn(pnKhuyenMai);
				pn_ChiTietKM.setVisible(false);
				pnKhuyenMai.restart();
				pn_ChiTietKM.restart();
				pnThongKe.pn_ChiTietThongKe.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.setVisible(false);
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pn_ThongTinKH.setVisible(false);
			}
		});
	}
	public void eventBtnSanPham() {
		txt_SanPham.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!pnBanHang.pn_BanHang.checkSave()) {
				openBtn(txt_SanPham);
				openPn(pnSanPham);
				pnSanPham.restart();
				pn_ThongTinKH.setVisible(false);
				pn_ChiTietKM.setVisible(false);
				pnThongKe.pn_ChiTietThongKe.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.setVisible(false);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventBtnKhachHang() {
		txt_KhachHang.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!pnBanHang.pn_BanHang.checkSave()) {
				openBtn(txt_KhachHang);
				openPn(pnKhachHang);
				pn_ThongTinKH.setVisible(false);
				pnKhachHang.restart();
				pnKhachHang.setVisible(true);
				pn_ChiTietKM.setVisible(false);
				pnThongKe.pn_ChiTietThongKe.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.setVisible(false);
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventBtnNhanVien() {
		txt_NhanVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!pnBanHang.pn_BanHang.checkSave()) {
				openBtn(txt_NhanVien);
				openPn(pnNhanVien);
				pnNhanVien.restart();
				pn_ThongTinKH.setVisible(false);
				pn_ChiTietKM.setVisible(false);
				pnThongKe.pn_ChiTietThongKe.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.setVisible(false);
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventBtnNhapHang() {
		txt_NhapHang.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!pnBanHang.pn_BanHang.checkSave()) {
				openBtn(txt_NhapHang);
				openPn(pnNhapHang);
				pnNhapHang.restart();
				pn_ThongTinKH.setVisible(false);
				pn_ChiTietKM.setVisible(false);
				pnThongKe.pn_ChiTietThongKe.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.setVisible(false);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventBtnThongKe() {
		txt_ThongKe.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!pnBanHang.pn_BanHang.checkSave()) {
				openBtn(txt_ThongKe);
				openPn(pnThongKe);
				pn_Manager_ThongKe.pn_ThongKeTongQuat.thietLapBang();
				pn_Manager_ThongKe.pn_ChiTietThongKe.thietLapBang();
				pn_ThongTinKH.setVisible(false);
				pn_ChiTietKM.setVisible(false);
				pnThongKe.pn_ThongKeTongQuat.ThongKe();
				pnThongKe.pn_ThongKeTongQuat.setVisible(true);
				}
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
