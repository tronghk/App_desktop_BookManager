package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import BUS.billBUS;
import BUS.bookBUS;
import BUS.customerBUS;
import BUS.employeeBUS;
import BUS.publishingCompanyBUS;
import BUS.typeBookBUS;
import DTO.book;
import DTO.customer;
import DTO.publishingCompany;
import DTO.typeBook;

public class pn_KhachHang extends JPanel {
	public pn_KhachHang() {
		
		this.setLayout(null);
		this.setBounds(230, 0,770, 800);
		
		KhoiTaoGiaoDien();
		thietLapGiaoDien();
		event();
	}
	
	private JLabel txt_TieuDe;
	private JLabel txt_ThongtinKH;
	private JLabel txt_BXH;
	private JLabel txt_MaKH;
	private JLabel txt_TenKH;
	private JLabel txt_SoDienThoai;
	private JLabel txt_DiaChi;
	private JLabel txt_LoaiKH;
	private JTextField tf_MaKH;
	private JTextField tf_TenKH;
	private JTextField tf_DiaChi;
	private JComboBox<String> tf_LoaiKH;
	private JTextField tf_SoDienThoai;
	private JButton btn_Them;
	private JButton btn_Sua;
	private JButton btn_Xoa;
	private JTable  tb_BangKH;
	private JLabel txt_TimKiem;
	private JTextField tf_TimKiem;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private JTable tb_BangNXBSp;
	private DefaultTableModel model_NXBSp;
	static int count = 0;
	static int count1 = 0;
	static String idKH = "";
	private JLabel txt_Error;
	private JButton btn_TaoLai;
	private JScrollPane scrollBXH;
	static boolean openBanHang =  true;
	
	public void KhoiTaoGiaoDien() {
//		khởi tạo
		txt_TieuDe = new JLabel();
		txt_ThongtinKH = new JLabel();
		txt_MaKH = new JLabel();
		txt_TenKH = new JLabel();
		txt_SoDienThoai = new JLabel();
		txt_DiaChi = new JLabel();
		txt_LoaiKH = new JLabel();
		tf_MaKH = new JTextField();
		tf_TenKH = new JTextField();
		tf_DiaChi = new JTextField();
		tf_SoDienThoai = new JTextField();
		btn_Them = new JButton();
		btn_Sua = new JButton();
		btn_Xoa = new JButton();
		txt_TimKiem = new JLabel();
		tf_TimKiem = new JTextField();
		txt_BXH = new JLabel();
		tb_BangKH = new myTable();
		txt_Error = new JLabel();
		btn_TaoLai = new JButton();
	}
	public void thietLapGiaoDien() {
		thietLapGiaoDienText();
		thietLapGiaoDientf();
		thietLapBtn();
		thietLapBangKH();
		thietLapBang();
		bxhKH();
	}
	public void thietLapGiaoDienText() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Quản lý khách hàng");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_BXH.setText("BXH khách hàng");
		txt_BXH.setFont(font);
		txt_BXH.setHorizontalAlignment(0);
		txt_BXH.setBounds(460, 50, 150, 22);
		
		txt_ThongtinKH.setText("Thông tin khách hàng");
		txt_ThongtinKH.setFont(font);
		txt_ThongtinKH.setHorizontalAlignment(0);
		txt_ThongtinKH.setBounds(90, 50, 170, 22);
		
		txt_MaKH.setText("Mã KH  ");
		txt_MaKH.setFont(font);
		txt_MaKH.setHorizontalAlignment(0);
		txt_MaKH.setBounds(20, 75, 150, 30);
		
		txt_TenKH.setText("Tên KH ");
		txt_TenKH.setFont(font);
		txt_TenKH.setHorizontalAlignment(0);
		txt_TenKH.setBounds(20, 105, 150, 30);
		
		txt_SoDienThoai.setText("SĐT      ");
		txt_SoDienThoai.setFont(font);
		txt_SoDienThoai.setHorizontalAlignment(0);
		txt_SoDienThoai.setBounds(20, 135, 150, 30);
		
		txt_DiaChi.setText("Địa chỉ ");
		txt_DiaChi.setFont(font);
		txt_DiaChi.setHorizontalAlignment(0);
		txt_DiaChi.setBounds(20, 165, 150, 30);
		
		txt_LoaiKH.setText("Loại KH");
		txt_LoaiKH.setFont(font);
		txt_LoaiKH.setHorizontalAlignment(0);
		txt_LoaiKH.setBounds(20, 195, 150, 30);
		
		txt_TimKiem.setText("Từ khóa");
		txt_TimKiem.setFont(font);
		txt_TimKiem.setHorizontalAlignment(0);
		txt_TimKiem.setBounds(310, 300, 150, 30);
		
		txt_Error.setFont(font);
		txt_Error.setHorizontalAlignment(0);
		txt_Error.setBounds(50, 225, 300, 30);
		
		this.add(txt_TieuDe);
		this.add(txt_ThongtinKH);
		this.add(txt_MaKH);
		this.add(txt_TenKH);
		this.add(txt_SoDienThoai);
		this.add(txt_LoaiKH);
		this.add(txt_DiaChi);
		this.add(txt_TimKiem);
		this.add(txt_BXH);
		this.add(txt_Error);
		
	}
	public void thietLapBangKH() {
		JTableHeader header = tb_BangKH.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_BangKH);
		scroll.setBounds(0, 340, 757, 420);
		this.add(scroll);
		
		tb_BangNXBSp = new myTable();
		JTableHeader headerBXH = tb_BangNXBSp.getTableHeader();
		headerBXH.setBackground(Color.pink);
		
		scrollBXH = new JScrollPane(tb_BangNXBSp);
		scrollBXH.setBounds(360, 75, 350, 200);
		this.add(scrollBXH);
	}
	public void thietLapGiaoDientf() {
		tf_MaKH.setBounds(165, 75, 150, 25);
		tf_MaKH.setForeground(Color.black);
		tf_MaKH.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TenKH.setBounds(165, 105, 150, 25);
		tf_TenKH.setForeground(Color.black);
		tf_TenKH.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_SoDienThoai.setBounds(165, 135, 150, 25);
		tf_SoDienThoai.setForeground(Color.black);
		tf_SoDienThoai.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_DiaChi.setBounds(165, 165, 150, 25);
		tf_DiaChi.setForeground(Color.black);
		tf_DiaChi.setFont(new Font("Arial", Font.BOLD, 13));
		
		
		String type[] = {"VIP","TV"};
		tf_LoaiKH = new JComboBox<String>(type);
		tf_LoaiKH.setBounds(165, 195, 150, 25);
		tf_LoaiKH.setForeground(Color.black);
		tf_LoaiKH.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TimKiem.setBounds(430, 300, 150, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_MaKH);
		this.add(tf_TenKH);
		this.add(tf_DiaChi);
		this.add(tf_LoaiKH);
		
		this.add(tf_SoDienThoai);
		this.add(tf_TimKiem);
	}
	public void thietLapBtn() {
		btn_Them.setText("Thêm");
		btn_Them.setFocusable(false);
		btn_Them.setHorizontalAlignment(JButton.LEFT);
		btn_Them.setIcon(new ImageIcon("image//image//customer//themCu.png"));
		btn_Them.setIconTextGap(5);
		btn_Them.setBounds(50, 300, 85, 30);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Sua.setText("Sửa");
		btn_Sua.setFocusable(false);
		btn_Sua.setHorizontalAlignment(JButton.LEFT);
		btn_Sua.setIcon(new ImageIcon("image//image//customer//themCu.png"));
		btn_Sua.setIconTextGap(5);
		btn_Sua.setBounds(140, 300, 85, 30);
		btn_Sua.setBackground(Color.lightGray);
		
		btn_Xoa.setText("Xóa");
		btn_Xoa.setFocusable(false);
		btn_Xoa.setBounds(230, 300, 85, 30);
		btn_Xoa.setIcon(new ImageIcon("image//image//xoa.png"));
		btn_Xoa.setBackground(Color.lightGray);
		
		
		btn_TaoLai.setText("Tạo lại");
		btn_TaoLai.setFocusable(false);
		btn_TaoLai.setIcon(new ImageIcon("image//image//TaoLai.png"));
		btn_TaoLai.setBounds(125, 260, 100, 30);
		btn_TaoLai.setBackground(Color.lightGray);
		
		this.add(btn_Them);
		this.add(btn_Sua);
		this.add(btn_Xoa);
		this.add(btn_TaoLai);
	}
	public void thietLapBang() {
		

		String col [] = {"Mã KH", "Tên KH", "Số điện thoại","Địa chỉ","Loại KH"};
		

		model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		
			for(customer value: menuManager.customerBUS.returnArr()) {
				Vector vt = new Vector();
				vt.add(value.getIdCustomer());
				vt.add(value.getName());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddress());
				vt.add(value.getTypeCustomer());
				model.addRow(vt);
			}
			tb_BangKH.setModel(model);

	}
	public void restartBangKH() {
		String col [] = {"Mã KH", "Tên KH", "Số điện thoại","Địa chỉ","Loại KH"};
		

		model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		
			for(customer value: menuManager.customerBUS.returnArr()) {
				Vector vt = new Vector();
				vt.add(value.getIdCustomer());
				vt.add(value.getName());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddress());
				vt.add(value.getTypeCustomer());
				model.addRow(vt);
			}
			tb_BangKH.setModel(model);
	}
	public void restart() {
		bxhKH();
		restartBangKH();
		restartTf();
		xoaLoi();
	}
	public void restartTf() {
		tf_DiaChi.setText("");
		tf_LoaiKH.setSelectedIndex(0);
		tf_MaKH.setText("");
		tf_SoDienThoai.setText("");
		tf_TenKH.setText("");
		tf_TimKiem.setText("");
	}
	public void event() {
		eventTbCustomer();
		eventAddObject();
		eventTaoLai();
		eventModifyObject();
		eventDeleteObject();
		eventSearch();
		eventBXH();
	}
	public void eventTbCustomer() {
		tb_BangKH.addMouseListener(new MouseListener() {
			
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
				getDataRow();
				setChangeForm();
				xoaLoi();
				
			}
		});
	}
	public void getDataRow() {
		int row = tb_BangKH.getSelectedRow();
		String key = model.getValueAt(row, 0)+"";
		for(customer value: menuManager.customerBUS.returnArr()) {
			if(value.getIdCustomer().compareToIgnoreCase(key) == 0)
			{
				tf_MaKH.setText(value.getIdCustomer());
				tf_TenKH.setText(value.getName());
				tf_SoDienThoai.setText(value.getPhoneNumber());
				tf_DiaChi.setText(value.getAddress());
				tf_LoaiKH.setSelectedIndex(menuManager.customerBUS.changeTypeCustomer(value.getTypeCustomer()));
			}
		}
	}
	public void setChangeForm() {
		count = count+1;
		if(count == 1) {
			idKH = returnStringidKH();
		}
		else {
			String idNew = returnStringidKH();
			if(idKH.compareToIgnoreCase(idNew) == 0)
			{
				count = 0;
				this.setVisible(false);
				PanelLeftGUI.pn_ThongTinKH.thietLapBangHD(idNew);
				PanelLeftGUI.pn_ThongTinKH.thietLapThongTinKH(idNew);
				PanelLeftGUI.pn_ThongTinKH.setVisible(true);
				
				
			}else {
				idKH = idNew;
				count = 1;
			}
			
		}
	}
	public String returnStringidKH() {
		int row  = tb_BangKH.getSelectedRow();
		String key = model.getValueAt(row, 0)+"";
		return key;
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
		String id = tf_MaKH.getText()+"";
		String name = tf_TenKH.getText()+ "";
		String phone = tf_SoDienThoai.getText()+ "";
		String address = tf_DiaChi.getText()+ "";
		String type = tf_LoaiKH.getItemAt(tf_LoaiKH.getSelectedIndex())+ "";
		String result = menuManager.customerBUS.addObject(id, name, phone, address, type);
		hienThiLoi(result,"Thêm khách hàng thành công");
 	}
	public void hienThiLoi(String error, String message) {
		txt_Error.setForeground(Color.red);
		switch (error) {
		case "Error id": {
			txt_Error.setText("Mã trùng lặp");
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
			thietLapBang();
			break;
		}
		}
	}
	public void xoaLoi() {
		txt_Error.setText("");
	}
	public void eventTaoLai() {
		btn_TaoLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				restart();
				
			}
		});
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
		String id = tf_MaKH.getText()+"";
		String name = tf_TenKH.getText()+ "";
		String phone = tf_SoDienThoai.getText()+ "";
		String address = tf_DiaChi.getText()+ "";
		String type = tf_LoaiKH.getItemAt(tf_LoaiKH.getSelectedIndex())+ "";
		String result = menuManager.customerBUS.modifyObject(id, name, phone, address, type);
		hienThiLoi(result,"Sửa thông tin khách hàng thành công");
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
		String id = tf_MaKH.getText()+"";
		String name = tf_TenKH.getText()+ "";
		String phone = tf_SoDienThoai.getText()+ "";
		String address = tf_DiaChi.getText()+ "";
		String type = tf_LoaiKH.getItemAt(tf_LoaiKH.getSelectedIndex())+ "";
		String result = menuManager.customerBUS.deleteObject(id, name, phone, address, type);
		hienThiLoi(result,"Xóa khách hàng thành công");
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
			ArrayList<customer> arr = menuManager.customerBUS.searchCustomer(s);
			thietLapBang(arr);
	}
	public void thietLapBang(ArrayList<customer> arr) {
		String col [] = {"Mã KH", "Tên KH", "Số điện thoại","Địa chỉ","Loại KH"};
		model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		
			for(customer value: arr) {
				Vector vt = new Vector();
				vt.add(value.getIdCustomer());
				vt.add(value.getName());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddress());
				vt.add(value.getTypeCustomer());
				model.addRow(vt);
			}
			tb_BangKH.setModel(model);
			count = 0;
	}
	public void bxhKH() {
		String col [] = {"Top","Tên KH", "Tổng HĐ","Tổng tiền"};
		model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		String arrTopKH[] = menuManager.customerBUS.topCustomer();
		
			for(int i=0;i<arrTopKH.length;i++) {
				String s[] = arrTopKH[i].split("-");
				Vector vt = new Vector();
				vt.add(""+(i+1));
				vt.add(s[3]);
				vt.add(s[2]);
				vt.add(s[1]);
				
				model.addRow(vt);
				if(i == 5)
					break;
			}
			tb_BangNXBSp.setModel(model);
	}
	public void eventBXH() {
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
				setChangeFormBXH();
				
			}
		});
	}
	public String returnIDBXH() {
		int row = tb_BangNXBSp.getSelectedRow();
		String s[] = menuManager.customerBUS.topCustomer();
		String sTemp[] = s[row].split("-");
		return sTemp[0];
		
	}
	public void setChangeFormBXH() {
		count1 = count1+1;
		if(count1 == 1) {
			idKH = returnIDBXH();
		}
		else {
			String idNew = returnIDBXH();
			if(idKH.compareToIgnoreCase(idNew) == 0)
			{
				count1 = 0;
				this.setVisible(false);
				PanelLeftGUI.pn_ThongTinKH.thietLapBangHD(idNew);
				PanelLeftGUI.pn_ThongTinKH.thietLapThongTinKH(idNew);
				PanelLeftGUI.pn_ThongTinKH.setVisible(true);
				
				
			}else {
				idKH = idNew;
				count1 = 1;
			}
			
		}
	}

}
