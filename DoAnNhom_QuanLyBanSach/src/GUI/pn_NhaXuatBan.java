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
import javax.swing.ImageIcon;
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
import DTO.publishingCompany;
import DTO.typeBook;

public class pn_NhaXuatBan extends JPanel {
	public pn_NhaXuatBan() {
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
	private JLabel txt_BangNXB;
	private JLabel txt_MaNXB;
	private JLabel txt_BangSp;
	private JLabel txt_TenNXB;
	private JTextField tf_MaNXB;
	private JTextField tf_TenNXB;
	private JButton btn_Them;
	private JButton btn_Sua;
	private JLabel btn_TimKiem;
	private JTextField tf_TimKiem;
	private JTable tb_BangSp;
	private JTable tb_BangNXBSp;
	private DefaultTableModel model_NXBSp;
	private DefaultTableModel model_Sp;
	private JScrollPane scroll;
	private JScrollPane scrollSp;
	private JLabel txtLoiMa;
	private JLabel txtLoiTen;
	private JLabel txt_ThanhCong;
	private JLabel txt_TimThay;
	private JButton btn_TaoLai;
	
	public void KhoiTao() {
		txt_TieuDe = new JLabel();
		txt_ThongtinSp = new JLabel();
		txt_MaNXB = new JLabel();
		txt_TenNXB = new JLabel();
		tf_MaNXB = new JTextField();
		tf_TenNXB = new JTextField();
		tf_TimKiem = new JTextField();
		btn_Sua = new JButton();
		btn_Them = new JButton();
		btn_TimKiem = new JLabel();
		txt_BangNXB = new JLabel();
		txt_BangSp = new JLabel();
		txtLoiMa = new JLabel();
		txtLoiTen = new JLabel();
		txt_ThanhCong = new JLabel();
		txt_TimThay = new JLabel();
		btn_TaoLai = new JButton();
	}
	public void ThietLap() {
		thietLapBang();
		thietLapLoi();
		thietLapGiaoDienText();
		thietLapGiaoDienTf();
		thietLapGiaoDienBtn();
		thietLapBangNXB();
		thietLapBangSp();
		
	}
	public void thietLapGiaoDienText() {
Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Quản lý nhà xuất bản");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_ThongtinSp.setText("Thông tin NXB");
		txt_ThongtinSp.setFont(font);
		txt_ThongtinSp.setHorizontalAlignment(0);
		txt_ThongtinSp.setBounds(90, 50, 150, 22);
		
		txt_BangSp.setText("Danh sách sản phẩm");
		txt_BangSp.setFont(font);
		txt_BangSp.setHorizontalAlignment(0);
		txt_BangSp.setBounds(10, 380, 180, 22);
		
		txt_BangNXB.setText("Bảng nhà xuất bản");
		txt_BangNXB.setFont(font);
		txt_BangNXB.setHorizontalAlignment(0);
		txt_BangNXB.setBounds(460, 50, 150, 22);
		
		txt_MaNXB.setText("Mã NXB           ");
		txt_MaNXB.setFont(font);
		txt_MaNXB.setHorizontalAlignment(0);
		txt_MaNXB.setBounds(20, 105, 150, 30);
		
		txt_TenNXB.setText("Tên NXB          ");
		txt_TenNXB.setFont(font);
		txt_TenNXB.setHorizontalAlignment(0);
		txt_TenNXB.setBounds(20, 135, 150, 30);
		
		txt_TimThay.setForeground(Color.green);
		txt_TimThay.setFont(font);
		txt_TimThay.setBounds(40, 335, 200, 30);
		
		this.add(txt_TieuDe);
		this.add(txt_ThongtinSp);
		this.add(txt_MaNXB);
		this.add(txt_TenNXB);
		this.add(txt_BangNXB);
		this.add(txt_BangSp);
		this.add(txt_TimThay);
		
	}
	public void thietLapGiaoDienTf() {
		
		tf_MaNXB.setBounds(130, 105, 150, 25);
		tf_MaNXB.setForeground(Color.black);
		tf_MaNXB.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TenNXB.setBounds(130, 135, 150, 25);
		tf_TenNXB.setForeground(Color.black);
		tf_TenNXB.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TimKiem.setBounds(130, 250, 150, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_MaNXB);
		this.add(tf_TenNXB);
		this.add(tf_TimKiem);
	}
	public void thietLapGiaoDienBtn() {
		btn_Them.setText("Thêm");
		btn_Them.setFocusable(false);
		btn_Them.setIcon(new ImageIcon("image//image//them.png"));
		btn_Them.setBounds(60, 200, 85, 30);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Sua.setText("Sửa");
		btn_Sua.setFocusable(false);
		btn_Sua.setIcon(new ImageIcon("image//image//sua.png"));
		btn_Sua.setBounds(160, 200, 85, 30);
		btn_Sua.setBackground(Color.lightGray);
		
		
		btn_TimKiem.setText("Tìm kiếm loại sách");
		btn_TimKiem.setBounds(10, 250, 200, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		btn_TaoLai.setText("Tạo lại");
		btn_TaoLai.setFocusable(false);
		btn_TaoLai.setIcon(new ImageIcon("image//image//TaoLai.png"));
		btn_TaoLai.setBounds(100, 300, 100, 30);
		btn_TaoLai.setBackground(Color.lightGray);
		
		
		this.add(btn_Them);
		this.add(btn_Sua);
		this.add(btn_TimKiem);
		this.add(btn_TaoLai);
	}
	public void thietLapBang() {
		tb_BangNXBSp = new myTable();
		JTableHeader header = tb_BangNXBSp.getTableHeader();
		header.setBackground(Color.pink);
		
		scroll = new JScrollPane(tb_BangNXBSp);
		scroll.setBounds(330, 105, 400, 300);
		this.add(scroll);
		tb_BangSp = new myTable();
		
		JTableHeader headerSp = tb_BangSp.getTableHeader();
		headerSp.setBackground(Color.pink);
		scrollSp = new JScrollPane(tb_BangSp);
		scrollSp.setBounds(10, 410, 740, 330);
		this.add(scrollSp);
	}
	public void thietLapBangNXB() {
		ArrayList<typeBook> arrType = menuManager.typeBookBUS.returnArrType();
		
		
		String col [] = {"Mã nhà xuất bản", "Tên nhà xuất bảng"};
		

		model_NXBSp = new DefaultTableModel(col, 0);
		model_NXBSp.setColumnIdentifiers(col);
		
			for(publishingCompany value: menuManager.pubBUS.returnArrPublishingCPN()) {
				Vector vt = new Vector();
				vt.add(value.getIdPublishingCompany());
				vt.add(value.getNamePublishingCompany());
				model_NXBSp.addRow(vt);
			}
			tb_BangNXBSp.setModel(model_NXBSp);
		
	}
	public void restart() {
		restartBangNXB();
		restartBangSP();
		restartTf();
		resertError();
	}
	public void restartTf() {
		tf_MaNXB.setText("");
		tf_TenNXB.setText("");
		tf_TimKiem.setText("");
		txt_TimThay.setText("");
	}
	public void restartBangNXB() {
		ArrayList<typeBook> arrType = menuManager.typeBookBUS.returnArrType();
		String col [] = {"Mã nhà xuất bản", "Tên nhà xuất bảng"};
		

		model_NXBSp = new DefaultTableModel(col, 0);
		model_NXBSp.setColumnIdentifiers(col);
		
			for(publishingCompany value: menuManager.pubBUS.returnArrPublishingCPN()) {
				Vector vt = new Vector();
				vt.add(value.getIdPublishingCompany());
				vt.add(value.getNamePublishingCompany());
				model_NXBSp.addRow(vt);
			}
			tb_BangNXBSp.setModel(model_NXBSp);
	}
	public void restartBangSP() {
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng","Ngày xuất bản" ,"Nhà phát hành"};
		

		model_Sp = new DefaultTableModel(col, 0);
		model_Sp.setColumnIdentifiers(col);
		tb_BangSp.setModel(model_Sp);
	}
	public void thietLapBangSp() {
		
		
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng","Ngày xuất bản" ,"Nhà phát hành"};
		

		model_Sp = new DefaultTableModel(col, 0);
		model_Sp.setColumnIdentifiers(col);
		tb_BangSp.setModel(model_Sp);
		
	}
	public void event() {
		eventgetTbType();
		eventTaoLai();
		eventBtnThemNXB();
		eventBtnSuaNXB();
		eventBtnSearch();
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
				
				
			}
		});
	}
	public void eventGetData() {
		tf_MaNXB.disable();
		int row = tb_BangNXBSp.getSelectedRow();
		String idType = model_NXBSp.getValueAt(row, 0)+"";
		for(publishingCompany value: menuManager.pubBUS.returnArrPublishingCPN()) {
			if(value.getIdPublishingCompany().compareToIgnoreCase(idType) == 0)
			{
				tf_MaNXB.setText(value.getIdPublishingCompany());
				tf_TenNXB.setText(value.getNamePublishingCompany());
			}
		}
		
	}
	public void eventGetDataProduct() {
		int row = tb_BangNXBSp.getSelectedRow();
		String idType = model_NXBSp.getValueAt(row, 0)+"";
		ArrayList<book> arrBook = menuManager.bookBUS.returnArrBookSamePublishingCPN(idType);
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng","Ngày xuất bản" ,"Nhà phát hành"};
		model_Sp = new DefaultTableModel(col, 0);
		model_Sp.setColumnIdentifiers(col);
		for(book value: arrBook) {
			Vector vt = new Vector();
			vt.add(value.getIdBook());
			vt.add(value.getNameBook());
			vt.add(value.getIdTypeBook());
			vt.add(value.getUnitPrice());
			vt.add(value.getQuantityBook());
			vt.add(value.getDatePublishing());
			vt.add(value.getIdPublishingCompany());
			model_Sp.addRow(vt);
		}
		this.tb_BangSp.setModel(model_Sp);
	}
	
	public void eventBtnThemNXB() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				eventThem();
				
				
			}
		});
	}
	public void eventThem() {
		String id = ""+ tf_MaNXB.getText();
		String ten = "" + tf_TenNXB.getText();
		String result = menuManager.pubBUS.addObject(id, ten);
		xuLyThem(result);
	}
	public void xuLyThem(String key) {
		switch (key) {
		case "Error id": {
			txtLoiMa.setText("Mã trùng lặp");
			break;
		}
		case "Error name": {
			txtLoiTen.setText("Tên không được để trống");
			break;
		}
		default:
			thietLapBangNXB();
			txt_ThanhCong.setText("Thêm nhà xuất bản thành công");
			break;
		}
	}
	public void eventTaoLai() {
		btn_TaoLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_MaNXB.enable();
				
				restart();
				
				
			}
		});
	}
	public void resertError() {
		
		txtLoiMa.setText("");
		txtLoiTen.setText("");
		txt_ThanhCong.setText("");
		txt_TimThay.setText("");
	}
	public void thietLapLoi() {
		txtLoiMa.setBounds(120, 160, 150, 30);
		txtLoiMa.setForeground(Color.red);
		txtLoiTen.setBounds(120, 160, 150, 30);
		txtLoiTen.setForeground(Color.red);
		txt_ThanhCong.setBounds(120, 160, 200, 30);
		txt_ThanhCong.setForeground(Color.green);
		
		
		this.add(txtLoiMa);
		this.add(txtLoiTen);
		this.add(txt_ThanhCong);
	}
	public void eventBtnSuaNXB() {
		btn_Sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				thietLapSua();
				
			}
		});
	}
	public void thietLapSua() {
		String id = ""+ tf_MaNXB.getText();
		String ten = "" + tf_TenNXB.getText();
		String result = menuManager.pubBUS.modifyObject(id, ten);
		xuLySua(result);
	}
	public void xuLySua(String key) {
		switch (key) {
		case "Error name": {
			txtLoiTen.setText("Tên không được để trống");
			break;
		}
		default:
			thietLapBangNXB();
			txt_ThanhCong.setText("Sửa tên nhà xuất bản thành công");
			break;
		}
	}
	public void eventBtnSearch() {
		tf_TimKiem.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				resertError();
				eventSearch();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventSearch() {
		ArrayList<publishingCompany> arr =  menuManager.pubBUS.arrSearch(tf_TimKiem.getText());
		thietLapBangNXB(arr);
		txt_TimThay.setText("Tìm thấy " + arr.size() + " nhà xuất bản");
	}
	public void thietLapBangNXB(ArrayList<publishingCompany> arr) {
		String col [] = {"Mã nhà xuất bản", "Tên nhà xuất bảng"};
		

		model_NXBSp = new DefaultTableModel(col, 0);
		model_NXBSp.setColumnIdentifiers(col);
		
			for(publishingCompany value: arr) {
				Vector vt = new Vector();
				vt.add(value.getIdPublishingCompany());
				vt.add(value.getNamePublishingCompany());
				model_NXBSp.addRow(vt);
			}
			tb_BangNXBSp.setModel(model_NXBSp);
		
	}
	
}
