package BUS;

import java.util.ArrayList;

import DAO.customerDAO;
import DTO.customer;
import GUI.menuManager;

public class customerBUS {
	static ArrayList<customer> arrCustomer = new ArrayList<customer>();
	private customerDAO customerDAO;
	private billBUS billBUS = new billBUS();
	public customerBUS() {
		this.setCustomerDAO(new customerDAO());
		arrCustomer = this.getCustomerDAO().readCustomer();
	}
	public customerDAO getCustomerDAO() {
		return customerDAO;
	}
	public void setCustomerDAO(customerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	public void BXHKH() {
		ArrayList<Float> sumPrice = new ArrayList<Float>();
		for(customer value: arrCustomer) {
			float sum = billBUS.sumPrice(value.getIdCustomer());
			sumPrice.add(sum);
		}
		
	}
	public ArrayList<customer> returnArr() {
		ArrayList<customer> arr= new ArrayList<customer>();
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo("") == 0)
				continue;
			arr.add(value);
		}
		return arr;
	}
	
	public  customer returnObject (String idKH) {
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo(idKH) == 0)
				return value;
		}
		return null;
	}
	public String TienChietKhau(String typeCu) {
		if(typeCu.compareToIgnoreCase("VIP") == 0)
			return "2%";
		return "1%";
	}
	public int changeTypeCustomer(String type) {
		if(type.compareTo("VIP") == 0)
			return 0;
		return 1;
	}
	public double downPrice(float price, String typeCustomer) {
		if(typeCustomer.compareToIgnoreCase("VIP") == 0)
			return (price - price*0.02);
		return price - price*0.01;
	}
	public boolean checkEmplty(String id) {
		if(id.compareTo("") == 0)
			return true;
		return false;
	}
	public String addObject(String id, String name, String phone, String address, String type) {
		if(checkIdObject(id) || checkEmplty(id))
			return "Error id";
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		customer cu = new customer(id, name, phone, address, type);
		arrCustomer.add(cu);
		this.getCustomerDAO().addCustomer(cu);
		return "0";
	}
	public boolean checkIdObject(String id) {
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo(id) == 0)
				return true;
		}
		return false;
	}
	public boolean checkName(String name) {
		if(name.compareTo("") == 0)
			return true;
		return false;
	}
	public String modifyObject(String id, String name, String phone, String address, String type) {
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		customer cu = new customer(id, name, phone, address, type);
		modifyObject(cu);
		this.getCustomerDAO().modifyCustomer(cu);
		return "0";
	}
	public void modifyObject(customer cu) {
		
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo(cu.getIdCustomer()) == 0) {
				value.setName(cu.getName());
				value.setAddress(cu.getAddress());
				value.setPhoneNumber(cu.getPhoneNumber());
				value.setTypeCustomer(cu.getTypeCustomer());
			}
		}
	}
	public String deleteObject(String id, String name, String phone, String address, String type) {
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		customer cu = new customer(id, name, phone, address, type);
		deleteObject(cu);
		this.getCustomerDAO().deleteCustomer(cu);
		menuManager.billBUS.deleteCustomer(id);
		return "0";
	}
	public void deleteObject(customer cu) {
		int i=0;
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo(cu.getIdCustomer()) == 0)
				break;
			i++;
		}
		arrCustomer.remove(arrCustomer.get(i));
	}
	public ArrayList<customer> searchCustomer(String s) {
		ArrayList<customer> arr = new ArrayList<customer>();
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
	public ArrayList<customer> searchId(String s){
		
		ArrayList<customer> arr = new ArrayList<customer>();
		int  i = s.length();
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo("") == 0)
				continue;
			if(value.getIdCustomer().length() >= i)
			if(value.getIdCustomer().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<customer> searchName(String s){
		int  i = s.length();
		ArrayList<customer> arr = new ArrayList<customer>();
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo("") == 0)
				continue;
			if(value.getName().length() >= i)
			if(value.getName().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<customer> searchPhone(String s){
		int  i = s.length();
		ArrayList<customer> arr = new ArrayList<customer>();
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo("") == 0)
				continue;
			if(value.getPhoneNumber().length() >= i)
			if(value.getPhoneNumber().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<customer> searchType(String s){
		ArrayList<customer> arr = new ArrayList<customer>();
		try {
			int  i = s.length();
			
			for(customer value: arrCustomer) {
				if(value.getIdCustomer().compareTo("") == 0)
					continue;
				if(value.getTypeCustomer().length() >= i)
				if(value.getTypeCustomer().substring(0, i).compareToIgnoreCase(s) == 0)
					arr.add(value);
			}
			}
		catch(Exception ex) {
			
		}
		return arr;
	}
	public String[] topCustomer() {
		// đẩy toàn bộ id khách hàng vào arrCustomer;
		String arrCustomer[] = new String[returnArr().size()];
		int i=0;
		for(customer value: returnArr()) {
			arrCustomer[i] = value.getIdCustomer();
			i++;
		}
		// tính tổng tiền ứng với id khách hàng trong tháng
		arrCustomer = tinhTongTien(arrCustomer);
		
		// sắp xếp tổng tiền từ lớn đến bé theo Kh;
		arrCustomer = sortTopKh(arrCustomer);
		
		// truy xuất tổng số hóa đơn kh
		arrCustomer = tinhTongHoaDon(arrCustomer);
		
		//lấy tên Kh;
		arrCustomer = LayTenKH(arrCustomer);
		
		return arrCustomer;
	}
	// tính tổng tiền cho từng khách hàng;
	public String[] tinhTongTien(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = menuManager.billBUS.tinhTongTienKH(arr[i]);
		}
		return arr;
	}
	public String [] tinhTongHoaDon(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			String temp[] = arr[i].split("-");
			
			arr[i] = arr[i]+"-"+ menuManager.billBUS.truyXuatTongSoHoaDon(temp[0]);
		}
		return arr;
	}
	public String [] LayTenKH(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			String temp[] = arr[i].split("-");
			
			arr[i] = arr[i]+"-"+ returnNameCustomer(temp[0]);
		}
		return arr;
	}
	public String returnNameCustomer(String id) {
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo(id) == 0)
				return value.getName();
		}
		return null;
	}
	// sắp xếp top khách hàng theo tổng tiền
	public String[] sortTopKh(String []arr) {
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
	public String returnType(String idKh) {
		String idKH ="";
		for(customer value: arrCustomer) {
			if(value.getIdCustomer().compareTo(idKH) ==0)
				idKh = value.getTypeCustomer();
		}
		return idKh;
	}
}
	
