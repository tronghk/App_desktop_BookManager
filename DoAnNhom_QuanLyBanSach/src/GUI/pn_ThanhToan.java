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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.billDetailBUS;
import BUS.bookBUS;
import DTO.bill;
import DTO.billDetail;
import DTO.customer;

public class pn_ThanhToan extends JPanel{
	public pn_ThanhToan() {
		this.setLayout(null);
		this.setBounds(0, 20,770, 745);
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
	private JButton btn_ThanhToan;
	private JLabel txt_TenKHNew;
	private JLabel txt_MaKHNew;
	private JLabel txt_SDTKHNew;
	private JLabel txt_DCKHNew;
	private JLabel txt_LoaiKHNew;
	private JTable  tb_BangCTHD;
	private JLabel txt_TimKiem;
	private JTextField tf_TimKiem;
	private JScrollPane scroll;
	private DefaultTableModel model_BangCTHD;
	private JTable tb_BangKH;
	private DefaultTableModel model_BangKH;
	private JButton btn_QuayLai;
	private JLabel txt_TienGiam;
	private JLabel txt_TienGiamNew;
	private JScrollPane scrollHD;
	private JLabel txt_ChonLoaiTT;
	private JComboBox<String> cbb_LoaiTT;
	private JPanel pn_TongCong;
	private JLabel txt_TongSL;
	private JLabel txt_ThanhToan;
	private JLabel txt_TongTien;
	private JButton btn_ChonLai;
	static int idBill = 0;
	public void KhoiTaoGiaoDien() {
//		khởi tạo
		txt_TieuDe = new JLabel();
		txt_ThongtinKH = new JLabel();
		txt_MaKH = new JLabel();
		txt_TenKH = new JLabel();
		txt_SoDienThoai = new JLabel();
		txt_DiaChi = new JLabel();
		txt_LoaiKH = new JLabel();
		btn_ThanhToan = new JButton();
		txt_TimKiem = new JLabel();
		tf_TimKiem = new JTextField();
		txt_BXH = new JLabel();
		btn_QuayLai = new JButton(); 
		txt_MaKHNew = new JLabel();
		txt_TenKHNew = new JLabel();
		txt_SDTKHNew = new JLabel();
		txt_DCKHNew = new JLabel();
		txt_LoaiKHNew = new JLabel();
		txt_ChonLoaiTT = new JLabel();
		txt_TienGiam = new JLabel();
		txt_TienGiamNew = new JLabel();
		pn_TongCong = new JPanel();
		txt_TongSL = new JLabel();
		txt_ThanhToan = new JLabel();
		txt_TongTien = new JLabel();
		btn_ChonLai = new JButton();
		
	}
	public void thietLapGiaoDien() {
		thietLapGiaoDienText();
		thietLapGiaoDientf();
		thietLapBtn();
		TaoMoiBang();
		thietLapBangKH();
		thietLapLoaiTT();
	}
	public void TaoMoiBang() {
		tb_BangKH = new myTable();
		JTableHeader header = tb_BangKH.getTableHeader();
		header.setBackground(Color.pink);
		 scrollHD = new JScrollPane(tb_BangKH);
		scrollHD.setBounds(340, 75, 400, 200);
		this.add(scrollHD);
		
		tb_BangCTHD = new myTable();
		JTableHeader header1 = tb_BangCTHD.getTableHeader();
		header1.setBackground(Color.pink);
		scroll = new JScrollPane(tb_BangCTHD);
		scroll.setBounds(10, 340, 740, 380);
		this.add(scroll);
	}
	public void thietLapGiaoDienText() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Chọn khách hàng cần thanh toán");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_BXH.setText("Bảng khách hàng");
		txt_BXH.setFont(font);
		txt_BXH.setHorizontalAlignment(0);
		txt_BXH.setBounds(460, 50, 150, 22);
		
		txt_ThongtinKH.setText("Thông tin khách hàng");
		txt_ThongtinKH.setFont(font);
		txt_ThongtinKH.setHorizontalAlignment(0);
		txt_ThongtinKH.setBounds(90, 50, 170, 22);
		
		txt_MaKH.setText("Mã KH   ");
		txt_MaKH.setFont(font);
		txt_MaKH.setHorizontalAlignment(0);
		txt_MaKH.setBounds(20, 75, 150, 30);
		
		txt_MaKHNew.setFont(font);
		txt_MaKHNew.setHorizontalAlignment(0);
		txt_MaKHNew.setBounds(140, 75, 160, 30);
		txt_MaKHNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TenKH.setText("Tên KH  ");
		txt_TenKH.setFont(font);
		txt_TenKH.setHorizontalAlignment(0);
		txt_TenKH.setBounds(20, 105, 150, 30);
		
		txt_TenKHNew.setFont(font);
		txt_TenKHNew.setHorizontalAlignment(0);
		txt_TenKHNew.setBounds(140, 105, 160, 30);
		txt_TenKHNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_SoDienThoai.setText("SĐT       ");
		txt_SoDienThoai.setFont(font);
		txt_SoDienThoai.setHorizontalAlignment(0);
		txt_SoDienThoai.setBounds(20, 135, 150, 30);
		
		txt_SDTKHNew.setFont(font);
		txt_SDTKHNew.setHorizontalAlignment(0);
		txt_SDTKHNew.setBounds(140, 135, 160, 30);
		txt_SDTKHNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_DiaChi.setText("Địa chỉ  ");
		txt_DiaChi.setFont(font);
		txt_DiaChi.setHorizontalAlignment(0);
		txt_DiaChi.setBounds(20, 165, 150, 30);
		
		txt_DCKHNew.setFont(font);
		txt_DCKHNew.setHorizontalAlignment(0);
		txt_DCKHNew.setBounds(140, 165, 160, 30);
		txt_DCKHNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_LoaiKH.setText("Loại KH");
		txt_LoaiKH.setFont(font);
		txt_LoaiKH.setHorizontalAlignment(0);
		txt_LoaiKH.setBounds(20, 195, 150, 30);
		
		txt_TienGiam.setText("% giảm  ");
		txt_TienGiam.setFont(font);
		txt_TienGiam.setHorizontalAlignment(0);
		txt_TienGiam.setBounds(20, 225, 150, 30);
		
		txt_ChonLoaiTT.setText("Chọn loại thanh toán");
		txt_ChonLoaiTT.setFont(font);
		txt_ChonLoaiTT.setHorizontalAlignment(JLabel.LEFT);
		txt_ChonLoaiTT.setBounds(10, 255, 200, 30);
		
		txt_LoaiKHNew.setFont(font);
		txt_LoaiKHNew.setHorizontalAlignment(0);
		txt_LoaiKHNew.setBounds(140, 195, 160, 30);
		txt_LoaiKHNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TienGiamNew.setFont(font);
		txt_TienGiamNew.setHorizontalAlignment(0);
		txt_TienGiamNew.setBounds(140, 225, 160, 30);
		txt_TienGiamNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TimKiem.setText("Tìm khách hàng");
		txt_TimKiem.setFont(font);
		txt_TimKiem.setHorizontalAlignment(0);
		txt_TimKiem.setBounds(320, 300, 150, 30);
		
		this.add(txt_TieuDe);
		this.add(txt_ThongtinKH);
		this.add(txt_MaKH);
		this.add(txt_TenKH);
		this.add(txt_SoDienThoai);
		this.add(txt_LoaiKH);
		this.add(txt_DiaChi);
		this.add(txt_TimKiem);
		this.add(txt_BXH);
		this.add(txt_MaKHNew);
		this.add(txt_TenKHNew);
		this.add(txt_SDTKHNew);
		this.add(txt_DCKHNew);
		this.add(txt_LoaiKHNew);
		this.add(txt_TienGiam);
		this.add(txt_TienGiamNew);
		this.add(txt_ChonLoaiTT);
		
		this.add(pn_TongCong);
		pn_TongCong.add(txt_TongSL);
		pn_TongCong.add(txt_ThanhToan);
		pn_TongCong.add(txt_TongTien);
		
	}
	public void thietLapTongCTHD() {
		pn_TongCong.setLayout(null);
		pn_TongCong.setBackground(Color.orange);
		pn_TongCong.setBounds(10, 720, 740, 20);
		
		txt_TongSL.setText("Tổng số sách: " + menuManager.billDTBUS.returnQuantityBook(menuManager.billBUS.returnOBStaticBill().getIdBill()));
		txt_TongSL.setHorizontalAlignment(JLabel.LEFT);
		txt_TongSL.setBounds(10, 0, 150, 20);
		
		txt_ThanhToan.setText("Loại thanh toán: Trực tiếp");
		txt_ThanhToan.setHorizontalAlignment(JLabel.LEFT);
		txt_ThanhToan.setBounds(240, 0, 200, 20);
		
		txt_TongTien.setText("Tổng tiền: "+menuManager.billDTBUS.returnSumPrice(menuManager.billBUS.returnOBStaticBill().getIdBill()));
		txt_TongTien.setHorizontalAlignment(JLabel.LEFT);
		txt_TongTien.setBounds(550, 0, 150, 20);
	}
	public void thietLapGiaoDientf() {
		
		tf_TimKiem.setBounds(480, 300, 200, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_TimKiem);
	}
	public void thietLapThongTinKH(String idKH) {
		customer cu = menuManager.customerBUS.returnObject(idKH);
		txt_MaKHNew.setText(cu.getIdCustomer());
		txt_TenKHNew.setText(cu.getName());
		txt_SDTKHNew.setText(cu.getPhoneNumber());
		txt_DCKHNew.setText(cu.getAddress());
		txt_LoaiKHNew.setText(cu.getTypeCustomer());
	}
	public void thietLapBtn() {
		btn_ThanhToan.setText("Thanh toán");
		btn_ThanhToan.setFocusable(false);
		btn_ThanhToan.setIcon(new ImageIcon("image//image//BanHang//thanhToana.png"));
		btn_ThanhToan.setBounds(30, 300, 120, 30);
		btn_ThanhToan.setBackground(Color.lightGray);
		
		btn_ChonLai.setText("Chọn lại");
		btn_ChonLai.setFocusable(false);
		btn_ChonLai.setIcon(new ImageIcon("image//image//TaoLai.png"));
		btn_ChonLai.setBounds(160, 300, 120, 30);
		btn_ChonLai.setBackground(Color.lightGray);
		
		btn_QuayLai.setText("Trở lại");
		btn_QuayLai.setFocusable(false);
		btn_QuayLai.setBounds(10, 10, 80, 20);
		btn_QuayLai.setBackground(Color.lightGray);
		btn_QuayLai.setBackground(null);
		btn_QuayLai.setFocusable(false);
		
		
		
		
		this.add(btn_ThanhToan);
		this.add(btn_QuayLai);
		this.add(btn_ChonLai);
	}
	public void thietLapLoaiTT() {
		String [] LoaiTT = {"Trực tiếp", "Momo","ATM"};
		cbb_LoaiTT = new JComboBox<String>(LoaiTT);
		cbb_LoaiTT.setBounds(180, 260, 120, 20);
		this.add(cbb_LoaiTT);
	}
	public void thietLapBangCTHD(int idBill) {
		ArrayList<billDetail> arrBillDT = menuManager.billDTBUS.returnArrBillDTToBill(idBill);

		String col [] = {"STT", "Tên sách","Giá tiền/1c", "Số lượng mua","Tiền đã giảm","Tiền phải trả"};
		

		model_BangCTHD = new DefaultTableModel(col, 0);
		model_BangCTHD.setColumnIdentifiers(col);
		int i=1;
			for(billDetail value: arrBillDT) {
				Vector vt = new Vector();
				vt.add(i);
				vt.add(menuManager.bookBUS.returnNameBook(value.getIdBook()));
				vt.add(menuManager.bookBUS.returnPriceBook(value.getIdBook()));
				vt.add(value.getQuantityBook());
				vt.add(value.getMoneyDown());
				vt.add(value.getIntoMoney());
				model_BangCTHD.addRow(vt);
				i++;
			}
			tb_BangCTHD.setModel(model_BangCTHD);
	}
	public void thietLapBangCTHD() {
		

		String col [] = {"STT", "Tên sách","Giá tiền/1c", "Số lượng mua","Tiền đã giảm","Tiền phải trả"};
		

		model_BangCTHD = new DefaultTableModel(col, 0);
		model_BangCTHD.setColumnIdentifiers(col);
			tb_BangCTHD.setModel(model_BangCTHD);
	}
	public void thietLapBangKH() {
		ArrayList<customer> arrCustomer = menuManager.customerBUS.returnArr();
		String col [] = {"Mã KH", "Tên KH","SĐT", "Địa Chỉ","Loại KH"};
		model_BangKH = new DefaultTableModel(col, 0);
		model_BangKH.setColumnIdentifiers(col);
			for(customer value: arrCustomer) {
				Vector vt = new Vector();
				vt.add(value.getIdCustomer());
				vt.add(value.getName());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddress());
				vt.add(value.getTypeCustomer());
				model_BangKH.addRow(vt);
			}
			tb_BangKH.setModel(model_BangKH);

		eventBangKH();
	}
	public void event() {
		eventBtnBack();
		eventPhuongThucThanhToan();
		eventSearch();
		eventThanhToan();
		eventQuayLai();
	}
	public void eventBangKH() {
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
				int row = tb_BangKH.getSelectedRow();
				String idKH = model_BangKH.getValueAt(row, 0)+"";
				eventBangKH(idKH);
				eventTongCTHD(idKH);
			}
		});
	}
	public void eventBangKH(String idKhachHang) {
		customer cu = menuManager.customerBUS.returnObject(idKhachHang);
		txt_DCKHNew.setText(cu.getAddress());
		txt_LoaiKHNew.setText(cu.getTypeCustomer());
		txt_MaKHNew.setText(cu.getIdCustomer());
		txt_SDTKHNew.setText(cu.getPhoneNumber());
		txt_TenKHNew.setText(cu.getName());
		txt_TienGiamNew.setText(menuManager.customerBUS.TienChietKhau(cu.getTypeCustomer()));
	}
	public void eventTongCTHD(String idKH) {
		customer cu = menuManager.customerBUS.returnObject(idKH);
		String LoaiKH = cu.getTypeCustomer();
		String LoaiTT = cbb_LoaiTT.getSelectedItem().toString();
		txt_ThanhToan.setText("Loại thanh toán: "+LoaiTT+"-"+LoaiKH);
		float sumMoney = menuManager.billDTBUS.returnSumPrice(menuManager.billBUS.returnOBStaticBill().getIdBill());
		sumMoney = (float) menuManager.customerBUS.downPrice(sumMoney, cu.getTypeCustomer());
		txt_TongTien.setText("Tổng tiền: "+ sumMoney );
	}
	public void eventBtnBack() {
		btn_QuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pn_Manager_BanHang.pn_HoaDon.restart();
				pn_Manager_BanHang.pn_BanHang.setVisible(false);
				pn_Manager_BanHang.pn_HoaDon.setVisible(true);
				
				restart();
				
			}
		});
		
	}
	public void restart() {
		txt_DCKHNew.setText("");
		txt_LoaiKHNew.setText("");
		txt_MaKHNew.setText("");
		txt_SDTKHNew.setText("");
		txt_TenKHNew.setText("");
		txt_TienGiamNew.setText("");
		tf_TimKiem.setText("");
		cbb_LoaiTT.setSelectedIndex(0);
		thietLapBangKH();
		thietLapBangCTHD();
	}
	public void eventPhuongThucThanhToan() {
		cbb_LoaiTT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTextLoaiThanhToan();
				
			}
		});
	}
	public void setTextLoaiThanhToan() {
		
		String LoaiKH = txt_LoaiKHNew.getText()+"";
		String LoaiTT = cbb_LoaiTT.getSelectedItem().toString();
		if(!menuManager.customerBUS.checkEmplty(LoaiKH))
			 LoaiTT+="-";
		
		txt_ThanhToan.setText("Loại thanh toán: "+LoaiTT+LoaiKH);
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
		model_BangKH = new DefaultTableModel(col, 0);
		model_BangKH.setColumnIdentifiers(col);
		
			for(customer value: arr) {
				Vector vt = new Vector();
				vt.add(value.getIdCustomer());
				vt.add(value.getName());
				vt.add(value.getPhoneNumber());
				vt.add(value.getAddress());
				vt.add(value.getTypeCustomer());
				model_BangKH.addRow(vt);
			}
			tb_BangKH.setModel(model_BangKH);
			
	}
	public void eventQuayLai() {
		btn_ChonLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				restartKH();
				
			}
		});
	}
	public void restartKH() {
		txt_DCKHNew.setText("");
		txt_LoaiKHNew.setText("");
		txt_MaKHNew.setText("");
		txt_SDTKHNew.setText("");
		txt_TenKHNew.setText("");
		txt_TienGiamNew.setText("");
		tf_TimKiem.setText("");
		cbb_LoaiTT.setSelectedIndex(0);
		thietLapBangKH();
	}
	public void eventThanhToan() {
		btn_ThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thanhToan();
				
			}
		});
	}
	public void thanhToan() {
		String idKH = "";
		try {
		int row = tb_BangKH.getSelectedRow();
		idKH = idKH+ model_BangKH.getValueAt(row, 0);
		}catch(Exception ex){
			
		}
		menuManager.billBUS.changeIdKH(idKH, idBill+"");
		menuManager.billBUS.eventXuatFileExcel(idBill,txt_TienGiamNew.getText().replace("%", ""));
		JOptionPane.showConfirmDialog(new JFrame(), "Thanh toán hoàn tất, hãy đợi in hóa đơn", "Thông báo", JOptionPane.DEFAULT_OPTION);
	}
}
