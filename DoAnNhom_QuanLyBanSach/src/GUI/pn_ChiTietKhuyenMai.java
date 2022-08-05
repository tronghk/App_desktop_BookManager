package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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

import DTO.book;
import DTO.detailCoupon;
import DTO.detailPromotion;

public class pn_ChiTietKhuyenMai extends JPanel {
	public pn_ChiTietKhuyenMai() {
		 this.setLayout(null);
			this.setBounds(230, 0,770, 800);
			Border border = BorderFactory.createLineBorder(Color.black);
			setBorder(border);
			
			khoiTao();
			thietLap();
			
			event();
	}	
	private JLabel txt_TieuDe;
	private JLabel txt_DSSach;
	private JLabel txt_CTCTKM;
	private JButton btn_Them;
	private JButton btn_TimKiem;
	private JButton btn_Sua;
	private JButton btn_Xoa;
	private JButton btn_QuayLai;
	private JButton btn_LuuCT;
	private JTextField tf_TimKiem;
	private JTable tb_BangSanPham;
	private DefaultTableModel model_Book;
	private JTable tb_CTKM;
	private DefaultTableModel model_CTKM;
	private JLabel txt_TenSach;
	private JTextField tf_TenSach;
	private JLabel txt_MaSach;
	private JTextField tf_MaSach;
	private JScrollPane scrollBook;
	private JScrollPane scrollCTKM;
	private JLabel txt_ChietKhau;
	private JTextField tf_ChietKhau;
	private JLabel txt_ThoiGianDienRa;
	private JLabel txt_TenChuongTrinh;
	private JTextField tf_TenChuongTrinh;
	private JLabel txt_ThoiGianBatDau;
	private JLabel txt_ThoiGianKetThuc;
	private JDateChooser date_NgayBatDau;
	private JDateChooser date_NgayKetThuc;
	private JButton btn_TaoLai;
	private JLabel txt_ThongTin;
	
	
	public void khoiTao() {
		khoiTaoBang();
		txt_TieuDe = new JLabel();
		txt_DSSach = new JLabel();
		txt_CTCTKM = new JLabel();
		btn_Them = new JButton();
		btn_TimKiem = new JButton();
		btn_Sua = new JButton();
		tf_TimKiem = new JTextField();
		btn_Xoa = new JButton();
		btn_QuayLai = new  JButton();
		btn_LuuCT = new  JButton();
		txt_TenSach = new JLabel();
		tf_TenSach = new JTextField();
		txt_MaSach = new JLabel();
		tf_MaSach = new JTextField();
		txt_ChietKhau = new JLabel();
		tf_ChietKhau = new JTextField();
		txt_TenChuongTrinh = new JLabel();
		txt_ThoiGianBatDau = new JLabel();
		txt_ThoiGianDienRa = new JLabel();
		txt_ThoiGianKetThuc = new JLabel();
		tf_TenChuongTrinh = new JTextField();
		date_NgayBatDau = new JDateChooser();
		date_NgayKetThuc = new JDateChooser();
		btn_TaoLai = new JButton();
		txt_ThongTin = new JLabel();
	}
	public void thietLap() {
		thietLapGiaoDientxt();
		thietLapGiaoDienTf();
		thietLapGiaoDienBtn();
		OffFuction();
		thietLapBang();
		thietLapCTKM();
	}
	public void khoiTaoBang() {
		tb_BangSanPham = new myTable();
		JTableHeader header = tb_BangSanPham.getTableHeader();
		header.setBackground(Color.pink);
		scrollBook = new JScrollPane(tb_BangSanPham);
		scrollBook.setBounds(10, 100, 480, 300);
		this.add(scrollBook);
		
		tb_CTKM = new myTable();
		JTableHeader headerCTKM = tb_CTKM.getTableHeader();
		headerCTKM.setBackground(Color.pink);
		scrollCTKM = new JScrollPane(tb_CTKM);
		scrollCTKM.setBounds(10, 460, 480, 275);
		this.add(scrollCTKM);	
	}
	public void thietLapGiaoDientxt() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Chương trình khuyến mãi");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_DSSach.setText("Sách");
		txt_DSSach.setFont(font);
		txt_DSSach.setHorizontalAlignment(JLabel.LEFT);
		txt_DSSach.setBounds(10, 70, 100, 22);

		txt_CTCTKM.setText("Chi tiết CTKM");
		txt_CTCTKM.setFont(font);
		txt_CTCTKM.setBounds(10, 430, 250, 22);
		txt_CTCTKM.setHorizontalAlignment(JLabel.LEFT);
		
		txt_MaSach.setText("Mã sách");
		txt_MaSach.setFont(font);
		txt_MaSach.setBounds(500, 190, 150, 30);
		txt_MaSach.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TenSach.setText("Tên sách");
		txt_TenSach.setFont(font);
		txt_TenSach.setBounds(500, 240, 150, 30);
		txt_TenSach.setHorizontalAlignment(JLabel.LEFT);
		
		txt_ChietKhau.setText("% Chiết khấu");
		txt_ChietKhau.setFont(font);
		txt_ChietKhau.setBounds(500, 290, 150, 30);
		txt_ChietKhau.setHorizontalAlignment(JLabel.LEFT);
		
		txt_ThoiGianDienRa.setText("Thiết lập chương trình");
		txt_ThoiGianDienRa.setFont(font);
		txt_ThoiGianDienRa.setBounds(540, 450, 200, 30);
		txt_ThoiGianDienRa.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TenChuongTrinh.setText("Tên chương trình");
		txt_TenChuongTrinh.setForeground(Color.red);
		txt_TenChuongTrinh.setFont(font);
		txt_TenChuongTrinh.setBounds(560, 490, 150, 30);
		txt_TenChuongTrinh.setHorizontalAlignment(JLabel.LEFT);
		
		txt_ThoiGianBatDau.setText("Ngày bắt đầu");
		txt_ThoiGianBatDau.setFont(font);
		txt_ThoiGianBatDau.setBounds(500, 560, 150, 30);
		txt_ThoiGianBatDau.setHorizontalAlignment(JLabel.LEFT);
		
		txt_ThoiGianKetThuc.setText("Ngày kết thúc");
		txt_ThoiGianKetThuc.setFont(font);
		txt_ThoiGianKetThuc.setBounds(500, 590, 150, 30);
		txt_ThoiGianKetThuc.setHorizontalAlignment(JLabel.LEFT);
		
		txt_ThongTin.setFont(font);
		txt_ThongTin.setBounds(530, 390,250, 30);
		txt_ThongTin.setHorizontalAlignment(JLabel.LEFT);
		
		this.add(txt_ThongTin);
		this.add(txt_TieuDe);
		this.add(txt_DSSach);
		this.add(txt_CTCTKM);
		this.add(txt_MaSach);
		this.add(txt_TenSach);
		this.add(txt_ChietKhau);
		this.add(txt_ThoiGianDienRa);
		this.add(txt_TenChuongTrinh);
		this.add(txt_ThoiGianBatDau);
		this.add(txt_ThoiGianKetThuc);
		
		
	}
	public void thietLapGiaoDienTf() {
		tf_TimKiem.setBounds(160, 60, 170, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_MaSach.setBounds(585, 190, 150, 25);
		tf_MaSach.setForeground(Color.black);
		tf_MaSach.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TenSach.setBounds(585, 240, 150, 25);
		tf_TenSach.setForeground(Color.black);
		tf_TenSach.setFont(new Font("Arial", Font.BOLD, 13));

		tf_ChietKhau.setBounds(635, 290, 100, 25);
		tf_ChietKhau.setForeground(Color.black);
		tf_ChietKhau.setFont(new Font("Arial", Font.BOLD, 13));
		
		
		tf_TenChuongTrinh.setBounds(525, 525, 200, 25);
		tf_TenChuongTrinh.setForeground(Color.black);
		tf_TenChuongTrinh.setFont(new Font("Arial", Font.BOLD, 13));
		
		date_NgayBatDau.setBounds(610, 560, 135, 25);
		date_NgayBatDau.setForeground(Color.black);
		date_NgayBatDau.setFont(new Font("Arial", Font.BOLD, 13));
		
		date_NgayKetThuc.setBounds(610, 590, 135, 25);
		date_NgayKetThuc.setForeground(Color.black);
		date_NgayKetThuc.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_TimKiem);
		this.add(tf_MaSach);
		this.add(tf_TenSach);
		this.add(tf_ChietKhau);
		this.add(tf_TenChuongTrinh);
		this.add(date_NgayBatDau);
		this.add(date_NgayKetThuc);
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
		
		
		btn_LuuCT.setText("Lưu chương trình khuyến mãi");
		btn_LuuCT.setFocusable(false);
		btn_LuuCT.setBounds(510, 650, 225, 29);
		btn_LuuCT.setBackground(Color.orange);
		
		this.add(btn_TimKiem);
		this.add(btn_Them);
		this.add(btn_Sua);
		this.add(btn_QuayLai);
		this.add(btn_LuuCT);
		this.add(btn_Xoa);
		this.add(btn_TaoLai);
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
	public void restart() {
		restartTf();
		thietLapBang();
		thietLapCTKM();
		txt_ThongTin.setText("");
		date_NgayBatDau.setDate(null);
		date_NgayKetThuc.setDate(null);
		menuManager.DTPromotionBUS.deleteCT();
	}
	public void restartTf() {
		tf_ChietKhau.setText("");
		tf_MaSach.setText("");
		tf_TenChuongTrinh.setText("");
		tf_TenSach.setText("");
		tf_TimKiem.setText("");
	}
	public void thietLapCTKM() {
		String col[] = {"Mã sách","Chiết khấu"};
		model_CTKM = new DefaultTableModel(col, 0);
		model_CTKM.setColumnIdentifiers(col);
		tb_CTKM.setModel(model_CTKM);
	}
	public void OffFuction() {
		tf_MaSach.disable();
		tf_TenSach.disable();
	}
	public void event() {
		eventBangSach();
		eventBtnBack();
		eventSearch();
		eventAddObject();
		eventModifyObject();
		eventDeleteObject();
		eventSave();
		eventCTKM();
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
	public void eventGetData() {
		int row = tb_BangSanPham.getSelectedRow();
		String id = model_Book.getValueAt(row, 0)+"";
		book b = menuManager.bookBUS.returnObject(id);
		tf_MaSach.setText(b.getIdBook());
		tf_TenSach.setText(b.getNameBook());
	}
	public void eventBtnBack() {
		btn_QuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventLuaChon();
			}
		});
	}
	public void eventLuaChon() {
		if(menuManager.DTPromotionBUS.checkProduct() >0) {
			int Jdialog = JOptionPane.showConfirmDialog(new JFrame(),"Thông tin khuyến mãi chưa được lưu, bạn có muốn thoát?", "Thông báo",JOptionPane.YES_NO_OPTION);
			if(Jdialog == JOptionPane.YES_OPTION) {
				PanelLeftGUI.pn_ChiTietKM.setVisible(false);
				PanelLeftGUI.pnKhuyenMai.setVisible(true);
				restart();
			}
		}else {
			PanelLeftGUI.pn_ChiTietKM.setVisible(false);
			PanelLeftGUI.pnKhuyenMai.setVisible(true);
			restart();
		}
		
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
	public void eventAddObject() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addObject();
			}
		});
	}
	public void thietLapBangCT() {
		ArrayList<detailPromotion> arr = menuManager.DTPromotionBUS.returnArrCTPromotion(-1+"");
		thietLapCTKM(arr);
		
	}
	public void thietLapCTKM(ArrayList<detailPromotion> arr) {
		String col[] = {"Mã sách","Chiết khấu"};
		model_CTKM = new DefaultTableModel(col, 0);
		model_CTKM.setColumnIdentifiers(col);
		for(detailPromotion value: arr) {
			Vector<String> vt = new Vector<String>();
			vt.add(value.getIdBook());
			vt.add(value.getDiscount()+"%");
			model_CTKM.addRow(vt);
		}
		tb_CTKM.setModel(model_CTKM);
	}
	
	public void addObject() {
		String id =""+ tf_MaSach.getText();
		String discount = tf_ChietKhau.getText()+"";
		String idPromotion = ""+-1;
		String result = menuManager.DTPromotionBUS.addObject(id, idPromotion, discount);
		hienThiLoi(result, "Thêm chi tiết thành công");
		
	}
	public void hienThiLoi(String error, String message) {
		txt_ThongTin.setForeground(Color.red);
		switch (error) {
		case "Error":{
			txt_ThongTin.setText("Không có sản phẩm");
			break;
		}
		case "Error duplicate":{
			txt_ThongTin.setText("Sản phẩm đã có trong chi tiết");
			break;
		}
		case "Error discount":{
			txt_ThongTin.setText("chiết khấu không hợp lệ");
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
	public void eventTaoLai() {
		btn_TaoLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				taoLai();
				
			}
		});
	}
	public void taoLai() {
		restartTf();
		thietLapBang();
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
		String discount = tf_ChietKhau.getText()+"";
		String idPromotion = ""+-1;
		String result = menuManager.DTPromotionBUS.modifyObject(id, idPromotion, discount);
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
		String discount = tf_ChietKhau.getText()+"";
		String idPromotion = ""+-1;
		String result = menuManager.DTPromotionBUS.deleteObject(id, idPromotion, discount);
		hienThiLoi(result, "Xóa chi tiết thành công");
	}
	public void eventSave() {
		btn_LuuCT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
	}
	public void save() {
		try{
		String name = tf_TenChuongTrinh.getText();
		java.util.Date dateStart =  date_NgayBatDau.getDate();
		String date1Start = ""+DateFormat.getDateInstance().format(dateStart);
		java.util.Date dateEnd =  date_NgayKetThuc.getDate();
		String date1End = ""+DateFormat.getDateInstance().format(dateEnd);
		String result = menuManager.promotionBUS.savePromotion(name, date1Start, date1End);
		System.out.println(result);
		hienThiLoi(result);
		}catch(Exception ex) {
			hienThiLoi("Error");
		}
	}
	public void hienThiLoi(String error) {
		txt_ThongTin.setForeground(Color.red);
		switch (error) {
		case "Error name":{
			txt_ThongTin.setText("Tên chương trình rỗng!");
			break;
		}
		case "Error":{
			txt_ThongTin.setText("Ngày không hợp lệ");
			break;
		}
		case "Error empty":{
			txt_ThongTin.setText("Chưa có chi tiết nào");
			break;
		}
		default :{
			PanelLeftGUI.pnKhuyenMai.thietLapBangCTKM();
			PanelLeftGUI.pnKhuyenMai.thietLapCTCTKM();
			myNotifycation.notifycation("Đã thêm chương trình khuyến mãi");
			this.setVisible(false);
			PanelLeftGUI.pnKhuyenMai.setVisible(true);
			break;
		}
		}
	}
	public void eventCTKM() {
		tb_CTKM.addMouseListener(new MouseListener() {
			
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
				eventTBCT();
				
			}
		});
	}
	public void eventTBCT() {
		int row = tb_CTKM.getSelectedRow();
		String id = model_CTKM.getValueAt(row, 0)+""; // lấy ra id ở hàng row cột 0
		String name = menuManager.bookBUS.returnNameBook(id);
		String discount = model_CTKM.getValueAt(row, 1)+"";
		discount = discount.replace("%", "");
		tf_MaSach.setText(id);
		tf_TenSach.setText(name);
		tf_ChietKhau.setText(discount);
	}
}
