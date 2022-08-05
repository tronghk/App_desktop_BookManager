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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DTO.billDetail;
import DTO.book;

public class pn_BanHang extends JPanel{
	public pn_BanHang() {
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
	private JLabel txt_GioHang;
	private JButton btn_Them;
	private JLabel btn_TimKiem;
	private JButton btn_Sua;
	private JButton btn_Xoa;
	private JButton btn_HoanTat;
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
	private JLabel image_SanPham;
	private JLabel txt_XemAnh;
	private JScrollPane scroll;
	private JScrollPane scrollCT;
	private JLabel txt_GiamGia;
	private JTextField tf_GiamGia;
	private JLabel thongBao;
	
	public void khoiTao() {
		taoBang();
		txt_TieuDe = new JLabel();
		txt_DSSach = new JLabel();
		txt_GioHang = new JLabel();
		btn_Them = new JButton();
		btn_TimKiem = new JLabel();
		btn_Sua = new JButton();
		tf_TimKiem = new JTextField();
		
		btn_Xoa = new JButton();
		btn_HoanTat = new  JButton();
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
		image_SanPham = new JLabel();
		txt_XemAnh = new JLabel();
		txt_GiamGia = new JLabel();
		tf_GiamGia = new JTextField();
		thongBao = new JLabel();
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
		
		txt_TieuDe.setText("Hóa đơn");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_DSSach.setText("Danh sách sản phẩm");
		txt_DSSach.setFont(font);
		txt_DSSach.setHorizontalAlignment(JLabel.LEFT);
		txt_DSSach.setBounds(10, 70, 200, 22);

		txt_GioHang.setText("Giỏ hàng");
		txt_GioHang.setFont(font);
		txt_GioHang.setBounds(10, 410, 250, 22);
		txt_GioHang.setHorizontalAlignment(JLabel.LEFT);
		
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
		
		txt_SoLuong.setText("SL mua ");
		txt_SoLuong.setFont(font);
		txt_SoLuong.setBounds(500, 230, 150, 30);
		txt_SoLuong.setHorizontalAlignment(JLabel.LEFT);
		
		txt_DonGia.setText("Giá bán ");
		txt_DonGia.setFont(font);
		txt_DonGia.setBounds(500, 270, 150, 30);
		txt_DonGia.setHorizontalAlignment(JLabel.LEFT);
		
		txt_GiamGia.setText("%Giảm");
		txt_GiamGia.setFont(font);
		txt_GiamGia.setBounds(500, 310, 150, 30);
		txt_GiamGia.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TongTien.setText("Thành tiền");
		txt_TongTien.setFont(font);
		txt_TongTien.setBounds(500, 350, 150, 30);
		txt_TongTien.setHorizontalAlignment(JLabel.LEFT);
		
		thongBao.setFont(font);
		thongBao.setBounds(200, 405, 300, 30);
		thongBao.setHorizontalAlignment(JLabel.LEFT);
		
		
		
		
		this.add(thongBao);
		this.add(txt_TieuDe);
		this.add(txt_DSSach);
		this.add(txt_GioHang);
		this.add(txt_MaSach);
		this.add(txt_TenSach);
		this.add(txt_LoaiSach);
		this.add(txt_SoLuong);
		this.add(txt_DonGia);
		this.add(txt_TongTien);
		this.add(txt_GiamGia);
		
	}
	public void thietLapGiaoDienTf() {
		tf_TimKiem.setBounds(220, 60, 170, 30);
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
		
		tf_GiamGia.setBounds(585, 310, 150, 25);
		tf_GiamGia.setForeground(Color.black);
		tf_GiamGia.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TongTien.setBounds(585, 350, 150, 25);
		tf_TongTien.setForeground(Color.black);
		tf_TongTien.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_TimKiem);
		this.add(tf_MaSach);
		this.add(tf_TenSach);
		this.add(tf_SoLuong);
		this.add(tf_DonGia);
		this.add(tf_TongTien);
		this.add(tf_GiamGia);
	}
	public void thietLapGiaoDienBtn() {
		btn_TimKiem.setIcon(new ImageIcon("image//image//timKiem.png"));
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setBounds(395, 60, 90, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		btn_Them.setText("Thêm giỏ hàng");
		btn_Them.setIcon(new ImageIcon("image//image//BanHang//them.png"));
		btn_Them.setFocusable(false);
		btn_Them.setBounds(555, 380, 140, 29);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Sua.setText("Sửa CT");
		btn_Sua.setFocusable(false);
		btn_Sua.setIcon(new ImageIcon("image//image//BanHang//sua.png"));
		btn_Sua.setBounds(520, 420, 100, 29);
		btn_Sua.setBackground(Color.lightGray);
		
		btn_Xoa.setText("Xóa CT");
		btn_Xoa.setFocusable(false);
		btn_Xoa.setIcon(new ImageIcon("image//image//xoa.png"));
		btn_Xoa.setBounds(630,420, 100, 29);
		btn_Xoa.setBackground(Color.lightGray);
		
		
		btn_HoanTat.setText("Hoàn tất hóa đơn");
		btn_HoanTat.setIcon(new ImageIcon("image//image//BanHang//luu.png"));
		btn_HoanTat.setFocusable(false);
		btn_HoanTat.setBounds(550, 680, 150, 29);
		btn_HoanTat.setBackground(Color.lightGray);
		
		this.add(btn_TimKiem);
		this.add(btn_Them);
		this.add(btn_Sua);
		this.add(btn_HoanTat);
		this.add(btn_Xoa);
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
	public void taoBang() {
		tb_BangSanPham = new myTable();
		tb_CTPNH = new myTable();
		JTableHeader header = tb_BangSanPham.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_BangSanPham);
		scroll.setBounds(10, 100, 480, 300);
		this.add(scroll);
		
		JTableHeader headerCT = tb_CTPNH.getTableHeader();
		headerCT.setBackground(Color.pink);
		scrollCT = new JScrollPane(tb_CTPNH);
		scrollCT.setBounds(10, 440, 480, 295);
		this.add(scrollCT);
	}
	public void reastart() {
		restartBook();
		restartCTPNH();
		restartTf();
	}
	public void restartTf() {
		tf_DonGia.setText("");
		tf_GiamGia.setText("");
		tf_MaSach.setText("");
		tf_SoLuong.setText("");
		tf_TenSach.setText("");
		tf_TimKiem.setText("");
		tf_TongTien.setText("");
		
		thongBao.setText("");
		image_SanPham.setIcon(null);
		image_SanPham.setHorizontalAlignment(0);
	}
	public void restartBook() {
		ArrayList<book> arrBook = menuManager.bookBUS.returnArrbook();
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng"};
		

		model_Book = new DefaultTableModel(col, 0);
		model_Book.setColumnIdentifiers(col);
		
			for(book value: arrBook) {
				if(value.getQuantityBook() >0) {
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
			}
		tb_BangSanPham.setModel(model_Book);
	}
	public void restartCTPNH() {
		String col[] = {"Mã sách","Tên sách","Số lượng","Giá bán/1c","Thành tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		tb_CTPNH.setModel(model_CTPHN);
	}
	public void thietLapCTPNH() {
		String col[] = {"Mã sách","Tên sách","Số lượng","Giá bán/1c","Thành tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		tb_CTPNH.setModel(model_CTPHN);
		
	}
	public void thietLapGiaoDienCBB() {
		String arrTypeBook[] = menuManager.typeBookBUS.arrStringTypeBookPNH();
		
		cbb_LoaiSach = new JComboBox<String>(arrTypeBook);
		cbb_LoaiSach.setBounds(585, 110, 150, 25);
		
		this.add(cbb_LoaiSach);
	}
	public void GiaoDienXemAnh() {
		Border border = BorderFactory.createLineBorder(Color.gray);
		image_SanPham.setBorder(border);
		image_SanPham.setBounds(540, 470, 160, 160);
		image_SanPham.setHorizontalAlignment(0);
		
		txt_XemAnh.setText("Hình ảnh");
		txt_XemAnh.setBounds(600,640, 100, 25);
		txt_XemAnh.setFocusable(false);
		txt_XemAnh.setBackground(Color.CYAN);
		
		this.add(image_SanPham);
		this.add(txt_XemAnh);
	}
	public void OffFuction() {
		tf_MaSach.disable();
		tf_TenSach.disable();
		tf_TongTien.disable();
		tf_DonGia.disable();
		cbb_LoaiSach.disable();
		tf_GiamGia.disable();
	}
	public void event() {
		eventBangSach();
		eventThanhtien();
		eventAddObject();
		eventModifyObject();
		eventDeleteObject();
		eventBangCT();
		eventSearch();
		eventLuuHoaDon();
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
				eventGetData();
			}
		});
	}
	public void eventBangCT() {
		tb_CTPNH.addMouseListener(new MouseListener() {
			
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
				eventGetDataCT();
			}
		});
	}
	public void eventGetDataCT() {
		
		thongBao.setText("");
		tf_TimKiem.setText("");
		tf_GiamGia.setText("");
		int row = tb_CTPNH.getSelectedRow();
		String id = model_CTPHN.getValueAt(row, 0)+"";
		String pathFile = menuManager.link.returnLink(id);
		String name = model_CTPHN.getValueAt(row, 1)+"";
		String quantity = model_CTPHN.getValueAt(row, 2)+"";
		String price = menuManager.bookBUS.returnUnitprice(id)+"";
		String discount =""+ menuManager.DTPromotionBUS.checkGiamGia(id);
		String thanhTien = model_CTPHN.getValueAt(row, 4)+"";
		book b = menuManager.bookBUS.returnObject(id);
		int index = menuManager.typeBookBUS.indexTypeBook(b.getIdTypeBook());
		cbb_LoaiSach.setSelectedIndex(index+1);
		tf_MaSach.setText(id);
		tf_TenSach.setText(name);
		tf_SoLuong.setText(quantity);
		tf_DonGia.setText(price);
		if(discount.compareTo("null")!= 0)
		tf_GiamGia.setText(discount);
		tf_TongTien.setText(thanhTien);
		image_SanPham.setIcon(new ImageIcon(pathFile));
		
		
	}
	public void eventGetData() {
		tf_TimKiem.setText("");
		tf_TongTien.setText("");
		tf_SoLuong.setText("");
		tf_GiamGia.setText("");
		thongBao.setText("");
		int row = tb_BangSanPham.getSelectedRow();
		String id = model_Book.getValueAt(row, 0)+"";
		String pathFile = menuManager.link.returnLink(id);
		book b = menuManager.bookBUS.returnObject(id);
		int index = menuManager.typeBookBUS.indexTypeBook(b.getIdTypeBook());
		cbb_LoaiSach.setSelectedIndex(index+1);
		tf_MaSach.setText(b.getIdBook());
		tf_TenSach.setText(b.getNameBook());
		tf_DonGia.setText(b.getUnitPrice()+"");
		eventGiamGia(id);
		image_SanPham.setIcon(new ImageIcon(pathFile));
		
	}
	
	public void eventGiamGia(String id) {
		
		String discount =""+ menuManager.DTPromotionBUS.checkGiamGia(id);
		if(discount.compareTo("null") != 0)
		tf_GiamGia.setText(discount);
		
	}
	public void eventThanhtien() {
		tf_SoLuong.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(tf_MaSach.getText().compareTo("") != 0) {
				String id = tf_MaSach.getText();
				String quantity = tf_SoLuong.getText();
				soluongLonNhat(id, quantity);
				String discount = tf_GiamGia.getText().replace("%", "");
				tf_TongTien.setText(menuManager.billBUS.thanhTien(id,quantity,discount));
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void soluongLonNhat(String id, String quantity){
		String soLuong =menuManager.bookBUS.soLuongToiDa(id, quantity);
		if(soLuong.compareTo("Error") != 0)
			tf_SoLuong.setText(soLuong);
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
		String id =""+ tf_MaSach.getText();
		String name = "" + tf_TenSach.getText();
		String quantity = "" + tf_SoLuong.getText();
		String price = tf_DonGia.getText()+"";
		String sumPrice = menuManager.billBUS.thanhTien(id, quantity, tf_GiamGia.getText().replace("%", ""));
		String result = menuManager.billDTBUS.addObject(id, price, name, sumPrice, quantity);
		hienThiLoi( result, "Đã thêm chi tiết");
	}
	public void hienThiLoi(String error, String message) {
		thongBao.setForeground(Color.red);
		switch (error) {
		case "Error quantity":{
			thongBao.setText("SL không hợp lệ!");
			break;
		}
		case "null":{
			thongBao.setText("Chưa chọn sản phẩm");
			break;
		}
		case "Error id":{
			thongBao.setText("Sản phẩm đã có trong chi tiết");
			break;
		}
		default :{
			thietLapCTPNH(menuManager.billDTBUS.returnArrGioHang());
			thongBao.setForeground(Color.green);
			thongBao.setText(message);
			if(message.compareTo("Sửa chi tiết thành công") != 0)
			break;
		}
		}
	}
	public void thietLapCTPNH(ArrayList<billDetail> arr) {
		String col[] = {"Mã sách","Tên sách","Số lượng","Giá bán/1c","Thành tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		for(billDetail value: arr) {
			Vector<String> vt = new Vector<String>();
			vt.add(value.getIdBook());
			vt.add(menuManager.bookBUS.returnNameBook(value.getIdBook()));
			vt.add(value.getQuantityBook()+"");
			vt.add((float)(value.getIntoMoney()/value.getQuantityBook())+"");
			vt.add(value.getIntoMoney()+"");
			model_CTPHN.addRow(vt);
		}
		
		tb_CTPNH.setModel(model_CTPHN);
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
		String name = "" + tf_TenSach.getText();
		String quantity = "" + tf_SoLuong.getText();
		String price = tf_DonGia.getText()+"";
		String sumPrice = menuManager.billBUS.thanhTien(id, quantity, tf_GiamGia.getText().replace("%", ""));
		String result = menuManager.billDTBUS.modifyObject(id, price, name, sumPrice, quantity);
		hienThiLoi( result, "Sửa chi tiết thành công");
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
		String name = "" + tf_TenSach.getText();
		String quantity = "" + tf_SoLuong.getText();
		String price = "" + tf_DonGia.getText()+"";
		String sumPrice = menuManager.billBUS.thanhTien(id, quantity, tf_GiamGia.getText().replace("%", ""));
		String result = menuManager.billDTBUS.deleteObject(id, price, name, sumPrice, quantity);
		hienThiLoi( result, "Đã xóa chi tiết");
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
				if(value.getQuantityBook() > 0) {
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
			}
		tb_BangSanPham.setModel(model_Book);
		
	}
	public void eventLuuHoaDon() {
		btn_HoanTat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveBill();
			}
		});
	}
	public void saveBill() {
		String result =menuManager.billBUS.createBill();
		hienThiThongTinLuu(result);
	}
	public void hienThiThongTinLuu(String result) {
		if(result.compareTo("Error bill")==0) {
			thongBao.setForeground(Color.red);
			thongBao.setText("Chưa có sản phẩm nào");
		}
		else
		{
			JOptionPane.showConfirmDialog(new JFrame(), "Hóa đơn đã được lưu, mã hóa đơn "+result,"Thông báo", JOptionPane.DEFAULT_OPTION);	
			reastart();
		}
	}
	public boolean checkSave() {
		
		int size = 0+ menuManager.billDTBUS.returnArrGioHang().size();
		if(size >0) {
			 int Jdialog = JOptionPane.showConfirmDialog(new JFrame(), "Hóa đơn chưa được lưu bạn có muốn thoát?","Thông báo",JOptionPane.YES_NO_OPTION);
			 if(Jdialog == JOptionPane.YES_OPTION) {
				 menuManager.billDTBUS.deleteArr();
				 return false;
			 }
			 else
				 return true;
			 
		}else
		return false;
	
}

}
