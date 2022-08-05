package BUS;

import java.time.LocalDate;
import java.util.ArrayList;

import DAO.couponDAO;
import DTO.coupon;
import DTO.detailCoupon;
import GUI.menuManager;

public class couponBUS {
	static ArrayList<coupon> arrCoupons = new ArrayList<coupon>();
	private couponDAO couponDAO;
	static coupon coupon;
	public couponBUS() {
		arrCoupons = new ArrayList<coupon>();
		this.setCouponDAO(new couponDAO());
		arrCoupons = this.getCouponDAO().readCoupon();
	}
	
	
	public static coupon getCoupon() {
		return coupon;
	}


	public static void setCoupon(coupon coupon) {
		couponBUS.coupon = coupon;
	}


	public couponDAO getCouponDAO() {
		return couponDAO;
	}
	public void setCouponDAO(couponDAO couponDAO) {
		this.couponDAO = couponDAO;
	}
	public ArrayList<coupon> returnArrCoupon(){
		return arrCoupons;
	}
	public ArrayList<coupon> returnListPNH(String idDistributor) {
		ArrayList<coupon> arrCoupon = new ArrayList<coupon>();
		for(coupon value: arrCoupons) {
			if(value.getIdBookDistributor().compareTo(idDistributor) == 0)
				arrCoupon.add(value);
		}
		return arrCoupon;
	}
	public ArrayList<coupon> eventSearch(String s) {
		int count = 3;
		ArrayList<coupon> arr =new ArrayList<coupon>();
		while(count >0) {
			arr = eventSearchID(s);
			if(arr.size() == 0)
				arr = searchDate(s);
			if(arr.size() == 0)
				arr = searchMaPNH(s);
			if(arr.size() == 0)
				arr = searchDay(s);
			if(arr.size() == 0)
				arr = searchMonth(s);
			if(arr.size() == 0)
				arr = searchYear(s);
			if(s.length() <=1 )
				break;
			if(s.length()>1 && arr.size() == 0)
				s = s.substring(0, s.length()-1);
			count --;
		}
		return arr;
			
	}
	public ArrayList<coupon> eventSearchID(String s) {
		int temp;
		ArrayList<coupon> arr = new ArrayList<coupon>();
		try {
			temp = Integer.parseInt(s);
		}catch(Exception e) {
			return arr;
		}
		
		for(coupon value: arrCoupons) {
			if(value.getIdCoupon() == temp)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<coupon> searchMaPNH(String s){
		int i = s.length();
		ArrayList<coupon> arr = new ArrayList<coupon>();
		for(coupon value: arrCoupons) {
			if(value.getIdBookDistributor().length() >=i)
				if(value.getIdBookDistributor().substring(0, i).compareTo(s) == 0)
					arr.add(value);
		}
		return arr;
	}
	public ArrayList<coupon> searchDate(String s){
		int i = s.length();
		ArrayList<coupon> arr = new ArrayList<coupon>();
		for(coupon value: arrCoupons) {
			if(value.getDateAdded().toString().length() >=i)
				if(value.getDateAdded().toString().compareTo(s) == 0)
					arr.add(value);
		}
		return arr;
	}
	public ArrayList<coupon> searchDay(String s){
		int temp;
		ArrayList<coupon> arr = new ArrayList<coupon>();
		try {
			temp = Integer.parseInt(s);
		}catch(Exception e) {
			return arr;
		}
		for(coupon value: arrCoupons) {
			String date[] = value.getDateAdded().toString().split("-");
			if(Integer.parseInt(date[2]) == temp)
				arr.add(value);
		}
		return arr;
	}
	
	public ArrayList<coupon> searchMonth(String s){
		int temp;
		ArrayList<coupon> arr = new ArrayList<coupon>();
		try {
			temp = Integer.parseInt(s);
		}catch(Exception e) {
			return arr;
		}
		for(coupon value: arrCoupons) {
			String date[] = value.getDateAdded().toString().split("-");
			if(Integer.parseInt(date[1]) == temp)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<coupon> searchYear(String s){
		int temp;
		ArrayList<coupon> arr = new ArrayList<coupon>();
		try {
			temp = Integer.parseInt(s);
		}catch(Exception e) {
			return arr;
		}
		for(coupon value: arrCoupons) {
			String date[] = value.getDateAdded().toString().split("-");
			if(Integer.parseInt(date[0]) == temp)
				arr.add(value);
		}
		return arr;
	}
	public String paymentCoupon(String idNPH) {
		ArrayList<detailCoupon> arr = menuManager.dtCoupon.returnArrCTCreate(-1);
		if(arr.size() == 0)
			return "Error empty";
		else {
			createCoupon(arr, idNPH);
			return "0";
		}
	}
	public void createCoupon(ArrayList<detailCoupon> arr, String idNPH) {
		//tạo Phiếu 
		coupon co = new coupon(topCoupon(), LocalDate.now(), menuManager.dtCoupon.sumPrice(-1), idNPH);
		//thêm vào phiếu
		arrCoupons.add(co);
		//đổi phiếu
		menuManager.dtCoupon.changeIDCT(co.getIdCoupon());
		// ghi dữ liệu
		this.getCouponDAO().addCoupon(co);
		
		// ghi dữ liệu chi tiết sp;
		menuManager.dtCoupon.addDTCoupon(co.getIdCoupon());
		
		menuManager.dtCoupon.eventXuatFileExcel(co.getIdCoupon());
		
	}
	public int topCoupon() {
		int i = 0;
		for(coupon value: arrCoupons) {
			if(value.getIdCoupon() > i)
				i = value.getIdCoupon();
		}
		System.out.println(i);
		return i+1;
	}

	
}
