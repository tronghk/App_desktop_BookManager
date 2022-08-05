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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DTO.coupon;
import DTO.detailCoupon;

public class pn_PhieuNhapHang extends JPanel {
	public pn_PhieuNhapHang() {
		 this.setLayout(null);
			this.setBounds(0, 20,770, 745);
			Border border = BorderFactory.createLineBorder(Color.black);
			setBorder(border);
			
			khoiTao();
			thietLap();
			
			event();
	}	
	private JLabel txt_TieuDe;
	private JLabel txt_PhieuNhapHang;
	private JLabel txt_CTPNH;
	private JButton btn_Them;
	private JButton btn_TimKiem;
	private JButton btn_Xuat;
	private JTextField tf_TimKiem;
	private JTable tb_PhieuNhapHang;
	private DefaultTableModel model_PNH;
	private JTable tb_CTPNH;
	private DefaultTableModel model_CTPHN;
	JScrollPane scroll;
	private JScrollPane scrollCT;
	private JLabel thongBao;
	
	public void khoiTao() {
		taoPhieuNhapHang();
		txt_TieuDe = new JLabel();
		txt_PhieuNhapHang = new JLabel();
		txt_CTPNH = new JLabel();
		btn_Them = new JButton();
		btn_TimKiem = new JButton();
		btn_Xuat = new JButton();
		tf_TimKiem = new JTextField();
		thongBao = new JLabel();
	}
	public void thietLap() {
		thietLapGiaoDien();
		thietLapBangPhieuNhapHang();
		thietLapCTPNH();
	}
	public void taoPhieuNhapHang() {
		tb_PhieuNhapHang = new myTable();
		JTableHeader header = tb_PhieuNhapHang.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_PhieuNhapHang);
		scroll.setBounds(0, 100, 620, 330);
		this.add(scroll);
		
		tb_CTPNH = new myTable();
		JTableHeader headerCT = tb_CTPNH.getTableHeader();
		headerCT.setBackground(Color.pink);
		
		 scrollCT = new JScrollPane(tb_CTPNH);
		scrollCT.setBounds(0, 460, 757, 280);
		this.add(scrollCT);
	}
	public void thietLapGiaoDien() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Quản lý phiếu nhập hàng");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_PhieuNhapHang.setText("Thông tin phiếu nhập hàng");
		txt_PhieuNhapHang.setFont(font);
		txt_PhieuNhapHang.setHorizontalAlignment(0);
		txt_PhieuNhapHang.setBounds(10, 70, 200, 22);
		
		tf_TimKiem.setBounds(300, 65, 200, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		btn_TimKiem.setText("Tìm kiếm");
		btn_TimKiem.setIcon(new ImageIcon("image//image//timKiem.png"));
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setBounds(510, 65, 110, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		btn_Them.setText("Tạo PNH");
		btn_Them.setFocusable(false);
		btn_Them.setIcon(new ImageIcon("image//image//BanHang//thanhToan.png"));
		btn_Them.setHorizontalAlignment(JButton.LEFT);
		btn_Them.setBounds(630, 110, 120, 29);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Xuat.setText("Xuất PNH");
		btn_Xuat.setFocusable(false);
		btn_Xuat.setIcon(new ImageIcon("image//image//XuatExcel.png"));
		btn_Xuat.setBounds(630, 150, 120, 29);
		btn_Xuat.setBackground(Color.lightGray);
		
		txt_CTPNH.setText("Chi tiết phiếu nhập hàng");
		txt_CTPNH.setFont(font);
		txt_CTPNH.setBounds(10, 435, 250, 22);
		txt_CTPNH.setHorizontalAlignment(JLabel.LEFT);
		
		thongBao.setFont(font);
		thongBao.setBounds(300, 430, 250, 22);
		thongBao.setHorizontalAlignment(JLabel.LEFT);
		
		this.add(txt_TieuDe);
		this.add(txt_PhieuNhapHang);
		this.add(tf_TimKiem);
		this.add(btn_TimKiem);
		this.add(btn_Them);
		this.add(btn_Xuat);
		this.add(txt_CTPNH);
		this.add(thongBao);
	}
	public void thietLapBangPhieuNhapHang() {
		
		ArrayList<coupon> arrCoupon = menuManager.couponBUS.returnArrCoupon();
		String col[] = {"Mã PHN"," Ngày nhập", "Tổng tiền","Nhà cung cấp"};
		model_PNH = new DefaultTableModel(col, 0);
		model_PNH.setColumnIdentifiers(col);
		for(coupon value: arrCoupon) {
			Vector vt = new Vector();
			vt.add(value.getIdCoupon());
			vt.add(value.getDateAdded()+"");
			vt.add(value.getIntoMoney());
			vt.add(value.getIdBookDistributor());
			model_PNH.addRow(vt);
		}
		tb_PhieuNhapHang.setModel(model_PNH);
		
		
	}
	public void restart() {
		restartPNH();
		restartCTPNH();
		thongBao.setText("");
		
	}
	public void restartThongBao() {
		thongBao.setText("");
	}
	public void restartPNH() {
		ArrayList<coupon> arrCoupon = menuManager.couponBUS.returnArrCoupon();
		String col[] = {"Mã PHN"," Ngày nhập", "Tổng tiền","Nhà cung cấp"};
		model_PNH = new DefaultTableModel(col, 0);
		model_PNH.setColumnIdentifiers(col);
		for(coupon value: arrCoupon) {
			Vector vt = new Vector();
			vt.add(value.getIdCoupon());
			vt.add(value.getDateAdded()+"");
			vt.add(value.getIntoMoney());
			vt.add(value.getIdBookDistributor());
			model_PNH.addRow(vt);
		}
		tb_PhieuNhapHang.setModel(model_PNH);
		tf_TimKiem.setText("");
	}
	public void restartCTPNH() {
		String col[] = {"Mã sách","Số lượng","Giá tiền/c","Tổng tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		tb_CTPNH.setModel(model_CTPHN);
	}
	public void thietLapCTPNH() {
		String col[] = {"Mã sách","Số lượng","Giá tiền/c","Tổng tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		tb_CTPNH.setModel(model_CTPHN);
	}
	public void event() {
		eventPNH();
		eventTaoPNH();
		eventSearch();
		eventTimKiem();
		eventXuatPNH();
	}
	public void eventPNH() {
		tb_PhieuNhapHang.addMouseListener(new MouseListener() {
			
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
				
				eventCTPHN();
			}
		});
	}
	public void eventTaoPNH() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pn_Manager_NhapHang.pn_PhieuNhapHang.setVisible(false);
				pn_Manager_NhapHang.pn_CTPNH.reastart();
				pn_Manager_NhapHang.pn_CTPNH.setVisible(true);
				
			}
		});
	}
	public void eventCTPHN() {
		
		int row = tb_PhieuNhapHang.getSelectedRow();
		String id = model_PNH.getValueAt(row, 0)+"";
		ArrayList<detailCoupon> arr = menuManager.dtCoupon.returnArrSomeCoupon(Integer.parseInt(id));
		String col[] = {"Mã sách","Số lượng","Giá tiền/c","Tổng tiền"};
		model_CTPHN = new DefaultTableModel(col, 0);
		model_CTPHN.setColumnIdentifiers(col);
		
		for(detailCoupon value: arr) {
			Vector vt = new Vector();
			vt.add(value.getIdBook());
			vt.add(value.getQuantityImport());
			vt.add(value.getUnitPrice());
			vt.add(value.getIntoMoney());
			model_CTPHN.addRow(vt);
		}
		tb_CTPNH.setModel(model_CTPHN);
		
		
	}
	public void eventSearch() {
		tf_TimKiem.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					search();
				
			}
		});
	}
	public void search() {
		String text = tf_TimKiem.getText();
		ArrayList<coupon> arr =  menuManager.couponBUS.eventSearch(text);
		searchPNH(arr);
	}
	public void searchPNH(ArrayList<coupon> arrCoupon) {
		
		String col[] = {"Mã PHN"," Ngày nhập", "Tổng tiền","Nhà cung cấp"};
		model_PNH = new DefaultTableModel(col, 0);
		model_PNH.setColumnIdentifiers(col);
		for(coupon value: arrCoupon) {
			Vector vt = new Vector();
			vt.add(value.getIdCoupon());
			vt.add(value.getDateAdded()+"");
			vt.add(value.getIntoMoney());
			vt.add(value.getIdBookDistributor());
			model_PNH.addRow(vt);
		}
		tb_PhieuNhapHang.setModel(model_PNH);
		tf_TimKiem.setText("");
	}
	public void eventTimKiem() {
		btn_TimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			search();
				
			}
		});
	}
	public void eventXuatPNH() {
		btn_Xuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuatPhieuNhapHang();
				
			}
		});
	}
	public void xuatPhieuNhapHang() {
		try {
		int row = tb_PhieuNhapHang.getSelectedRow();
		String id = model_PNH.getValueAt(row, 0)+"";
		menuManager.dtCoupon.eventXuatFileExcel(Integer.parseInt(id));
		hienThiXuatPNH();
		}catch(Exception ex) {
			thongBao.setText("Chưa chọn phiếu nhập hàng");
		}
		
	}
	public void hienThiXuatPNH() {
			thongBao.setText("Đã xuất phiếu nhập hàng");
	}
}
