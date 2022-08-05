package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import BUS.bookBUS;
import BUS.publishingCompanyBUS;
import BUS.typeBookBUS;
import DTO.book;


public class pn_SanPham extends JPanel {
	public pn_SanPham() {
		this.setLayout(null);
		this.setBounds(0, 20 ,770, 745);
		Border border = BorderFactory.createLineBorder(Color.black);
		setBorder(border);
		taoBang();
		KhoiTaoGiaoDien();
		thietLapGiaoDien();
		event();
	}
	
	private JLabel txt_TieuDe;
	private JLabel txt_ThongtinSp;
	private JLabel txt_MaSp;
	private JLabel txt_TenSp;
	private JLabel txt_Loai;
	private JComboBox<String> list_LoaiSp;
	private JComboBox<String> list_NPH;
	private JLabel txt_SoLuong;
	private JLabel txt_DonGia;
	private JLabel txt_NhaPhatHanh;
	private JLabel txt_NgayXuatBan;
	private JTextField tf_MaSp;
	private JTextField tf_TenSp;
	private JTextField tf_SoLuong;
	private JTextField tf_DonGia;
	private JButton btn_Them;
	private JButton btn_Sua;
	private JButton btn_Xoa;
	private JButton btn_TaoLai;
	private JTable  tb_BangSanPham;
	private JLabel txt_TimKiem;
	private JTextField tf_TimKiem;
	private JScrollPane scroll;
	private JDateChooser dateChooser;
	private DefaultTableModel model;
	private JLabel image_SanPham;
	private JButton btn_ChonAnh;
	private String pathFile = "";
	private JLabel txtLoiMa;
	private JLabel txtLoiTen;
	private JLabel txtLoiSoLuong;
	private JLabel txtLoiTien;
	private JLabel txtLoiDate;
	private JLabel txt_ThanhCong;
	private File file;
	public void KhoiTaoGiaoDien() {
//		khởi tạo
		txt_TieuDe = new JLabel();
		txt_ThongtinSp = new JLabel();
		txt_MaSp = new JLabel();
		txt_TenSp = new JLabel();
		txt_Loai = new JLabel();
		txt_SoLuong = new JLabel();
		txt_DonGia = new JLabel();
		txt_NhaPhatHanh = new JLabel();
		txt_NgayXuatBan = new JLabel();
		tf_MaSp = new JTextField();
		tf_TenSp = new JTextField();
		tf_SoLuong = new JTextField();
		tf_DonGia = new JTextField();
		btn_Them = new JButton();
		btn_Sua = new JButton();
		btn_Xoa = new JButton();
		dateChooser = new JDateChooser();
		txt_TimKiem = new JLabel();
		tf_TimKiem = new JTextField();
		btn_TaoLai = new JButton();
		image_SanPham = new JLabel();
		btn_ChonAnh = new JButton();
		txtLoiMa = new JLabel();
		txtLoiSoLuong = new JLabel();
		txtLoiTen = new JLabel();
		txtLoiTien = new JLabel();
		txtLoiDate = new JLabel();
		txt_ThanhCong = new JLabel();
	}
	public void thietLapGiaoDien() {
		thietLapGiaoDienText();
		thietLapLoi();
		thietLapGiaoDientf();
		thietLapLoaiSp();
		thietLapBtn();
		thietLapBang();
		GiaoDienChonAnh();
	}
	public void thietLapLoi() {
		txtLoiMa.setBounds(330, 75, 150, 30);
		txtLoiMa.setForeground(Color.red);
		txtLoiSoLuong.setBounds(330, 165, 150, 30);
		txtLoiSoLuong.setForeground(Color.red);
		txtLoiTen.setBounds(330, 105, 150, 30);
		txtLoiTen.setForeground(Color.red);
		txtLoiTien.setBounds(330, 195, 150, 30);
		txtLoiTien.setForeground(Color.red);
		txtLoiDate.setBounds(330, 225, 150, 30);
		txtLoiDate.setForeground(Color.red);
		txt_ThanhCong.setBounds(250, 280, 200, 20);
		
		
		this.add(txtLoiMa);
		this.add(txtLoiDate);
		this.add(txtLoiSoLuong);
		this.add(txtLoiTen);
		this.add(txtLoiTien);
		this.add(txt_ThanhCong);
	}
	public void taoBang() {
		tb_BangSanPham = new myTable();
		JTableHeader header = tb_BangSanPham.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_BangSanPham);
		scroll.setBounds(0, 340, 757, 402);
		this.add(scroll);
	}
	public void thietLapGiaoDienText() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Quản lý sản phẩm");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_ThongtinSp.setText("Thông tin sản phẩm");
		txt_ThongtinSp.setFont(font);
		txt_ThongtinSp.setHorizontalAlignment(0);
		txt_ThongtinSp.setBounds(90, 50, 150, 22);
		
		txt_MaSp.setText("Mã sách           ");
		txt_MaSp.setFont(font);
		txt_MaSp.setHorizontalAlignment(0);
		txt_MaSp.setBounds(20, 75, 150, 30);
		
		txt_TenSp.setText("Tên sách          ");
		txt_TenSp.setFont(font);
		txt_TenSp.setHorizontalAlignment(0);
		txt_TenSp.setBounds(20, 105, 150, 30);
		
		txt_Loai.setText("Thể loại            ");
		txt_Loai.setFont(font);
		txt_Loai.setHorizontalAlignment(0);
		txt_Loai.setBounds(20, 135, 150, 30);
		
		txt_SoLuong.setText("Số lượng         ");
		txt_SoLuong.setFont(font);
		txt_SoLuong.setHorizontalAlignment(0);
		txt_SoLuong.setBounds(20, 165, 150, 30);
		
		txt_DonGia.setText("Đơn giá            ");
		txt_DonGia.setFont(font);
		txt_DonGia.setHorizontalAlignment(0);
		txt_DonGia.setBounds(20, 195, 150, 30);
		
		txt_NgayXuatBan.setText("Ngày xuất bản");
		txt_NgayXuatBan.setFont(font);
		txt_NgayXuatBan.setHorizontalAlignment(0);
		txt_NgayXuatBan.setBounds(20, 225, 150, 30);
		
		txt_NhaPhatHanh.setText("Nhà phát hành");
		txt_NhaPhatHanh.setFont(font);
		txt_NhaPhatHanh.setHorizontalAlignment(0);
		txt_NhaPhatHanh.setBounds(20, 255, 150, 30);
		
		txt_TimKiem.setIcon(new ImageIcon("image//image//timKiem.png"));
		txt_TimKiem.setFont(font);
		txt_TimKiem.setHorizontalAlignment(0);
		txt_TimKiem.setBounds(450, 300, 130, 30);
		
		this.add(txt_TieuDe);
		this.add(txt_ThongtinSp);
		this.add(txt_MaSp);
		this.add(txt_TenSp);
		this.add(txt_Loai);
		this.add(txt_DonGia);
		this.add(txt_SoLuong);
		this.add(txt_NhaPhatHanh);
		this.add(txt_NgayXuatBan);
		this.add(txt_TimKiem);
		
	}
	public void thietLapGiaoDientf() {
		tf_MaSp.setBounds(170, 75, 150, 25);
		tf_MaSp.setForeground(Color.black);
		tf_MaSp.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TenSp.setBounds(170, 105, 150, 25);
		tf_TenSp.setForeground(Color.black);
		tf_TenSp.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_SoLuong.setBounds(170, 165, 150, 25);
		tf_SoLuong.setForeground(Color.black);
		tf_SoLuong.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_DonGia.setBounds(170, 195, 150, 25);
		tf_DonGia.setForeground(Color.black);
		tf_DonGia.setFont(new Font("Arial", Font.BOLD, 13));
		
		tf_TimKiem.setBounds(530, 300, 150, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_MaSp);
		this.add(tf_TenSp);
		this.add(tf_SoLuong);
		this.add(tf_DonGia);
		this.add(tf_TimKiem);
	}
	public void thietLapLoaiSp() {
		String arrStringTB[] = menuManager.typeBookBUS.arrStringTypeBook();
		list_LoaiSp = new JComboBox<String>(arrStringTB);
		list_LoaiSp.setBounds(170, 135, 150, 25);
		
		String arrStringCPN[] = menuManager.pubBUS.arrStringCPN();
		list_NPH = new JComboBox<String>(arrStringCPN);
		list_NPH.setBounds(170, 255, 150, 25);
		
		
		dateChooser.setBounds(170, 225, 150, 25);
		
		this.add(dateChooser);
		this.add(list_LoaiSp);
		this.add(list_NPH);
	}
	public void restartCbb() {
		String arrStringTB[] = menuManager.typeBookBUS.arrStringTypeBook();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(arrStringTB);
		list_LoaiSp.setModel(model);
		
		String arrStringCPN[] = menuManager.pubBUS.arrStringCPN();
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>(arrStringCPN);
		list_NPH.setModel(model1);
	}
	public void thietLapBtn() {
		btn_Them.setText("Thêm");
		btn_Them.setIcon(new ImageIcon("image//image//them.png"));
		btn_Them.setHorizontalAlignment(JButton.LEFT);
		btn_Them.setIconTextGap(5);
		btn_Them.setFocusable(false);
		btn_Them.setBounds(50, 300, 85, 30);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Sua.setText("Sửa");
		btn_Sua.setFocusable(false);
		btn_Sua.setIcon(new ImageIcon("image//image//sua.png"));
		btn_Sua.setHorizontalAlignment(JButton.LEFT);
		btn_Sua.setIconTextGap(5);
		btn_Sua.setBounds(140, 300, 85, 30);
		btn_Sua.setBackground(Color.lightGray);
		
		btn_Xoa.setText("Xóa");
		btn_Xoa.setFocusable(false);
		btn_Xoa.setIcon(new ImageIcon("image//image//xoa.png"));
		btn_Xoa.setHorizontalAlignment(JButton.LEFT);
		btn_Xoa.setIconTextGap(5);
		btn_Xoa.setBounds(230, 300, 85, 30);
		btn_Xoa.setBackground(Color.lightGray);
		
		btn_TaoLai.setText("Tạo lại");
		btn_TaoLai.setFocusable(false);
		btn_TaoLai.setIcon(new ImageIcon("image//image//TaoLai.png"));
		btn_TaoLai.setBounds(320, 300, 100, 30);
		btn_TaoLai.setBackground(Color.lightGray);
		
		
		this.add(btn_Them);
		this.add(btn_Sua);
		this.add(btn_Xoa);
		this.add(btn_TaoLai);
	}
	public void thietLapBang() {
		ArrayList<book> arrBook = menuManager.bookBUS.returnArrbook();
		
		
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng","Ngày xuất bản" ,"Nhà xuất bản"};
		

		model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		
			for(book value: arrBook) {
				Vector vt = new Vector();
				vt.add(value.getIdBook());
				vt.add(value.getNameBook());
				vt.add(value.getIdTypeBook());
				vt.add(value.getUnitPrice());
				vt.add(value.getQuantityBook());
				vt.add(value.getDatePublishing());
				vt.add(value.getIdPublishingCompany());
				model.addRow(vt);
			}
		tb_BangSanPham.setModel(model);
		
	}
	public void restartBangSp() {
		ArrayList<book> arrBook = menuManager.bookBUS.returnArrbook();
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng","Ngày xuất bản" ,"Nhà xuất bản"};
		model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		
			for(book value: arrBook) {
				Vector vt = new Vector();
				vt.add(value.getIdBook());
				vt.add(value.getNameBook());
				vt.add(value.getIdTypeBook());
				vt.add(value.getUnitPrice());
				vt.add(value.getQuantityBook());
				vt.add(value.getDatePublishing());
				vt.add(value.getIdPublishingCompany());
				model.addRow(vt);
			}
		tb_BangSanPham.setModel(model);
		restartTf();
		resertError();
	}
	public void restart() {
		restartBangSp();
		restartTf();
		restartCbb();
	}
	public void restartTf() {
		tf_DonGia.setText("");
		tf_SoLuong.setText("");
		tf_MaSp.setText("");
		tf_TenSp.setText("");
		tf_TimKiem.setText("");
		list_LoaiSp.setSelectedIndex(0);
		list_NPH.setSelectedIndex(0);
		image_SanPham.setIcon(new ImageIcon(""));
		
	}
	public void GiaoDienChonAnh() {
		Border border = BorderFactory.createLineBorder(Color.gray);
		image_SanPham.setBorder(border);
		image_SanPham.setBounds(450, 75, 160, 160);
		image_SanPham.setHorizontalAlignment(JLabel.CENTER);
		
		btn_ChonAnh.setText("Chọn ảnh");
		btn_ChonAnh.setBounds(480,245, 100, 25);
		btn_ChonAnh.setFocusable(false);
		btn_ChonAnh.setBackground(Color.CYAN);
		
		this.add(image_SanPham);
		this.add(btn_ChonAnh);
	}
	public void event() {
		eventChonAnh();
		eventTableProduct();
		eventTaoLai();
		eventAddObject();
		eventModifyObject();
		eventDeleteObject();
		eventSearchSp();
	}
	public void eventChonAnh() {
		btn_ChonAnh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setLinkFile();	
			}
		});
	}
	public void eventChonAnh(String idBook) {
		String link = menuManager.link.getLink(idBook);
		image_SanPham.setIcon(new ImageIcon(link));
	}
	public void setLinkFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // chỉ hiện thị file
		int returnValue = fileChooser.showOpenDialog(this);
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			// lấy đường dẫn file	
			pathFile = file.getAbsolutePath().toString();
			BufferedImage b;
			try {
				b = ImageIO.read(file);
				image_SanPham.setIcon(new ImageIcon(b));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void eventTableProduct() {
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
				eventSelectDataJtabel();
				resertError();
				
			}
		});
	}
	public void eventSelectDataJtabel() {
		tf_MaSp.disable();
		
		int row = tb_BangSanPham.getSelectedRow();
		String maSp = ""+ model.getValueAt(row, 0);
		pathFile = menuManager.link.returnLink(maSp);
		for(book value: menuManager.bookBUS.returnArrbook()) {
			if(value.getIdBook().compareToIgnoreCase(maSp) == 0)
			{
				tf_MaSp.setText(value.getIdBook());
				tf_DonGia.setText(value.getUnitPrice()+"");
				list_LoaiSp.setSelectedIndex(menuManager.typeBookBUS.indexTypeBook(value.getIdTypeBook()));
				java.util.Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(value.getDatePublishing()+"");
					dateChooser.setDate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				list_NPH.setSelectedIndex(menuManager.pubBUS.indexPublishing(value.getIdPublishingCompany()));
				tf_SoLuong.setText(value.getQuantityBook()+"");
				tf_TenSp.setText(value.getNameBook());
				eventChonAnh(value.getIdBook());
				break;
			}
		}
		
	}
	public void eventAddObject() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				thietLapBang();
				addObject();
				
				
			}
		});
	}
	public void addObject() {
		
		try {
			String maSp = "" + tf_MaSp.getText();
			String tenSp = "" + tf_TenSp.getText();
			String loaiSp = "" + list_LoaiSp.getItemAt(list_LoaiSp.getSelectedIndex());
			String soLuong = "" + tf_SoLuong.getText();
			String donGia = "" + tf_DonGia.getText();
			java.util.Date date =  dateChooser.getDate();
			String date1 = ""+DateFormat.getDateInstance().format(date);
			String NXB = "" + list_NPH.getItemAt(list_NPH.getSelectedIndex());
			String result = menuManager.bookBUS.addObject(maSp, tenSp, loaiSp, soLuong, donGia, date1, NXB, pathFile);
			hienThiLoi(result,"Thêm sản phẩm thành công");
		}catch(Exception ex) {
			txtLoiDate.setText("Lỗi ngày tháng!");
		}
		
	}
	public void hienThiLoi(String error, String message) {
		switch (error) {
		case "0": {
			txt_ThanhCong.setText(message);
				thietLapBang();
			break;
		}
		case "Error Id":{
			txtLoiMa.setText("Mã trùng lặp!");
			break;
		}
		case "Error name":{
			txtLoiTen.setText("Tên rỗng!");
			break;
		}
		case "Error quantity":{
			txtLoiSoLuong.setText("SL không hợp lệ!");
			break;
		}
		case "Error date":{
			txtLoiDate.setText("ngày tháng sai!");
			break;
		}
		case "Error price":{
			txtLoiTien.setText("Đơn giá sai!");
			break;
		}
		}
		
	}
	public void eventTaoLai() {
		btn_TaoLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_MaSp.enable();
				thietLapBang();
				restartTf();
				resertError();
				
			}
		});
	}
	public void eventModifyObject() {
		btn_Sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				eventSuaSp();
				
				
			}
		});	}
	public void eventSuaSp() {
		try {
			String maSp = "" + tf_MaSp.getText();
			String tenSp = "" + tf_TenSp.getText();
			String loaiSp = "" + list_LoaiSp.getItemAt(list_LoaiSp.getSelectedIndex());
			String soLuong = "" + tf_SoLuong.getText();
			String donGia = "" + tf_DonGia.getText();
			java.util.Date date =  dateChooser.getDate();
			String date1 = ""+DateFormat.getDateInstance().format(date);
			String NXB = "" + list_NPH.getItemAt(list_NPH.getSelectedIndex());
			String result = menuManager.bookBUS.modifyObject(maSp, tenSp, loaiSp, soLuong, donGia, date1, NXB, pathFile);
			pathFile = "";
			hienThiLoi(result,"Sửa sản phẩm thành công");
			if(result.compareTo("0")==0)
				eventSearch(tf_MaSp.getText());
		}catch(Exception ex) {
			txtLoiDate.setText("Lỗi ngày tháng!");
		}
	}
	public void resertError() {
		txtLoiDate.setText("");
		txtLoiMa.setText("");
		txtLoiSoLuong.setText("");
		txtLoiTen.setText("");
		txtLoiTien.setText("");
		txt_ThanhCong.setText("");
	}
	public void eventDeleteObject() {
		btn_Xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resertError();
				eventDelete();
				
			}
		});
	}
	public void eventDelete() {
		try {
			String maSp = "" + tf_MaSp.getText();
			String tenSp = "" + tf_TenSp.getText();
			String loaiSp = "" + list_LoaiSp.getItemAt(list_LoaiSp.getSelectedIndex());
			String soLuong = "" + tf_SoLuong.getText();
			String donGia = "" + tf_DonGia.getText();
			java.util.Date date =  dateChooser.getDate();
			String date1 = ""+DateFormat.getDateInstance().format(date);
			String NXB = "" + list_NPH.getItemAt(list_NPH.getSelectedIndex());
			String result = menuManager.bookBUS.deleteObject(maSp, tenSp, loaiSp, soLuong, donGia, date1, NXB, pathFile);
			hienThiLoi(result,"Xóa sản phẩm thành công");
		}catch(Exception ex) {
			txtLoiDate.setText("Ngày tháng không chính xác!");
		}
		
	}
	public void eventSearchSp() {
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
				
				
				
			}
		});
	}
	public void eventSearch() {
		String s = tf_TimKiem.getText()+"";
		ArrayList<book> arrBook = menuManager.bookBUS.arrSearch(s);
		thietLapBangTimKiem(arrBook);
		
	}
	public void eventSearch(String s) {
		ArrayList<book> arrBook = menuManager.bookBUS.arrSearch(s);
		thietLapBangTimKiem(arrBook);
		
	}
	public void thietLapBangTimKiem(ArrayList<book> arrBook) {
		String col [] = {"Mã sách", "Tên sách", "Loại","Đơn giá","Số lượng","Ngày xuất bản" ,"Nhà xuất bản"};
		

		model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		
			for(book value: arrBook) {
				Vector vt = new Vector();
				vt.add(value.getIdBook());
				vt.add(value.getNameBook());
				vt.add(value.getIdTypeBook());
				vt.add(value.getUnitPrice());
				vt.add(value.getQuantityBook());
				vt.add(value.getDatePublishing());
				vt.add(value.getIdPublishingCompany());
				model.addRow(vt);
			}
		tb_BangSanPham.setModel(model);
		
	}
}
