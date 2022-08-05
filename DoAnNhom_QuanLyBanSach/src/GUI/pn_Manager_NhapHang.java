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

public class pn_Manager_NhapHang extends JPanel {
	public pn_Manager_NhapHang() {
		this.setLayout(null);
		this.setBounds(230, 0,770, 800);
		GiaoDien();
		openbtn(btn_PhieuNhapHang);
		pn_NhaCungCap.setVisible(false);
		pn_CTPNH.setVisible(false);
		
		event();
	}
	private JButton btn_PhieuNhapHang;
	private JButton btn_NhaCungCap;
	static pn_PhieuNhapHang pn_PhieuNhapHang;
	static pn_NhaCungCap pn_NhaCungCap;
	static pn_TaoPhieuNhapHang pn_CTPNH;
	ArrayList<JButton> arrbtn = new ArrayList<JButton>();
	
	
	public void GiaoDien() {
		Font font = new Font("Arial", Font.BOLD, 10);
		btn_PhieuNhapHang = new JButton();
		btn_NhaCungCap = new JButton();
		pn_PhieuNhapHang = new pn_PhieuNhapHang();
		pn_NhaCungCap = new pn_NhaCungCap();
		pn_CTPNH = new pn_TaoPhieuNhapHang();

		
		btn_PhieuNhapHang.setText("Phiếu nhập hàng");
		btn_PhieuNhapHang.setFont(font);
		btn_PhieuNhapHang.setBackground(Color.lightGray);
		btn_PhieuNhapHang.setFocusable(false);
		btn_PhieuNhapHang.setBorder(null);
		btn_PhieuNhapHang.setBounds(0, 0, 90, 20);
		
		btn_NhaCungCap.setText("Nhà cung ứng");
		btn_NhaCungCap.setFont(font);
		btn_NhaCungCap.setBackground(Color.lightGray);
		btn_NhaCungCap.setFocusable(false);
		btn_NhaCungCap.setBorder(null);
		btn_NhaCungCap.setBounds(91, 0, 90, 20);
			
		this.add(btn_PhieuNhapHang);
		this.add(btn_NhaCungCap);

		
		this.add(pn_PhieuNhapHang);
		this.add(pn_NhaCungCap);
		this.add(pn_CTPNH);
	}
	public void restart() {
		this.pn_CTPNH.setVisible(false);
		this.pn_NhaCungCap.setVisible(false);
		this.openbtn(btn_PhieuNhapHang);
		this.btn_NhaCungCap.setBackground(Color.LIGHT_GRAY);
		this.pn_NhaCungCap.restart();
		this.pn_PhieuNhapHang.restart();
		this.pn_PhieuNhapHang.setVisible(true);
	}
	public void addArrBtn() {
		arrbtn.add(btn_PhieuNhapHang);
		arrbtn.add(btn_NhaCungCap);
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
		btn_PhieuNhapHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openbtn(btn_PhieuNhapHang);
				btn_NhaCungCap.setBackground(Color.LIGHT_GRAY);
				pn_PhieuNhapHang.restartThongBao();
				pn_NhaCungCap.setVisible(false);
				pn_PhieuNhapHang.setVisible(true);
			}
		});
	}
		public void eventBtnLoaiSP() {
			btn_NhaCungCap.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					openbtn(btn_NhaCungCap);
					btn_PhieuNhapHang.setBackground(Color.LIGHT_GRAY);
					pn_NhaCungCap.setVisible(true);
					pn_PhieuNhapHang.setVisible(false);
					pn_CTPNH.setVisible(false);
				}
			});
			
		}
}
