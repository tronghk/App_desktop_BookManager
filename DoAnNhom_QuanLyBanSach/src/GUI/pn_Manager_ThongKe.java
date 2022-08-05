package GUI;

import javax.swing.JPanel;

public class pn_Manager_ThongKe extends JPanel {
	public pn_Manager_ThongKe() {
		this.setLayout(null);
		this.setBounds(230, 0,770, 800);
		pn_ThongKeTongQuat = new pn_ThongKe();
		pn_ChiTietThongKe = new pn_ThongKeThanhPhan();
		
		this.add(pn_ChiTietThongKe);
		this.add(pn_ThongKeTongQuat);
		pn_ChiTietThongKe.setVisible(false);
	}
	static pn_ThongKe pn_ThongKeTongQuat;
	static pn_ThongKeThanhPhan pn_ChiTietThongKe;
	
}
