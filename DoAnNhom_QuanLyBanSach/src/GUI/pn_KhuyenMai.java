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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DTO.coupon;
import DTO.detailPromotion;
import DTO.promotion;

public class pn_KhuyenMai  extends JPanel{
	public pn_KhuyenMai() {
		 this.setLayout(null);
			this.setBounds(230, 0,770, 800);
			Border border = BorderFactory.createLineBorder(Color.black);
			setBorder(border);
			khoiTao();
			thietLap();
			event();
	}	
	private JLabel txt_TieuDe;
	private JLabel txt_CTKM;
	private JLabel txt_CTCTKMH;
	private JButton btn_Them;
	private JButton btn_TimKiem;
	private JButton btn_Xuat;
	private JTextField tf_TimKiem;
	private JTable tb_CTKM;
	private DefaultTableModel model_CTKM;
	private JTable tb_CTCTKM;
	private DefaultTableModel model_CTCTKM;
	private JScrollPane scrollCTKM;
	private JScrollPane scrollCTCTKM;
	private JLabel thongBao;
	
	public void khoiTao() {
		khoiTaoBang();
		txt_TieuDe = new JLabel();
		txt_CTKM = new JLabel();
		txt_CTCTKMH = new JLabel();
		btn_Them = new JButton();
		btn_TimKiem = new JButton();
		btn_Xuat = new JButton();
		tf_TimKiem = new JTextField();
		thongBao = new JLabel();
		
	}
	public void thietLap() {
		
		thietLapGiaoDien();
		thietLapBangCTKM();
		thietLapCTCTKM();
	}
	public void khoiTaoBang() {
		tb_CTKM = new myTable();
		tb_CTCTKM = new myTable();
		
		JTableHeader headerKM = tb_CTKM.getTableHeader();
		headerKM.setBackground(Color.pink);
		
		JTableHeader headerCTKM = tb_CTCTKM.getTableHeader();
		headerCTKM.setBackground(Color.pink);
		
		scrollCTKM = new JScrollPane(tb_CTKM);
		scrollCTKM.setBounds(0, 100, 620, 330);
		
		scrollCTCTKM = new JScrollPane(tb_CTCTKM);
		scrollCTCTKM.setBounds(0, 460, 757, 300);
		
		
		this.add(scrollCTCTKM);
		this.add(scrollCTKM);
	}
	public void thietLapGiaoDien() {
		Font font = new Font("Arial", Font.BOLD, 15);
		
		txt_TieuDe.setText("Chương trình khuyến mãi");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 10, 770, 30);
		
		txt_CTKM.setText("Danh sách CTKM");
		txt_CTKM.setFont(font);
		txt_CTKM.setHorizontalAlignment(JLabel.LEFT);
		txt_CTKM.setBounds(10, 75, 200, 22);
		
		tf_TimKiem.setBounds(300, 65, 200, 30);
		tf_TimKiem.setForeground(Color.black);
		tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
		
		btn_TimKiem.setText("Tìm kiếm");
		btn_TimKiem.setFocusable(false);
		btn_TimKiem.setIcon(new ImageIcon("image//image//timKiem.png"));
		btn_TimKiem.setBounds(500, 65, 110, 29);
		btn_TimKiem.setBackground(Color.lightGray);
		
		btn_Them.setText("Tạo CTKM");
		btn_Them.setFocusable(false);
		btn_Them.setIcon(new ImageIcon("image//image//TaoPNH.png"));
		btn_Them.setBounds(630, 120, 120, 29);
		btn_Them.setBackground(Color.lightGray);
		
		btn_Xuat.setText("Xuất CTKM");
		btn_Xuat.setFocusable(false);
		btn_Xuat.setIcon(new ImageIcon("image//image//XuatExcel.png"));
		btn_Xuat.setBounds(630, 160, 120, 29);
		btn_Xuat.setBackground(Color.lightGray);
		
		txt_CTCTKMH.setText("Chi tiết khuyến mãi");
		txt_CTCTKMH.setFont(font);
		txt_CTCTKMH.setBounds(10, 430, 250, 22);
		txt_CTCTKMH.setHorizontalAlignment(JLabel.LEFT);
		
		thongBao.setFont(font);
		thongBao.setBounds(300, 430, 350, 22);
		thongBao.setHorizontalAlignment(JLabel.LEFT);
		
		this.add(txt_TieuDe);
		this.add(txt_CTKM);
		this.add(tf_TimKiem);
		this.add(btn_TimKiem);
		this.add(btn_Them);
		this.add(btn_Xuat);
		this.add(txt_CTCTKMH);
		this.add(thongBao);
	}
	public void thietLapBangCTKM() {
		ArrayList<promotion> arrPromotion = menuManager.promotionBUS.returnArrPromotion();
		String col[] = {"Mã CTKM"," Tên CTKM", "Ngày bắt đầu","Ngày kết thúc"};
		model_CTKM = new DefaultTableModel(col, 0);
		model_CTKM.setColumnIdentifiers(col);
		for(promotion value: arrPromotion) {
			Vector vt = new Vector();
			vt.add(value.getIdPromotion());
			vt.add(value.getNamePromotion()+"");
			vt.add(value.getDateStart());
			vt.add(value.getDateEnd());
			model_CTKM.addRow(vt);
		}
		tb_CTKM.setModel(model_CTKM);
		
	}
	public void thietLapCTCTKM() {
		String col[] = {"Mã chương trình khuyến mãi","Mã sách khuyến mãi","% Chiết khấu"};
		model_CTCTKM = new DefaultTableModel(col, 0);
		model_CTCTKM.setColumnIdentifiers(col);
		tb_CTCTKM.setModel(model_CTCTKM);
	}
	public void event() {
		eventCTKM();
		eventTaoCTKM();
		eventTimKiem();
		eventXuatKhuyenMai();
		eventSearch();
	}
	public void eventCTKM() {
		tb_CTKM.addMouseListener(new MouseListener() {
			
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
				
				eventCTCTKM();
			}
		});
	}
	public void eventTaoCTKM() {
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelLeftGUI.pn_ChiTietKM.restart();
				PanelLeftGUI.pnKhuyenMai.setVisible(false);
				PanelLeftGUI.pn_ChiTietKM.setVisible(true);
				
			}
		});
	}
	public void eventCTCTKM() {
		int row = tb_CTKM.getSelectedRow();
		String id = model_CTKM.getValueAt(row, 0)+"";
		ArrayList<detailPromotion> arrDTPromotion = menuManager.DTPromotionBUS.returnArrDTPromotion();
		String col[] = {"Mã chương trình khuyến mãi","Mã sách khuyến mãi","% Chiết khấu"};
		model_CTCTKM = new DefaultTableModel(col, 0);
		model_CTCTKM.setColumnIdentifiers(col);
		
		for(detailPromotion value: arrDTPromotion) {
			
			if(value.getIdPromotion().compareTo(id) == 0) {
				Vector vt = new Vector();
			vt.add(value.getIdPromotion());
			vt.add(value.getIdBook());
			vt.add(value.getDiscount());
			model_CTCTKM.addRow(vt);
			}
			
		}
		tb_CTCTKM.setModel(model_CTCTKM);
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
		ArrayList<promotion> arr =  menuManager.promotionBUS.eventSearch(text);
		searchKM(arr);
	}
	public void searchKM(ArrayList<promotion> arrPromotion) {
		String col[] = {"Mã CTKM"," Tên CTKM", "Ngày bắt đầu","Ngày kết thúc"};
		model_CTKM = new DefaultTableModel(col, 0);
		model_CTKM.setColumnIdentifiers(col);
		for(promotion value: arrPromotion) {
			Vector vt = new Vector();
			vt.add(value.getIdPromotion());
			vt.add(value.getNamePromotion()+"");
			vt.add(value.getDateStart());
			vt.add(value.getDateEnd());
			model_CTKM.addRow(vt);
		}
		tb_CTKM.setModel(model_CTKM);
	}
	public void eventTimKiem() {
		btn_TimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			search();
				
			}
		});
	}
	public void eventXuatKhuyenMai() {
		btn_Xuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuatPhieuNhapHang();
				
			}
		});
	}
	public void xuatPhieuNhapHang() {
		try {
		int row = tb_CTKM.getSelectedRow();
		String id = model_CTKM.getValueAt(row, 0)+"";
		menuManager.DTPromotionBUS.eventXuatFileExcel(id);
		hienThiXuatPNH();
		}catch(Exception ex) {
			thongBao.setBackground(Color.red);
			thongBao.setText("Chưa chọn chương trình khuyến mãi");
		}
		
	}
	public void hienThiXuatPNH() {
			thongBao.setText("Đã xuất chương trình khuyến mãi");
	}
	public void restart() {
		thietLapBangCTKM();
		thietLapCTCTKM();
		tf_TimKiem.setText("");
		thongBao.setText("");
	}
}
