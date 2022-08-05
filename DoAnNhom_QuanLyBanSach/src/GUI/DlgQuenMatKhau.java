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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BUS.userBUS;


public class DlgQuenMatKhau extends JDialog {

	public DlgQuenMatKhau() {
		userBUS = new userBUS();
		this.setSize(800,600);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		khungQuenMatKhau();
	}
	

	private JLabel txt_TieuDe;
	private JTextArea txt_HuongDan;
	private JTextField btn_NhapDiaChi;
	private JButton tf_GuiThu;
	private JLabel txt_QuayLai;
	private JPanel p_KhungQuenMatKhau;
	private JLabel txt_TenEmail;
	private JPanel p_thanhNhapEmail;
	private JLabel lblNewLabel;
	private userBUS userBUS;
	
	
	public void khungQuenMatKhau() {
		GiaoDienQuenMatKhau();
		event();
	}
	public void GiaoDienQuenMatKhau() {

		//khởi tạo
		txt_TieuDe = new JLabel();
		txt_HuongDan = new JTextArea();
		btn_NhapDiaChi = new JTextField();
		tf_GuiThu = new myButton();
		txt_QuayLai = new JLabel();
		p_KhungQuenMatKhau = new myPanel();
		txt_TenEmail = new JLabel();
		p_thanhNhapEmail = new JPanel();
		lblNewLabel = new JLabel();
		
		// thiết lập
		p_KhungQuenMatKhau.setLayout(null);
		p_KhungQuenMatKhau.setBounds(180,70,400,400);
		p_KhungQuenMatKhau.setBackground(Color.DARK_GRAY);
		
		
		txt_TieuDe.setText("Khôi phục tài khoản");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setForeground(Color.DARK_GRAY);
		txt_TieuDe.setBounds(80, 0, 400, 100);
		txt_TieuDe.setForeground(Color.white);
		
		txt_HuongDan.setText("Vui lòng nhập địa chỉ email của bạn để chúng tôi tiến hành gửi mã xác thực tài khoản");
		txt_HuongDan.setFont(new Font("Arial", Font.BOLD, 15));
		txt_HuongDan.setBackground(Color.DARK_GRAY);
		txt_HuongDan.setForeground(Color.white);
		txt_HuongDan.setBounds(35,90,337,50);
		txt_HuongDan.setEditable(false);
		txt_HuongDan.setLineWrap(true);
		
		txt_TenEmail.setText("Nhập email");
		txt_TenEmail.setBounds(40, 110, 360, 100);
		txt_TenEmail.setFont(new Font("Arial", Font.BOLD, 15));
		txt_TenEmail.setForeground(Color.CYAN);
		
		btn_NhapDiaChi.setBounds(40, 170, 320, 30);
		btn_NhapDiaChi.setBackground(Color.DARK_GRAY);
		btn_NhapDiaChi.setBorder(null);
		btn_NhapDiaChi.setFont(new Font("Arial", Font.BOLD, 13));
		btn_NhapDiaChi.setForeground(Color.white);
		
		p_thanhNhapEmail.setBounds(40, 200, 320, 1);
		
		tf_GuiThu.setText("Gửi mã xác nhận");
		tf_GuiThu.setFont(new Font("Arial", Font.BOLD, 13));
		tf_GuiThu.setBounds(210, 210, 150, 30);
		tf_GuiThu.setBackground(Color.green);
		tf_GuiThu.setForeground(Color.black);
		
		txt_QuayLai.setText("Quay lại đăng nhập");
		txt_QuayLai.setFont(new Font("Arial", Font.BOLD, 15));
		txt_QuayLai.setBounds(130, 250, 180, 30);
		txt_QuayLai.setForeground(Color.magenta);
		txt_QuayLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		p_KhungQuenMatKhau.add(txt_TieuDe);
		p_KhungQuenMatKhau.add(txt_HuongDan);
		p_KhungQuenMatKhau.add(btn_NhapDiaChi);
		p_KhungQuenMatKhau.add(txt_TenEmail);
		p_KhungQuenMatKhau.add(p_thanhNhapEmail);
		p_KhungQuenMatKhau.add(tf_GuiThu);
		p_KhungQuenMatKhau.add(txt_QuayLai);
		
		
		lblNewLabel.setBounds(0, 0, 800, 600);
		lblNewLabel.setIcon(new ImageIcon("image\\CoGai.gif"));
		
		this.add(p_KhungQuenMatKhau);
		this.add(lblNewLabel);
		
	}
	
	
	public void event() {
		QuayLaiGiaoDienDangNhap();
		guiMaXacNhan();
	}
	// chuyên form mã xác nhận
	public void guiMaXacNhan() {
		
		tf_GuiThu.addMouseListener(new MouseListener() {
			
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
				String email = btn_NhapDiaChi.getText();
				eventBtnSendMail(email);
			}
		});
	}
	
	public void QuayLaiGiaoDienDangNhap() {
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
				
				new FormLogin().setVisible(true);
				setVisible(false);
				
			}
		});
	}
	
	// sự kiện đối với email
	public void eventBtnSendMail(String mail) {
		String result = userBUS.forgotPassword(mail);
		switch (result) {
			case "Success": {
				DlgMaXacNhan dlgMaXacNhan = new DlgMaXacNhan();
				setVisible(false);
				dlgMaXacNhan.setVisible(true);
				
				break;
			}
			case "Error gmail":{
				myNotifycation.notifycation("Địa chỉ mail không phù hợp trong hệ thống tài khoản");
				break;
			}
		}
	}


}
