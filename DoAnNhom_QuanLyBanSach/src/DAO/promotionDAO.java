package DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import DTO.promotion;
public class promotionDAO {
	private connection myConnection;

	public promotionDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addPromotion(promotion p) {
		String sSelection = "insert into promotions(idPromotion, namePromotions, dateStart, dateEnd)";
		String sValuePromotion = " values('"+ p.getIdPromotion()+"','" + p.getNamePromotion()+"','"
		+p.getDateStart()+"','"+p.getDateEnd()+"')";
		try {
			
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValuePromotion));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void modifyPromotion(promotion p) {
		String sSelection = "update promotions "+ "set namePromotions = ?" + ", dateStart = ?" + ", dateEnd = ?"
	+ " where idPromotion = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, p.getNamePromotion());
			this.getMyConnection().getPreparedStatement().setNString(2, p.getDateStart().toString());
			this.getMyConnection().getPreparedStatement().setNString(3, p.getDateEnd().toString());
			
			this.getMyConnection().getPreparedStatement().setNString(4, p.getIdPromotion());
			this.getMyConnection().getPreparedStatement().execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void deletePromotion(promotion p) {
		String sSelection = "delete from promotions "+ " where idPromotion  = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1,p.getIdPromotion());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<promotion> readPromotion(){
		ArrayList<promotion> arrPromotion = new ArrayList<promotion>();
		String sSelection = "select * from promotions";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String idPromotion = this.getMyConnection().getResultSet().getNString("idPromotion");
				String namePromotion = this.getMyConnection().getResultSet().getNString("namePromotions");
				Date dateSt = this.getMyConnection().getResultSet().getDate("dateStart");
				LocalDate dateStart = LocalDate.parse(dateSt.toString());
				Date dateEd = this.getMyConnection().getResultSet().getDate("dateEnd");
				LocalDate dateEnd = LocalDate.parse(dateEd.toString());
				promotion p = new promotion(idPromotion, namePromotion, dateStart, dateEnd);
				arrPromotion.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrPromotion;
	}
	
}
