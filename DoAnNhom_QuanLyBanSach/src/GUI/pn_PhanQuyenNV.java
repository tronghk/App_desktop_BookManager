package GUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class pn_PhanQuyenNV extends JPanel {
	 public pn_PhanQuyenNV() {
		 this.setLayout(null);
			this.setBounds(0, 20,770, 745);
			Border border = BorderFactory.createLineBorder(Color.black);
			setBorder(border);
	}
}
