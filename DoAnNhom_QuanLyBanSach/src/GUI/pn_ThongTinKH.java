package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.billBUS;
import BUS.billDetailBUS;
import BUS.bookBUS;
import DTO.book;
import DTO.customer;
import DTO.bill;
import DTO.billDetail;

public class pn_ThongTinKH extends JPanel{
	public pn_ThongTinKH() {
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
	private JLabel txt_TenKHNew;
	private JLabel txt_MaKHNew;
	private JLabel txt_SDTKHNew;
	private JLabel txt_DCKHNew;
	private JLabel txt_LoaiKHNew;
	private JButton btn_TimKiem;
	private JTable  tb_BangCTHD;
	private JLabel txt_TimKiem;
	private JTextField tf_TimKiem;
	private JScrollPane scroll;
	private JScrollPane scrollCT;
	private DefaultTableModel model_BangCTHD;
	private JTable tb_BangHoaDon;
	private DefaultTableModel model_BangHD;
	private JButton btn_QuayLai;
	public void KhoiTaoGiaoDien() {
//		khởi tạo
		txt_TieuDe = new JLabel();
		txt_ThongtinKH = new JLabel();
		txt_MaKH = new JLabel();
		txt_TenKH = new JLabel();
		txt_SoDienThoai = new JLabel();
		txt_DiaChi = new JLabel();
		txt_LoaiKH = new JLabel();
		txt_TimKiem = new JLabel();
		tf_TimKiem = new JTextField();
		btn_TimKiem = new JButton();
		txt_BXH = new JLabel();
		btn_QuayLai = new JButton(); 
		txt_MaKHNew = new JLabel();
		txt_TenKHNew = new JLabel();
		txt_SDTKHNew = new JLabel();
		txt_DCKHNew = new JLabel();
		txt_LoaiKHNew = new JLabel();
		tb_BangCTHD = new myTable();
	}
	public void thietLapGiaoDien() {
		thietLapGiaoDienText();
		thietLapGiaoDientf();
		thietLapBtn();
		taoBangHD();
		thietLapBangCTHD();

	}
	public void thietLapGiaoDienText() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Thông tin khách hàng");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_BXH.setText("Hóa đơn đã mua");
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
		
		txt_LoaiKHNew.setFont(font);
		txt_LoaiKHNew.setHorizontalAlignment(0);
		txt_LoaiKHNew.setBounds(140, 195, 160, 30);
		txt_LoaiKHNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TimKiem.setText("Từ khóa");
		txt_TimKiem.setFont(font);
		txt_TimKiem.setHorizontalAlignment(0);
		txt_TimKiem.setBounds(310, 300, 150, 30);
		
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
		
	}
	public void thietLapGiaoDientf() {
		
		tf_TimKiem.setBounds(430, 300, 150, 30);
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
		thietLapBangCTHD();
	}
	public void thietLapBtn() {
		
		btn_TimKiem.setText("Tìm");
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setBounds(590, 300, 70, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		btn_QuayLai.setText("Trở lại");
		btn_QuayLai.setFocusable(false);
		btn_QuayLai.setBounds(10, 10, 80, 20);
		btn_QuayLai.setBackground(Color.lightGray);
		btn_QuayLai.setBackground(null);
		btn_QuayLai.setFocusable(false);
		
		
		
		
		this.add(btn_TimKiem);
		this.add(btn_QuayLai);
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
			}
			tb_BangCTHD.setModel(model_BangCTHD);
	}
	public void thietLapBangCTHD() {
		
		String col [] = {"STT", "Tên sách","Giá tiền/1c", "Số lượng mua","Tiền đã giảm","Tiền phải trả"};
		

		model_BangCTHD = new DefaultTableModel(col, 0);
		model_BangCTHD.setColumnIdentifiers(col);
			tb_BangCTHD.setModel(model_BangCTHD);
		
	}
	public void taoBangHD() {
		tb_BangHoaDon = new myTable();
		JTableHeader header = tb_BangHoaDon.getTableHeader();
		header.setBackground(Color.pink);
		
		scroll = new JScrollPane(tb_BangHoaDon);
		scroll.setBounds(340, 75, 400, 200);
		this.add(scroll);
		tb_BangCTHD = new myTable();
		JTableHeader headerCT = tb_BangCTHD.getTableHeader();
		headerCT.setBackground(Color.pink);
		scrollCT = new JScrollPane(tb_BangCTHD);
		scrollCT.setBounds(0, 340, 757, 420);
		this.add(scrollCT);
	}
	public void thietLapBangHD(String idKH) {
		ArrayList<bill> arrBill  = menuManager.billBUS.returnArrBillCustomer(idKH);
		
		String col [] = {"Mã HD", "NVBH","Ngày lập HD", "Tổng tiền","Loại TT"};
		

		model_BangHD = new DefaultTableModel(col, 0);
		model_BangHD.setColumnIdentifiers(col);
			for(bill value: arrBill) {
				Vector vt = new Vector();
				vt.add(value.getIdBill());
				vt.add(menuManager.emBUS.nameEmployee(value.getIdEmployee()));
				vt.add(value.getDateBill().toString());
				vt.add(value.getMoneyPayment());
				vt.add(value.getTypePayment());
				model_BangHD.addRow(vt);
			}
		tb_BangHoaDon.setModel(model_BangHD);

		eventBangHD();
	}
	public void event() {
		eventBtnBack();
	}
	public void eventBangHD() {
		tb_BangHoaDon.addMouseListener(new MouseListener() {
			
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
				int id = returnRowClick();
				thietLapBangCTHD(id);
			}
		});
	}
	public int returnRowClick() {
		int row = tb_BangHoaDon.getSelectedRow();
		String id = model_BangHD.getValueAt(row, 0)+"";
		return Integer.parseInt(id);
	}
	public void eventBtnBack() {
		btn_QuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thietLapBangCTHD();
				PanelLeftGUI.pn_ThongTinKH.setVisible(false);
				PanelLeftGUI.pnKhachHang.setVisible(true);	
			}
		});
	}
}
