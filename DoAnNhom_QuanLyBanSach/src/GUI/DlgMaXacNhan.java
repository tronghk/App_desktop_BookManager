package GUI;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import BUS.userBUS;


public class DlgMaXacNhan extends JDialog {
	public DlgMaXacNhan() {
		userBUS = new userBUS();
		this.setSize(800,600);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Dgl_MaXacNhan();	
		setVisible(true);
		event();
		
		
		
	}
	private JLabel txt_TieuDe;
	private JLabel txt_NhapMaXacThuc;
	private JTextField tf_NhapMaXacThuc;
	private JLabel txt_GuiLaiMa;
	private JButton btn_XacNhan;
	private JPanel p_KhungXacThuc;
	private JPanel p_thanhNhapEmail;
	private JLabel txt_timeOut;
	private JLabel lblNewLabel;
	static int i = 60;
	private JLabel txt_QuayLai;
	Timer timer;
	
	private userBUS userBUS;
	public void Dgl_MaXacNhan() {
		
		// khởi tạo
		p_KhungXacThuc = new JPanel();
		txt_TieuDe = new JLabel();
		txt_NhapMaXacThuc = new JLabel();
		tf_NhapMaXacThuc = new JTextField(6);
		p_thanhNhapEmail = new JPanel();
		btn_XacNhan = new JButton();
		txt_GuiLaiMa = new JLabel();
		txt_timeOut = new JLabel();
		txt_QuayLai = new JLabel();
		
		//thiết lập
		p_KhungXacThuc.setLayout(null);
		p_KhungXacThuc.setBounds(180,70,400,400);
		p_KhungXacThuc.setBackground(Color.DARK_GRAY);
		
		txt_TieuDe.setText("Xác thực email");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setForeground(Color.DARK_GRAY);
		txt_TieuDe.setBounds(110, 50, 400, 100);
		txt_TieuDe.setForeground(Color.white);
		
		txt_NhapMaXacThuc.setText("Nhập mã xác thực");
		txt_NhapMaXacThuc.setBounds(40, 110, 360, 100);
		txt_NhapMaXacThuc.setFont(new Font("Arial", Font.BOLD, 15));
		txt_NhapMaXacThuc.setForeground(Color.CYAN);
		
		tf_NhapMaXacThuc.setBounds(40, 170, 320, 30);
		tf_NhapMaXacThuc.setBackground(Color.DARK_GRAY);
		tf_NhapMaXacThuc.setBorder(null);
		tf_NhapMaXacThuc.setFont(new Font("Arial", Font.BOLD, 13));
		tf_NhapMaXacThuc.setForeground(Color.white);
		
		p_thanhNhapEmail.setBounds(40, 200, 320, 1);
		
		btn_XacNhan.setText("Xác nhận");
		btn_XacNhan.setBackground(Color.ORANGE);
		btn_XacNhan.setBounds(30,270, 340,35);
		btn_XacNhan.setFont(new Font("Arial", Font.BOLD, 20));
		btn_XacNhan.setForeground(Color.white);
		
		txt_GuiLaiMa.setText("Bạn chưa nhận được mã?");
		txt_GuiLaiMa.setFont(new Font("Arial", Font.BOLD, 15));
		txt_GuiLaiMa.setBounds(60, 210, 250, 30);
		txt_GuiLaiMa.setForeground(Color.blue);
		txt_GuiLaiMa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btn_XacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image//CoGai.gif"));
		lblNewLabel.setBounds(0, 0, 800, 600);
		
		txt_timeOut.setText("Gửi lại mã " );
		txt_timeOut.setFont(new Font("Arial", Font.BOLD, 15));
		txt_timeOut.setBounds(260, 210, 100, 30);
		txt_timeOut.setForeground(Color.green);
		txt_timeOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		txt_QuayLai.setText("Quay lại");
		txt_QuayLai.setFont(new Font("Arial", Font.BOLD, 15));
		txt_QuayLai.setBounds(30, 320, 340, 35);
		txt_QuayLai.setForeground(Color.magenta);
		txt_QuayLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		p_KhungXacThuc.add(txt_TieuDe);
		p_KhungXacThuc.add(txt_NhapMaXacThuc);
		p_KhungXacThuc.add(tf_NhapMaXacThuc);
		p_KhungXacThuc.add(p_thanhNhapEmail);
		p_KhungXacThuc.add(btn_XacNhan);
		p_KhungXacThuc.add(txt_GuiLaiMa);
		p_KhungXacThuc.add(txt_timeOut);
		p_KhungXacThuc.add(txt_QuayLai);
		
		
		this.add(p_KhungXacThuc);
		this.add(lblNewLabel);
		
	}
	
	public void event() {
		threadTime(); //chờ đợi 
		back();		// quay lại form trước
		eventComfirm();  // chấp nhập event
		eventRepeatCode(); // 
	}
	
	public void threadTime() {
		
		txt_timeOut.setEnabled(false);
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt_timeOut.setText("Gửi lại mã " + i);
				i = i-1;
				if(i<0) {
					txt_timeOut.setEnabled(true);
					txt_timeOut.setText("Gửi lại mã");
					timer.stop();
				}
			}
		});
		timer.start();
	}
	public void back() {
		txt_QuayLai.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				txt_QuayLai.setForeground(Color.magenta);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				txt_QuayLai.setForeground(Color.white);
				
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
				setVisible(false);
				new DlgQuenMatKhau().setVisible(true);
				timer.stop();
				
			}
		});
	}
	public void eventComfirm() {
		btn_XacNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text =""+ tf_NhapMaXacThuc.getText();
				eventComfirm(text);
				
			}
		});
	}
	
	public void eventComfirm(String text) {
		if(userBUS.checkComfirm(text)) {
			
		}
		else {
			myNotifycation.notifycation("Mã xác nhận không hợp lệ");
		}
		
	}
	public void eventRepeatCode() {
		txt_GuiLaiMa.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				txt_GuiLaiMa.setForeground(Color.red);
				
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				String text =""+ tf_NhapMaXacThuc.getText();
				eventComfirm();
			}
		});
	}

}
