package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.ref.Reference;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BUS.userBUS;
import DTO.user;

import javax.swing.ImageIcon;


public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tf_DangNhap;
	private JPasswordField tf_MatKhau;
	private JLabel txt_DangNhap;
	private JLabel txt_MatKhau;
	private JLabel txt_TieuDe;
	private JButton btn_DangNhap;
	private JLabel txt_QuenMatKhau;
	private JPanel p_khungDangNhap;
	private JPanel txtThanhTF_DangNhap;
	private JPanel txtThanhTF_MatKhau;
	private JLabel txt_LuuTaiKhoan;
	private JCheckBox cb_LuaChonLuu;
	private JLabel lblNewLabel;
	private JLabel iconViewPass;
	
	private userBUS userBUS;
	static myNotifycation notifycation;
	
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		this.setTitle("QUẢN LÝ BÁN SÁCH");
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		userBUS = new userBUS();
		khungDangNhap();
		event();
		userSave();
	}
	public void khungDangNhap() {
		//khởi tạo
				txt_TieuDe = new JLabel();
				txt_DangNhap = new JLabel();
				txt_MatKhau = new JLabel();
				btn_DangNhap = new myButton();
				p_khungDangNhap = new myPanel();
				tf_DangNhap = new JTextField(50);
				tf_MatKhau = new JPasswordField(50);
				txt_LuuTaiKhoan = new JLabel();
				cb_LuaChonLuu = new JCheckBox();
				txt_QuenMatKhau = new JLabel();
				iconViewPass = new JLabel();
		//cài đặt thông số
				
				p_khungDangNhap.setLayout(null);
				p_khungDangNhap.setBounds(180,70,400,400);
				p_khungDangNhap.setBackground(Color.DARK_GRAY);
				
				
				txt_TieuDe.setText("Đăng nhập");
				txt_TieuDe.setBounds(125,0, 400,100);
				txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 30));
				txt_TieuDe.setForeground(Color.white);
				
				
				txt_DangNhap.setText("Tên đăng nhập");
				txt_DangNhap.setBounds(40, 60, 360, 100);
				txt_DangNhap.setFont(new Font("Arial", Font.BOLD, 20));
				txt_DangNhap.setForeground(Color.cyan);
				
				
				tf_DangNhap.setBounds(40, 128, 300, 20);
				tf_DangNhap.setBackground(Color.DARK_GRAY);
				tf_DangNhap.setForeground(Color.LIGHT_GRAY);
				tf_DangNhap.setFont(new Font("Arial", Font.BOLD, 13));
				tf_DangNhap.setBorder(null);
				
				txtThanhTF_DangNhap = new JPanel();
				txtThanhTF_DangNhap.setBounds(40, 149, 320, 1);
				txtThanhTF_DangNhap.setBackground(Color.white);
				
				
				txt_MatKhau.setText("Mật khẩu");
				txt_MatKhau.setBounds(40, 130, 360, 100);
				txt_MatKhau.setFont(new Font("Arial", Font.BOLD, 20));
				txt_MatKhau.setForeground(Color.cyan);
				
				
				tf_MatKhau.setBounds(40, 200, 300, 20);
				tf_MatKhau.setBackground(Color.DARK_GRAY);
				tf_MatKhau.setForeground(Color.LIGHT_GRAY);
				tf_MatKhau.setFont(new Font("Arial", Font.BOLD, 13));
				tf_MatKhau.setEchoChar('*');
				tf_MatKhau.setLayout(null);
				tf_MatKhau.setBorder(null);
				
				txtThanhTF_MatKhau = new JPanel();
				txtThanhTF_MatKhau.setBounds(40, 220, 320, 1);
				txtThanhTF_MatKhau.setBackground(Color.white);
				
				
				txt_LuuTaiKhoan.setText("Lưu đăng nhập");
				txt_LuuTaiKhoan.setBounds(60, 230 , 120, 20);
				txt_LuuTaiKhoan.setFont(new Font("Arial", Font.BOLD, 13));
				txt_LuuTaiKhoan.setForeground(Color.cyan);
				
				
				cb_LuaChonLuu.setBounds(40, 230, 20, 20);
				cb_LuaChonLuu.setBorder(null);
				cb_LuaChonLuu.setBackground(Color.DARK_GRAY);
				
				txt_QuenMatKhau.setText("Quên mật khẩu ?");
				txt_QuenMatKhau.setBounds(260, 230 , 150, 20);
				txt_QuenMatKhau.setFont(new Font("Arial", Font.BOLD, 13));
				txt_QuenMatKhau.setForeground(Color.cyan);
				
				btn_DangNhap.setText("Đăng nhập");
				btn_DangNhap.setBackground(Color.ORANGE);
				btn_DangNhap.setFocusable(false);
				btn_DangNhap.setBounds(30,300, 340,45);
				btn_DangNhap.setFont(new Font("Arial", Font.BOLD, 25));
				btn_DangNhap.setForeground(Color.white);
				
				iconViewPass.setIcon(new ImageIcon("image\\eyePass.png"));
				iconViewPass.setBackground(Color.red);
				iconViewPass.setForeground(Color.green);
				iconViewPass.setBounds(340, 200, 30, 15);
				
				
				p_khungDangNhap.add(txt_TieuDe);
				p_khungDangNhap.add(txt_MatKhau);
				p_khungDangNhap.add(txt_DangNhap);
				p_khungDangNhap.add(tf_DangNhap);
				p_khungDangNhap.add(txtThanhTF_DangNhap);
				p_khungDangNhap.add(tf_MatKhau);
				p_khungDangNhap.add(txtThanhTF_MatKhau);
				p_khungDangNhap.add(txt_LuuTaiKhoan);
				p_khungDangNhap.add(cb_LuaChonLuu);
				p_khungDangNhap.add(txt_QuenMatKhau);
				p_khungDangNhap.add(btn_DangNhap);
				p_khungDangNhap.add(iconViewPass);
				
				getContentPane().add(p_khungDangNhap);
				
				lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon("image//CoGai.gif"));
				lblNewLabel.setBounds(0, 0, 800, 600);
				
				contentPane.add(lblNewLabel);
				
				
	}
	public void eventbtn() {
		/*goi TextField  phần nhập n là tf1
		 * TextField phần nhập x lả tf2
		 * Button tinh là btnTinh
		 * TextField phần kết quả là tf_KetQua
		 
			*/	
		btn_DangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eventTinh();
				
			}
		});
	}
	public void eventTinh() {
		try {
		int n = Integer.parseInt(tf_DangNhap.getText()+"");
		System.out.println(n);
		int x = Integer.parseInt(tf_MatKhau.getText()+"");
		double s = tinh(n,x);
		tf_DangNhap.setText(""+s);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public double tinh(int n, int x) {
		double sum = 0;
		for(int i = 0;i<=n;i++) {
			sum = sum + Math.pow(x, i);
		}
		return sum;
	}
	
	public void event() {
		eventForgotPassword();
		eventLogin();
		eyePassEvent();
	}
	public void eventForgotPassword() {
		txt_QuenMatKhau.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				txt_QuenMatKhau.setForeground(Color.cyan);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				txt_QuenMatKhau.setForeground(Color.white);
				
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
				
			}
		});
	}
	public void eventLogin() {
		btn_DangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String txtEmail =""+ tf_DangNhap.getText();
				String txtPass =""+ tf_MatKhau.getText();
				
				boolean checkTextBox = cb_LuaChonLuu.isSelected();
				eventLogin(txtEmail, txtPass,checkTextBox);
			}
		});
	}
	public void eyePassEvent() {
		iconViewPass.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				iconViewPass.setForeground(Color.black);
				tf_MatKhau.setEchoChar('*');
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				iconViewPass.setForeground(Color.white);
				tf_MatKhau.setEchoChar((char)0);
				
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
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void eventLogin(String txtEmail, String txtPass, boolean check) {
		String massage = userBUS.checkLogin(txtEmail, txtPass, check);
		switch (massage) {
			case "Success": {
				notifycation.loginSuccess();
				
				new menuManager().setVisible(true);
				
				setVisible(false);
				break;
			}
			case "Locked account": {
				notifycation.NotifycationLockedAccount();
				break;
			}
			case "Error user": {
				notifycation.FailUser();
				break;
			}
			
		}
		
	}
	public void userSave() {
		if(userBUS.checkUserSave())
		{
			user us = userBUS.returnUser();
			if(us != null)
			{
				tf_DangNhap.setText(us.getUsers());
				tf_MatKhau.setText(us.getPassword());
				cb_LuaChonLuu.setSelected(true);
			}
		}
		
	}
}
