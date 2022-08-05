package BUS;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.billDAO;
import DTO.bill;
import DTO.billDetail;
import DTO.detailCoupon;
import GUI.menuManager;

public class billBUS {
	ArrayList<bill> arrBill = new ArrayList<bill>();
	private billDAO billDAO;
	static bill bill = new bill();
	public billBUS() {
		arrBill = new ArrayList<bill>();
		this.setBill(new billDAO());
		arrBill = this.getBill().readBil();
		
	}
	public billDAO getBill() {
		return billDAO;
	}
	public void setBill(billDAO bill) {
		this.billDAO = bill;
	}
	
	public float sumPrice(String idCustomer) {
		float sum = 0;
		for(bill value: arrBill) {
			if(value.getIdCustomer().compareToIgnoreCase(idCustomer) == 0)
				sum = sum + value.getMoneyPayment();
		}
		return sum;
	}
	public ArrayList<bill> returnArrBillCustomer(String idKH){
		ArrayList<bill> arr = new ArrayList<bill>();
		for(bill value: arrBill) {
			if(value.getIdCustomer().compareTo(idKH) == 0)
				arr.add(value);
		}
		return arr;
	}
	public ArrayList<bill> arrBill(){
		return arrBill;
	}
	public ArrayList<bill> returnArrBillEmployee(String idNV){
		ArrayList<bill> arr = new ArrayList<bill>();
		for(bill value: arrBill) {
			if(value.getIdEmployee().compareTo(idNV) == 0)
				arr.add(value);
		}
		return arr;
	}
	public bill returnOBStaticBill() {
		return this.bill;
	}
	public void createObject(int idBill) {
		
		for(bill value: arrBill) {
			if(value.getIdBill() == idBill) {
				bill = value;
				break;
			}
		}
	}
	public boolean KiemTraThanhToan(int idBill) {
		for(bill value: arrBill) {
			if(value.getIdBill() == idBill)
				if(value.getStatus().compareToIgnoreCase("Đã thanh toán")== 0)
					return true;
			
		}
		return false;
	}
	public void deleteCustomer(String id) {
		for(bill value: arrBill) {
			if(value.getIdCustomer().compareTo(id) == 0)
			{
				value.setIdCustomer("");
				this.getBill().modifyBill(value);
			}
		}
	}
	// tính tổng tiền các hóa đơn trong tháng của kh
	public String tinhTongTienKH(String id) {
		float sum = 0;
		String date = LocalDate.now().toString();
		String sDate[] = date.split("-");
		for(bill value: arrBill) {
			if(value.getIdCustomer().compareTo(id) == 0)
			if(value.getDateBill().getMonthValue() == Integer.parseInt(sDate[1]) &&
					value.getDateBill().getYear() == Integer.parseInt(sDate[0]))
			{
				sum = sum + value.getMoneyPayment();
			}
				
		}
		return id + "-" + sum;
	}
	public String tinhTongTienEmployee(String id) {
		float sum = 0;
		String date = LocalDate.now().toString();
		String sDate[] = date.split("-");
		for(bill value: arrBill) {
			if(value.getIdEmployee().compareTo(id) == 0)
			if(value.getDateBill().getMonthValue() == Integer.parseInt(sDate[1]) &&
					value.getDateBill().getYear() == Integer.parseInt(sDate[0]))
			{
				sum = sum + value.getMoneyPayment();
			}
				
		}
		return id + "-" + sum;
	}
	public int truyXuatTongSoHoaDonEm(String id) {
		int count = 0;
		String date = LocalDate.now().toString();
		String sDate[] = date.split("-");
		for(bill value: arrBill) {
			if(value.getIdEmployee().compareTo(id) == 0)
				if(value.getDateBill().getMonthValue() == Integer.parseInt(sDate[1]) &&
				value.getDateBill().getYear() == Integer.parseInt(sDate[0]))
					count++;
				
		}
		return count;
	}
	public int truyXuatTongSoHoaDon (String id) {
		int count = 0;
		String date = LocalDate.now().toString();
		String sDate[] = date.split("-");
		for(bill value: arrBill) {
			if(value.getIdCustomer().compareTo(id) == 0)
				if(value.getDateBill().getMonthValue() == Integer.parseInt(sDate[1]) &&
				value.getDateBill().getYear() == Integer.parseInt(sDate[0]))
					count++;
				
		}
		return count;
	}
	public String thanhTien(String id, String quantity, String discount) {
		if(!checkNumber(quantity))
			return "";
			
		Float price = menuManager.bookBUS.returnUnitprice(id);
		if(discount.compareTo("")!= 0) {
			return ""+((price - (float)price*Integer.parseInt(discount)/100)*Integer.parseInt(quantity));
		}else
			return ""+(float)price*Integer.parseInt(quantity);	
	}
	public String thanhTien(String id, String discount) {
		Float price = menuManager.bookBUS.returnUnitprice(id);
		Float dis;
		if(discount.compareTo("") !=0) {
			dis = price*Integer.parseInt(discount);
			dis = (float)dis/100;
		}else
			dis = (float)0;
			return ""+(price - dis);
	}
	public boolean checkNumber(String quantity) {
		try{
			int  i = Integer.parseInt(quantity);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	public String createBill() {
		ArrayList<billDetail> arr = menuManager.billDTBUS.returnArrBillDTToBill(-1);
		if(arr.size() == 0)
			return "Error bill";
		int id = returnTopBill();
		String idEm = userBUS.userLogin.getUsers();
		LocalDate date = LocalDate.now();
		float unitPrice = menuManager.billDTBUS.sumPrice(arr);
		float moneyDown = menuManager.billDTBUS.sumDiscount(arr);
		float intoMoney = menuManager.billDTBUS.sumIntoMoney(arr);
		
		bill b = new bill(id, "", idEm, date, unitPrice, moneyDown, intoMoney, "", "Chưa thanh toán");
		arrBill.add(b);
		this.getBill().addBill(b);
		menuManager.billDTBUS.changeBill(id);
		menuManager.emBUS.tangDonHang(idEm);
		return id+"";
	}
	public int returnTopBill() {
		int i = 0;
		for(bill value: arrBill) {
			if(value.getIdBill()> i)
				i = value.getIdBill();
		}
		return i+1;
	}
	public ArrayList<bill> eventSearch(String text) {
		ArrayList<bill> arr = new ArrayList<bill>();
		while(arr.size() <1)
		{
			arr = searchID(text);
			if(arr.size() == 0)
				arr = searchIDKH(text);
			if(arr.size() == 0)
				arr = searchIDNV(text);
			if(arr.size() == 0)
				arr = searchSum(text);
			if(arr.size() == 0)
				arr = searchSumMoney(text);
			if(arr.size() == 0)
				arr = searchDownMoney(text);
			if(arr.size() == 0)
				arr = searchStatus(text);
			if(text.length() > 1)
				text = text.substring(0, text.length()-1);
			else
				break;
		}
		return arr;
	}
	public ArrayList<bill> searchID(String s) {
		int i = s.length();
			ArrayList<bill> arr = new ArrayList<bill>();
			for(bill value: arrBill) {
				String id = value.getIdBill()+"";
				if(id.length() >= i) {
					if(id.substring(0, i).compareTo(s) == 0)
						arr.add(value);
				}
			}
			return arr;
	}
	public ArrayList<bill> searchIDKH(String s) {
		int i = s.length();
			ArrayList<bill> arr = new ArrayList<bill>();
			for(bill value: arrBill) {
				if(value.getIdCustomer().length() >=i) {
					if(value.getIdCustomer().substring(0, i).compareTo(s) == 0)
						arr.add(value);
				}
			}
			return arr;
	}
	public ArrayList<bill> searchIDNV(String s) {
		int i = s.length();
			ArrayList<bill> arr = new ArrayList<bill>();
			for(bill value: arrBill) {
				if(value.getIdEmployee().length() >=i) {
					if(value.getIdEmployee().substring(0, i).compareTo(s) == 0)
						arr.add(value);
				}
			}
			return arr;
	}
	public ArrayList<bill> searchSumMoney(String s) {
		int i = s.length();
			ArrayList<bill> arr = new ArrayList<bill>();
			for(bill value: arrBill) {
				String sSum = value.getMoneyPayment()+"";
				if(sSum.length() >=i) {
					if(sSum.substring(0, i).compareTo(s) == 0)
						arr.add(value);
				}
			}
			return arr;
	}
	public ArrayList<bill> searchDownMoney(String s) {
		int i = s.length();
			ArrayList<bill> arr = new ArrayList<bill>();
			for(bill value: arrBill) {
				String sSum = value.getDiscountMoney()+"";
				if(sSum.length() >=i) {
					if(sSum.substring(0, i).compareTo(s) == 0)
						arr.add(value);
				}
			}
			return arr;
	}
	public ArrayList<bill> searchSum(String s) {
		int i = s.length();
			ArrayList<bill> arr = new ArrayList<bill>();
			for(bill value: arrBill) {
				String sSum = value.getSumMoney()+"";
				if(sSum.length() >=i) {
					if(sSum.substring(0, i).compareTo(s) == 0)
						arr.add(value);
				}
			}
			return arr;
	}
	public ArrayList<bill> searchStatus(String s) {
		int i = s.length();
			ArrayList<bill> arr = new ArrayList<bill>();
			for(bill value: arrBill) {
				if(value.getStatus().length() >=i) {
					if(value.getStatus().substring(0, i).compareTo(s) == 0)
						arr.add(value);
				}
			}
			return arr;
	}

	public void eventXuatFileExcel(int id, String discount) {	
		try {
			XSSFWorkbook wordBook = new XSSFWorkbook();
			XSSFSheet sheet = wordBook.createSheet("HoaDon");
			XSSFRow row = null;
			Cell cell = null;
			row = sheet.createRow(3);
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue("HÓA ĐƠN");
			
			row = sheet.createRow(4);
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("STT");
			
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Tên sản phẩm");
			
			cell = row.createCell(3,CellType.STRING);
			cell.setCellValue("Số lượng mua");
			
			cell= row.createCell(4, CellType.STRING);
			cell.setCellValue("Đơn giá");
			
			cell= row.createCell(5, CellType.STRING);
			cell.setCellValue("Giá đã giảm");
			
			
			cell= row.createCell(6, CellType.STRING);
			cell.setCellValue("Thành tiền");
			
			ArrayList<billDetail> arr = menuManager.billDTBUS.returnArrBillDTToBill(id);
			for(int i=0;i<arr.size();i++) {
				row = sheet.createRow(5+i);
				
				cell = row.createCell(1, CellType.NUMERIC);
				cell.setCellValue(i+1);
				
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(menuManager.bookBUS.returnNameBook(arr.get(i).getIdBook()));
				
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(arr.get(i).getQuantityBook());
				
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue((float)(arr.get(i).getUnitPrice()/arr.get(i).getQuantityBook())+"");
				
				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue((float)((arr.get(i).getUnitPrice()-arr.get(i).getMoneyDown())/arr.get(i).getQuantityBook())+"");
				
				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue(arr.get(i).getIntoMoney());
			}
			row = sheet.createRow(5+arr.size());
			cell = row.createCell(3,CellType.STRING);
			cell.setCellValue("Tổng số lượng");
			
			cell = row.createCell(3,CellType.STRING);
			cell.setCellValue("Tiền phải trả");
			
			row = sheet.createRow(5+arr.size()+1);
			cell = row.createCell(3,CellType.STRING);
			cell.setCellValue(menuManager.billDTBUS.returnQuantityBook(arr)+"");
			
			float sum = menuManager.billDTBUS.returnSumPrice(id);
			if(discount.compareTo("") != 0)
				sum = sum - ((float)sum*Integer.parseInt(discount)/100);
			
			cell = row.createCell(3,CellType.STRING);
			cell.setCellValue(sum+"");
			// save file
			File f = new File("fileExcel//HoaDon//HoaDon_"+arr.get(0).getIdBill()+".xlsx");
			FileOutputStream fis = new FileOutputStream(f);
			wordBook.write(fis);
			fis.close();
			wordBook.close();
		}catch(Exception e) {
		}
		
	}
	public void changeIdKH(String idKH, String idBill) {
		for(bill value: arrBill) {
			if(value.getIdBill() == Integer.parseInt(idBill)) {
				value.setIdCustomer(idKH);
				value.setStatus("Đã thanh toán");
				this.getBill().modifyBill(value);
			}
		}
	}
	public double sumPriceYear(String Year) {
		 double sum = 0;
		for(bill value: arrBill) {
			LocalDate date = value.getDateBill();
			String sDate[] = date.toString().split("-");
			if(sDate[0].compareTo(Year) == 0)
				sum = sum+value.getMoneyPayment();
		}
		System.out.println(sum);
		return sum;
	}
	public float sumQuiOne(String year) {
		float sum = 0;
		for(bill value: arrBill) {
			LocalDate date = value.getDateBill();
			String sDate[] = date.toString().split("-");
			if(sDate[0].compareTo(year) == 0)
				if(sDate[1].compareTo("01") == 0 ||sDate[1].compareTo("03") == 0 ||sDate[1].compareTo("02") == 0)
					sum = sum+value.getMoneyPayment();
		}
		return sum;
	}
	public float sumQuiTrue(String year) {
		float sum = 0;
		for(bill value: arrBill) {
			LocalDate date = value.getDateBill();
			String sDate[] = date.toString().split("-");
			if(sDate[0].compareTo(year) == 0)
				if(sDate[1].compareTo("04") == 0 ||sDate[1].compareTo("05") == 0 ||sDate[1].compareTo("06") == 0)
					sum = sum+value.getMoneyPayment();
		}
		return sum;
	}
	public float sumQuiThree(String year) {
		float sum = 0;
		for(bill value: arrBill) {
			LocalDate date = value.getDateBill();
			String sDate[] = date.toString().split("-");
			if(sDate[0].compareTo(year) == 0)
				if(sDate[1].compareTo("07") == 0 ||sDate[1].compareTo("08") == 0 ||sDate[1].compareTo("09") == 0)
					sum = sum+value.getMoneyPayment();
		}
		return sum;
	}
	public float sumQuiFour(String year) {
		float sum = 0;
		for(bill value: arrBill) {
			LocalDate date = value.getDateBill();
			String sDate[] = date.toString().split("-");
			if(sDate[0].compareTo(year) == 0)
				if(sDate[1].compareTo("10") == 0 ||sDate[1].compareTo("11") == 0 ||sDate[1].compareTo("12") == 0)
					sum = sum+value.getMoneyPayment();
		}
		return sum;
	}
	
	//tìm tất cả hóa đơn trong năm 
	public ArrayList<bill> returnArrBillYear(String year){
		ArrayList<bill> arr = new ArrayList<bill>();
		for(bill value: arrBill) {
			String date[] = value.getDateBill().toString().split("-");
			if(date[0].compareTo(year) == 0)
				arr.add(value);
		}
		return arr;
	}
	public String [] returnDoanhThuTungThang(String year) {
		String [] arr = {"01", "02", "03","04","05","06","07","08","09","10","11","12"};
		float sum = 0;
		for(int i = 0;i<12;i++) {
			for(bill value: arrBill) {
				LocalDate date = value.getDateBill();
				String sDate[] = date.toString().split("-");
				if(sDate[0].compareTo(year) == 0 && sDate[1].compareTo(arr[i]) == 0)
						sum = sum+value.getMoneyPayment();
			}
			arr[i] = arr[i] + "-"+sum;
			sum = 0;
		}
		return arr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
