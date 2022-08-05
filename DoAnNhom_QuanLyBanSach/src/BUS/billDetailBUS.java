package BUS;

import java.util.ArrayList;

import DAO.bilDetailDAO;
import DTO.bill;
import DTO.billDetail;
import GUI.menuManager;

public class billDetailBUS {
	ArrayList<billDetail> arrBillDetail = new ArrayList<billDetail>();
	private bilDetailDAO billDTDAO;
	public billDetailBUS() {
		arrBillDetail = new ArrayList<billDetail>();
		this.setBillDTDAO(new bilDetailDAO());
		arrBillDetail = billDTDAO.readBillDetail();
	}
	public bilDetailDAO getBillDTDAO() {
		return billDTDAO;
	}
	public void setBillDTDAO(bilDetailDAO billDTDAO) {
		this.billDTDAO = billDTDAO;
	}
	public ArrayList<billDetail> returnArrBillDTToBill(int bill){
		ArrayList<billDetail> arr = new ArrayList<billDetail>();
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == bill)
				arr.add(value);
		}
		return arr;
	}
	public int returnQuantityBook(int idBill) {
		int count = 0;
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == idBill)
				count = count + value.getQuantityBook();
		}
		return count;
	}
	public float returnSumPrice(int idBill) {
		float sum = 0;
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == idBill)
				sum = sum+ value.getIntoMoney();
		}
		return sum;
	}
	public String addObject(String id, String price, String name, String sumPrice,String quantity) {
		if(id.compareTo("") == 0)
			return "null";
		
		if(checkID(id))
			return "Error id";
		
		if(sumPrice.compareTo("") == 0)
			return "Error quantity";
		float sum =  Float.parseFloat(price)*Integer.parseInt(quantity);
		float intomoney = Float.parseFloat(sumPrice);
		float moneydown = sum - intomoney;
		billDetail dt = new billDetail(-1, id, Integer.parseInt(quantity),
				sum,intomoney , "1", moneydown);
		arrBillDetail.add(dt);
		return "0";
	}
	public ArrayList<billDetail> returnArrGioHang() {
		ArrayList<billDetail> arr= new ArrayList<billDetail>();
		for(billDetail value: arrBillDetail)
			if(value.getIdBill() == -1)
				arr.add(value);
		return arr;
	}
	public String modifyObject(String id, String price, String name, String sumPrice, String quantity) {
		if(sumPrice.compareTo("") == 0)
			return "Error quantity";
		if(!checkID(id))
			return "Error id";
		float sum =  Float.parseFloat(price)*Integer.parseInt(quantity);
		billDetail dt = new billDetail(-1, id, Integer.parseInt(quantity),
				sum, Float.parseFloat(sumPrice), "1", sum-Float.parseFloat(sumPrice));
		modifyObject(dt);
		return "0";
	}
	public void modifyObject(billDetail b) {
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == -1 && value.getIdBook().compareTo(b.getIdBook()) == 0) {
				value.setIntoMoney(b.getIntoMoney());
				value.setMoneyDown(b.getMoneyDown());
				value.setQuantityBook(b.getQuantityBook());
				value.setUnitPrice(b.getUnitPrice());
			}
				
		}
	}
	public boolean checkID(String idBook)
	{
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == -1 && value.getIdBook().compareTo(idBook) == 0)
				return true;
		}
		return false;
	}
	
	public String deleteObject(String id, String price, String name, String sumPrice, String quantity) {
		if(sumPrice.compareTo("") == 0)
			return "Error quantity";
		if(!checkID(id))
			return "Error id";
		float sum =  Float.parseFloat(price)*Integer.parseInt(quantity);
		billDetail dt = new billDetail(-1, id, Integer.parseInt(quantity),
				sum, Float.parseFloat(sumPrice), "1", sum-Float.parseFloat(sumPrice));
		deleteObject(dt);
		return "0";
	}
	public void deleteObject(billDetail b) {
		int i = 0;
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == -1 && value.getIdBook().compareTo(b.getIdBook()) == 0) {
				arrBillDetail.remove(i);
				break;
			}
			i++;
		}
	}
	public float sumPrice(ArrayList<billDetail> arr) {
		float sum = 0;
		for(billDetail value: arr) {
			sum = sum+value.getUnitPrice();
		}
		return sum;
	}
	
	public float sumDiscount(ArrayList<billDetail> arr) {
		float sum = 0;
		for(billDetail value: arr) {
			sum = sum+value.getMoneyDown();
		}
		return sum;
	}
	
	public float sumIntoMoney(ArrayList<billDetail> arr) {
		float sum = 0;
		for(billDetail value: arr) {
			sum = sum+value.getIntoMoney();
		}
		return sum;
	}
	public void changeBill( int idBill) {
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == -1) {
				 value.setIdBill(idBill);
				 menuManager.bookBUS.truSach(value.getIdBook(), value.getQuantityBook());
				 this.getBillDTDAO().addBillDetail(value);
			}
		}
	}
	public void deleteArr() {
		int temp = returnArrBillDTToBill(-1).size();
		while(temp>0) {
		int i = 0;
		for(billDetail value: arrBillDetail) {
			if(value.getIdBill() == -1) {
				arrBillDetail.remove(arrBillDetail.get(i));
				i = 0;
				break;
			}
			i++;
		}
		temp --;
		}
	}
	public int returnQuantityBook(ArrayList<billDetail> arr) {
		int sum = 0;
		for(billDetail value: arr) {
			sum = sum+value.getQuantityBook();
		}
		return sum;
	}
	public ArrayList<billDetail> returnArrYear(String year){
		ArrayList<bill> arrBill = menuManager.billBUS.returnArrBillYear(year);
		ArrayList<billDetail> arrCT = new ArrayList<billDetail>();
		for(bill value: arrBill) {
			for(billDetail Ct: arrBillDetail) {
				if(value.getIdBill() == Ct.getIdBill())
					arrCT.add(Ct);
					
			}
		}
		
		return arrCT;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
