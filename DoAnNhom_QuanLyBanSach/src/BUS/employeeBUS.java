package BUS;

import java.util.ArrayList;
import DTO.employee;
import GUI.menuManager;
import DAO.employeeDAO;

public class employeeBUS {
	public static ArrayList<employee> arrEmployee = new ArrayList<employee>();
	private employeeDAO employeeDAO;
	
	
	public employeeBUS() {
		arrEmployee = new ArrayList<employee>();
		this.setEmployeeDAO(new employeeDAO());
		arrEmployee = this.getEmployeeDAO().readEmployee();
	}
	public employeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	public void setEmployeeDAO(employeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	// thêm nhân viên
	public String addEmployee(String id, String name, String phoneNumber, String address, String turnover, String totalSales) {
		if(this.checkDuplicate(id))
			return "Error duplicate";
		String sPhone = myPhoneNumber.changePhoneNumber(phoneNumber);
		if(sPhone.compareToIgnoreCase("Success") != 0)
			return sPhone;
		if(!myNumber.checkIntNumber(turnover))
			return "Error char turnover";
		if(!myNumber.checkIntNumber(totalSales))
			return "Error char totalSale";
		return "Success";
		
			
	}
	// kiểm tra trùng lặp id nhân viên
	public boolean checkDuplicate(String idEm) {
		for(employee em: arrEmployee) {
			if(em.getIdEmployee().compareToIgnoreCase(idEm) == 0)
				return true;
		}
		return false;
	}
	public ArrayList<employee> returnArr(){
		return arrEmployee;
	}
	public String nameEmployee(String id) {
		String name = "";
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo(id) == 0)
			{ 
				name = value.getName();
				break;
			}
		}
		return name;
	}
	// xử lý chức vụ
	public String [] XuLyChucVu() {
		String arrChucVu[];
		employee em = returnObject(userBUS.userLogin.getUsers());
		if(em.getPosition().compareToIgnoreCase("Quản lý") ==0) {
			arrChucVu = new String[2];
			arrChucVu[0] = "Quản lý";
			arrChucVu[1] = "Nhân viên";
		}else {
			arrChucVu = new String[3];
			arrChucVu[2] = "Admin";
			arrChucVu[0] = "Quản lý";
			arrChucVu[1] = "Nhân viên";
		}
		return arrChucVu;
		
	}
	
	// trả về nhân viên
	public employee returnObject(String user) {
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo(user) == 0)
				return value;
		}
		return null;
	}
	public int xetChucVu(String ChucVu) {
		if(ChucVu.compareTo("Quản lý") == 0)
			return 0;
		else if(ChucVu.compareTo("Admin") == 0)
			return 2;
		return 1;
	}
	public ArrayList<employee> returnTablePosition() {
		employee em = returnObject(userBUS.userLogin.getUsers());
		if(em.getPosition().compareToIgnoreCase("Quản lý") == 0)
			return chonChucVuKhacAdmin();
		return returnArr();
			
	}
	public ArrayList<employee> chonChucVuKhacAdmin(){
		ArrayList<employee> arr = new ArrayList<employee>();
		for(employee value: arrEmployee) {
			if(value.getPosition().compareToIgnoreCase("Admin") != 0)
				arr.add(value);
		}
		return arr;
	}
	
	public String addObject(String id, String name, String phone, String address, String turnover, String position) {
		if(checkIdObject(id) || id.compareTo("") == 0)
			return "Error id";
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		if(!checkTurnover(turnover) || turnover.compareTo("") == 0)
			return "Error turnover";
		employee em = new employee(name, phone, address, id, Float.parseFloat(turnover), 0,getPermission(position) , position);
		arrEmployee.add(em);
		this.getEmployeeDAO().addEmployee(em);
		return "0";
	}
	public String getPermission(String position) {
		String s = "";
		if(position.compareTo("Nhân viên") == 0)
			s = "Bán hàng-Khuyến mãi-Sản phẩm-Khách hàng-Nhân viên-Nhập kho-Thống kê";
		if(position.compareTo("Quản lý") == 0)
			s = "Bán hàng-Khuyến mãi-Sản phẩm-Khách hàng-Nhân viên-Nhập kho-Thống kê";
		if(position.compareTo("Admin") == 0)
			s = "Bán hàng-Khuyến mãi-Sản phẩm-Khách hàng-Nhân viên-Nhập kho-Thống kê";
		return s;
	}
	public boolean checkTurnover(String luong) {
		try {
			float turnover = Float.parseFloat(luong);
			if(turnover < 0)
				return false;
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	public boolean checkIdObject(String id) {
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo(id) == 0)
				return true;
		}
		return false;
	}
	public boolean checkName(String name) {
		if(name.compareTo("") == 0)
			return true;
		return false;
	}
	public String modifyObject(String id, String name, String phone, String address, String turnover, String position) {
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		if(!checkTurnover(turnover) || turnover.compareTo("") == 0)
			return "Error turnover";
		employee em = new employee(name, phone, address, id, Float.parseFloat(turnover), 0,getPermission(position) , position);
		modifyObject(em);
		this.getEmployeeDAO().modifyEmployee(em);
		return "0";
	}
	public void modifyObject(employee em) {
		
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo(em.getIdEmployee()) == 0) {
				value.setName(em.getName());
				value.setAddress(em.getAddress());
				value.setPhoneNumber(em.getPhoneNumber());
				value.setPosition(em.getPosition());
				value.setTurnover(em.getTurnover());
			}
		}
	}
	public String deleteObject(String id, String name, String phone, String address, String turnover, String position) {
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		if(!checkTurnover(turnover) || turnover.compareTo("") == 0)
			return "Error turnover";
		employee em = new employee(name, phone, address, id, Float.parseFloat(turnover), 0,getPermission(position) , position);
		deleteEmployee(em);
		this.getEmployeeDAO().modifyEmployee(em);
		return "0";
	}
	public void deleteEmployee(employee em) {
		for(employee value: arrEmployee)
			if(em.getIdEmployee().compareTo(value.getIdEmployee()) == 0) {
					value.setTurnover(0);
					break;
				}
	}
	public ArrayList<employee> searchEmployee(String s) {
		ArrayList<employee> arr = new ArrayList<employee>();
		while(arr.size() < 1) {
			arr = searchId(s);
			if(arr.size() == 0)
				arr = searchName(s);
			if(arr.size() == 0)
				arr = searchPhone(s);
			if(arr.size() == 0)
				arr = searchType(s);
			if(s.length() > 1)
				s = s.substring(0, s.length()-1);
			if(s.length() <= 1 && arr.size() == 0)
				break;
		}
		return arr;
			
	}
	public ArrayList<employee> searchId(String s){
		
		ArrayList<employee> arr = new ArrayList<employee>();
		int  i = s.length();
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo("") == 0)
				continue;
			if(value.getIdEmployee().length() >= i)
			if(value.getIdEmployee().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<employee> searchName(String s){
		int  i = s.length();
		ArrayList<employee> arr = new ArrayList<employee>();
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo("") == 0)
				continue;
			if(value.getName().length() >= i)
			if(value.getName().substring(0, i).compareToIgnoreCase(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<employee> searchPhone(String s){
		int  i = s.length();
		ArrayList<employee> arr = new ArrayList<employee>();
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo("") == 0)
				continue;
			if(value.getPhoneNumber().length() >= i)
			if(value.getPhoneNumber().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<employee> searchType(String s){
		int  i = s.length();
		ArrayList<employee> arr = new ArrayList<employee>();
		for(employee value: arrEmployee) {
			String tu = value.getTurnover()+"";
			if(value.getIdEmployee().compareTo("") == 0)
				continue;
			if(tu.length() >= i)
			if(tu.substring(0, i).compareToIgnoreCase(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public String[] topEmployee() {
		// đẩy toàn bộ id khách hàng vào arrCustomer;
		String arr[] = new String[returnArr().size()];
		int i=0;
		for(employee value: returnArr()) {
			arr[i] = value.getIdEmployee();
			i++;
		}
		// tính tổng tiền ứng với id khách hàng trong tháng
		arr = tinhTongTienEmployee(arr);
		
		// sắp xếp tổng tiền từ lớn đến bé theo Kh;
		arr = sortTopNV
				(arr);
		
		// truy xuất tổng số hóa đơn kh
		arr = tinhTongHoaDon(arr);
		
		//lấy tên Kh;
		arr = LayTenNV(arr);
		
		return arr;
	}
	// tính tổng tiền cho từng NV;
	public String[] tinhTongTienEmployee(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = menuManager.billBUS.tinhTongTienEmployee(arr[i]);
		}
		return arr;
	}
	public String [] tinhTongHoaDon(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			String temp[] = arr[i].split("-");
			
			arr[i] = arr[i]+"-"+ menuManager.billBUS.truyXuatTongSoHoaDonEm(temp[0]);
		}
		return arr;
	}
	public String [] LayTenNV(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			String temp[] = arr[i].split("-");
			
			arr[i] = arr[i]+"-"+ returnNameEmployee(temp[0]);
		}
		return arr;
	}
	public String returnNameEmployee(String id) {
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo(id) == 0)
				return value.getName();
		}
		return null;
	}
	// sắp xếp top khách hàng theo tổng tiền
	public String[] sortTopNV(String []arr) {
		for(int i = 0;i<arr.length;i++) {
			String tempi[] = arr[i].split("-");
			float sumI = Float.parseFloat(tempi[1]);
			for(int j=i+1;j<arr.length;j++) {
				String tempj[] = arr[j].split("-");
				float sumJ = Float.parseFloat(tempj[1]);
				// so sánh 2 giá tiền
				if(sumI < sumJ)
				{
					// đổi chỗ tiền
					sumI = sumJ;
					
					// đổi vị trí 2 thành phần
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp; 
				}
			}
		}
		
		return arr;
	}
	public void tangDonHang(String idem) {
		for(employee value: arrEmployee) {
			if(value.getIdEmployee().compareTo(idem)==0) {
				value.setTotalSales(value.getTotalSales()+1);
				this.getEmployeeDAO().modifyEmployee(value);
				break;
			}
		}
	}
}	
