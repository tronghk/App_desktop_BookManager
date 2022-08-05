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

import BUS.billDetailBUS;
import BUS.bookBUS;
import DTO.bill;
import DTO.billDetail;
import DTO.customer;
import DTO.employee;

public class pn_ThongTinNV extends JPanel {
	public pn_ThongTinNV() {
		this.setLayout(null);
		this.setBounds(0, 20,770, 745);
		KhoiTaoGiaoDien();
		thietLapGiaoDien();
		event();
	}
	
	private JLabel txt_TieuDe;
	private JLabel txt_ThongtinNV;
	private JLabel txt_BXH;
	private JLabel txt_MaNV;
	private JLabel txt_TenNV;
	private JLabel txt_SoDienThoai;
	private JLabel txt_DiaChi;
	private JLabel txt_Luong;
	private JLabel txt_TenNVNew;
	private JLabel txt_MaNVNew;
	private JLabel txt_SDTNVNew;
	private JLabel txt_DCNVNew;
	private JLabel txt_LuongNew;
	private JTable  tb_BangCTHD;
	private JLabel txt_TimKiem;
	private JTextField tf_TimKiem;
	private DefaultTableModel model_BangCTHD;
	private JTable tb_BangHoaDon;
	private DefaultTableModel model_BangHD;
	private JButton btn_QuayLai;
	JScrollPane scroll;
	public void KhoiTaoGiaoDien() {
//		khởi tạo
		txt_TieuDe = new JLabel();
		txt_ThongtinNV = new JLabel();
		txt_MaNV = new JLabel();
		txt_TenNV = new JLabel();
		txt_SoDienThoai = new JLabel();
		txt_DiaChi = new JLabel();
		txt_Luong = new JLabel();
		txt_TimKiem = new JLabel();
		tf_TimKiem = new JTextField();
		txt_BXH = new JLabel();
		btn_QuayLai = new JButton(); 
		txt_MaNVNew = new JLabel();
		txt_TenNVNew = new JLabel();
		txt_SDTNVNew = new JLabel();
		txt_DCNVNew = new JLabel();
		txt_LuongNew = new JLabel();
		tb_BangCTHD = new myTable();
		tb_BangHoaDon = new myTable();
	}
	public void thietLapGiaoDien() {
		thietLapGiaoDienText();
		thietLapGiaoDientf();
		thietLapBtn();
		thietLapBangCTHD();
		thietLapBang();
		
		
	}
	public void thietLapGiaoDienText() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Thông tin nhân viên");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_BXH.setText("Hóa đơn đã bán");
		txt_BXH.setFont(font);
		txt_BXH.setHorizontalAlignment(0);
		txt_BXH.setBounds(460, 50, 150, 22);
		
		txt_ThongtinNV.setText("Thông tin nhân viên");
		txt_ThongtinNV.setFont(font);
		txt_ThongtinNV.setHorizontalAlignment(0);
		txt_ThongtinNV.setBounds(90, 50, 170, 22);
		
		txt_MaNV.setText("Mã NV   ");
		txt_MaNV.setFont(font);
		txt_MaNV.setHorizontalAlignment(0);
		txt_MaNV.setBounds(20, 75, 150, 30);
		
		txt_MaNVNew.setFont(font);
		txt_MaNVNew.setHorizontalAlignment(0);
		txt_MaNVNew.setBounds(140, 75, 160, 30);
		txt_MaNVNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TenNV.setText("Tên NV  ");
		txt_TenNV.setFont(font);
		txt_TenNV.setHorizontalAlignment(0);
		txt_TenNV.setBounds(20, 105, 150, 30);
		
		txt_TenNVNew.setFont(font);
		txt_TenNVNew.setHorizontalAlignment(0);
		txt_TenNVNew.setBounds(140, 105, 160, 30);
		txt_TenNVNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_SoDienThoai.setText("SĐT       ");
		txt_SoDienThoai.setFont(font);
		txt_SoDienThoai.setHorizontalAlignment(0);
		txt_SoDienThoai.setBounds(20, 135, 150, 30);
		
		txt_SDTNVNew.setFont(font);
		txt_SDTNVNew.setHorizontalAlignment(0);
		txt_SDTNVNew.setBounds(140, 135, 160, 30);
		txt_SDTNVNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_DiaChi.setText("Địa chỉ  ");
		txt_DiaChi.setFont(font);
		txt_DiaChi.setHorizontalAlignment(0);
		txt_DiaChi.setBounds(20, 165, 150, 30);
		
		txt_DCNVNew.setFont(font);
		txt_DCNVNew.setHorizontalAlignment(0);
		txt_DCNVNew.setBounds(140, 165, 160, 30);
		txt_DCNVNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_Luong.setText("Lương    ");
		txt_Luong.setFont(font);
		txt_Luong.setHorizontalAlignment(0);
		txt_Luong.setBounds(20, 195, 150, 30);
		
		txt_LuongNew.setFont(font);
		txt_LuongNew.setHorizontalAlignment(0);
		txt_LuongNew.setBounds(140, 195, 160, 30);
		txt_LuongNew.setHorizontalAlignment(JLabel.LEFT);
		
		txt_TimKiem.setText("Từ khóa");
		txt_TimKiem.setFont(font);
		txt_TimKiem.setHorizontalAlignment(0);
		txt_TimKiem.setBounds(310, 300, 150, 30);
		
		this.add(txt_TieuDe);
		this.add(txt_ThongtinNV);
		this.add(txt_MaNV);
		this.add(txt_TenNV);
		this.add(txt_SoDienThoai);
		this.add(txt_Luong);
		this.add(txt_DiaChi);
		this.add(txt_TimKiem);
		this.add(txt_BXH);
		this.add(txt_MaNVNew);
		this.add(txt_TenNVNew);
		this.add(txt_SDTNVNew);
		this.add(txt_DCNVNew);
		this.add(txt_LuongNew);
		
	}
	public void thietLapBang() {
		JTableHeader header = tb_BangHoaDon.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_BangHoaDon);
		scroll.setBounds(340, 75, 400, 200);
		this.add(scroll);
	}
	public void thietLapGiaoDientf() {
		
		tf_TimKiem.setBounds(430, 300, 150, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		this.add(tf_TimKiem);
	}
	public void thietLapThongTinNV(String idNV) {
		employee em = menuManager.emBUS.returnObject(idNV);
		txt_MaNVNew.setText(em.getIdEmployee());
		txt_TenNVNew.setText(em.getName());
		txt_SDTNVNew.setText(em.getPhoneNumber());
		txt_DCNVNew.setText(em.getAddress());
		txt_LuongNew.setText(em.getTurnover()+"");
		
	}
	public void thietLapBtn() {
		
		
		btn_QuayLai.setText("Trở lại");
		btn_QuayLai.setFocusable(false);
		btn_QuayLai.setBounds(10, 10, 80, 20);
		btn_QuayLai.setBackground(Color.lightGray);
		btn_QuayLai.setBackground(null);
		btn_QuayLai.setFocusable(false);
		
		
		
		
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
	public void resert() {
		
	}
	public void thietLapBangCTHD() {
		String col [] = {"STT", "Tên sách","Giá tiền/1c", "Số lượng mua","Tiền đã giảm","Tiền phải trả"};
		model_BangCTHD = new DefaultTableModel(col, 0);
		model_BangCTHD.setColumnIdentifiers(col);
			tb_BangCTHD.setModel(model_BangCTHD);
		JTableHeader header = tb_BangCTHD.getTableHeader();
		header.setBackground(Color.pink);
		JScrollPane scroll = new JScrollPane(tb_BangCTHD);
		scroll.setBounds(10, 340, 740, 400);
		this.add(scroll);
	}
	
	
	public void thietLapBangHD(String idNV) {
		ArrayList<bill> arrBill  = menuManager.billBUS.returnArrBillEmployee(idNV);
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
	public void resertCTHD() {
		String col [] = {"STT", "Tên sách","Giá tiền/1c", "Số lượng mua","Tiền đã giảm","Tiền phải trả"};
		model_BangCTHD = new DefaultTableModel(col, 0);
		model_BangCTHD.setColumnIdentifiers(col);
		tb_BangCTHD.setModel(model_BangCTHD);
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
				pn_Manager_NhanVien.pn_TTNV.setVisible(false);
				pn_Manager_NhanVien.pn_NhanVien.setVisible(true);
			}
		});
	}
}
