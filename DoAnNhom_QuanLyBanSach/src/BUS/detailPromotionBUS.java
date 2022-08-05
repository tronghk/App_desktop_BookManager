package BUS;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.detailPromotionDAO;
import DTO.detailPromotion;
import DTO.promotion;
import GUI.menuManager;

public class detailPromotionBUS {
	static ArrayList<detailPromotion> arrDetailPromotion = new ArrayList<detailPromotion>();
	detailPromotionDAO DTPromotionDAO ;
	public detailPromotionBUS() {
		this.setDTPromotionDAO(new detailPromotionDAO());
		arrDetailPromotion = this.getDTPromotionDAO().readDetailPromotion();
		
	}
	public detailPromotionDAO getDTPromotionDAO() {
		return DTPromotionDAO;
	}
	public void setDTPromotionDAO(detailPromotionDAO dTPromotionDAO) {
		DTPromotionDAO = dTPromotionDAO;
	}
	public ArrayList<detailPromotion> returnArrDTPromotion() {
		return arrDetailPromotion;
	}
	public void eventXuatFileExcel(String id) {	
		try {
			XSSFWorkbook wordBook = new XSSFWorkbook();
			XSSFSheet sheet = wordBook.createSheet("ChuongTrinhKhuyenMai");
			XSSFRow row = null;
			Cell cell = null;
			row = sheet.createRow(3);
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("DANH SÁCH CHI TIẾT KHUYẾN MÃI");
			
			row = sheet.createRow(4);
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("STT");
			
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Mã sách khuyến mãi");
			
			cell = row.createCell(3,CellType.STRING);
			cell.setCellValue("Chiết khấu");
			
			ArrayList<detailPromotion> arr = returnArrCTPromotion(id+"");
			for(int i=0;i<arr.size();i++) {
				row = sheet.createRow(5+i);
				
				cell = row.createCell(1, CellType.NUMERIC);
				cell.setCellValue(i+1);
				
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(arr.get(i).getIdBook());
				
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(arr.get(i).getDiscount()+"%");
			}
			// save file
			File f = new File("fileExcel\\KhuyenMai\\KhuyenMai_"+arr.get(0).getIdPromotion()+".xlsx");
			FileOutputStream fis = new FileOutputStream(f);
			wordBook.write(fis);
			fis.close();
			wordBook.close();
		}catch(Exception e) {
			System.out.println("Lỗi all");
		}
		
	}
	public ArrayList<detailPromotion> returnArrCTPromotion(String id) {
		ArrayList<detailPromotion> arr =new ArrayList<detailPromotion>();
		for(detailPromotion value: arrDetailPromotion) {
			if(value.getIdPromotion().compareTo(id) == 0)
				arr.add(value);
		}
		return arr;
	}
	public String addObject(String idBook,String idP, String discount) {
		if(!checkInt(discount))
			return "Error discount";
		if(checkDuplicate(idBook))
			return "Error duplicate";
		detailPromotion dt = new detailPromotion(idBook, "-1", Integer.parseInt(discount));
		arrDetailPromotion.add(dt);
		return "0";
		
	}
	
	public String modifyObject(String idBook,String idP, String discount) {
		if(!checkInt(discount))
			return "Error discount";
		if(!checkDuplicate(idBook))
			return "Error duplicate";
		detailPromotion dt = new detailPromotion(idBook, "-1", Integer.parseInt(discount));
		modifyObject(dt);
		return "0";
		
	}
	public String deleteObject(String idBook,String idP, String discount) {
		if(!checkInt(discount))
			return "Error discount";
		if(!checkDuplicate(idBook))
			return "Error duplicate";
		detailPromotion dt = new detailPromotion(idBook, "-1", Integer.parseInt(discount));
		deleteObject(dt);
		return "0";
		
	}
	public void modifyObject(detailPromotion dt) {
		for(detailPromotion value: arrDetailPromotion)
		{
			if(value.getIdBook().compareTo(dt.getIdBook()) == 0 && value.getIdPromotion().compareTo("-1") == 0)
				value.setDiscount(dt.getDiscount());
		}
	}
	public void deleteObject(detailPromotion dt) {
		int i = 0;
		for(detailPromotion value: arrDetailPromotion)
		{
			if(value.getIdBook().compareTo(value.getIdBook()) == 0 && value.getIdPromotion().compareTo("-1") == 0) {
				arrDetailPromotion.remove(i);
				break;
			}
			i++;
		}
	}
	public boolean checkInt(String discount) {
		try {
			int i = Integer.parseInt(discount);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	public boolean checkDuplicate(String id) {
		for(detailPromotion value: arrDetailPromotion) {
			if(value.getIdBook().compareTo(id) == 0 && value.getIdPromotion().compareTo("-1") == 0)
				return true;
		}
		return false;
	}
	public void changeId(String id) {
		for(detailPromotion value: arrDetailPromotion) {
			if(value.getIdPromotion().compareTo("-1") == 0)
				value.setIdPromotion(id);
		}
	}
	public void addDTPromotion(String id) {
		for(detailPromotion value: arrDetailPromotion) {
			if(value.getIdPromotion().compareTo(id) == 0)
				this.getDTPromotionDAO().addDetailPromotion(value);
		}
	}
	public void deleteCT() {
		try {
			int i = 0;
			for(detailPromotion value: arrDetailPromotion) {
				if(value.getIdPromotion().compareTo("-1") == 0)
					arrDetailPromotion.remove(arrDetailPromotion.get(i));
				i++;
			}
		}catch(Exception ex) {
			
		}
	}
	public int checkProduct() {
		int count = 0;
		for(detailPromotion value: arrDetailPromotion) {
			if(value.getIdPromotion().compareTo("-1") == 0)
				count++;
			
		}
		return count;
	}
	public ArrayList<detailPromotion> GiamGia(){
		ArrayList<promotion> arr = menuManager.promotionBUS.returnArrChuongTrinh();
		ArrayList<detailPromotion> arrDT = new ArrayList<detailPromotion>();
		for(promotion value: arr)
			for(detailPromotion value1: arrDetailPromotion) {
				if(value1.getIdPromotion().compareTo(value.getIdPromotion()) == 0)
					arrDT.add(value1);
			}
		return arrDT;
	}
	public String checkGiamGia(String idBook) {
		ArrayList<detailPromotion> arr = GiamGia();
		for(detailPromotion value : arr) {
			if(value.getIdBook().compareTo(idBook) == 0)
				return value.getDiscount()+"%";
		}
		return null;
	}
}
