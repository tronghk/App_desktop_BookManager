package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class pn_Manager_SanPham extends JPanel {
	public pn_Manager_SanPham() {
		this.setLayout(null);
		this.setBounds(230, 0,770, 800);
		GiaoDien();
		openbtn(btn_SanPham);
		pn_LoaiSP.setVisible(false);
		pn_NXB.setVisible(false);
		
		event();
	}
	private JButton btn_SanPham;
	private JButton btn_LoaiSanPham;
	private JButton btn_NhaXuatBan;
	private pn_SanPham pn_SanPham;
	private pn_LoaiSanPham pn_LoaiSP;
	private pn_NhaXuatBan pn_NXB;
	
	ArrayList<JButton> arrbtn = new ArrayList<JButton>();
	
	public void restart() {
		btn_LoaiSanPham.setBackground(Color.LIGHT_GRAY);
		btn_NhaXuatBan.setBackground(Color.LIGHT_GRAY);
		openbtn(btn_SanPham);
		this.pn_LoaiSP.setVisible(false);
		this.pn_NXB.setVisible(false);
		this.pn_SanPham.restartBangSp();
		this.pn_NXB.restart();
		this.pn_LoaiSP.restart();
		this.pn_SanPham.setVisible(true);
		this.pn_SanPham.resertError();
		
	}
	public void GiaoDien() {
		Font font = new Font("Arial", Font.BOLD, 10);
		btn_SanPham = new JButton();
		btn_LoaiSanPham = new JButton();
		btn_NhaXuatBan = new JButton();
		pn_SanPham = new pn_SanPham();
		pn_LoaiSP = new pn_LoaiSanPham();
		pn_NXB = new pn_NhaXuatBan();
		
		btn_SanPham.setText("Sản phẩm");
		btn_SanPham.setFont(font);
		btn_SanPham.setBackground(Color.lightGray);
		btn_SanPham.setFocusable(false);
		btn_SanPham.setBorder(null);
		btn_SanPham.setBounds(0, 0, 90, 20);
		
		btn_LoaiSanPham.setText("Loại SP");
		btn_LoaiSanPham.setFont(font);
		btn_LoaiSanPham.setBackground(Color.lightGray);
		btn_LoaiSanPham.setFocusable(false);
		btn_LoaiSanPham.setBorder(null);
		btn_LoaiSanPham.setBounds(91, 0, 90, 20);
		
		btn_NhaXuatBan.setText("Nhà XB");
		btn_NhaXuatBan.setFont(font);
		btn_NhaXuatBan.setBackground(Color.lightGray);
		btn_NhaXuatBan.setFocusable(false);
		btn_NhaXuatBan.setBorder(null);
		btn_NhaXuatBan.setBounds(182, 0, 90, 20);
		
		this.add(btn_SanPham);
		this.add(btn_LoaiSanPham);
		this.add(btn_NhaXuatBan);
		
		this.add(pn_SanPham);
		this.add(pn_LoaiSP);
		this.add(pn_NXB);
	}
	public void addArrBtn() {
		arrbtn.add(btn_SanPham);
		arrbtn.add(btn_LoaiSanPham);
		arrbtn.add(btn_NhaXuatBan);
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
		eventBtnNhaXB();
	}
	
	public void eventBtnSp() {
		btn_SanPham.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openbtn(btn_SanPham);
				btn_LoaiSanPham.setBackground(Color.LIGHT_GRAY);
				btn_NhaXuatBan.setBackground(Color.LIGHT_GRAY);
				pn_NXB.setVisible(false);
				pn_LoaiSP.setVisible(false);
				pn_SanPham.setVisible(true);
				pn_SanPham.restart();
				
				
			}
		});
	}
		public void eventBtnLoaiSP() {
			btn_LoaiSanPham.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					openbtn(btn_LoaiSanPham);
					btn_SanPham.setBackground(Color.LIGHT_GRAY);
					btn_NhaXuatBan.setBackground(Color.LIGHT_GRAY);
					pn_NXB.setVisible(false);
					pn_LoaiSP.setVisible(true);
					pn_SanPham.setVisible(false);
				}
			});
			
		}
			public void eventBtnNhaXB() {
				btn_NhaXuatBan.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						openbtn(btn_NhaXuatBan);
						btn_SanPham.setBackground(Color.LIGHT_GRAY);
						btn_LoaiSanPham.setBackground(Color.LIGHT_GRAY);
						pn_NXB.setVisible(true);
						pn_LoaiSP.setVisible(false);
						pn_SanPham.setVisible(false);
						
					}
				});
	}
	
}
