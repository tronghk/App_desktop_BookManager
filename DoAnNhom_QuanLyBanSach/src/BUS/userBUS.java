package BUS;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DTO.mail;
import DTO.user;
import DTO.userSave;
import DAO.userSaveDAO;
import DAO.usersDAO;

public class userBUS {
	static ArrayList<user> arrUser;
	private usersDAO userDAO;
	private userSaveDAO userSaveDAO;
	static user userLogin;
	private InetAddress inet;
	private userSave userSave;
	
	
	
	public userBUS() {
		arrUser = new ArrayList<user>();
		this.setUserDAO(new usersDAO());
		this.setUserSaveDAO(new userSaveDAO());
		arrUser = this.getUserDAO().readUser();
		readUserIpPc();
	}
	
	public userSave getUserSave() {
		return userSave;
	}

	public void setUserSave(userSave userSave) {
		this.userSave = userSave;
	}

	public userSaveDAO getUserSaveDAO() {
		return userSaveDAO;
	}

	public void setUserSaveDAO(userSaveDAO userSaveDAO) {
		this.userSaveDAO = userSaveDAO;
	}

	public usersDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(usersDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	// đọc tài khoản đã lưu từ máy chủ
	public void readUserIpPc() {
		ArrayList<userSave> arr = this.getUserSaveDAO().readUser();
		InetAddress inet;
		try {
			inet =   InetAddress.getLocalHost();
			for (userSave v: arr) {
				if(v.getIpPc().compareToIgnoreCase(""+inet) == 0)
					userSave = v;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//thêm tài khoản
	public String AddUser(String user, String password) {
		if(checkDuplicate(user))
			return "Error Duplicate";          //thông báo lỗi trùng lặp tên tài khoản
		else if (!checkGmail(user))				//thông báo mail không hợp lệ 
			return "Error Gmail";
		else if(checkEmptyPassword(password))
			return "Error Empty password";		// thông báo lỗi không nhập password
		else if(!checkPassswordInvalid(password))
			return "Error password invilid";	// thông báo lỗi password không hợp lệ
		else {
			user us = new user(user, password,"Hoạt động");
			userBUS.arrUser.add(us);
			this.getUserDAO().addUser(us);
			return "Success";
		}
	}
	
	//kiểm tra tài khoản gmail hợp lệ
	public boolean checkGmail(String user) {
		Pattern s = Pattern.compile("^[a-zA-Z][a-zA-Z0-9.]+@[a-zA-Z](.[a-zA-z]+){1,3}$");
		if(s.matcher(user).find())
			return true;
		return false;
	}
	
	//kiểm tra trùng lặp tài khoản
	public boolean checkDuplicate(String user) {
		for(user value: userBUS.arrUser) {
			if(value.getUsers().compareToIgnoreCase(user) == 0)
				return true;
		}
		return false;
	}
	
	//kiểm tra tài khoản có độ dài trên 3
	public boolean checkSize(String user) {
		return user.length() >= 3;
	}
	
	//kiểm tra mật khẩu rỗng
	public boolean checkEmptyPassword(String password) {
		return password.length() == 0;
	}
	
	//kiểm tra in hoa in thường kí tự chuỗi mật khẩu
	public boolean checkPassswordInvalid(String password) {
		if(myString.checkUpChar(password) && myString.checkLowChar(password)
				&& myString.checkSpecialChar(password))
			return true;
		return false;
	}
	
	//kiểm tra mật khẩu mới hợp lệ
	public String modifyPassword(user us) {
		if(!checkDuplicate(us.getUsers()))
			return "Error Duplicate";
		else if(!checkSize(us.getPassword()))
			return "Error Size";
		else if(checkEmptyPassword(us.getPassword()))
			return "Error Empty password";
		else if(!checkPassswordInvalid(us.getPassword()))
			return "Error password invilid";
		else {
			changeNewPassword(us);
			this.getUserDAO().modifyUser(us);
			return "Success";
		}
	}
	
	
	//lưu mật khẩu mới vào arraylist
	public void changeNewPassword(user us) {
		for(user value: userBUS.arrUser) {
			if(value.getUsers().equals(us.getUsers()))
				value.setPassword(us.getPassword());
		}
	}
	
	
	//xử lý đổi mật khẩu
	public String changePassword(user us, String oldPassword, String newPassword, String repeatPaswword) {
		if(!checkOldPasswordDuplicate(us.getPassword(), oldPassword))
			return "Error oldPassword";
		else if(!checkNewPasswordDuplicate(newPassword, repeatPaswword))
			return "Error new password not duplicate";
		else	{
			us.setPassword(newPassword);
			return modifyPassword(us);
			}
	}
	
	
	//kiểm tra 2 mật khẩu vừa nhập giống nhau 
	public boolean checkNewPasswordDuplicate(String newPassword, String repeatPassword) {
		return newPassword.equals(repeatPassword);
	}
	
	
	// kiểm tra mật khẩu cũ có trùng mk vừa nhập
	public boolean checkOldPasswordDuplicate(String oldPassword, String InputOldPassword) {
		return oldPassword.equals(InputOldPassword);
	}
	
	//tạo tài khoản trả về hệ thống view
	public user createUser(String us, String password) {
		user user = new user(us, password,"Hoạt động");
		return user;
	}
	
	//kiểm tra thông tin người dùng hợp lệ
	public boolean checkUserInvalid(String btn_user, String btn_pass) {
		for(user value: userBUS.arrUser)
			if(value.getUsers().equals(btn_user) && value.getPassword().equals(btn_pass))
				return true;
		return false;
	}
	// đổi trạng thái tài khoản
	public void modifyStatusUser(user us, String status) {
		us.setStatus(status);
		this.getUserDAO().modifyUser(us);
	}
	// thực hiên chức năng quên mật khẩu
	public String forgotPassword(String email) {
		if(checkDuplicate(email))
		{
			myNumber.maXacNhan =""+ sendEmail(email);
			myNumber.countTime = 300;
			myNumber.countTime();
			return "Success";
		}else {
			return "Error gmail";
		}
	}	
	
	//kiểm tra mã xác nhận hợp lệ
	public boolean checkComfirm(String text) {
		if(myNumber.maXacNhan.compareToIgnoreCase(text) == 0 && myNumber.maXacNhan.compareToIgnoreCase("") != 0)
			return true;
		return false;
	}
	
	//gửi email cho chủ nhân
	public String sendEmail(String toEmail) {
		String newPassword = "";
		try {
			mail email = new mail();
			email.setForm("tn530599@gmail.com");
			email.setPass("037818aA@");
			email.setTo(toEmail);
			newPassword = newPassword + myNumber.randomSixNumber();
			email.setContent("Chào bạn! \n Chúng tôi cung cấp password mới cho bạn là: "+ newPassword);
			email.setSubject("Change Password");
			myMail.send(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPassword;
	}
	public String checkLogin(String user, String pass, boolean status) {
		for(user us : arrUser) {
			if(us.getUsers().compareTo(user) == 0 && us.getPassword().compareTo(pass) == 0)
				{
				if(us.getStatus().compareTo("Hoạt động") == 0) {
					userLogin= new user(user, pass, "Hoạt động");
					saveUser(status);
					return "Success";
				}
				else
					return "Locked account";
				}
			
		}
		return "Error user";
	}
	
	// lưu hoặc sửa đổi tài khoản đã thêm
	public void saveUser(boolean status) {
		
		if(status)
		{
			try {
				inet = InetAddress.getLocalHost();
				userSave us = new userSave(inet+"", userLogin.getUsers(), userLogin.getStatus());
				if(userSave != null)
					this.userSaveDAO.modifyUser(us);
				else 	
				this.userSaveDAO.addUser(us);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			if(userSave != null) {
				userSave.setStatus("Ngưng hoạt động");
				userSaveDAO.modifyUser(userSave);
			}
			
		}
	}
	// kiểm tra tài khoản đã lưu có rỗng hay không
	public boolean checkUserSave() {
		if(this.getUserSave() == null)
			return false;
		else if(this.getUserSave().getStatus().compareToIgnoreCase("Ngưng hoạt động") == 0)
			return false;
		return true;
	}
	// trả về tài khoản đã lưu
	public user returnUser() {
		for(user v: arrUser) {
			if(this.getUserSave().getUser().compareToIgnoreCase(v.getUsers()) == 0)
				return v;
		}
		return null;
	}
	
		
		
}
