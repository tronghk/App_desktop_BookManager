package GUI;

import java.awt.Color;

import javax.mail.Header;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class myTable extends JTable {
	public boolean isCellEditable(int rowIndex, int colIndex) {
		  return false; //Disallow the editing of any cell
		  }
	

}
