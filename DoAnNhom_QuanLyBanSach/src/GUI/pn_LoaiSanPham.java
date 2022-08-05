package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.bookBUS;
import BUS.typeBookBUS;
import DTO.book;
import DTO.typeBook;

public class pn_LoaiSanPham extends JPanel {
	public pn_LoaiSanPham() {
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
	private JLabel txt_BangLoaiSp;
	private JLabel txt_MaLoai;
	private JLabel txt_BangSp;
	private JLabel txt_TenLoai;
	private JTextField tf_MaLoai;
	private JTextField tf_TenLoai;
	private JButton btn_Them;
	private JButton btn_Sua;
	private JButton btn_Xoa;
	private JLabel btn_TimKiem;
	private JTextField tf_TimKiem;
	private JTable tb_BangLoaiSp;
	private JTable tb_BangSp;
	private DefaultTableModel model_LoaiSp;
	private DefaultTableModel model_Sp;
	private JButton btn_TaoLai;
	private JScrollPane scroll;
	private JScrollPane scrollSp;
	private JLabel txtLoiMa;
	private JLabel txtLoiTen;
	private JLabel txt_ThanhCong;
	private JLabel txt_TimThay;
	
	public void KhoiTao() {
		txt_TieuDe = new JLabel();
		txt_ThongtinSp = new JLabel();
		txt_MaLoai = new JLabel();
		txt_TenLoai = new JLabel();
		tf_MaLoai = new JTextField();
		tf_TenLoai = new JTextField();
		tf_TimKiem = new JTextField();
		btn_Sua = new JButton();
		btn_Them = new JButton();
		btn_TimKiem = new JLabel();
		btn_Xoa = new JButton();
		txt_BangLoaiSp = new JLabel();
		txt_BangSp = new JLabel();
		btn_TaoLai = new JButton();
		txtLoiMa = new JLabel();
		txtLoiTen = new JLabel();
		txt_ThanhCong = new JLabel();
		txt_TimThay = new JLabel();
	}
	public void ThietLap() {
		thietLapBang();
		thietLapGiaoDienText();
		thietLapGiaoDienTf();
		thietLapGiaoDienBtn();
		thietLapBangLoaiSp();
		thietLapBangSp();
		thietLapLoi();
		
	}
	public void thietLapBang() {
		tb_BangLoaiSp = new myTable();
		JTableHeader header = tb_BangLoaiSp.getTableHeader();
		header.setBackground(Color.pink);
		
		scroll = new JScrollPane(tb_BangLoaiSp);
		scroll.setBounds(330, 105, 400, 300);
		this.add(scroll);
		
		tb_BangSp = new myTable();
		JTableHeader headerSp = tb_BangSp.getTableHeader();
		headerSp.setBackground(Color.pink);
		scrollSp = new JScrollPane(tb_BangSp);
		scrollSp.setBounds(10, 410, 740, 330);
		this.add(scrollSp);
	}
	public void thietLapGiaoDienText() {
Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Quản lý loại sản phẩm");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_ThongtinSp.setText("Thông tin loại");
		txt_ThongtinSp.setFont(font);
		txt_ThongtinSp.setHorizontalAlignment(0);
		txt_ThongtinSp.setBounds(90, 50, 150, 22);
		
		txt_BangSp.setText("Danh sách sản phẩm");
		txt_BangSp.setFont(font);
		txt_BangSp.setHorizontalAlignment(0);
		txt_BangSp.setBounds(10, 380, 180, 22);
		
		txt_BangLoaiSp.setText("Bảng loại sản phẩm");
		txt_BangLoaiSp.setFont(font);
		txt_BangLoaiSp.setHorizontalAlignment(0);
		txt_BangLoaiSp.setBounds(460, 50, 150, 22);
		
		txt_MaLoai.setText("Mã loại           ");
		txt_MaLoai.setFont(font);
		txt_MaLoai.setHorizontalAlignment(0);
		txt_MaLoai.setBounds(20, 105, 150, 30);
		
		txt_TenLoai.setText("Tên loại          ");
		txt_TenLoai.setFont(font);
		txt_TenLoai.setHorizontalAlignment(0);
		txt_TenLoai.setBounds(20, 135, 150, 30);
		
		txt_TimThay.setForeground(Color.green);
		txt_TimThay.setFont(font);
		txt_TimThay.setBounds(40, 335, 150, 30);
		
		this.add(txt_TieuDe);
		this.add(txt_ThongtinSp);
		this.add(txt_MaLoai);
		this.add(txt_TenLoai);
		this.add(txt_BangLoaiSp);
		this.add(txt_BangSp);
		this.add(txt_TimThay);
		
	}
	public void thietLapGiaoDienTf() {
		
		tf_MaLoai.setBounds(130, 105, 150, 25);
		tf_MaLoai.setForeground(Color.black);
		tf_MaLoai.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TenLoai.setBounds(130, 135, 150, 25);
		tf_TenLoai.setForeground(Color.black);
		tf_TenLoai.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TimKiem.setBounds(130, 250, 150, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_MaLoai);
		this.add(tf_TenLoai);
		this.add(tf_TimKiem);
	}
	public void thietLapGiaoDienBtn() {
		btn_Them.setText("Thêm");
		btn_Them.setFocusable(false);
		btn_Them.setIcon(new ImageIcon("image//image//them.png"));
		btn_Them.setBounds(40, 200, 85, 30);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Sua.setText("Sửa");
		btn_Sua.setFocusable(false);
		btn_Sua.setIcon(new ImageIcon("image//image//sua.png"));
		btn_Sua.setBounds(135, 200, 85, 30);
		btn_Sua.setBackground(Color.lightGray);
		
		btn_Xoa.setText("Xóa");
		btn_Xoa.setFocusable(false);
		btn_Xoa.setIcon(new ImageIcon("image//image//xoa.png"));
		btn_Xoa.setBounds(230, 200, 85, 30);
		btn_Xoa.setBackground(Color.lightGray);
		
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
		this.add(btn_Xoa);
		this.add(btn_TimKiem);
		this.add(btn_TaoLai);
	}
	public void thietLapBangLoaiSp() {
		ArrayList<typeBook> arrType = menuManager.typeBookBUS.returnArrType();
		
		
		String col [] = {"Mã loại", "Tên loại"};
		

		model_LoaiSp = new DefaultTableModel(col, 0);
		model_LoaiSp.setColumnIdentifiers(col);
		
			for(typeBook value: arrType) {
				Vector vt = new Vector();
				vt.add(value.getIdTypeBook());
				vt.add(value.getNameTypeBook());
				model_LoaiSp.addRow(vt);
			}
		tb_BangLoaiSp.setModel(model_LoaiSp);
	}
	public void restart() {
		restartTf();
		restartBangLoaiSp();
		restartBangSp();
	}
	public void restartTf() {
		tf_MaLoai.setText("");
		tf_TenLoai.setText("");
		tf_TimKiem.setText("");
		txt_TimThay.setText("");
	}
	public void restartBangLoaiSp() {
		ArrayList<typeBook> arrType = menuManager.typeBookBUS.returnArrType();
		
		String col [] = {"Mã loại", "Tên loại"};
		

		model_LoaiSp = new DefaultTableModel(col, 0);
		model_LoaiSp.setColumnIdentifiers(col);
		
			for(typeBook value: arrType) {
				Vector vt = new Vector();
				vt.add(value.getIdTypeBook());
				vt.add(value.getNameTypeBook());
				model_LoaiSp.addRow(vt);
			}
		tb_BangLoaiSp.setModel(model_LoaiSp);
	}
	public void restartBangSp() {
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
		eventBtnThemLoaiSp();
		eventBtnSuaSp();
		eventBtnXoaLoaiSp();
		eventBtnSearch();
	}
	public void eventgetTbType() {
		tb_BangLoaiSp.addMouseListener(new MouseListener() {
			
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
				resertError();
				eventGetData();
				eventGetDataProduct();
				
				
			}
		});
	}
	public void eventGetData() {
		tf_MaLoai.disable();
		int row = tb_BangLoaiSp.getSelectedRow();
		String idType = model_LoaiSp.getValueAt(row, 0)+"";
		for(typeBook value: menuManager.typeBookBUS.returnArrType()) {
			if(value.getIdTypeBook().compareToIgnoreCase(idType) == 0)
			{
				tf_MaLoai.setText(value.getIdTypeBook());
				tf_TenLoai.setText(value.getNameTypeBook());
			}
		}
		
	}
	public void eventGetDataProduct() {
		int row = tb_BangLoaiSp.getSelectedRow();
		String idType = model_LoaiSp.getValueAt(row, 0)+"";
		ArrayList<book> arrBook = menuManager.bookBUS.returnArrBookSameType(idType);
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
		tb_BangSp.setModel(model_Sp);
	}
	public void eventBtnThemLoaiSp() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				eventThem();
				
				
			}
		});
	}
	public void eventThem() {
		String id = ""+ tf_MaLoai.getText();
		String ten = "" + tf_TenLoai.getText();
		String result = menuManager.typeBookBUS.addObject(id, ten);
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
			thietLapBangLoaiSp();
			txt_ThanhCong.setText("Thêm loại sản phẩm thành công");
			break;
		}
	}
	public void eventTaoLai() {
		btn_TaoLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_MaLoai.enable();
				restartBangLoaiSp();
				restartBangSp();
				restartTf();
				resertError();
				
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
	public void eventBtnSuaSp() {
		btn_Sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				thietLapSua();
				
			}
		});
	}
	public void thietLapSua() {
		String id = ""+ tf_MaLoai.getText();
		String ten = "" + tf_TenLoai.getText();
		String result = menuManager.typeBookBUS.modifyObject(id, ten);
		xuLySua(result);
	}
	public void xuLySua(String key) {
		switch (key) {
		case "Error name": {
			txtLoiTen.setText("Tên không được để trống");
			break;
		}
		default:
			thietLapBangLoaiSp();
			txt_ThanhCong.setText("Sửa loại sản phẩm thành công");
			break;
		}
	}
	public void eventBtnXoaLoaiSp() {
		btn_Xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				thietLapXoa();
				
			}
		});
	}
	public void thietLapXoa() {
		String id = ""+ tf_MaLoai.getText();
		String ten = "" + tf_TenLoai.getText();
		String result = menuManager.typeBookBUS.deleteObject(id, ten);
		xuLyXoa(result);
	}
	public void xuLyXoa(String key) {
		switch (key) {
		case "Error name": {
			txtLoiTen.setText("Tên không hợp lệ");
			break;
		}
		case "-1": {
			break;
		}
		default:{
			txt_ThanhCong.setText("xóa loại sản phẩm thành công");
			restart();
			break;
		}
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
				eventSearch();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventSearch() {
		ArrayList<typeBook> arr =  menuManager.typeBookBUS.arrSearch(tf_TimKiem.getText());
		thietLapBangLoaiSp(arr);
		txt_TimThay.setText("Tìm thấy " + arr.size() + " loại sách");
	}
	public void thietLapBangLoaiSp(ArrayList<typeBook> arr) {
		String col [] = {"Mã loại", "Tên loại"};
		

		model_LoaiSp = new DefaultTableModel(col, 0);
		model_LoaiSp.setColumnIdentifiers(col);
		
			for(typeBook value: arr) {
				Vector vt = new Vector();
				vt.add(value.getIdTypeBook());
				vt.add(value.getNameTypeBook());
				model_LoaiSp.addRow(vt);
			}
		tb_BangLoaiSp.setModel(model_LoaiSp);
	}
}
