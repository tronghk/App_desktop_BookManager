package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import BUS.employeeBUS;

public class pn_Manager_NhanVien extends JPanel {
	public pn_Manager_NhanVien() {
		this.setLayout(null);
		this.setBounds(230, 0,770, 800);
		GiaoDien();
		openbtn(btn_QLNV);
		pn_PhanQuyen.setVisible(false);
		pn_TTNV.setVisible(false);
		
		event();
	}
	private JButton btn_QLNV;
	private JButton btn_PhanQuyen;
	static pn_NhanVien pn_NhanVien;
	static pn_PhanQuyenNV pn_PhanQuyen;
	static pn_ThongTinNV pn_TTNV;
	
	ArrayList<JButton> arrbtn = new ArrayList<JButton>();
	
	
	public void GiaoDien() {
		Font font = new Font("Arial", Font.BOLD, 10);
		btn_QLNV = new JButton();
		btn_PhanQuyen = new JButton();
		pn_NhanVien = new pn_NhanVien();
		pn_PhanQuyen = new pn_PhanQuyenNV();
		pn_TTNV = new pn_ThongTinNV();

		
		btn_QLNV.setText("QLNV");
		btn_QLNV.setFont(font);
		btn_QLNV.setBackground(Color.lightGray);
		btn_QLNV.setFocusable(false);
		btn_QLNV.setBorder(null);
		btn_QLNV.setBounds(0, 0, 90, 20);
		
		btn_PhanQuyen.setText("Phân quyền");
		btn_PhanQuyen.setFont(font);
		btn_PhanQuyen.setBackground(Color.lightGray);
		btn_PhanQuyen.setFocusable(false);
		btn_PhanQuyen.setBorder(null);
		btn_PhanQuyen.setBounds(91, 0, 90, 20);
			
		this.add(btn_QLNV);
		this.add(btn_PhanQuyen);

		
		this.add(pn_NhanVien);
		this.add(pn_PhanQuyen);
		this.add(pn_TTNV);
	}
	public void restart() {
		this.btn_PhanQuyen.setBackground(Color.LIGHT_GRAY);
		this.openbtn(btn_QLNV);
		pn_NhanVien.restart();
		this.pn_PhanQuyen.setVisible(false);
		this.pn_TTNV.setVisible(false);
		this.pn_NhanVien.restartBangNV();
		this.pn_NhanVien.setVisible(true);
	}
	public void addArrBtn() {
		arrbtn.add(btn_QLNV);
		arrbtn.add(btn_PhanQuyen);
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
		btn_QLNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openbtn(btn_QLNV);
				btn_PhanQuyen.setBackground(Color.LIGHT_GRAY);
				pn_PhanQuyen.setVisible(false);
				pn_NhanVien.setVisible(true);
			}
		});
	}
		public void eventBtnLoaiSP() {
			btn_PhanQuyen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					openbtn(btn_PhanQuyen);
					btn_QLNV.setBackground(Color.LIGHT_GRAY);
					pn_PhanQuyen.setVisible(true);
					pn_NhanVien.setVisible(false);
				}
			});
			
		}
}
