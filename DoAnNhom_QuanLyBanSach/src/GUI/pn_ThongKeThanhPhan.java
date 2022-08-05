package GUI;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class pn_ThongKeThanhPhan extends JPanel {
	public pn_ThongKeThanhPhan() {
		this.setLayout(null);
		this.setBounds(0, 0,770, 800);
		khoiTao();
		thietLap();
		event();
	}
	private JTable tb_TopSanPham;
	private JScrollPane scroll;
	private JLabel txt_TieuDe;
	private JButton btn_QuayLai;
	public static boolean charPn = false;
	ChartPanel chartPanel;
	private JFreeChart jfreeChart;
	
	public void khoiTao() {
		khoiTaoBang();
		txt_TieuDe = new JLabel();
		btn_QuayLai = new  JButton();
		
	}
	public void khoiTaoBang() {
		tb_TopSanPham = new myTable();
		JTableHeader header = tb_TopSanPham.getTableHeader();
		header.setBackground(Color.green);
		scroll = new JScrollPane(tb_TopSanPham);
		scroll.setBounds(80, 100, 600, 185);
		this.add(scroll);
	}
	public void thietLap() {
		thietLapTxt();
		thietLapBang();
		btnQuayLai();
	}
	public void thietLapTxt() {
		Font font = new Font("Arial", Font.BOLD, 20);
		
		txt_TieuDe.setText("Bảng xếp hạng sản phẩm");
		txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		txt_TieuDe.setHorizontalAlignment(0);
		txt_TieuDe.setBounds(0, 30, 770, 30);
		
		
		
		this.add(txt_TieuDe);
		
	}
	public void thietLapBang() {
		String col[] = {"Top", "Sản phẩm","Doanh thu","Số lượng bán"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		tb_TopSanPham.setModel(model);
		
		
	}
	public void event() {
		eventQuayVe();
	}
	public void btnQuayLai() {
		btn_QuayLai.setIcon(new ImageIcon("image//image//thongKe//quayLai.png"));
		btn_QuayLai.setFocusable(false);
		btn_QuayLai.setBounds(10, 10, 30, 30);
		this.add(btn_QuayLai);
	}
	public void eventQuayVe() {
		btn_QuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pn_Manager_ThongKe.pn_ThongKeTongQuat.setVisible(true);
				
			}
		});
	}
	public void thongKeChiTiet(String year) {
		
		String book[] = menuManager.bookBUS.thongKeSanPham(year);
		String col[] = {"Top", "Sản phẩm","Doanh thu","Số lượng bán"};
		DefaultTableModel model = new DefaultTableModel(col, 0);
		model.setColumnIdentifiers(col);
		for(int i =0;i<book.length;i++) {
			String s[] = book[i].split("-");
			Vector<String> vt = new Vector<String>();
			vt.add((i+1)+"");
			vt.add(s[3]);
			vt.add(s[1]);
			vt.add(s[2]);
			model.addRow(vt);
			if(i >8)
				break;
		}
		tb_TopSanPham.setModel(model);
		thietLapBieuDo(year);
	}
	
	public void thietLapBieuDo(String year) {
		jfreeChart = ChartFactory.createBarChart("Biểu đồ doanh thu hàng tháng trong năm "+year,"Tháng","Doanh thu"
				,createDataset(year),PlotOrientation.VERTICAL,false,false,false );
		
		if(!charPn) {
			chartPanel = new ChartPanel(jfreeChart);
			chartPanel.setBounds(0, 350, 740,400);
			this.add(chartPanel);
			charPn = true;
		}
		else {
			chartPanel.setChart(ChartFactory.createBarChart("Biểu đồ doanh thu hàng tháng trong năm "+year,"Tháng","Doanh thu"
				,createDataset(year),PlotOrientation.VERTICAL,false,false,false ));
		}
	}
	public CategoryDataset createDataset(String year) {
		String arrDT[] = menuManager.billBUS.returnDoanhThuTungThang(year);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i =0;i<arrDT.length;i++) {
			String data[] = arrDT[i].split("-");
			dataset.addValue(Float.parseFloat(data[1]), "Doanh thu", "T"+(i+1));
		}
		return dataset;
	}
}
