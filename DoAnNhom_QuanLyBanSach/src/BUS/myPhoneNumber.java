package BUS;

public class myPhoneNumber {
	static String arrPhone[] = {"0162", "0163", "0164"," 0165", "0166", "0167", "0168", "0169",
			"0123", "0124", "0125", "0127", "0129", "0120", "0121", "0122", "0126", "0128", "0186", "0199"};
	static String arrNewPhone[] = {"032","033","034","035","036","037", "038","039","083","084","085","081","082",
			"070","079","077","076","078","058","059"};
	static String arrAllFirstnumPhone [] = {"032","033","034","052","035","036","037", "038","039","083","084","085","081","082",
			"070","079","077","076","078","058","059","089","090","093","092","056","088","091","094","086","097","096","098"};
	// chuyển đổi 11 thành 10 số
	public static String changePhoneNumber(String sNum) {
			if(sNum.compareTo("") == 0)
				return "-1";
			String arrNum[] = sNum.split("");
			for(int i=0;i<arrNum.length;i++) {        // kiểm tra có phải số
				if(!checkNumber(arrNum[i]))
					return "Error";
			}
			if(arrNum.length > 11 || arrNum.length <10)   // độ dài chuỗi hơn hoặc ít hơn yêu cầu
				return "Not PhoneNumber";
			String newPhone = changeNumber(sNum)+"";
			if(sNum.compareToIgnoreCase(newPhone)==0 && !checkPhoneNumber(sNum)) // nếu đầu số như cũ và không có trong tất cả đầu số mới
				return "Error Phone";
			else
				return newPhone;
	}
	// kiểm tra có phải số
	public static boolean checkNumber(String s) {
		try {
			int num = Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static String changeNumber(String sNum) {
		String fourNumFirst = sNum.substring(0, 4);
		System.out.println(fourNumFirst);
		for(int i=0;i<arrPhone.length;i++) {
			if(arrPhone[i].compareToIgnoreCase(fourNumFirst)==0)
				sNum = arrNewPhone[i] + sNum.substring(4);
		}
		return sNum;
	}
	public static boolean checkPhoneNumber(String sNum) {
		if(sNum.length() == 11)
			return false;
		String treeFirstNum = sNum.substring(0,3);
		for(int i=0;i<arrAllFirstnumPhone.length;i++)
			if(arrAllFirstnumPhone[i].compareToIgnoreCase(treeFirstNum) == 0)
				return true;
		return false;
	}
}
