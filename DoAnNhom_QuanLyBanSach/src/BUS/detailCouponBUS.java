package BUS;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.detailCouponDAO;
import DTO.detailCoupon;
import GUI.menuManager;

public class detailCouponBUS {
	static ArrayList<detailCoupon> arrDetailCoupon = new ArrayList<detailCoupon>();
	detailCouponDAO datailCouponDAO;
	public detailCouponBUS() {
		arrDetailCoupon = new ArrayList<detailCoupon>();
		this.setDatailCouponDAO(new detailCouponDAO());
		arrDetailCoupon = this.getDatailCouponDAO().readDetailCoupon();
	}
	public detailCouponDAO getDatailCouponDAO() {
		return datailCouponDAO;
	}
	public void setDatailCouponDAO(detailCouponDAO datailCouponDAO) {
		this.datailCouponDAO = datailCouponDAO;
	}
	public ArrayList<detailCoupon> returnArrSomeCoupon(int id) {
		ArrayList<detailCoupon> arrDTCoupon = new ArrayList<detailCoupon>();
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdCoupon() == id)
				arrDTCoupon.add(value);
		}
		return arrDTCoupon;
	}
	public String addObject(String idBook, String idCoupon, String price, String sumPrice, String quantity) {
		if(idBook.compareTo("") == 0)
			return "Error";
		if(menuManager.bookBUS.checkQuantity(quantity).compareTo("0")!= 0)
			return "Error quantity";
		if(menuManager.bookBUS.checkPrice(sumPrice).compareTo("0")!= 0)
			return "Error price";
		if(checkDuplicateID(idBook))
			return "Error duplicate";
		detailCoupon c = new detailCoupon(idBook, -1, Integer.parseInt(quantity), Float.parseFloat(price), Float.parseFloat(sumPrice));
		arrDetailCoupon.add(c);
		return "0";
			
	}
	
	public String modifyObject(String idBook, String idCoupon, String price, String sumPrice, String quantity) {
		if(idBook.compareTo("") == 0)
			return "Error";
		if(menuManager.bookBUS.checkQuantity(quantity).compareTo("0")!= 0)
			return "Error quantity";
		if(menuManager.bookBUS.checkPrice(sumPrice).compareTo("0")!= 0)
			return "Error price";
		if(!checkDuplicateID(idBook))
			return "Error duplicate";
		detailCoupon c = new detailCoupon(idBook, -1, Integer.parseInt(quantity), Float.parseFloat(price), Float.parseFloat(sumPrice));
		modifyObject(c);
		return "0";
			
	}
	public void modifyObject(detailCoupon dt) {
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdBook().compareTo(dt.getIdBook()) ==0 && value.getIdCoupon() == -1)
			{
				value.setQuantityImport(dt.getQuantityImport());
				value.setUnitPrice(dt.getUnitPrice());
				value.setIntoMoney(dt.getIntoMoney());
				break;
			}
		}
	}
	public String deleteObject(String idBook, String idCoupon, String price, String sumPrice, String quantity) {
		if(idBook.compareTo("") == 0)
			return "Error";
		if(menuManager.bookBUS.checkQuantity(quantity).compareTo("0")!= 0)
			return "Error quantity";
		if(menuManager.bookBUS.checkPrice(sumPrice).compareTo("0")!= 0)
			return "Error price";
		if(!checkDuplicateID(idBook))
			return "Error duplicate";
		detailCoupon c = new detailCoupon(idBook, -1, Integer.parseInt(quantity), Float.parseFloat(price), Float.parseFloat(sumPrice));
		deleteObject(c);
		return "0";
			
	}
	public void deleteObject(detailCoupon dt) {
		int i = 0;
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdBook().compareTo(dt.getIdBook()) ==0 && value.getIdCoupon() == -1)
			{
				arrDetailCoupon.remove(arrDetailCoupon.get(i));
				break;
			}
			i++;
		}
	}
	public boolean checkDuplicateID(String id) {
		for(detailCoupon value: arrDetailCoupon) {
			
			if(value.getIdBook().compareTo(id) == 0 && value.getIdCoupon() == -1)
				return true;
		}
		return false;
	}
	public ArrayList<detailCoupon> returnArrCTCreate(int idCoupon) {
		ArrayList<detailCoupon> arr = new ArrayList<detailCoupon>();
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdCoupon() == idCoupon)
				arr.add(value);
			
		}
		return arr;
	}
	public String returnSumPrice(String donGia, String SoLuong) {
		try {
			int quantity = Integer.parseInt(SoLuong);
			Float unitPrice = Float.parseFloat(donGia);
			return ""+(quantity*unitPrice);
		}catch(Exception ex) {
			
		}
		return "";
	}
	public Float sumPrice(int id) {
		float sum = 0;
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdCoupon()==id)
				sum += value.getIntoMoney();
		}
		return sum;
	}
	public void changeIDCT(int idCoupon) {
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdCoupon() == -1) {
				value.setIdCoupon(idCoupon);
				menuManager.bookBUS.congThemSach(value.getIdBook(), value.getQuantityImport());
				menuManager.bookBUS.addQuantityBook(value.getIdBook(), value.getQuantityImport());
			}
		}
	}
	
	public void addDTCoupon(int id) {
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdCoupon() == id)
				this.getDatailCouponDAO().addDetailCoupon(value);
		}
	}
	public ArrayList<detailCoupon> returnArrCTPNH (int id) {
		ArrayList<detailCoupon> arr = new ArrayList<detailCoupon>();
		for(detailCoupon value: arrDetailCoupon) {
			if(value.getIdCoupon() == id)
				arr.add(value);
		}
		return arr;
	}
	public void eventXuatFileExcel(int id) {	
		try {
			XSSFWorkbook wordBook = new XSSFWorkbook();
			XSSFSheet sheet = wordBook.createSheet("PhieuNhapHang");
			XSSFRow row = null;
			Cell cell = null;
			row = sheet.createRow(3);
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("DANH SÁCH CHI TIẾT PHIẾU NHẬP HÀNG");
			
			row = sheet.createRow(4);
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("STT");
			
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Tên sách");
			
			cell = row.createCell(3,CellType.STRING);
			cell.setCellValue("Số lượng");
			
			cell= row.createCell(4, CellType.STRING);
			cell.setCellValue("Đơn giá");
			
			cell= row.createCell(5, CellType.STRING);
			cell.setCellValue("Thành tiền");
			
			ArrayList<detailCoupon> arr = returnArrCTCreate(id);
			for(int i=0;i<arr.size();i++) {
				row = sheet.createRow(5+i);
				
				cell = row.createCell(1, CellType.NUMERIC);
				cell.setCellValue(i+1);
				
				cell = row.createCell(2, CellType.STRING);

				cell.setCellValue(arr.get(i).getIdBook());
				
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(arr.get(i).getQuantityImport());
				
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue(arr.get(i).getUnitPrice());
				
				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue(arr.get(i).getIntoMoney());
			}
			// save file
			File f = new File("fileExcel//PhieuNhapHang_"+arr.get(0).getIdCoupon()+".xlsx");
			FileOutputStream fis = new FileOutputStream(f);
			wordBook.write(fis);
			fis.close();
			wordBook.close();
		}catch(Exception e) {
			System.out.println("Lỗi all");
		}
		
	}
}
