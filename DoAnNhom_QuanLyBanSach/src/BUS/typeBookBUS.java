package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DTO.typeBook;
import DAO.typeBookDAO;

public class typeBookBUS {
	private typeBookDAO typeBook;
	static ArrayList<typeBook> arrTB = new ArrayList<typeBook>();
	static bookBUS bookBUS = new bookBUS();
	
	public typeBookBUS() {
		arrTB = new ArrayList<typeBook>();
		this.setTypeBook(new typeBookDAO());
		arrTB = this.typeBook.readTypeBook();
	}


	public typeBookDAO getTypeBook() {
		return typeBook;
	}


	public void setTypeBook(typeBookDAO typeBook) {
		this.typeBook = typeBook;
	}


	public static ArrayList<typeBook> getArrTB() {
		return arrTB;
	}


	public static void setArrTB(ArrayList<typeBook> arrTB) {
		typeBookBUS.arrTB = arrTB;
	}


	public String addTypeBook(String name) {
		String idTypeBook ="T"+ numberMaxId();
		
		if(name.length() >30)
			return "Error length";
		else {
			typeBook tb = new typeBook(idTypeBook, name,"Hoạt động");
			arrTB.add(tb);
			this.getTypeBook().addTypeBook(tb);
			return "success";
		}
		
	}
	public  ArrayList<typeBook> returnArrType(){
		ArrayList<typeBook> arr = new ArrayList<typeBook>();
		
		for(typeBook value: arrTB) {
			if(value.getIdTypeBook().compareTo("Vô danh") == 0)
			{
				continue;
			}
			arr.add(value);
		}
		return arr;
	}
	//kiểm tra trung lặp
	public boolean checkDuplicateTypeBook(String idType) {
		for(typeBook tb: arrTB) {
			if(tb.getIdTypeBook().compareTo(idType) == 0)
				return true;
		}
		return false;
	}
	
	//tìm mã lớn nhất
	public int numberMaxId() {
		int num = 0;
		for(typeBook tb: arrTB) {
			int temp = Integer.parseInt(tb.getIdTypeBook().substring(1, tb.getIdTypeBook().length()));
			if(temp> num)
				num = temp;
		}
		return num+1;
	}
	// sửa loại sản phẩm
	public void modifyTypeBook(typeBook tb) {
		for(typeBook value: arrTB) {
			if(value.getIdTypeBook().compareTo(tb.getIdTypeBook()) == 0)
				value.setNameTypeBook(tb.getNameTypeBook());
		}
	}
	//xóa loại sản phẩm
	public void deleteTypeBook(typeBook tb) {
		int i=0;
		for(typeBook sTB: arrTB) {
			if(sTB.getIdTypeBook().compareTo(tb.getIdTypeBook()) == 0) {
				arrTB.remove(arrTB.get(i));
				break;
			}
			i++;
		}
	}
	// tìm kiếm loại sản phẩm
	public void searchType(String nameType) {
		
	}
	
	// trả về mảng string loại sách
	public String[] arrStringTypeBook() {
		int size = arrTB.size();
		String []arrTypeBook = new String [size-1];
		int i=0;
		for(typeBook v: arrTB) {
			if(v.getIdTypeBook().compareTo("Vô danh") == 0)
				continue;
			arrTypeBook[i] = v.getIdTypeBook();
			i++;
		}
		return arrTypeBook;
	}
	public String[] arrStringTypeBookPNH() {
		int size = arrTB.size()+1;
		String []arrTypeBook = new String [size];
		arrTypeBook[0] = "Loại sách";
		int i=1;
		for(typeBook v: arrTB) {
			arrTypeBook[i] = v.getIdTypeBook();
			i++;
		}
		return arrTypeBook;
	}
	public String returnNameTypeBook(String id) {
		for(typeBook value: arrTB) {
			if(id.compareToIgnoreCase(value.getNameTypeBook()) == 0)
				return value.getNameTypeBook();
		}
		return null;
	}
	//trả về loại sách trong combobox
	public int indexTypeBook(String idType) {
		int i=0;
		for(typeBook value: arrTB) {
			if(value.getIdTypeBook().compareToIgnoreCase(idType) == 0)
				break;
			i = i+1;
		}
		return i;
	}
	public String addObject(String id, String name) {
		if(checkDuplicateTypeBook(id) || id.compareTo("") == 0)
			return "Error id";
		if(name.compareTo("") == 0)
			return "Error name";
		typeBook tb = new typeBook(id, name, "Hoạt động");
		arrTB.add(tb);
		this.getTypeBook().addTypeBook(tb);
		return "0";
	}
	public String modifyObject(String id, String name) {
		if(name.compareTo("") == 0)
			return "Error name";
		typeBook tb = new typeBook(id, name, "Hoạt động");
		modifyTypeBook(tb);
		this.getTypeBook().modifyTypeBook(tb);
		return "0";
	}
	public String deleteObject(String id, String name) {
		if(!checkName(id, name))
			return "Error name";
		int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa loại sản phẩm?");
		if(dialogResult == JOptionPane.YES_OPTION) {
			typeBook tb = new typeBook(id, name, "Hoạt động");
			bookBUS.changeTypeBook(tb.getIdTypeBook());
			deleteTypeBook(tb);
			this.getTypeBook().deleteTypeBook(tb);
			return "0";
		}
		return "-1";
		
	}
	public  boolean checkName(String id, String name) {
		for(typeBook value: arrTB) {
			if(value.getIdTypeBook().compareTo(id) == 0 && value.getNameTypeBook().compareTo(name) != 0)
				return false;
		}
		return true;
	}
	
	public ArrayList<typeBook> arrSearch(String s){
		ArrayList<typeBook> arrBookSearch = new ArrayList<typeBook>();
		arrBookSearch = search(s);
		return arrBookSearch;
	}
	public ArrayList<typeBook> search(String s) {
		ArrayList<typeBook> arr = new ArrayList<typeBook>();
		while(arr.size() <1) {
			arr = returnArrMaLoaiSp(s);
			if(arr.size() == 0)
				arr = returnArrTenLoaiSp(s);
			if(s.length() >1)
				s = s.substring(0, s.length()-1);
			if(s.length()<=1 && arr.size() == 0)
				break;
		}
		return arr;
	}
	public ArrayList<typeBook> returnArrMaLoaiSp(String s){
		int i = s.length();
		ArrayList<typeBook> arr = new ArrayList<typeBook>();
		for(typeBook value: arrTB) {
			if(value.getIdTypeBook().compareTo("Vô danh") != 0)
				if(value.getIdTypeBook().length()>=i)
					if(value.getIdTypeBook().substring(0, i).compareTo(s) == 0)
						arr.add(value);
		}
		return arr;
	}
	public ArrayList<typeBook> returnArrTenLoaiSp(String s){
		int i = s.length();
		
		ArrayList<typeBook> arr = new ArrayList<typeBook>();
		for(typeBook value: arrTB) {
			if(value.getIdTypeBook().compareTo("Vô danh") != 0)
				if(value.getNameTypeBook().length()>=i)
				if(value.getNameTypeBook().substring(0, i).compareToIgnoreCase(s) == 0)
					arr.add(value);
		}
		return arr;
	}
}

