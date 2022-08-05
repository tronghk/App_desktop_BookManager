package BUS;

import java.time.LocalDate;
import java.util.ArrayList;
import DAO.promotionDAO;
import DTO.detailPromotion;
import DTO.promotion;
import GUI.menuManager;

public class promotionBUS {
	static ArrayList<promotion> arrPromotion = new ArrayList<promotion>();
	promotionDAO promotionDAO;
	public promotionBUS() {
		arrPromotion = new ArrayList<promotion>();
		this.setPromotionDAO(new promotionDAO());
		arrPromotion = this.getPromotionDAO().readPromotion();
	}
	public promotionDAO getPromotionDAO() {
		return promotionDAO;
	}
	public void setPromotionDAO(promotionDAO promotionDAO) {
		this.promotionDAO = promotionDAO;
	}
	public ArrayList<promotion> returnArrPromotion() {
		return arrPromotion;
	}
	public ArrayList<promotion> eventSearch(String s) {
		int count = 3;
		ArrayList<promotion> arr =new ArrayList<promotion>();
		while(count >0) {
			arr = eventSearchID(s);
			if(arr.size() == 0)
				arr = searchName(s);
			if(arr.size() == 0)
				arr = searchDateStart(s);
			if(arr.size() == 0)
				arr = searchDateEnd(s);
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
	public ArrayList<promotion> eventSearchID(String s) {
		ArrayList<promotion> arr = new ArrayList<promotion>();
		int i = s.length();
		for(promotion value: arrPromotion) {
			if(value.getIdPromotion().length() >= i)	
			if(value.getIdPromotion().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<promotion> searchName(String s){
		int i = s.length();
		ArrayList<promotion> arr = new ArrayList<promotion>();
		for(promotion value: arrPromotion) {
			if(value.getNamePromotion().length() >=i)
				if(value.getNamePromotion().substring(0, i).compareTo(s) == 0)
					arr.add(value);
		}
		return arr;
	}
	public ArrayList<promotion> searchDateStart(String s){
		int i = s.length();
		ArrayList<promotion> arr = new ArrayList<promotion>();
		for(promotion value: arrPromotion) {
			if(value.getDateStart().toString().length() >=i)
				if(value.getDateStart().toString().compareTo(s) == 0)
					arr.add(value);
		}
		return arr;
	}
	public ArrayList<promotion> searchDateEnd(String s){
		int i = s.length();
		ArrayList<promotion> arr = new ArrayList<promotion>();
		for(promotion value: arrPromotion) {
			if(value.getDateEnd().toString().length() >=i)
				if(value.getDateEnd().toString().compareTo(s) == 0)
					arr.add(value);
		}
		return arr;
	}
	public ArrayList<promotion> searchDay(String s){
		int temp;
		ArrayList<promotion> arr = new ArrayList<promotion>();
		try {
			temp = Integer.parseInt(s);
		}catch(Exception e) {
			return arr;
		}
		for(promotion value: arrPromotion) {
			String date[] = value.getDateStart().toString().split("-");
			if(Integer.parseInt(date[2]) == temp)
				arr.add(value);
		}
		return arr;
	}
	
	public ArrayList<promotion> searchMonth(String s){
		int temp;
		ArrayList<promotion> arr = new ArrayList<promotion>();
		try {
			temp = Integer.parseInt(s);
		}catch(Exception e) {
			return arr;
		}
		for(promotion value: arrPromotion) {
			String date[] = value.getDateStart().toString().split("-");
			if(Integer.parseInt(date[1]) == temp)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<promotion> searchYear(String s){
		int temp;
		ArrayList<promotion> arr = new ArrayList<promotion>();
		try {
			temp = Integer.parseInt(s);
		}catch(Exception e) {
			return arr;
		}
		for(promotion value: arrPromotion) {
			String date[] = value.getDateStart().toString().split("-");
			if(Integer.parseInt(date[0]) == temp)
				arr.add(value);
		}
		return arr;
	}
	public String savePromotion(String name, String dateStart, String dateEnd) {
		dateStart = Mydate.Date(dateStart);
		dateEnd = Mydate.DatePhatTrien(dateEnd);
		if(name.compareTo("") == 0)
			return "Error name";
		if(dateEnd  == null)
			return "Error dateEnd";
		if(dateStart == null)
			return "Error dateStart";
		ArrayList<detailPromotion> arr = menuManager.DTPromotionBUS.returnArrCTPromotion("-1");
		if(arr.size() == 0)
			return "Error empty";
		else {
			savePromotion(arr, name, dateStart, dateEnd);
			return "0";
		}
	}
	public void savePromotion(ArrayList<detailPromotion> arr, String name, String dateStart, String dateEnd) {
		//tạo Phiếu 
		promotion p = new promotion(topIDPromotion(), name, LocalDate.parse(dateStart), LocalDate.parse(dateEnd));
		//thêm vào phiếu
		arrPromotion.add(p);
		//đổi phiếu
		menuManager.DTPromotionBUS.changeId(p.getIdPromotion());
		// ghi dữ liệu
		this.getPromotionDAO().addPromotion(p);
		
		// ghi dữ liệu chi tiết sp;
		menuManager.DTPromotionBUS.addDTPromotion(p.getIdPromotion());
	}
	public String topIDPromotion() {
		int i = 0;
		for(promotion value: arrPromotion) {
			int temp = Integer.parseInt(value.getIdPromotion());
			if(temp > i)
				i = temp;
		}
		return (i+1)+"";
	}
	public ArrayList<promotion> returnArrChuongTrinh() {
		ArrayList<promotion> arr = new ArrayList<promotion>();
		String date[] = LocalDate.now().toString().split("-");
		for(promotion value: arrPromotion) {
			String dateStart[] = value.getDateStart().toString().split("-");
			String dateEnd[] = value.getDateEnd().toString().split("-");
			
			try {
				int dateTodayYear = Integer.parseInt(date[0]);
				int dateTodayMonth = Integer.parseInt(date[1]);
				int dateTodayDay = Integer.parseInt(date[2]);
				
				int dateStartYear = Integer.parseInt(dateStart[0]);
				int dateStartMonth = Integer.parseInt(dateStart[1]);
				int dateStartDay = Integer.parseInt(dateStart[2]);
				
				int dateEndYear = Integer.parseInt(dateEnd[0]);
				int dateEndMonth = Integer.parseInt(dateEnd[1]);
				int dateEndDay = Integer.parseInt(dateEnd[2]);
				
				if(dateTodayYear >= dateStartYear && dateTodayYear <= dateEndYear && dateTodayMonth >= dateStartMonth && 
						dateTodayMonth <= dateEndMonth &&  dateTodayDay >= dateStartDay && dateTodayDay <= dateEndDay)
					arr.add(value);
			}catch(Exception ex) {
				System.out.println("Lỗi");
			}
			
			
		}
		return arr;
	}
}
