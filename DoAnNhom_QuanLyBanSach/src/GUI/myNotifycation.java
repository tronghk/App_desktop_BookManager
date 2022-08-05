package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class myNotifycation {
	public static void errorNotifycation() {
		String message = "Thông báo lỗi";
		JOptionPane.showMessageDialog(new JFrame(), message, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void loginSuccess() {
		String message = "Đăng nhập thành công";
		JOptionPane.showConfirmDialog(new JFrame(), message, "Thông báo", JOptionPane.DEFAULT_OPTION);
	}
	public static void NotifycationLockedAccount() {
		String message = "Tài khoản của bạn đã bị khóa vui lòng liên hệ admin để mở khóa hoặc đăng nhập tài khoản khác";
		JOptionPane.showConfirmDialog(new JFrame(), message, "Thông báo lỗi", JOptionPane.DEFAULT_OPTION);
	}
	public static void FailUser() {
		String message = "Tài khoản hoặc mật khẩu không chính xác ";
		JOptionPane.showConfirmDialog(new JFrame(), message, "Thông báo lỗi", JOptionPane.DEFAULT_OPTION);
	}
	public static void notifycation(String message) {
		
		JOptionPane.showConfirmDialog(new JFrame(), message, "Thông báo", JOptionPane.DEFAULT_OPTION);
	}

	
	
}
