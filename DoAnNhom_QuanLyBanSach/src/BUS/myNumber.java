package BUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;


public class myNumber {
	
	static String maXacNhan;
	// kiểm tra  có phải số 
	public static boolean checkIntNumber(String s) {
		try {
			String skipchar[] = s.split(".");
			String sNum = "";
			for(int i=0;i<skipchar.length;i++) {
				sNum = sNum+skipchar[i];
			}
			skipchar = sNum.split("");
			for(int i=0;i<skipchar.length;i++) {
			int num = Integer.parseInt(s);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static String randomSixNumber() {
		Random rd = new Random();
		String s = "";
		for (int i=0;i<6;i++) {
			s = s + rd.nextInt(10);
		}
		return s;
	}
	static Timer timer;
	static int countTime;
	public static void countTime() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				countTime = countTime - 1;
				if(countTime < 0) {
					maXacNhan = "";
					timer.stop();
				}
			}
		});
		timer.start();
	}
}
