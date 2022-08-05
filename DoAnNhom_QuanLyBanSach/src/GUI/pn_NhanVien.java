package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.billBUS;
import BUS.bookBUS;
import BUS.customerBUS;
import BUS.employeeBUS;
import DTO.book;
import DTO.customer;
import DTO.employee;

public class pn_NhanVien extends JPanel {
	 public pn_NhanVien() {
		 this.setLayout(null);
			this.setBounds(0, 20,770, 745);
			Border border = BorderFactory.createLineBorder(Color.black);
			setBorder(border);
			
			KhoiTaoGiaoDien();
			thietLapGiaoDien();
			event();
	}	
		private JLabel txt_TieuDe;
		private JLabel txt_ThongtinNV;
		private JLabel txt_BXH;
		private JLabel txt_MaNV;
		private JLabel txt_TenNV;
		private JLabel txt_SoDienThoai;
		private JLabel txt_DiaChi;
		private JLabel txt_Luong;
		private JLabel txt_ChucVu;
		private JComboBox<String> cbb_ChucVu;
		private JTextField tf_MaNV;
		private JTextField tf_TenNV;
		private JTextField tf_DiaChi;
		private JTextField tf_Luong;
		private JTextField tf_SoDienThoai;
		private JButton btn_Them;
		private JButton btn_Sua;
		private JButton btn_Xoa;
		private JTable  tb_BangNV;
		private JLabel txt_TimKiem;
		private JTextField tf_TimKiem;
		private JScrollPane scroll;
		private DefaultTableModel model;
		private JTable tb_BangNXBSp;
		private DefaultTableModel model_NXBSp;
		static int count = 0;
		static int count1 = 0;
		static String idNV = "";
		private JLabel txt_Error;
		private JButton btn_TaoLai;
		private JScrollPane scrollBXH ;
		
		public void KhoiTaoGiaoDien() {
//			khởi tạo
			taoBang();
			txt_TieuDe = new JLabel();
			txt_ThongtinNV = new JLabel();
			txt_MaNV = new JLabel();
			txt_TenNV = new JLabel();
			txt_SoDienThoai = new JLabel();
			txt_DiaChi = new JLabel();
			txt_Luong = new JLabel();
			tf_MaNV = new JTextField();
			tf_TenNV = new JTextField();
			tf_DiaChi = new JTextField();
			tf_Luong = new JTextField();
			tf_SoDienThoai = new JTextField();
			btn_Them = new JButton();
			btn_Sua = new JButton();
			btn_Xoa = new JButton();
			txt_TimKiem = new JLabel();
			tf_TimKiem = new JTextField();
			txt_BXH = new JLabel();
			txt_ChucVu = new JLabel();
			txt_Error = new JLabel();
			btn_TaoLai = new JButton();
		}
		public void thietLapGiaoDien() {
			thietLapGiaoDienText();
			thietLapGiaoDientf();
			thietLapBtn();
			thietLapBang();
			thietLapBangBXH_KH();
			thietLapChucVu();
		}
		public void thietLapGiaoDienText() {
			Font font = new Font("Arial", Font.BOLD, 15);
			
			txt_TieuDe.setText("Quản lý nhân viên");
			txt_TieuDe.setFont(new Font("Arial", Font.BOLD, 25));
			txt_TieuDe.setHorizontalAlignment(0);
			txt_TieuDe.setBounds(0, 10, 770, 30);
			
			txt_BXH.setText("BXH nhân viên");
			txt_BXH.setFont(font);
			txt_BXH.setHorizontalAlignment(0);
			txt_BXH.setBounds(460, 50, 150, 22);
			
			txt_ThongtinNV.setText("Thông tin nhân viên");
			txt_ThongtinNV.setFont(font);
			txt_ThongtinNV.setHorizontalAlignment(0);
			txt_ThongtinNV.setBounds(90, 50, 170, 22);
			
			txt_MaNV.setText("Mã NV   ");
			txt_MaNV.setFont(font);
			txt_MaNV.setHorizontalAlignment(0);
			txt_MaNV.setBounds(20, 75, 150, 30);
			
			txt_TenNV.setText("Tên NV  ");
			txt_TenNV.setFont(font);
			txt_TenNV.setHorizontalAlignment(0);
			txt_TenNV.setBounds(20, 105, 150, 30);
			
			txt_SoDienThoai.setText("SĐT       ");
			txt_SoDienThoai.setFont(font);
			txt_SoDienThoai.setHorizontalAlignment(0);
			txt_SoDienThoai.setBounds(20, 135, 150, 30);
			
			txt_DiaChi.setText("Địa chỉ  ");
			txt_DiaChi.setFont(font);
			txt_DiaChi.setHorizontalAlignment(0);
			txt_DiaChi.setBounds(20, 165, 150, 30);
			
			txt_Luong.setText("Lương  ");
			txt_Luong.setFont(font);
			txt_Luong.setHorizontalAlignment(0);
			txt_Luong.setBounds(20, 195, 150, 30);
			
			txt_ChucVu.setText("Chức vụ");
			txt_ChucVu.setFont(font);
			txt_ChucVu.setHorizontalAlignment(0);
			txt_ChucVu.setBounds(20, 225, 150, 30);
			
			txt_TimKiem.setText("Từ khóa");
			txt_TimKiem.setFont(font);
			txt_TimKiem.setHorizontalAlignment(0);
			txt_TimKiem.setBounds(350, 300, 150, 30);
			
			txt_Error.setFont(font);
			txt_Error.setHorizontalAlignment(0);
			txt_Error.setBounds(50, 270, 300, 30);
			
			this.add(txt_TieuDe);
			this.add(txt_ThongtinNV);
			this.add(txt_MaNV);
			this.add(txt_TenNV);
			this.add(txt_SoDienThoai);
			this.add(txt_Luong);
			this.add(txt_DiaChi);
			this.add(txt_TimKiem);
			this.add(txt_BXH);
			this.add(txt_Error);
		}
		
		public void thietLapChucVu() {
			String arrChucVu[] = menuManager.emBUS.XuLyChucVu();
			cbb_ChucVu = new JComboBox<String>(arrChucVu);
			cbb_ChucVu.setBounds(165, 225, 150, 25);
			this.add(cbb_ChucVu);
		}
		public void thietLapGiaoDientf() {
			tf_MaNV.setBounds(165, 75, 150, 25);
			tf_MaNV.setForeground(Color.black);
			tf_MaNV.setFont(new Font("Arial", Font.BOLD, 13));
			
			tf_TenNV.setBounds(165, 105, 150, 25);
			tf_TenNV.setForeground(Color.black);
			tf_TenNV.setFont(new Font("Arial", Font.BOLD, 13));
			
			tf_SoDienThoai.setBounds(165, 135, 150, 25);
			tf_SoDienThoai.setForeground(Color.black);
			tf_SoDienThoai.setFont(new Font("Arial", Font.BOLD, 13));
			
			tf_DiaChi.setBounds(165, 165, 150, 25);
			tf_DiaChi.setForeground(Color.black);
			tf_DiaChi.setFont(new Font("Arial", Font.BOLD, 13));
			
			tf_Luong.setBounds(165, 195, 150, 25);
			tf_Luong.setForeground(Color.black);
			tf_Luong.setFont(new Font("Arial", Font.BOLD, 13));
			
			tf_TimKiem.setBounds(470, 300, 150, 30);
			tf_TimKiem.setForeground(Color.black);
			tf_TimKiem.setFont(new Font("Arial", Font.BOLD, 13));
			
			this.add(tf_MaNV);
			this.add(tf_TenNV);
			this.add(tf_DiaChi);
			this.add(tf_Luong);
			this.add(tf_TimKiem);
			this.add(tf_SoDienThoai);
			this.add(txt_ChucVu);
		}
		public void thietLapBtn() {
			btn_Them.setText("Thêm");
			btn_Them.setFocusable(false);
			btn_Them.setIcon(new ImageIcon("image//image//customer//themCu.png"));
			btn_Them.setBounds(10, 300, 85, 30);
			btn_Them.setBackground(Color.lightGray);
			
			btn_Sua.setText("Sửa");
			btn_Sua.setFocusable(false);
			btn_Sua.setIcon(new ImageIcon("image//image//customer//themCu.png"));
			btn_Sua.setBounds(100, 300, 85, 30);
			btn_Sua.setBackground(Color.lightGray);
			
			btn_Xoa.setText("Xóa");
			btn_Xoa.setFocusable(false);
			btn_Xoa.setIcon(new ImageIcon("image//image//xoa.png"));
			btn_Xoa.setBounds(190, 300, 85, 30);
			btn_Xoa.setBackground(Color.lightGray);
			
			
			btn_TaoLai.setText("Tạo lại");
			btn_TaoLai.setFocusable(false);
			btn_TaoLai.setIcon(new ImageIcon("image//image//TaoLai.png"));
			btn_TaoLai.setBounds(280, 300, 90, 30);
			btn_TaoLai.setBackground(Color.lightGray);
			
			
			this.add(btn_Them);
			this.add(btn_Sua);
			this.add(btn_Xoa);
			this.add(btn_TaoLai);
		}
		public void taoBang() {
			tb_BangNV = new myTable();
			JTableHeader header = tb_BangNV.getTableHeader();
			header.setBackground(Color.pink);
			scroll = new JScrollPane(tb_BangNV);
			scroll.setBounds(0, 340, 757, 400);
			this.add(scroll);
			
			tb_BangNXBSp = new myTable();
			JTableHeader headerBXH = tb_BangNXBSp.getTableHeader();
			headerBXH.setBackground(Color.pink);
			
			scrollBXH = new JScrollPane(tb_BangNXBSp);
			scrollBXH.setBounds(360, 75, 350, 200);
			this.add(scrollBXH);
		}
		public void thietLapBang() {
			String col [] = {"Mã NV", "Tên NV", "Số điện thoại","Địa chỉ","Lương", "Chức vụ"};
			

			model = new DefaultTableModel(col, 0);
			model.setColumnIdentifiers(col);
			
				for(employee value: menuManager.emBUS.returnArr()) {
					Vector vt = new Vector();
					vt.add(value.getIdEmployee());
					vt.add(value.getName());
					vt.add(value.getPhoneNumber());
					vt.add(value.getAddress());
					vt.add(value.getTurnover());
					vt.add(value.getPosition());
					model.addRow(vt);
				}
				tb_BangNV.setModel(model);
			
		}
		public void restartBangNV() {
			
			String col [] = {"Mã NV", "Tên NV", "Số điện thoại","Địa chỉ","Lương", "Chức vụ"};
			model = new DefaultTableModel(col, 0);
			model.setColumnIdentifiers(col);
			
				for(employee value: menuManager.emBUS.returnArr()) {
					Vector vt = new Vector();
					vt.add(value.getIdEmployee());
					vt.add(value.getName());
					vt.add(value.getPhoneNumber());
					vt.add(value.getAddress());
					vt.add(value.getTurnover());
					vt.add(value.getPosition());
					model.addRow(vt);
				}
				tb_BangNV.setModel(model);
				restartTf();
		}
		public void restartTf() {
			tf_MaNV.setText("");
			tf_TenNV.setText("");
			tf_DiaChi.setText("");
			tf_Luong.setText("");
			tf_SoDienThoai.setText("");
			tf_TimKiem.setText("");
			cbb_ChucVu.setSelectedIndex(0);
		}
		public void thietLapBangBXH_KH() {
			
			
			String col [] = {"Top", "Tên NV","Tổng HĐ", "Doanh Thu"};
			

			model_NXBSp = new DefaultTableModel(col, 0);
			model_NXBSp.setColumnIdentifiers(col);
				
				tb_BangNXBSp.setModel(model_NXBSp);
			
		}
		public void event() {
			eventTbCustomer();
			eventAddObject();
			eventModifyObject();
			eventDeleteObject();
			eventSearch();
			eventBXH();
			eventTaoLai();
			bxhNV();
		}
		public void eventTbCustomer() {
			tb_BangNV.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					getDataRow();
					setChangeForm();
					
				}
			});
		}
		public void getDataRow() {
			int row = tb_BangNV.getSelectedRow();
			String key = model.getValueAt(row, 0)+"";
			for(employee value: menuManager.emBUS.returnTablePosition()) {
				if(value.getIdEmployee().compareToIgnoreCase(key) == 0)
				{
					tf_MaNV.setText(value.getIdEmployee());
					tf_TenNV.setText(value.getName());
					tf_SoDienThoai.setText(value.getPhoneNumber());
					tf_DiaChi.setText(value.getAddress());
					tf_Luong.setText(value.getTurnover()+"");
					cbb_ChucVu.setSelectedIndex(menuManager.emBUS.xetChucVu(value.getPosition()));
				}
			}
		}
		public void setChangeForm() {
			count = count+1;
			if(count == 1) {
				idNV = returnStringidNV();
			}
			else {
				String idNew = returnStringidNV();
				if(idNV.compareToIgnoreCase(idNew) == 0)
				{
					count = 0;
					this.setVisible(false);
					pn_Manager_NhanVien.pn_TTNV.resertCTHD();
					pn_Manager_NhanVien.pn_TTNV.thietLapBangHD(idNew);
					pn_Manager_NhanVien.pn_TTNV.thietLapThongTinNV(idNew);
					pn_Manager_NhanVien.pn_TTNV.setVisible(true);
					
					
				}else {
					idNV = idNew;
					count = 1;
				}
				
			}
		}
		public String returnStringidNV() {
			int row  = tb_BangNV.getSelectedRow();
			String key = model.getValueAt(row, 0)+"";
			return key;
		}
		public void eventAddObject() {
			btn_Them.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					addObject();
					
				}
			});
		}
		public void addObject() {
			String id = tf_MaNV.getText()+"";
			String name = tf_TenNV.getText()+ "";
			String phone = tf_SoDienThoai.getText()+ "";
			String address = tf_DiaChi.getText()+ "";
			String type = cbb_ChucVu.getItemAt(cbb_ChucVu.getSelectedIndex())+ "";
			String turnover = tf_Luong.getText();
			String result = menuManager.emBUS.addObject(id, name, phone, address, turnover,type);
			hienThiLoi(result,"Thêm nhân viên thành công");
	 	}
		public void hienThiLoi(String error, String message) {
			txt_Error.setForeground(Color.red);
			switch (error) {
			case "Error id": {
				txt_Error.setText("Mã trùng lặp");
				break;
			}
			case "Error turnover": {
				txt_Error.setText("Lương sai");
				break;
			}
			case "Error name": {
				txt_Error.setText("Lỗi tên rỗng");
				break;
			}
			case "Error phone": {
				txt_Error.setText("Số điện thoại không hợp lệ");
				break;
			}
			default:{
				txt_Error.setForeground(Color.green);
				txt_Error.setText(message);
				thietLapBang();
				break;
			}
			}
		}
		public void xoaLoi() {
			txt_Error.setText("");
		}
		public void eventTaoLai() {
			btn_TaoLai.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					restart();
					
				}
			});
		}
		public void restart() {
			thietLapBang();
			xoaLoi();
			restartTf();
			bxhNV();
		}
		public void eventModifyObject() {
			btn_Sua.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					modifyObject();
					
				}
			});
		}
		public void modifyObject() {
			String id = tf_MaNV.getText()+"";
			String name = tf_TenNV.getText()+ "";
			String phone = tf_SoDienThoai.getText()+ "";
			String address = tf_DiaChi.getText()+ "";
			String type = cbb_ChucVu.getItemAt(cbb_ChucVu.getSelectedIndex())+ "";
			String turnover = tf_Luong.getText();
			String result = menuManager.emBUS.modifyObject(id, name, phone, address, turnover, type);
			hienThiLoi(result,"Sửa thông tin nhân viên thành công");
	 	}
		public void eventDeleteObject() {
			btn_Xoa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					deleteObject();
					
				}
			});
		}
		public void deleteObject() {
			String id = tf_MaNV.getText()+"";
			String name = tf_TenNV.getText()+ "";
			String phone = tf_SoDienThoai.getText()+ "";
			String address = tf_DiaChi.getText()+ "";
			String type = cbb_ChucVu.getItemAt(cbb_ChucVu.getSelectedIndex())+ "";
			String turnover = tf_Luong.getText();
			String result = menuManager.emBUS.deleteObject(id, name, phone, address, turnover, type);
			hienThiLoi(result,"Xóa nhân viên thành công");
		}
		public void eventSearch() {
			
			tf_TimKiem.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					search();
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		public void search() {
			String s = tf_TimKiem.getText()+"";
				ArrayList<employee> arr = menuManager.emBUS.searchEmployee(s);
				thietLapBang(arr);
		}
		public void thietLapBang(ArrayList<employee> arr) {
			String col [] = {"Mã Nv", "Tên NV", "Số điện thoại","Địa chỉ","Lương", "Chức vụ"};
			

			model = new DefaultTableModel(col, 0);
			model.setColumnIdentifiers(col);
			
				for(employee value: arr) {
					Vector vt = new Vector();
					vt.add(value.getIdEmployee());
					vt.add(value.getName());
					vt.add(value.getPhoneNumber());
					vt.add(value.getAddress());
					vt.add(value.getTurnover());
					vt.add(value.getPosition());
					model.addRow(vt);
				}
				tb_BangNV.setModel(model);
				count = 0;
		}
		public void bxhNV() {
			String col [] = {"Top","Tên NV", "Tổng HĐ","Doanh thu tháng"};
			model = new DefaultTableModel(col, 0);
			model.setColumnIdentifiers(col);
			String arrTopNV[] = menuManager.emBUS.topEmployee();
			
				for(int i=0;i<arrTopNV.length;i++) {
					String s[] = arrTopNV[i].split("-");
					Vector vt = new Vector();
					vt.add(""+(i+1));
					vt.add(s[3]);
					vt.add(s[2]);
					vt.add(s[1]);
					
					model.addRow(vt);
					if(i == 5)
						break;
				}
				tb_BangNXBSp.setModel(model);
		}
		public void eventBXH() {
			tb_BangNXBSp.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					setChangeFormBXH();
					
				}
			});
		}
		public String returnIDBXH() {
			int row = tb_BangNXBSp.getSelectedRow();
			String s[] = menuManager.customerBUS.topCustomer();
			String sTemp[] = s[row].split("-");
			return sTemp[0];
			
		}
		public void setChangeFormBXH() {
			count1 = count1+1;
			if(count1 == 1) {
				idNV = returnIDBXH();
			}
			else {
				String idNew = returnIDBXH();
				if(idNV.compareToIgnoreCase(idNew) == 0)
				{
					count1 = 0;
					this.setVisible(false);
					PanelLeftGUI.pn_ThongTinKH.thietLapBangHD(idNew);
					PanelLeftGUI.pn_ThongTinKH.thietLapThongTinKH(idNew);
					PanelLeftGUI.pn_ThongTinKH.setVisible(true);
					
					
				}else {
					idNV = idNew;
					count1 = 1;
				}
				
			}
		}
}
