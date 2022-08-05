package GUI;

import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.bookBUS;
import BUS.publishingCompanyBUS;
import BUS.typeBookBUS;
import DTO.book;
import DTO.bookDistributor;
import DTO.coupon;
import DTO.employee;
import DTO.publishingCompany;
import DTO.typeBook;

public class pn_NhaCungCap extends JPanel {
	public pn_NhaCungCap() {
		this.setLayout(null);
		this.setBounds(0, 20,770, 745);
		Border border = BorderFactory.createLineBorder(Color.black);
		setBorder(border);
		
		KhoiTao();
		ThietLap();
		event();
		
	}
	private JLabel txt_TieuDe;
	private JLabel txt_ThongtinSp;
	private JLabel txt_BangNhaCungUng;
	private JLabel txt_MaNhaCungUng;
	private JLabel txt_BangPNH;
	private JLabel txt_TenNXB;
	private JTextField tf_MaNXB;
	private JTextField tf_TenNXB;
	private JButton btn_Them;
	private JButton btn_Sua;
	private JButton btn_Xoa;
	private JLabel btn_TimKiem;
	private JTextField tf_TimKiem;
	private JTable tb_BangSp;
	private JTable tb_BangNXBSp;
	private DefaultTableModel model_NXBSp;
	private DefaultTableModel model_Sp;
	private JLabel txt_SoDienThoai;
	private JLabel txt_DiaChi;
	private JLabel txt_Email;
	private JTextField tf_DiaChi;
	private JTextField tf_Email;
	private JTextField tf_SoDienThoai;
	private JLabel txt_Error;
	private JScrollPane scroll;
	private JScrollPane scrollCT;

	
	public void KhoiTao() {
		khoiTaoBang();
		txt_Error = new JLabel();
		txt_TieuDe = new JLabel();
		txt_ThongtinSp = new JLabel();
		txt_MaNhaCungUng = new JLabel();
		txt_TenNXB = new JLabel();
		tf_MaNXB = new JTextField();
		tf_TenNXB = new JTextField();
		tf_TimKiem = new JTextField();
		btn_Sua = new JButton();
		btn_Them = new JButton();
		btn_TimKiem = new JLabel();
		btn_Xoa = new JButton();
		txt_BangNhaCungUng = new JLabel();
		txt_BangPNH = new JLabel();
		txt_SoDienThoai = new JLabel();
		txt_DiaChi = new JLabel();
		txt_Email = new JLabel();
		tf_DiaChi = new JTextField();
		tf_Email = new JTextField();
		tf_SoDienThoai = new JTextField();
	}
	public void ThietLap() {
		
		thietLapGiaoDienText();
		thietLapGiaoDienTf();
		thietLapGiaoDienBtn();
		thietLapBangLoaiSp();
		thietLapBangSp();
		
	}
	public void thietLapGiaoDienText() {
Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Quản lý nhà xuất bản");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_ThongtinSp.setText("Thông tin nhà cung cấp");
		txt_ThongtinSp.setFont(font);
		txt_ThongtinSp.setHorizontalAlignment(0);
		txt_ThongtinSp.setBounds(90, 70, 180, 22);
		
		txt_BangPNH.setText("Danh sách PNH");
		txt_BangPNH.setFont(font);
		txt_BangPNH.setHorizontalAlignment(0);
		txt_BangPNH.setBounds(10, 380, 180, 22);
		
		txt_BangNhaCungUng.setText("Bảng nhà cung cấp");
		txt_BangNhaCungUng.setFont(font);
		txt_BangNhaCungUng.setHorizontalAlignment(0);
		txt_BangNhaCungUng.setBounds(460, 70, 150, 22);
		
		txt_MaNhaCungUng.setText("Mã NCC           ");
		txt_MaNhaCungUng.setFont(font);
		txt_MaNhaCungUng.setHorizontalAlignment(JLabel.LEFT);
		txt_MaNhaCungUng.setBounds(40, 105, 150, 30);
		
		txt_TenNXB.setText("Tên NCC          ");
		txt_TenNXB.setFont(font);
		txt_TenNXB.setHorizontalAlignment(JLabel.LEFT);
		txt_TenNXB.setBounds(40, 135, 150, 30);
		
		txt_SoDienThoai.setText("SĐT      ");
		txt_SoDienThoai.setFont(font);
		txt_SoDienThoai.setHorizontalAlignment(JLabel.LEFT);
		txt_SoDienThoai.setBounds(40, 165, 150, 30);
		
		txt_DiaChi.setText("Địa chỉ ");
		txt_DiaChi.setFont(font);
		txt_DiaChi.setHorizontalAlignment(JLabel.LEFT);
		txt_DiaChi.setBounds(40, 195, 150, 30);
		
		txt_Email.setText("Email");
		txt_Email.setFont(font);
		txt_Email.setHorizontalAlignment(JLabel.LEFT);
		txt_Email.setBounds(40, 225, 150, 30);
		
		txt_Error.setFont(font);
		txt_Error.setHorizontalAlignment(0);
		txt_Error.setBounds(50, 260, 300, 30);
		
		this.add(txt_TieuDe);
		this.add(txt_ThongtinSp);
		this.add(txt_MaNhaCungUng);
		this.add(txt_TenNXB);
		this.add(txt_BangNhaCungUng);
		this.add(txt_BangPNH);
		this.add(txt_SoDienThoai);
		this.add(txt_Email);
		this.add(txt_DiaChi);
		this.add(txt_Error);
		
	}
	public void thietLapGiaoDienTf() {
		
		tf_MaNXB.setBounds(130, 105, 150, 25);
		tf_MaNXB.setForeground(Color.black);
		tf_MaNXB.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TenNXB.setBounds(130, 135, 150, 25);
		tf_TenNXB.setForeground(Color.black);
		tf_TenNXB.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TimKiem.setBounds(130, 340, 150, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_SoDienThoai.setBounds(130, 165, 150, 25);
		tf_SoDienThoai.setForeground(Color.black);
		tf_SoDienThoai.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_DiaChi.setBounds(130, 195, 150, 25);
		tf_DiaChi.setForeground(Color.black);
		tf_DiaChi.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_Email.setBounds(130, 225, 150, 25);
		tf_Email.setForeground(Color.black);
		tf_Email.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_MaNXB);
		this.add(tf_TenNXB);
		this.add(tf_TimKiem);
		this.add(tf_DiaChi);
		this.add(tf_Email);
		this.add(tf_SoDienThoai);
	}
	public void thietLapGiaoDienBtn() {
		btn_Them.setText("Thêm");
		btn_Them.setFocusable(false);
		btn_Them.setBounds(40, 300, 70, 30);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Sua.setText("Sửa");
		btn_Sua.setFocusable(false);
		btn_Sua.setBounds(125, 300, 70, 30);
		btn_Sua.setBackground(Color.lightGray);
		
		btn_Xoa.setText("Tạo lại");
		btn_Xoa.setFocusable(false);
		btn_Xoa.setBounds(210, 300, 90, 30);
		btn_Xoa.setBackground(Color.lightGray);
		
		btn_TimKiem.setText("Tìm kiếm");
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setBounds(50, 340, 70, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		
		
		this.add(btn_Them);
		this.add(btn_Sua);
		this.add(btn_Xoa);
		this.add(btn_TimKiem);
	}
	public void khoiTaoBang() {
		tb_BangNXBSp = new myTable();
		JTableHeader header = tb_BangNXBSp.getTableHeader();
		header.setBackground(Color.pink);
		
		scroll = new JScrollPane(tb_BangNXBSp);
		scroll.setBounds(330, 105, 420, 300);
		this.add(scroll);
		
		tb_BangSp = new myTable();
		
		JTableHeader headerCT = tb_BangSp.getTableHeader();
		headerCT.setBackground(Color.pink);
		 scrollCT = new JScrollPane(tb_BangSp);
		scrollCT.setBounds(10, 410, 740, 320);
		this.add(scrollCT);
	}
	public void thietLapBangLoaiSp() {
		ArrayList<bookDistributor> arrDis = menuManager.distributorBUS.returnArrDistributor();
		
		
		String col [] = {"Mã NCC", "Tên NCC","SĐT","Địa chỉ","Email"};
		

		model_NXBSp = new DefaultTableModel(col, 0);
		model_NXBSp.setColumnIdentifiers(col);
		
			for(bookDistributor value: arrDis) {
				Vector vt = new Vector();
				vt.add(value.getIdBookDistributor());
				vt.add(value.getNameDistributor());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddressDistributor());
				vt.add(value.getEmail());
				
				model_NXBSp.addRow(vt);
			}
			tb_BangNXBSp.setModel(model_NXBSp);
		
	}
	public void restartBangNCC() {
		ArrayList<bookDistributor> arrDis = menuManager.distributorBUS.returnArrDistributor();

		String col [] = {"Mã NCC", "Tên NCC","SĐT","Địa chỉ","Email"};
		

		model_NXBSp = new DefaultTableModel(col, 0);
		model_NXBSp.setColumnIdentifiers(col);
		
			for(bookDistributor value: arrDis) {
				Vector vt = new Vector();
				vt.add(value.getIdBookDistributor());
				vt.add(value.getNameDistributor());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddressDistributor());
				vt.add(value.getEmail());
				
				model_NXBSp.addRow(vt);
			}
			tb_BangNXBSp.setModel(model_NXBSp);
	}
	public void restartTf() {
		tf_DiaChi.setText("");
		tf_Email.setText("");
		tf_MaNXB.setText("");
		tf_SoDienThoai.setText("");
		tf_TenNXB.setText("");
		tf_TimKiem.setText("");
	}
	public void restartPNH() {
		String col [] = {"Mã phiếu nhập hàng", "Ngày nhập hàng" ,"Tổng tiền"};
		

		model_Sp = new DefaultTableModel(col, 0);
		model_Sp.setColumnIdentifiers(col);
		tb_BangSp.setModel(model_Sp);
	}
	public void thietLapBangSp() {
		
		
		String col [] = {"Mã phiếu nhập hàng", "Ngày nhập hàng" ,"Tổng tiền"};
		

		model_Sp = new DefaultTableModel(col, 0);
		model_Sp.setColumnIdentifiers(col);
		tb_BangSp.setModel(model_Sp);
		
	}
	public void event() {
		eventgetTbType();
		eventAddObject();
		eventModifyObject();
		eventTaoLai();
		eventSearch();
	}
	public void eventgetTbType() {
		tb_BangNXBSp.addMouseListener(new MouseListener() {
			
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
				eventGetData();
				eventGetDataProduct();
				xoaLoi();
			}
		});
	}
	public void eventGetData() {
		tf_MaNXB.disable();
		int row = tb_BangNXBSp.getSelectedRow();
		String idType = model_NXBSp.getValueAt(row, 0)+"";
		bookDistributor dis = menuManager.distributorBUS.returnObject(idType);
		tf_MaNXB.setText(dis.getIdBookDistributor());
		tf_TenNXB.setText(dis.getNameDistributor());
		tf_SoDienThoai.setText(dis.getPhoneNumber());
		tf_DiaChi.setText(dis.getAddressDistributor());
		tf_Email.setText(dis.getEmail());
		
	}
	public void eventGetDataProduct() {
		int row = tb_BangNXBSp.getSelectedRow();
		String idType = model_NXBSp.getValueAt(row, 0)+"";
		ArrayList<coupon> arr = menuManager.couponBUS.returnListPNH(idType);
		String col [] = {"Mã phiếu nhập hàng", "Ngày nhập hàng" ,"Tổng tiền"};
		

		model_Sp = new DefaultTableModel(col, 0);
		model_Sp.setColumnIdentifiers(col);
		for(coupon value: arr) {
			Vector vt = new Vector();
			vt.add(value.getIdCoupon());
			vt.add(value.getDateAdded()+"");
			vt.add(value.getIntoMoney());
			
			model_Sp.addRow(vt);
		}
		tb_BangSp.setModel(model_Sp);
	}
	public void eventAddObject() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addObject();
				
			}
		});
	}
	public void addObject() {
		String address = tf_DiaChi.getText()+"";
		String mail = tf_Email.getText()+ "";
		String id = tf_MaNXB.getText()+ "";
		String phone = tf_SoDienThoai.getText()+ "";
		String name = tf_TenNXB.getText()+"";
		String result = menuManager.distributorBUS.addObject(id, name, phone, address, mail);
		hienThiLoi(result,"Thêm nhân viên thành công");
 	}
	public void hienThiLoi(String error, String message) {
		txt_Error.setForeground(Color.red);
		switch (error) {
		case "Error id": {
			txt_Error.setText("Mã trùng lặp");
			break;
		}
		case "Error mail": {
			txt_Error.setText("Địa chỉ mail không hợp lệ");
			break;
		}
		case "Error name": {
			txt_Error.setText("Lỗi tên rỗng");
			break;
		}
		case "Error phone": {
			txt_Error.setText("Số điện thoại không hợp lệ");
			break;
		}
		default:{
			txt_Error.setForeground(Color.green);
			txt_Error.setText(message);
			thietLapBangLoaiSp();
			break;
		}
		}
	}
	public void xoaLoi() {
		txt_Error.setText("");
	}
	public void eventTaoLai() {
		btn_Xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
				
			}
		});
	}
	public void restart() {
		restartBangNCC();
		restartPNH();
		xoaLoi();
		restartTf();
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
		String address = tf_DiaChi.getText()+"";
		String mail = tf_Email.getText()+ "";
		String id = tf_MaNXB.getText()+ "";
		String phone = tf_SoDienThoai.getText()+ "";
		String name = tf_TenNXB.getText()+"";
		String result = menuManager.distributorBUS.modifyObject(id, name, phone, address, mail);
		hienThiLoi(result,"Sửa thông tin nhân viên thành công");
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
		String s = tf_TimKiem.getText()+"";
			ArrayList<bookDistributor> arr = menuManager.distributorBUS.searchBookDistributor(s);
			thietLapBang(arr);
	}
	public void thietLapBang(ArrayList<bookDistributor> arr) {

		String col [] = {"Mã NCC", "Tên NCC","SĐT","Địa chỉ","Email"};
		

		model_NXBSp = new DefaultTableModel(col, 0);
		model_NXBSp.setColumnIdentifiers(col);
		
			for(bookDistributor value: arr) {
				Vector vt = new Vector();
				vt.add(value.getIdBookDistributor());
				vt.add(value.getNameDistributor());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddressDistributor());
				vt.add(value.getEmail());
				
				model_NXBSp.addRow(vt);
			}
			tb_BangNXBSp.setModel(model_NXBSp);
	}
	
}
