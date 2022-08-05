package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import BUS.couponBUS;
import BUS.detailCouponBUS;
import BUS.employeeBUS;

public class pn_Manager_BanHang extends JPanel {
	public pn_Manager_BanHang() {
		this.setLayout(null);
		this.setBounds(230, 0,770, 800);
		GiaoDien();
		openbtn(btn_BanHang);
		pn_HoaDon.setVisible(false);
		pn_ThanhToan.setVisible(false);
		event();
	}
	private JButton btn_BanHang;
	private JButton btn_HoaDon;
	static pn_BanHang pn_BanHang;
	static pn_HoaDon pn_HoaDon;
	static pn_ThanhToan pn_ThanhToan;
	ArrayList<JButton> arrbtn = new ArrayList<JButton>();
	
	
	public void GiaoDien() {
		Font font = new Font("Arial", Font.BOLD, 10);
		btn_BanHang = new JButton();
		btn_HoaDon = new JButton();
		pn_BanHang = new pn_BanHang();
		pn_HoaDon = new pn_HoaDon();
		pn_ThanhToan = new pn_ThanhToan();

		
		btn_BanHang.setText("Bán hàng");
		btn_BanHang.setFont(font);
		btn_BanHang.setBackground(Color.lightGray);
		btn_BanHang.setFocusable(false);
		btn_BanHang.setBorder(null);
		btn_BanHang.setBounds(0, 0, 90, 20);
		
		btn_HoaDon.setText("Hóa đơn");
		btn_HoaDon.setFont(font);
		btn_HoaDon.setBackground(Color.lightGray);
		btn_HoaDon.setFocusable(false);
		btn_HoaDon.setBorder(null);
		btn_HoaDon.setBounds(91, 0, 90, 20);
			
		this.add(btn_BanHang);
		this.add(btn_HoaDon);
		this.add(pn_BanHang);
		this.add(pn_HoaDon);
		this.add(pn_ThanhToan);
	}
	public void addArrBtn() {
		arrbtn.add(btn_BanHang);
		arrbtn.add(btn_HoaDon);
	}
	public void openbtn(JButton btn) {
		for(JButton value: arrbtn) {
			if(!value.equals(btn))
			value.setBackground(Color.lightGray);
		}
		btn.setBackground(Color.orange);
	}
	public void event() {
		eventBtnLoaiSP();
		eventBtnSp();
	}
	
	public void eventBtnSp() {
		btn_BanHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openbtn(btn_BanHang);
				btn_HoaDon.setBackground(Color.LIGHT_GRAY);
				pn_HoaDon.setVisible(false);
				pn_BanHang.setVisible(true);
			}
		});
	}
		public void eventBtnLoaiSP() {
			btn_HoaDon.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!pn_BanHang.checkSave()) {
					pn_HoaDon.restart();
					openbtn(btn_HoaDon);
					btn_BanHang.setBackground(Color.LIGHT_GRAY);
					pn_HoaDon.setVisible(true);
					pn_BanHang.setVisible(false);
					}
				}
			});
			
		}
		public void restart() {
			btn_BanHang.setBackground(Color.orange);
			btn_HoaDon.setBackground(Color.gray);
			pn_BanHang.reastart();
			pn_ThanhToan.restart();
			pn_HoaDon.restart();
		}
}
