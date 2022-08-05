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

import BUS.billBUS;
import DTO.bill;
import DTO.billDetail;
import DTO.coupon;
import DTO.detailCoupon;

public class pn_HoaDon extends JPanel{
	public pn_HoaDon() {
		 this.setLayout(null);
			this.setBounds(0, 20,770, 745);
			Border border = BorderFactory.createLineBorder(Color.black);
			setBorder(border);
			
			khoiTao();
			thietLap();
			
			event();
	}	
	private JLabel txt_TieuDe;
	private JLabel txt_HD;
	private JLabel txt_CTHD;
	private JButton btn_ThanhToan;
	private JLabel btn_TimKiem;
	private JButton btn_Xuat;
	private JTextField tf_TimKiem;
	private JTable tb_HoaDon;
	private DefaultTableModel model_HD;
	private JTable tb_CTHD;
	private DefaultTableModel model_CTHD;
	private JScrollPane scroll;
	private JScrollPane scrollCT;
	private JLabel txt_ThongBao;
	
	public void khoiTao() {
		txt_TieuDe = new JLabel();
		txt_HD = new JLabel();
		txt_CTHD = new JLabel();
		btn_ThanhToan = new JButton();
		btn_TimKiem = new JLabel();
		btn_Xuat = new JButton();
		tf_TimKiem = new JTextField();
		tb_HoaDon = new myTable();
		tb_CTHD = new myTable();
		txt_ThongBao = new JLabel();
	}
	public void thietLap() {
		thietLapGiaoDien();
		khoiTaoBang();
		thietLapBangHoaDon();
		thietLapCTHD();
	}
	public void thietLapGiaoDien() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Quản lý hóa đơn");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_HD.setText("Thông tin hóa đơn");
		txt_HD.setFont(font);
		txt_HD.setHorizontalAlignment(JLabel.LEFT);
		txt_HD.setBounds(10, 70, 200, 22);
		
		tf_TimKiem.setBounds(280, 70, 270, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		btn_TimKiem.setFont(font);
		btn_TimKiem.setIcon(new ImageIcon("image//image//timKiem.png"));
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setBounds(250, 70, 110, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		btn_ThanhToan.setText("Thanh toán");
		btn_ThanhToan.setIcon(new ImageIcon("image//image//BanHang//thanhToan.png"));
		btn_ThanhToan.setFocusable(false);
		btn_ThanhToan.setBounds(630, 110, 120, 29);
		btn_ThanhToan.setBackground(Color.lightGray);
		
		btn_Xuat.setText("Xuất HĐ");
		btn_Xuat.setFocusable(false);
		btn_Xuat.setIcon(new ImageIcon("image//image//XuatExcel.png"));
		btn_Xuat.setBounds(630, 150, 120, 29);
		btn_Xuat.setBackground(Color.lightGray);
		
		txt_CTHD.setText("Chi tiết hóa đơn");
		txt_CTHD.setFont(font);
		txt_CTHD.setBounds(10, 430, 250, 22);
		txt_CTHD.setHorizontalAlignment(JLabel.LEFT);
		
		txt_ThongBao.setBounds(250, 430, 300, 22);
		txt_ThongBao.setHorizontalAlignment(JLabel.LEFT);
		txt_ThongBao.setForeground(Color.red);
		
		this.add(txt_TieuDe);
		this.add(txt_HD);
		this.add(tf_TimKiem);
		this.add(btn_TimKiem);
		this.add(btn_ThanhToan);
		this.add(btn_Xuat);
		this.add(txt_CTHD);
		this.add(txt_ThongBao);
	}
	public void khoiTaoBang() {
		JTableHeader header = tb_HoaDon.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_HoaDon);
		scroll.setBounds(10, 100, 610, 330);
		this.add(scroll);
		
		JTableHeader header1 = tb_CTHD.getTableHeader();
		header1.setBackground(Color.pink);
		
		 scrollCT = new JScrollPane(tb_CTHD);
		scrollCT.setBounds(10, 460, 737, 275);
		this.add(scrollCT);
		
		
	}
	public void thietLapBangHoaDon() {
		ArrayList<bill> arrBill = menuManager.billBUS.arrBill();
		String col[] = {"Mã HĐ","Mã KH","Mã NV"," Ngày nhập", "Tổng tiền","Tiền chiết khấu","Tiền phải trả","Trạng thái"};
		model_HD = new DefaultTableModel(col, 0);
		model_HD.setColumnIdentifiers(col);
		for(bill value: arrBill) {
			Vector vt = new Vector();
			vt.add(value.getIdBill());
			vt.add(value.getIdCustomer());
			vt.add(value.getIdEmployee());
			vt.add(value.getDateBill());
			vt.add(value.getSumMoney());
			vt.add(value.getDiscountMoney());
			vt.add(value.getMoneyPayment());
			vt.add(value.getStatus());
			model_HD.addRow(vt);
		}
		
		tb_HoaDon.setModel(model_HD);
		
	}
	public void restart() {
		thietLapBangHoaDon();
		thietLapCTHD();
		tf_TimKiem.setText("");
		txt_ThongBao.setText("");
	}
	public void thietLapCTHD() {
		String col[] = {"Mã sách","Số lượng","Tổng tiền","Tiền đã giảm","Thành tiền"};
		model_CTHD = new DefaultTableModel(col, 0);
		model_CTHD.setColumnIdentifiers(col);
		tb_CTHD.setModel(model_CTHD);
	}
	public void event() {
		eventHoaDon();
		eventThanhToan();
		eventSearch();
		eventXuatHD();
	}
	public void eventHoaDon() {
		tb_HoaDon.addMouseListener(new MouseListener() {
			
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
				txt_ThongBao.setVisible(false);
				eventCTPHN();
			}
		});
	}
	public void eventThanhToan() {
		btn_ThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelLeftGUI.pnBanHang.pn_ThanhToan.restart();
				eventBtnThanhToan();
				
			}
		});
	}
	public void eventBtnThanhToan() {
		try{
		int row = tb_HoaDon.getSelectedRow();
		String idHd = model_HD.getValueAt(row, 0)+"";
		int num = Integer.parseInt(idHd);
		menuManager.billBUS.createObject(num);
		if(!menuManager.billBUS.KiemTraThanhToan(num)) {
			this.setVisible(false);
			pn_Manager_BanHang.pn_ThanhToan.idBill = Integer.parseInt(idHd);
			pn_Manager_BanHang.pn_ThanhToan.thietLapTongCTHD();
			pn_Manager_BanHang.pn_ThanhToan.thietLapBangCTHD(num);
			pn_Manager_BanHang.pn_ThanhToan.setVisible(true);
		}else 
			loiNhanDaThanhToan();
		}catch(Exception e) {
			loiNhanChuaChonThanhToan();
		}
		
	}
	public void loiNhanDaThanhToan() {
		txt_ThongBao.setText("Hóa đơn đã được thanh toán");
		txt_ThongBao.setVisible(true);
	}
	public void loiNhanChuaChonThanhToan() {
		txt_ThongBao.setText("Vui lòng chọn hóa đơn cần thanh toán");
		txt_ThongBao.setVisible(true);
	}
	public void eventCTPHN() {
		int row = tb_HoaDon.getSelectedRow();
		String id = tb_HoaDon.getValueAt(row, 0)+"";
		ArrayList<billDetail> arr = menuManager.billDTBUS.returnArrBillDTToBill(Integer.parseInt(id));
		String col[] = {"Mã sách","Số lượng","Đơn giá","Tổng tiền","Tiền đã giảm","Thành tiền"};
		model_CTHD = new DefaultTableModel(col, 0);
		model_CTHD.setColumnIdentifiers(col);
		
		for(billDetail value: arr) {
			Vector vt = new Vector();
			vt.add(value.getIdBook());
			vt.add(value.getQuantityBook());
			vt.add(menuManager.bookBUS.returnUnitprice(value.getIdBook())+"");
			vt.add(value.getUnitPrice());
			vt.add(value.getMoneyDown());
			vt.add(value.getIntoMoney());
			model_CTHD.addRow(vt);
		}
		tb_CTHD.setModel(model_CTHD);
		
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
		String txt = tf_TimKiem.getText();
		ArrayList<bill> arr =  menuManager.billBUS.eventSearch(txt);
		thietLapBangHoaDon(arr);
		txt_ThongBao.setText("Tìm thấy "+arr.size() + " hóa đơn");
	}
	public void thietLapBangHoaDon(ArrayList<bill> arrBill) {
		String col[] = {"Mã HĐ","Mã KH","Mã NV"," Ngày nhập", "Tổng tiền","Tiền chiết khấu","Tiền phải trả","Trạng thái"};
		model_HD = new DefaultTableModel(col, 0);
		model_HD.setColumnIdentifiers(col);
		for(bill value: arrBill) {
			Vector vt = new Vector();
			vt.add(value.getIdBill());
			vt.add(value.getIdCustomer());
			vt.add(value.getIdEmployee());
			vt.add(value.getDateBill());
			vt.add(value.getSumMoney());
			vt.add(value.getDiscountMoney());
			vt.add(value.getMoneyPayment());
			vt.add(value.getStatus());
			model_HD.addRow(vt);
		}
		
		tb_HoaDon.setModel(model_HD);
		
	}
	public void eventXuatHD() {
		btn_Xuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				XuatHD();
				
			}
		});
	}
	public void XuatHD() {
		txt_ThongBao.setForeground(Color.red);
		try {
			int row = tb_HoaDon.getSelectedRow();
			String id = model_HD.getValueAt(row, 0)+"";
			String status = model_HD.getValueAt(row, 7)+"";
			String idKh = model_HD.getValueAt(row, 1)+"";
			if(status.compareTo("Chưa thanh toán") == 0) {
				txt_ThongBao.setText("Vui lòng chọn hóa đơn cần thanh toán");
			}
			else {
				menuManager.billBUS.eventXuatFileExcel(Integer.parseInt(id), menuManager.customerBUS.TienChietKhau(menuManager.customerBUS.returnType(idKh)).replace("%", ""));
				JOptionPane.showConfirmDialog(new JFrame(), "Đã xuất hóa đơn vào file excel","Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		}catch(Exception ex) {
			txt_ThongBao.setText("Vui lòng chọn hóa đơn cần thanh toán");
		}
	}
}
