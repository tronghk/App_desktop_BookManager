package BUS;

import java.util.ArrayList;
import java.util.regex.Pattern;

import DAO.bookDistributorDAO;
import DTO.bookDistributor;

public class bookDistributorBUS {
	static ArrayList<bookDistributor> arrBookDistributor = new ArrayList<bookDistributor>();
	private bookDistributorDAO distributorDAO;
	public bookDistributorBUS() {
		arrBookDistributor = new ArrayList<bookDistributor>();
		this.setDistributorDAO(new bookDistributorDAO());
		arrBookDistributor = this.getDistributorDAO().readBookDistributor();
	}
	public bookDistributorDAO getDistributorDAO() {
		return distributorDAO;
	}
	public void setDistributorDAO(bookDistributorDAO distributorDAO) {
		this.distributorDAO = distributorDAO;
	}
	public ArrayList<bookDistributor> returnArrBookDistributor() {
		return arrBookDistributor;
	}
	public String[] arrStringDistributor() {
		int size = arrBookDistributor.size();
		String []arrDistributor = new String [size];
		int i=0;
		for(bookDistributor v: arrBookDistributor) {
			arrDistributor[i] = v.getIdBookDistributor();
			i++;
		}
		return arrDistributor;
	}
	public String[] arrStringDistributorPNH() {
		int size = arrBookDistributor.size()+1;
		String []arrDistributor = new String [size];
		arrDistributor[0] = "Nhà cung cấp";
		int i=1;
		for(bookDistributor v: arrBookDistributor) {
			arrDistributor[i] = v.getIdBookDistributor();
			i++;
		}
		return arrDistributor;
	}
	public bookDistributor returnObject(String id) {
		for(bookDistributor value: arrBookDistributor)
			if(value.getIdBookDistributor().compareTo(id) == 0)
				return value;
		return null;
	}
	public ArrayList<bookDistributor> returnArrDistributor() {
		return arrBookDistributor;
	}
	public String addObject(String id, String name, String phone, String address, String mail) {
		if(checkIdObject(id) || id.compareTo("") == 0)
			return "Error id";
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		if(!checkGmail(mail))
			return "Error mail";
		bookDistributor bd = new bookDistributor(id, name, phone, address, mail);
		arrBookDistributor.add(bd);
		this.getDistributorDAO().addBookDistributor(bd);
		return "0";
	}
	public String modifyObject(String id, String name, String phone, String address, String mail) {
		if(!checkIdObject(id) || id.compareTo("") == 0)
			return "Error id";
		if(checkName(name))
			return "Error name";
		phone = myPhoneNumber.changePhoneNumber(phone);
		if(phone.length() != 10)
			return "Error phone";
		if(!checkGmail(mail))
			return "Error mail";
		bookDistributor bd = new bookDistributor(id, name, phone, address, mail);
		modifyObject(bd);
		this.getDistributorDAO().modifyBookDistributor(bd);
		return "0";
	}
	public void modifyObject( bookDistributor bd) {
		for(bookDistributor value: arrBookDistributor) {
			if(value.getIdBookDistributor().compareTo(bd.getIdBookDistributor()) ==0) {
				value.setAddressDistributor(bd.getAddressDistributor());
				value.setEmail(bd.getEmail());
				value.setNameDistributor(bd.getNameDistributor());
				value.setPhoneNumber(bd.getPhoneNumber());
			}
		}
	}
	public boolean checkIdObject(String id) {
		for(bookDistributor value: arrBookDistributor) {
			if(value.getIdBookDistributor().compareTo(id) == 0)
				return true;
		}
		return false;
	}
	public boolean checkName(String name)
	{
		return name.compareTo("") == 0;
	}
	public boolean checkGmail(String user) {
		Pattern s = Pattern.compile("^[a-zA-Z][a-zA-Z0-9.]+@[a-zA-Z](.[a-zA-z]+){1,3}$");
		if(s.matcher(user).find())
			return true;
		return false;
	}
	
	public ArrayList<bookDistributor> searchBookDistributor(String s) {
		ArrayList<bookDistributor> arr = new ArrayList<bookDistributor>();
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
	public ArrayList<bookDistributor> searchId(String s){
		
		ArrayList<bookDistributor> arr = new ArrayList<bookDistributor>();
		int  i = s.length();
		for(bookDistributor value: arrBookDistributor) {
			if(value.getIdBookDistributor().compareTo("") == 0)
				continue;
			if(value.getIdBookDistributor().length() >= i)
			if(value.getIdBookDistributor().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<bookDistributor> searchName(String s){
		int  i = s.length();
		ArrayList<bookDistributor> arr = new ArrayList<bookDistributor>();
		for(bookDistributor value: arrBookDistributor) {
			if(value.getIdBookDistributor().compareTo("") == 0)
				continue;
			if(value.getNameDistributor().length() >= i)
			if(value.getNameDistributor().substring(0, i).compareToIgnoreCase(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<bookDistributor> searchPhone(String s){
		int  i = s.length();
		ArrayList<bookDistributor> arr = new ArrayList<bookDistributor>();
		for(bookDistributor value: arrBookDistributor) {
			if(value.getIdBookDistributor().compareTo("") == 0)
				continue;
			if(value.getPhoneNumber().length() >= i)
			if(value.getPhoneNumber().substring(0, i).compareTo(s) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<bookDistributor> searchType(String s){
		int  i = s.length();
		ArrayList<bookDistributor> arr = new ArrayList<bookDistributor>();
		for(bookDistributor value: arrBookDistributor) {
			if(value.getIdBookDistributor().compareTo("") == 0)
				continue;
			if(value.getEmail().length() >= i)
			if(value.getEmail().substring(0, i).compareToIgnoreCase(s) == 0)
				arr.add(value);
		}
		return arr;
	}
}
