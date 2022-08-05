package GUI;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DTO.book;
import DTO.bookDistributor;
import DTO.coupon;
import DTO.detailCoupon;
import DTO.typeBook;

public class pn_TaoPhieuNhapHang extends JPanel{
	public pn_TaoPhieuNhapHang() {
		 this.setLayout(null);
			this.setBounds(0, 20,770, 745);
			Border border = BorderFactory.createLineBorder(Color.black);
			setBorder(border);
			
			khoiTao();
			thietLap();
			
			event();
	}	
	private JLabel txt_TieuDe;
	private JLabel txt_DSSach;
	private JLabel txt_CTPNH;
	private JButton btn_Them;
	private JButton btn_TimKiem;
	private JButton btn_Sua;
	private JButton btn_Xoa;
	private JButton btn_QuayLai;
	private JButton btn_ThanhToan;
	private JTextField tf_TimKiem;
	private JTable tb_BangSanPham;
	private DefaultTableModel model_Book;
	private JTable tb_CTPNH;
	private DefaultTableModel model_CTPHN;
	private JLabel txt_TenSach;
	private JTextField tf_TenSach;
	private JLabel txt_LoaiSach;
	private JComboBox<String> cbb_LoaiSach;
	private JLabel txt_MaSach;
	private JTextField tf_MaSach;
	private JLabel txt_SoLuong;
	private JLabel txt_DonGia;
	private JLabel txt_TongTien;
	private JTextField tf_SoLuong;
	private JTextField tf_DonGia;
	private JTextField tf_TongTien;
	private JLabel txt_NhaCungCap;
	private JComboBox<String> cbb_NCC;
	private JLabel image_SanPham;
	private JLabel txt_XemAnh;
	private JScrollPane scroll;
	private JScrollPane scrollCT;
	private JLabel txt_ThongTin;
	private JButton btn_TaoLai;
	
	public void khoiTao() {
		taoBang();
		txt_TieuDe = new JLabel();
		txt_DSSach = new JLabel();
		txt_CTPNH = new JLabel();
		btn_Them = new JButton();
		btn_TimKiem = new JButton();
		btn_Sua = new JButton();
		tf_TimKiem = new JTextField();
		btn_Xoa = new JButton();
		btn_QuayLai = new  JButton();
		btn_ThanhToan = new  JButton();
		txt_TenSach = new JLabel();
		tf_TenSach = new JTextField();
		txt_LoaiSach = new JLabel();
		txt_MaSach = new JLabel();
		tf_MaSach = new JTextField();
		txt_SoLuong = new JLabel();
		tf_SoLuong = new JTextField();
		txt_DonGia = new JLabel();
		tf_DonGia = new JTextField();
		tf_TongTien = new JTextField();
		txt_TongTien = new JLabel();
		txt_NhaCungCap = new JLabel();
		image_SanPham = new JLabel();
		txt_XemAnh = new JLabel();
		txt_ThongTin = new JLabel();
		btn_TaoLai = new JButton();
	}
	public void thietLap() {
		thietLapGiaoDientxt();
		thietLapGiaoDienTf();
		thietLapGiaoDienBtn();
		thietLapGiaoDienCBB();
		GiaoDienXemAnh();
		OffFuction();
		thietLapBang();
		thietLapCTPNH();
	}
	public void thietLapGiaoDientxt() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Phiếu nhập hàng");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_DSSach.setText("Sách");
		txt_DSSach.setFont(font);
		txt_DSSach.setHorizontalAlignment(JLabel.LEFT);
		txt_DSSach.setBounds(10, 70, 100, 22);

		txt_CTPNH.setText("Chi tiết nhập");
		txt_CTPNH.setFont(font);
		txt_CTPNH.setBounds(10, 430, 250, 22);
		txt_CTPNH.setHorizontalAlignment(JLabel.LEFT);
		
		txt_MaSach.setText("Mã sách");
		txt_MaSach.setFont(font);
		txt_MaSach.setBounds(500, 150, 150, 30);
		txt_MaSach.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TenSach.setText("Tên sách");
		txt_TenSach.setFont(font);
		txt_TenSach.setBounds(500, 190, 150, 30);
		txt_TenSach.setHorizontalAlignment(JLabel.LEFT);
		
		txt_LoaiSach.setText("Thể loại");
		txt_LoaiSach.setFont(font);
		txt_LoaiSach.setBounds(500, 110, 150, 30);
		txt_LoaiSach.setHorizontalAlignment(JLabel.LEFT);
		
		txt_SoLuong.setText("SL nhập ");
		txt_SoLuong.setFont(font);
		txt_SoLuong.setBounds(500, 230, 150, 30);
		txt_SoLuong.setHorizontalAlignment(JLabel.LEFT);
		
		txt_DonGia.setText("Giá mua ");
		txt_DonGia.setFont(font);
		txt_DonGia.setBounds(500, 270, 150, 30);
		txt_DonGia.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		txt_NhaCungCap.setText("NCC");
		txt_NhaCungCap.setFont(font);
		txt_NhaCungCap.setBounds(500, 310, 150, 30);
		txt_NhaCungCap.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TongTien.setText("Thành tiền");
		txt_TongTien.setFont(font);
		txt_TongTien.setBounds(500, 350, 150, 30);
		txt_TongTien.setHorizontalAlignment(JLabel.LEFT);
		
		txt_ThongTin.setFont(font);
		txt_ThongTin.setBounds(530, 390,250, 30);
		txt_ThongTin.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		
		
		this.add(txt_TieuDe);
		this.add(txt_DSSach);
		this.add(txt_CTPNH);
		this.add(txt_MaSach);
		this.add(txt_TenSach);
		this.add(txt_LoaiSach);
		this.add(txt_SoLuong);
		this.add(txt_DonGia);
		this.add(txt_TongTien);
		this.add(txt_NhaCungCap);
		this.add(txt_ThongTin);
		
	}
	public void thietLapGiaoDienTf() {
		tf_TimKiem.setBounds(160, 60, 170, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_MaSach.setBounds(585, 150, 150, 25);
		tf_MaSach.setForeground(Color.black);
		tf_MaSach.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TenSach.setBounds(585, 190, 150, 25);
		tf_TenSach.setForeground(Color.black);
		tf_TenSach.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_SoLuong.setBounds(585, 230, 150, 25);
		tf_SoLuong.setForeground(Color.black);
		tf_SoLuong.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_DonGia.setBounds(585, 270, 150, 25);
		tf_DonGia.setForeground(Color.black);
		tf_DonGia.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TongTien.setBounds(585, 350, 150, 25);
		tf_TongTien.setForeground(Color.black);
		tf_TongTien.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_TimKiem);
		this.add(tf_MaSach);
		this.add(tf_TenSach);
		this.add(tf_SoLuong);
		this.add(tf_DonGia);
		this.add(tf_TongTien);
	}
	public void thietLapGiaoDienBtn() {
		btn_TimKiem.setText("Tìm sách");
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setBounds(350, 60, 90, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		btn_Them.setText("Thêm CT");
		btn_Them.setFocusable(false);
		btn_Them.setBounds(130, 410, 90, 29);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Sua.setText("Sửa CT");
		btn_Sua.setFocusable(false);
		btn_Sua.setBounds(230, 410, 80, 29);
		btn_Sua.setBackground(Color.lightGray);
		
		btn_Xoa.setText("Xóa CT");
		btn_Xoa.setFocusable(false);
		btn_Xoa.setBounds(320, 410, 80, 29);
		btn_Xoa.setBackground(Color.lightGray);
		
		btn_TaoLai.setText("Tạo lại");
		btn_TaoLai.setFocusable(false);
		btn_TaoLai.setBounds(410, 410, 90, 29);
		btn_TaoLai.setBackground(Color.lightGray);
		
		btn_QuayLai.setText("Trở về");
		btn_QuayLai.setFocusable(false);
		btn_QuayLai.setBounds(10, 10, 90, 29);
		btn_QuayLai.setBackground(Color.lightGray);
		
		btn_ThanhToan.setText("Thanh toán");
		btn_ThanhToan.setFocusable(false);
		btn_ThanhToan.setBounds(580, 430, 100, 29);
		btn_ThanhToan.setBackground(Color.lightGray);
		
		this.add(btn_TimKiem);
		this.add(btn_Them);
		this.add(btn_Sua);
		this.add(btn_QuayLai);
		this.add(btn_ThanhToan);
		this.add(btn_Xoa);
		this.add(btn_TaoLai);
	}
	public void taoBang() {
		tb_BangSanPham = new myTable();
		JTableHeader header = tb_BangSanPham.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_BangSanPham);
		scroll.setBounds(10, 100, 480, 300);
		this.add(scroll);
		
		tb_CTPNH = new myTable();
		JTableHeader headerCT = tb_CTPNH.getTableHeader();
		headerCT.setBackground(Color.pink);
		 scrollCT = new JScrollPane(tb_CTPNH);
		scrollCT.setBounds(10, 460, 480, 275);
		this.add(scrollCT);
	}
	public void thietLapBang() {
		ArrayList<book> arrBook = menuManager.bookBUS.returnArrbook();
		
		
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng"};
		

		model_Book = new DefaultTableModel(col, 0);
		model_Book.setColumnIdentifiers(col);
		
			for(book value: arrBook) {
				Vector vt = new Vector();
				vt.add(value.getIdBook());
				vt.add(value.getNameBook());
				vt.add(value.getIdTypeBook());
				vt.add(value.getUnitPrice());
				vt.add(value.getQuantityBook());
				vt.add(value.getDatePublishing());
				vt.add(value.getIdPublishingCompany());
				model_Book.addRow(vt);
			}
		tb_BangSanPham.setModel(model_Book);
		
	}
	public void reastart() {
		restartBook();
		restartCTPNH();
		restartTf();
	}
	public void restartBook() {
		ArrayList<book> arrBook = menuManager.bookBUS.returnArrbook();
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng"};
		

		model_Book = new DefaultTableModel(col, 0);
		model_Book.setColumnIdentifiers(col);
		
			for(book value: arrBook) {
				Vector vt = new Vector();
				vt.add(value.getIdBook());
				vt.add(value.getNameBook());
				vt.add(value.getIdTypeBook());
				vt.add(value.getUnitPrice());
				vt.add(value.getQuantityBook());
				vt.add(value.getDatePublishing());
				vt.add(value.getIdPublishingCompany());
				model_Book.addRow(vt);
			}
		tb_BangSanPham.setModel(model_Book);
	}
	public void restartCTPNH() {
		String col[] = {"Mã sách","Tên sách","Số lượng","Giá mua/1c","Tổng tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		tb_CTPNH.setModel(model_CTPHN);
	}
	public void thietLapCTPNH() {
		String col[] = {"Mã sách","Tên sách","Số lượng","Giá mua/1c","Tổng tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		tb_CTPNH.setModel(model_CTPHN);
		
	}
	public void thietLapGiaoDienCBB() {
		String arrTypeBook[] = menuManager.typeBookBUS.arrStringTypeBookPNH();
		String arrDistributor[] = menuManager.distributorBUS.arrStringDistributor();
		
		cbb_LoaiSach = new JComboBox<String>(arrTypeBook);
		cbb_LoaiSach.setBounds(585, 110, 150, 25);
		
		cbb_NCC = new JComboBox<String>(arrDistributor);
		cbb_NCC.setBounds(585, 310, 150, 25);
		
		this.add(cbb_LoaiSach);
		this.add(cbb_NCC);
	}
	public void GiaoDienXemAnh() {
		Border border = BorderFactory.createLineBorder(Color.gray);
		image_SanPham.setBorder(border);
		image_SanPham.setBounds(550, 530, 160, 160);
		image_SanPham.setHorizontalAlignment(0);
		
		txt_XemAnh.setText("Hình ảnh");
		txt_XemAnh.setBounds(610,700, 100, 25);
		txt_XemAnh.setFocusable(false);
		txt_XemAnh.setBackground(Color.CYAN);
		
		this.add(image_SanPham);
		this.add(txt_XemAnh);
	}
	public void OffFuction() {
		cbb_LoaiSach.disable();
		tf_MaSach.disable();
		tf_TenSach.disable();
		tf_TongTien.disable();
	}
	public void event() {
		eventBangSach();
		eventBtnBack();
		eventSearch();
		eventAddObject();
		eventTinhTongTien();
		eventTaoLai();
		eventModifyObject();
		eventDeleteObject();
		eventThanhToan();
	}
	public void eventBangSach() {
		tb_BangSanPham.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				restartTf();
				eventGetData();
				eventImageBook();
			}
		});
	}
	public void eventGetData() {
		int row = tb_BangSanPham.getSelectedRow();
		String id = model_Book.getValueAt(row, 0)+"";
		book b = menuManager.bookBUS.returnObject(id);
		int index = menuManager.typeBookBUS.indexTypeBook(b.getIdTypeBook());
		cbb_LoaiSach.setSelectedIndex(index+1);
		tf_MaSach.setText(b.getIdBook());
		tf_TenSach.setText(b.getNameBook());
	}
	public void eventBtnBack() {
		btn_QuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pn_Manager_NhapHang.pn_PhieuNhapHang.restartThongBao();
				pn_Manager_NhapHang.pn_CTPNH.setVisible(false);
				pn_Manager_NhapHang.pn_PhieuNhapHang.setVisible(true);
			}
		});
	}
	public void eventSearch() {
		tf_TimKiem.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				search();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void search() {
		String s = tf_TimKiem.getText();
		ArrayList<book> arr = menuManager.bookBUS.arrSearch(s);
		thietLapBang(arr);
	}
	public void thietLapBang(ArrayList<book> arrBook) {		
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng"};
		

		model_Book = new DefaultTableModel(col, 0);
		model_Book.setColumnIdentifiers(col);
		
			for(book value: arrBook) {
				Vector vt = new Vector();
				vt.add(value.getIdBook());
				vt.add(value.getNameBook());
				vt.add(value.getIdTypeBook());
				vt.add(value.getUnitPrice());
				vt.add(value.getQuantityBook());
				vt.add(value.getDatePublishing());
				vt.add(value.getIdPublishingCompany());
				model_Book.addRow(vt);
			}
		tb_BangSanPham.setModel(model_Book);
		
	}
	public void eventImageBook() {
		int row = tb_BangSanPham.getSelectedRow();
		String s = model_Book.getValueAt(row, 0)+"";
		String link = menuManager.link.getLink(s);
		image_SanPham.setIcon(new ImageIcon(link));
	}
	public void eventAddObject() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addObject();
			}
		});
	}
	public void thietLapBangCT() {
		ArrayList<detailCoupon> arr = menuManager.dtCoupon.returnArrCTCreate(-1);
		thietLapCTPNH(arr);
		
	}
	public void thietLapCTPNH(ArrayList<detailCoupon> arr) {
		String col[] = {"Mã sách","Tên sách","Số lượng","Giá mua/1c","Tổng tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		for(detailCoupon value: arr) {
			Vector vt = new Vector();
			vt.add(value.getIdBook());
			vt.add(menuManager.bookBUS.returnNameBook(value.getIdBook()));
			vt.add(value.getQuantityImport());
			vt.add(value.getUnitPrice());
			vt.add(value.getIntoMoney());
			model_CTPHN.addRow(vt);
		}
		tb_CTPNH.setModel(model_CTPHN);
		
		
	}
	public void addObject() {
		String id =""+ tf_MaSach.getText();
		String quantity = "" + tf_SoLuong.getText();
		String price = "" + tf_DonGia.getText();
		String sumPrice = tf_TongTien.getText();
		String idCoupon = "-1";
		String result = menuManager.dtCoupon.addObject(id, idCoupon, price, sumPrice, quantity);
		hienThiLoi(result, "Thêm chi tiết thành công");
		
	}
	public void hienThiLoi(String error, String message) {
		txt_ThongTin.setForeground(Color.red);
		switch (error) {
		case "Error":{
			txt_ThongTin.setText("Không có sản phẩm");
			break;
		}
		case "Error quantity":{
			txt_ThongTin.setText("SL không hợp lệ!");
			break;
		}
		case "Error duplicate":{
			txt_ThongTin.setText("Sản phẩm đã có trong chi tiết");
			break;
		}
		case "Error price":{
			txt_ThongTin.setText("Đơn giá sai!");
			break;
		}
		default :{
			thietLapBangCT();
			txt_ThongTin.setForeground(Color.green);
			txt_ThongTin.setText(message);
			if(message.compareTo("Sửa chi tiết thành công") != 0)
			break;
		}
		}
	}
	public void eventTinhTongTien() {
		tf_DonGia.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				eventTongTien();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventTongTien() {
		String DonGia = ""+tf_DonGia.getText();
		String soLuong = ""+tf_SoLuong.getText();
		String tongTien = menuManager.dtCoupon.returnSumPrice(DonGia, soLuong);
		tf_TongTien.setText(tongTien);
	}
	public void eventTaoLai() {
		btn_TaoLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
				
			}
		});
	}
	public void restart() {
		restartTf();
		thietLapBang();
		
	}
	public void restartTf() {
		txt_ThongTin.setText("");
		tf_DonGia.setText("");
		tf_MaSach.setText("");
		tf_SoLuong.setText("");
		tf_TenSach.setText("");
		tf_TimKiem.setText("");
		tf_TongTien.setText("");
		cbb_LoaiSach.setSelectedIndex(0);
		cbb_NCC.setSelectedIndex(0);
		image_SanPham.setIcon(null);
	}
	public void eventModifyObject() {
		btn_Sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifyObject();
				
			}
		});
	}
	public void modifyObject() {
		String id =""+ tf_MaSach.getText();
		String quantity = "" + tf_SoLuong.getText();
		String price = "" + tf_DonGia.getText();
		String sumPrice = tf_TongTien.getText();
		String idCoupon = "-1";
		String result = menuManager.dtCoupon.modifyObject(id, idCoupon, price, sumPrice, quantity);
		hienThiLoi(result, "Sửa chi tiết thành công");
	}
	public void eventDeleteObject() {
		btn_Xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteObject();
			}
		});
	}
	public void deleteObject() {
		String id =""+ tf_MaSach.getText();
		String quantity = "" + tf_SoLuong.getText();
		String price = "" + tf_DonGia.getText();
		String sumPrice = tf_TongTien.getText();
		String idCoupon = "-1";
		String result = menuManager.dtCoupon.deleteObject(id, idCoupon, price, sumPrice, quantity);
		hienThiLoi(result, "Xóa chi tiết thành công");
	}
	public void eventThanhToan() {
		btn_ThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				payment();
				
			}
		});
	}
	public void payment() {
		String idNCC = cbb_NCC.getItemAt(cbb_NCC.getSelectedIndex());
		String result = menuManager.couponBUS.paymentCoupon(idNCC);
		hienThiThanhToan(result);
		
	}
	public void hienThiThanhToan(String s) {
		if(s.compareToIgnoreCase("0") == 0) {
			JOptionPane.showMessageDialog(null, "Thanh toán hoàn tất","Trạng thái thanh toán",JOptionPane.YES_OPTION);
			thietLapBangCT();
		}
		else
		{
			txt_ThongTin.setBackground(Color.red);
			txt_ThongTin.setText("Chưa có sản phẩm nào");
		}
			
	}
	
}
