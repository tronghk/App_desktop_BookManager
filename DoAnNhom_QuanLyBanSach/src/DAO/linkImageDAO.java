package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.linkImage;

public class linkImageDAO {
	private connection myConnection;
	public linkImageDAO() {
		this.setMyConnection(new connection());
	}
	public connection getMyConnection() {
		return myConnection;
	}
	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addObject( linkImage link) {
		String sSelecytion = "insert into linkimage(link, idBook)";
		String sValueBill = " values('"+ link.getLink().toString()+"','"+ link.getIdBook()+"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelecytion+sValueBill));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modifyObject(linkImage link) {
		String sSelection = "update linkimage" +" set link = ?"+ " where idBook  = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, link.getLink());
			this.getMyConnection().getPreparedStatement().setNString(2, link.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}
	public void deleteObject(linkImage link) {
		String sSelection = "delete from linkimage" +" where idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1,link.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<linkImage> readLinkImage(){
		String sSelection = "select * from linkimage";
		ArrayList<linkImage> arrLink = new ArrayList<linkImage>();
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				
				String link = this.getMyConnection().getResultSet().getNString("link");
				String idBook = this.getMyConnection().getResultSet().getNString("idBook");
				link = link.replace("-", "\\");
			
				linkImage l = new linkImage(link, idBook);
				arrLink.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrLink;
		
	}
	
	 
}
