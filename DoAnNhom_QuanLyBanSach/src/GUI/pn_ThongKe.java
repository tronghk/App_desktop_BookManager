package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class pn_ThongKe extends JPanel {
	public pn_ThongKe() {
		this.setLayout(null);
		this.setBounds(0, 0,770, 800);
		this.setBackground(Color.gray);
		KhoiTao();
		setNullPN();
		thietLap();
		event();
	}
	private JLabel txt_TieuDe;
	private JLabel image_NhanVien;
	private JLabel image_ThanhVien;
	private JLabel image_Sach;
	private JLabel image_DoanhThu;
	private JLabel txt_TongNhanVien;
	private JLabel txt_ThanhVien;
	private JLabel txt_TongSach;
	private JLabel txt_TongDoanhThu;
	private JLabel txt_NhanVien;
	private JLabel txt_TongThanhVien;
	private JLabel txt_Sach;
	private JLabel txt_DoanhThu;
	private JTable tb_BangDoanhThu;
	private JScrollPane scroll;
	private JButton btn_ThongTinChiTiet;
	private JComboBox<String> listDate;
	private JPanel pn_DoanhThu;
	private JPanel pn_Sach;
	private JPanel pn_NhanVien;
	private JPanel pn_ThanhVien;
	private JLabel txt_ThongKeTheoQuy;
	private JTable tb_TongDoanhThu;
	private JScrollPane scroll_Tong;
	static String year = ""+2020;
	
	public void KhoiTao() {
		khoiTaoBang();
		khoiTaoDate();
		image_DoanhThu = new JLabel();
		image_NhanVien = new JLabel();
		image_Sach = new JLabel();
		image_ThanhVien = new JLabel();
		txt_DoanhThu = new JLabel();
		txt_NhanVien = new JLabel();
		txt_Sach  = new JLabel();
		txt_TongThanhVien = new JLabel();
		txt_TongDoanhThu = new  JLabel();
		txt_TongNhanVien = new  JLabel();
		txt_TongSach = new JLabel();
		txt_ThanhVien = new JLabel();
		btn_ThongTinChiTiet = new JButton();
		pn_DoanhThu = new myPanel();
		pn_Sach = new myPanel();
		pn_NhanVien = new myPanel();
		pn_ThanhVien = new myPanel();
		txt_TieuDe = new JLabel();
		txt_ThongKeTheoQuy = new JLabel();
	}
	public void khoiTaoBang() {
		tb_BangDoanhThu = new myTable();
		JTableHeader header = tb_BangDoanhThu.getTableHeader();
		header.setBackground(Color.pink);
		scroll = new JScrollPane(tb_BangDoanhThu);
		scroll.setBounds(10, 485, 735, 255);
		this.add(scroll);
		
		tb_TongDoanhThu = new myTable();
		JTableHeader header1 = tb_TongDoanhThu.getTableHeader();
		header1.setBackground(Color.orange);
		scroll_Tong = new JScrollPane(tb_TongDoanhThu);
		scroll_Tong.setBounds(10, 740, 735, 20);
		this.add(scroll_Tong);
	}
	public void khoiTaoDate() {
		String s[] = {"2020","2021","2022"};
		listDate = new JComboBox<String>(s);
		this.add(listDate);
	}
	public void setNullPN() {
		pn_DoanhThu.setLayout(null);
		pn_ThanhVien.setLayout(null);
		pn_NhanVien.setLayout(null);
		pn_Sach.setLayout(null);
	}
	public void thietLap() {
		thietLapTxt();
		thietLapImage();
		thietLapPn();
		thietLapBtn();
		thietLapCbb();
		thietLapBang();
	}
	public void thietLapTxt() {
		
		txt_TieuDe.setText("Thống kê hằng năm");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30); 
		
		txt_ThongKeTheoQuy.setText("Thống kê theo quý");
		txt_ThongKeTheoQuy.setFont(new Font("Arial", Font.BOLD, 23));
		txt_ThongKeTheoQuy.setHorizontalAlignment(0);
		txt_ThongKeTheoQuy.setBounds(-10, 450, 770, 30); 
		
		Font font = new Font("Arial", Font.BOLD, 15);
		Font fontTong = new Font("Arial", Font.BOLD, 20);
		txt_DoanhThu.setFont(font);
		txt_DoanhThu.setText("Doanh thu");
		txt_DoanhThu.setBounds(10, 0, 150, 100);
		
		txt_TongDoanhThu.setFont(fontTong);
		txt_TongDoanhThu.setBounds(20, 20, 250, 120);
		
		txt_Sach.setFont(font);
		txt_Sach.setText("Sách");
		txt_Sach.setBounds(10, 0, 150, 100);
		
		txt_TongSach.setFont(fontTong);
		txt_TongSach.setBounds(20, 20, 230, 120);
		
		txt_NhanVien.setFont(font);
		txt_NhanVien.setText("Nhân viên");
		txt_NhanVien.setBounds(10, 0, 150, 100);
		
		txt_TongNhanVien.setFont(fontTong);
		txt_TongNhanVien.setBounds(20, 20, 230, 120);
		
		txt_ThanhVien.setFont(font);
		txt_ThanhVien.setText("Thành viên");
		txt_ThanhVien.setBounds(10, 0, 150, 100);
		
		txt_TongThanhVien.setFont(fontTong);
		txt_TongThanhVien.setBounds(20, 20, 230, 120);
		
		
		
		pn_DoanhThu.add(txt_DoanhThu);
		pn_DoanhThu.add(txt_TongDoanhThu);
		pn_ThanhVien.add(txt_ThanhVien);
		pn_ThanhVien.add(txt_TongThanhVien);
		pn_Sach.add(txt_Sach);
		pn_Sach.add(txt_TongSach);
		pn_NhanVien.add(txt_NhanVien);
		pn_NhanVien.add(txt_TongNhanVien);
		this.add(txt_TieuDe);
		this.add(txt_ThongKeTheoQuy);
	}
	public void thietLapImage() {
		image_DoanhThu.setBounds(110, 5, 128, 128);
		image_DoanhThu.setIcon(new ImageIcon("image//Image_ThongKe//Image_DoanhThu.png"));
		pn_DoanhThu.add(image_DoanhThu);
	}
	public void thietLapPn() {
		pn_DoanhThu.setBounds(262, 300, 230, 140);
		pn_DoanhThu.setBackground(Color.green);
		
		pn_Sach.setBounds(262, 100, 230, 140);
		pn_Sach.setBackground(Color.yellow);
		
		pn_NhanVien.setBounds(10, 200, 230, 140);
		pn_NhanVien.setBackground(Color.MAGENTA);
		
		pn_ThanhVien.setBounds(514, 200, 230, 140);
		pn_ThanhVien.setBackground(Color.blue);
		
		
		this.add(pn_DoanhThu);
		this.add(pn_Sach);
		this.add(pn_NhanVien);
		this.add(pn_ThanhVien);
	}
	public void thietLapBtn() {
		btn_ThongTinChiTiet.setBounds(10, 10, 30, 30);
		btn_ThongTinChiTiet.setIcon(new ImageIcon("image//Image_ThongKe//Chitiet.png"));
		this.add(btn_ThongTinChiTiet);
	}
	public void thietLapCbb() {
		listDate.setBounds(320, 255, 120, 30);	
	}
	public void thietLapBang() {
		String col[] = {"Quý","Quý 1","Quý 2","Quý 3","Quý 4"};
		Vector<String> vt = new Vector<String>();
		vt.add("Doanh Thu");
		vt.add("");
		vt.add("");
		vt.add("");
		vt.add("");
		DefaultTableModel model = new DefaultTableModel(col,0);
		model.setColumnIdentifiers(col);
		tb_BangDoanhThu.setModel(model);
		tb_BangDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(30);
		tb_BangDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(20);
		tb_BangDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(20);
		tb_BangDoanhThu.getColumnModel().getColumn(3).setPreferredWidth(20);
		tb_BangDoanhThu.getColumnModel().getColumn(4).setPreferredWidth(20);
		
		String col1[] = {"Tổng cộng",""};
		DefaultTableModel model1 = new DefaultTableModel(col1,0);
		model1.setColumnIdentifiers(col1);
		tb_TongDoanhThu.setModel(model1);
		tb_TongDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(30);
		tb_TongDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(455);
		
	}
	public void event() {
		eventBtnChiTiet();
		eventCBB();
	}
	
	public void eventBtnChiTiet() {
		btn_ThongTinChiTiet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventBtnSP();
				
			}
		});
	}
	public void eventBtnSP() {
		this.setVisible(false);
		pn_Manager_ThongKe.pn_ChiTietThongKe.thongKeChiTiet(listDate.getItemAt(listDate.getSelectedIndex()));
		pn_Manager_ThongKe.pn_ChiTietThongKe.setVisible(true);
		thietLapBang();
	}
	public void ThongKe() {
		String sizeBook = menuManager.bookBUS.returnArrbook().size()+"";
		String sizeEmployee = menuManager.emBUS.returnArr().size()+"";
		String sizeCustomer = ""+(menuManager.customerBUS.returnArr().size()-1);
		String year = listDate.getItemAt(listDate.getSelectedIndex());
		String sumPrice = menuManager.billBUS.sumPriceYear(year)+"";
		
		txt_TongDoanhThu.setText(sumPrice);
		txt_TongNhanVien.setText(sizeEmployee);
		txt_TongSach.setText(sizeBook);
		txt_TongThanhVien.setText(sizeCustomer);
		thongKeTheoQuy();
	}
	public void eventCBB() {
		listDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				change();
				thongKeTheoQuy();
			}
		});
	}
	public void change() {
		this.year = listDate.getItemAt(listDate.getSelectedIndex())+"";
		String sizeBook = menuManager.bookBUS.returnArrbook().size()+"";
		String sizeEmployee = menuManager.emBUS.returnArr().size()+"";
		String sizeCustomer = ""+(menuManager.customerBUS.returnArr().size()-1);
		String sumPrice = menuManager.billBUS.sumPriceYear(this.year)+"";
		
		txt_TongDoanhThu.setText(sumPrice);
		txt_TongNhanVien.setText(sizeEmployee);
		txt_TongSach.setText(sizeBook);
		txt_TongThanhVien.setText(sizeCustomer);
	}
	public void thongKeTheoQuy() {
		String sumOne = menuManager.billBUS.sumQuiOne(year)+"";
		String sumTrue = menuManager.billBUS.sumQuiTrue(year)+"";
		String sumThree = menuManager.billBUS.sumQuiThree(year)+"";
		String sumFour = menuManager.billBUS.sumQuiFour(year)+"";
		
		String col[] = {"Quý","Quý 1","Quý 2","Quý 3","Quý 4"};
		DefaultTableModel model = new DefaultTableModel(col,0);
		model.setColumnIdentifiers(col);
		
		Vector<String> vt = new Vector<String>();
		vt.add("Doanh Thu");
		vt.add(sumOne);
		vt.add(sumTrue);
		vt.add(sumThree);
		vt.add(sumFour);
		model.addRow(vt);
		
		tb_BangDoanhThu.setModel(model);
		tb_BangDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(30);
		tb_BangDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(20);
		tb_BangDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(20);
		tb_BangDoanhThu.getColumnModel().getColumn(3).setPreferredWidth(20);
		tb_BangDoanhThu.getColumnModel().getColumn(4).setPreferredWidth(20);
		
		String col1[] = {"Tổng cộng",txt_TongDoanhThu.getText()};
		DefaultTableModel model1 = new DefaultTableModel(col1,0);
		model1.setColumnIdentifiers(col1);
		tb_TongDoanhThu.setModel(model1);
		tb_TongDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(30);
		tb_TongDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(455);
	}
}
