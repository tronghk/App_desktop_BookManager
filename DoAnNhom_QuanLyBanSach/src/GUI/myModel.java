package GUI;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;
	public class myModel extends DefaultTableModel{
		public myModel(Object[] columnNames, int rowCount) {
	        this.convertToVector(columnNames);
	        this.setRowCount(rowCount);
	    }
		
	}
