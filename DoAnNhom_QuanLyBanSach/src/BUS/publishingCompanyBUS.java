package BUS;

import java.util.ArrayList;

import DTO.publishingCompany;
import DAO.publishingCompanyDAO;

public class publishingCompanyBUS {
	static ArrayList<publishingCompany> arrPC;
	private publishingCompanyDAO publishingCompany;
	
	public publishingCompanyBUS() {
		super();
		arrPC = new ArrayList<publishingCompany>();
		this.setPublishingCompany(new publishingCompanyDAO());
		arrPC = this.getPublishingCompany().readPublishingCompany();
	}
	public publishingCompanyDAO getPublishingCompany() {
		return publishingCompany;
	}
	public void setPublishingCompany(publishingCompanyDAO publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	// trả về mảng string loại sách
	public String[] arrStringCPN() {
		int size = arrPC.size();
		String []arrCPN = new String [size];
		int i=0;
		for(publishingCompany v: arrPC) {
			arrCPN[i] = v.getIdPublishingCompany();
			i++;
		}
		return arrCPN;
	}
	public int indexPublishing(String id) {
		int i=0;
		for(publishingCompany value: publishingCompanyBUS.arrPC) {
			if(value.getIdPublishingCompany().compareToIgnoreCase(id) == 0)
				break;
			i = i+1;
		}
		return i;
	}
	public ArrayList<publishingCompany> returnArrPublishingCPN(){
		return arrPC;
	}
	public boolean checkDuplicateTypeBook(String id) {
		for(publishingCompany tb: arrPC) {
			if(tb.getIdPublishingCompany().compareTo(id) == 0)
				return true;
		}
		return false;
	}
	public String addObject(String id, String name) {
		if(checkDuplicateTypeBook(id) || id.compareTo("") == 0)
			return "Error id";
		if(name.compareTo("") == 0)
			return "Error name";
		publishingCompany p = new publishingCompany(id, name);
		arrPC.add(p);
		this.getPublishingCompany().addPublishingCompany(p);
		return "0";
	}
	public String modifyObject(String id, String name) {
		if(name.compareTo("") == 0)
			return "Error name";
		publishingCompany p = new publishingCompany(id, name);
		modify(p);
		this.getPublishingCompany().modifyPublishingCompany(p);
		return "0";
	}
	public void modify(publishingCompany p) {
		for(publishingCompany value: arrPC)
			if(value.getIdPublishingCompany().compareTo(p.getIdPublishingCompany()) == 0) {
				value.setNamePublishingCompany(p.getNamePublishingCompany());
				break;
			}
	}
	public ArrayList<publishingCompany> arrSearch(String s){
		ArrayList<publishingCompany> arrBookSearch = new ArrayList<publishingCompany>();
		arrBookSearch = search(s);
		return arrBookSearch;
	}
	public ArrayList<publishingCompany> search(String s) {
		ArrayList<publishingCompany> arr = new ArrayList<publishingCompany>();
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
	public ArrayList<publishingCompany> returnArrMaLoaiSp(String s){
		int i = s.length();
		ArrayList<publishingCompany> arr = new ArrayList<publishingCompany>();
		for(publishingCompany value: arrPC) {
				if(value.getIdPublishingCompany().length()>=i)
					if(value.getIdPublishingCompany().substring(0, i).compareTo(s) == 0)
						arr.add(value);
		}
		return arr;
	}
	public ArrayList<publishingCompany> returnArrTenLoaiSp(String s){
		int i = s.length();
		
		ArrayList<publishingCompany> arr = new ArrayList<publishingCompany>();
		for(publishingCompany value: arrPC) {
			if(value.getIdPublishingCompany().compareTo("Vô danh") != 0)
				if(value.getNamePublishingCompany().length()>=i)
				if(value.getNamePublishingCompany().substring(0, i).compareToIgnoreCase(s) == 0)
					arr.add(value);
		}
		return arr;
	}
}
