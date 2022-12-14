package DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import DTO.coupon;

public class couponDAO {
	private connection myConnection;

	public couponDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addCoupon(coupon co) {
		String sSelection = "insert into coupon(idCoupon, dateAdded, 	intoMoney, idBookDistributor) ";
		String sValueCoupon = "values('"+co.getIdCoupon()+"','"+ co.getDateAdded()+"','"+co.getIntoMoney()
		+"','"+co.getIdBookDistributor()+"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValueCoupon));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void modifyCoupon(coupon co) {
		String sSelection = "update coupon "+ " set dateAdded = ?, intoMoney = ?, idBookDistributor = ?"+ " where idCoupon = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, co.getDateAdded().toString());
			this.getMyConnection().getPreparedStatement().setFloat(2, co.getIntoMoney());
			this.getMyConnection().getPreparedStatement().setNString(3, co.getIdBookDistributor());
			this.getMyConnection().getPreparedStatement().setInt(4, co.getIdCoupon());
			this.getMyConnection().getPreparedStatement().execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteCoupon(coupon co) {
		String sSelection = "delete from coupon where idCoupon = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setInt(1, co.getIdCoupon());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<coupon> readCoupon(){
		ArrayList<coupon> arrCoupon = new ArrayList<coupon>();
		String sSeletion = "select * from coupon";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSeletion));
			while(this.getMyConnection().getResultSet().next()) {
				int idCoupon = this.getMyConnection().getResultSet().getInt("idCoupon");
				Date date = this.getMyConnection().getResultSet().getDate("dateAdded");
				String sDate = date+"";
				String dateAdded = sDate;
				Float intoMoney = this.getMyConnection().getResultSet().getFloat("intoMoney");
				String idBookDistributor = this.getMyConnection().getResultSet().getNString("idBookDistributor");
				coupon co = new coupon(idCoupon, LocalDate.parse(dateAdded),
						intoMoney, idBookDistributor);
				arrCoupon.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrCoupon;
	}
	
}
