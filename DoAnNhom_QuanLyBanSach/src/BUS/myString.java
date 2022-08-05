package BUS;

import java.util.Random;

public class myString {
	static char arrCharLow [] = {'a','b','c','d','e','q','w','r','t','y','u','i','o','p','s','f','g','h','j','k','l','z','x','v','b','n','m',};
	static char arrCharUp[] = {'A','Q','W','E','R','T','Y','U','I','O','P','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
	// kiểm tra trong chuỗi có số
	public static boolean checkNumber(String s) {
		char arrN[] = s.toCharArray();
		for(int i = 0;i<arrN.length;i++) {
			Integer codeChar = (int) arrN[i];
			if(codeChar >= 48 && codeChar <= 57)
				return true;	
		}
		return false;
	}
	//kiểm tra trong chuỗi có chữ hoa
	public static boolean checkUpChar(String s) {
		char arrN[] = s.toCharArray();
		for(int i = 0;i<arrN.length;i++) {
			Integer codeChar = (int) arrN[i];
			if(codeChar >= 65 && codeChar <= 90)
				return true;	
		}
		return false;
	}
	//kiểm tra trong chuỗi có chữ thường
	public static boolean checkLowChar(String s) {
		char arrN[] = s.toCharArray();
		for(int i = 0;i<arrN.length;i++) {
			Integer codeChar = (int) arrN[i];
			if(codeChar >= 97 && codeChar <= 122)
				return true;	
		}
		return false;
	}
	//kiểm tra kí tự đặc biệt
	public static boolean checkSpecialChar(String s) {
		char arrN[] = s.toCharArray();
		for(int i = 0;i<arrN.length;i++) {
			Integer codeChar = (int) arrN[i];
			if(codeChar >= 1 && codeChar <= 47)
				return true;	
		}
		return false;
	}
		public static String ranDomChar() {
		Random rd = new Random();
		String s = ""; 
		s = s+ arrCharLow[rd.nextInt(25)+1] + arrCharUp[rd.nextInt(25)+1];
		return s;
		
	}
}
