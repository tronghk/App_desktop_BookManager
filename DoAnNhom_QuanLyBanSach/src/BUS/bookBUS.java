package BUS;

import java.time.LocalDate;
import java.util.ArrayList;

import DAO.BookDAO;
import DTO.billDetail;
import DTO.book;
import DTO.detailCoupon;
import DTO.linkImage;
import GUI.menuManager;

public class bookBUS {
	static ArrayList<book> arrBook = new ArrayList<book>();
	private BookDAO bookDAO;
	public bookBUS() {
		arrBook = new ArrayList<book>();
		this.bookDAO = new BookDAO();
		arrBook = this.bookDAO.readBook();
	}
	public ArrayList<book> returnArrbook(){
		return arrBook;
	}
	public ArrayList<book> returnArrBookSameType(String idType) {
		ArrayList<book> arr = new ArrayList<book>();
		for(book value: arrBook) {
			if(value.getIdTypeBook().compareToIgnoreCase(idType) == 0) {
				arr.add(value);
			}
		}
		return arr;
	}
	
	public ArrayList<book> returnArrBookSamePublishingCPN(String idType) {
		ArrayList<book> arr = new ArrayList<book>();
		for(book value: arrBook) {
			if(value.getIdPublishingCompany().compareToIgnoreCase(idType) == 0) {
				arr.add(value);
			}
		}
		return arr;
	}
	public String returnNameBook(String idBook) {
		String name = "";
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(idBook) == 0)
			{
				name = value.getNameBook();
				break;
			}
		}
		return name;
	}
	public float returnPriceBook(String idBook) {
		float price = 0;
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(idBook) == 0)
			{
				price = value.getUnitPrice();
				break;
			}
		}
		return price;
	}
	public book returnObject(String id) {
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(id) == 0)
				return value;
		}
		return null;
	}
	public String addObject(String id, String name, String type, String quantity, String price, String date, String nxb, String pathFile) {
		date = checkDate(date);
		if(checkDuplicateID(id)) {
			return "Error Id";
		}
		else if( checkEmptyName(name))
			return "Error name";
		else if(checkQuantity(quantity).compareTo("0") != 0)
			return "Error quantity";
		else if(checkPrice(price).compareTo("0") != 0)
			return "Error price";
		else if(date == null) {
			return "Error date";
		}
		else
		{
			try {
			LocalDate date2 = LocalDate.parse(date);
			book b = new book(id, name, Float.parseFloat(price), date2, Integer.parseInt(quantity), type, nxb, "Hoạt động");
			arrBook.add(b);
			this.bookDAO.addBook(b);
			menuManager.link.createLink(id, pathFile);
			}catch(Exception ex) {
			}
			return "0";
		}
	}
	public boolean checkDuplicateID(String id) {
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(id) == 0)
				return true;
		}
		return false;
	}
	public boolean checkEmptyName(String name) {
		if(name.compareTo("") == 0)
			return true;
		return false;
	}
	public String checkQuantity(String quantity) {
		try {
			int num = Integer.parseInt(quantity);
			if(num < 0)
				return "error num";
			else
				return "0";
		}catch(Exception ex) {
			return " error string";
		}
	}
	public String checkPrice(String price) {
		try {
			price = price.replace(".", "");
			float num = Integer.parseInt(price);
			if(num < 0)
				return "error num";
			else
				return "0";
		}catch(Exception ex) {
			return " error string";
		}
	}
	public String checkDate(String date) {
		return Mydate.Date(date);
	}
	public String modifyObject(String id,String name, String type, String quantity, String price, String date, String nxb, String pathFile) {
		date = checkDate(date);
		if(!checkDuplicateID(id)) {
			return "Error Id";
		}
		else if( checkEmptyName(name))
			return "Error name";
		else if(checkQuantity(quantity).compareTo("0") != 0)
			return "Error quantity";
		else if(checkPrice(price).compareTo("0") != 0)
			return "Error price";
		else if(date == null) {
			return "Error date";
		}
		else
		{
			try {
			LocalDate date2 = LocalDate.parse(date);
			book b = new book(id, name, Float.parseFloat(price), date2, Integer.parseInt(quantity), type, nxb, "Hoạt động");
			menuManager.link.modifyLink(new linkImage(pathFile, id));
			modifyObject(b);
			this.bookDAO.modifyBook(b);
			
			}catch(Exception ex) {
			}
			return "0";
		}
	}
	public void modifyObject(book b) {
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(b.getIdBook()) == 0) {
				value.setDatePublishing(b.getDatePublishing());
				value.setIdPublishingCompany(b.getIdPublishingCompany());
				value.setIdTypeBook(b.getIdTypeBook());
				value.setNameBook(b.getNameBook());
				value.setQuantityBook(b.getQuantityBook());
				value.setStatus(b.getStatus());
				value.setUnitPrice(b.getUnitPrice());
				break;
			}
		}
	}
	public String deleteObject(String id,String name, String type, String quantity, String price, String date, String nxb, String pathFile) {
		date = checkDate(date);
		if(!checkDuplicateID(id) || id.compareTo("") == 0) {
			return "Error Id";
		}
		else if( checkEmptyName(name))
			return "Error name";
		else if(checkQuantity(quantity).compareTo("0") != 0)
			return "Error quantity";
		else if(checkPrice(price).compareTo("0") != 0)
			return "Error price";
		else if(date == null) {
			return "Error date";
		}
		else
		{
			try {
			LocalDate date2 = LocalDate.parse(date);
			book b = new book(id, name, Float.parseFloat(price), date2, Integer.parseInt(quantity), type, nxb, "Hoạt động");
			menuManager.link.deleteLinkObject(new linkImage(pathFile, id));
			deleteObject(b);
			this.bookDAO.deleteBook(b);
			
			}catch(Exception ex) {
			}
			return "0";
		}
	}
	public void deleteObject(book b) {
		int i=0;
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(b.getIdBook()) == 0) {
				arrBook.remove(arrBook.get(i));
				break;
			}
			i++;
		}
				
	}
	public ArrayList<book> arrSearch(String s){
		ArrayList<book> arrBookSearch = new ArrayList<book>();
		arrBookSearch = search(s);
		return arrBookSearch;
	}
	public ArrayList<book> search(String s) {
		ArrayList<book> arr = new ArrayList<book>();
		while(arr.size() <1) {
			arr = returnArrMaSp(s);
			if(arr.size() == 0)
				arr = returnArrTenSp(s);
			if(arr.size() == 0)
				arr = returnArrLoaiSp(s);
			if(arr.size() == 0)
				arr = returnArrSoLuongSp(s);
			if( arr.size() == 0)
				arr = returnArrGiatienSp(s);
			if(s.length() >1)
				s = s.substring(0, s.length()-1);
			if(s.length()<=1 && arr.size() == 0)
				break;
		}
		return arr;
	}
	public ArrayList<book> returnArrMaSp(String s){
		int i = s.length();
		ArrayList<book> arr = new ArrayList<book>();
		for(book value: arrBook) {
			if(value.getIdBook().length()>=i)
			if(value.getIdBook().substring(0, i).compareTo(s) == 0) {
				arr.add(value);
				
			}
		}
		return arr;
	}
	public ArrayList<book> returnArrTenSp(String s){
		int i = s.length();
		
		ArrayList<book> arr = new ArrayList<book>();
		for(book value: arrBook) {
			if(value.getNameBook().length()>=i)
			if(value.getNameBook().substring(0, i).compareToIgnoreCase(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<book> returnArrLoaiSp(String s){
		int i = s.length();
		ArrayList<book> arr = new ArrayList<book>();
		for(book value: arrBook) {
			if(value.getIdTypeBook().length()>=i)
			if(value.getIdTypeBook().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<book> returnArrSoLuongSp(String s){
		int i = s.length();
		ArrayList<book> arr = new ArrayList<book>();
		for(book value: arrBook) {
			String temp = value.getQuantityBook()+"";
			if(temp.length()>=i)
			if(temp.compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<book> returnArrGiatienSp(String s){
		ArrayList<book> arr = new ArrayList<book>();
		for(book value: arrBook) {
			String sPrice = s.replace(",", "");
			sPrice = s.replace(".", "");
			String temp = value.getUnitPrice()+"";
			temp = temp.replace(",", "");
			if(temp.compareToIgnoreCase(sPrice) == 0)
				arr.add(value);
		}
		return arr;
	}
	public void changeTypeBook(String id) {
		for(book value: arrBook) {
			if(value.getIdTypeBook().compareTo(id) == 0) {
				value.setIdTypeBook("Vô danh");
				this.bookDAO.modifyBook(value);
			}
		}
	}
	public void addQuantityBook(String idBook, int quantity) {
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(idBook) == 0) {
				value.setIdBook(value.getIdBook()+quantity);
				this.bookDAO.modifyBook(value);
			}
			
		}
	}
	public ArrayList<String> returnArrBook(ArrayList<detailCoupon> arr){
		ArrayList<String> arrBook = new ArrayList<String>();
		for(detailCoupon value: arr) {
			arrBook.add(returnNameBook(value.getIdBook()));
		}
		return arrBook;
	}
	public Float returnUnitprice(String id) {
		for(book value: arrBook)
			if(value.getIdBook().compareTo(id) == 0)
				return value.getUnitPrice();
		return null;
	}
	public void congThemSach(String idBook, int quantiTy) {
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(idBook) == 0) {
				value.setQuantityBook(value.getQuantityBook()+quantiTy);
				this.bookDAO.modifyBook(value);
			}
		}
	}
	public void truSach(String idBook, int quantiTy) {
		for(book value: arrBook) {
			if(value.getIdBook().compareTo(idBook) == 0) {
				value.setQuantityBook(value.getQuantityBook()-quantiTy);
				this.bookDAO.modifyBook(value);
			}
		}
	}
	public String soLuongToiDa(String idbook, String quantity ) {
		try {
			int quantt = 0;
			for(book value: arrBook) {
				if(value.getIdBook().compareTo(idbook) == 0) {
					quantt = value.getQuantityBook();
					break;
				}
			}
			if(quantt < Integer.parseInt(quantity))
				return quantt+"";
			else
				return Integer.parseInt(quantity)+"";
		}catch(Exception ex) {
			return "Error";
		}
	}
	// thống kê top sản phẩm của năm
	
	public String[] thongKeSanPham(String year) {
		//khởi tạo độ dài mảng  = all sách
			String book[] = new String[arrBook.size()];
			
		// trả về mảng với toàn bộ id sách
			book = returnIDBook(book);
		// trả về tổng tiền với toàn bộ sách trong năm
			book = returnSumBook(book, year);
			
		// sắp xếp book từ lớn đến bé
			book = sortBook(book);
			
			//lấy tên sách
			book = returnNameBook(book);
		//trả về mảng book;
			
		return book;
	}
	public String [] returnIDBook(String [] book) {
		int i = 0;
		for(book value: arrBook) {
			book[i] = value.getIdBook()+"-";
			i++;
		}
		return book;
	}
	public String [] returnSumBook(String [] book, String year) {
		ArrayList<billDetail> arr = menuManager.billDTBUS.returnArrYear(year);
		float sum = 0;
		int count = 0;
		for(int i = 0;i<book.length;i++) {
			for(billDetail value: arr) {
				if(value.getIdBook().compareTo(book[i].replace("-", "")) == 0) {
					sum = value.getIntoMoney()+sum;
					count = value.getQuantityBook();
				}
					
			}
			book[i] = book[i] + sum+"-"+count;
			sum = 0;
			count = 0;
		}
		return book;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String [] abc( String[] book, String year) {
		ArrayList<billDetail> arr = menuManager.billDTBUS.returnArrYear(year);
		float sum = 0;
		for(int i = 0;i<book.length;i++) {
			for(billDetail value: arr) {
				if(value.getIdBook().compareTo(book[i]) ==0)
					sum = sum+value.getIntoMoney();
			}
			book[i] = book[i]+"-"+sum;
			sum = 0;
		}
		return book;
	}
	public String [] sortBook(String [] book) {
		for(int i=0;i<book.length;i++) {
				String bLeft[] = book[i].split("-");
			for(int j = i;j<book.length;j++) {
				String bRight[] = book[j].split("-");
				
				// đem so sánh tổng tiền
				
				float sumbLeft = Float.parseFloat(bLeft[1]);
				float sumbRight = Float.parseFloat(bRight[1]);

				//ss
				if(sumbLeft < sumbRight) {
					// hoán dổi vị trí
					String temp = book[i];
					
					book[i] = book[j];
					
					book[j] = temp;
					
					bLeft[1] = bRight[1];
				}
			}
		}
		return book;
	}
	public String[] returnNameBook(String [] book) {
		
		for(int i =0;i<book.length;i++) {
			String sBook[] = book[i].split("-");
			for(book value: arrBook) {
				if(value.getIdBook().compareTo(sBook[0]) ==0)
					book[i] = book[i] + "-"+value.getNameBook();
			}
		}
		return book;
	}
}

