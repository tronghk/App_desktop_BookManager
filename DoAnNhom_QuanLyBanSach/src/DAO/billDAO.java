package DAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.bill;

public class billDAO {
	private connection myConnection;

	public billDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addBill(bill b) {
		String sSelecytion = "insert into bill(idBill, idCustomer, idEmployee, dateBill, sumMoney, typePayment, discountMoney"
				+ ",moneyPayment, status )";
		String sValueBill = " values('" + b.getIdBill() + "','" + b.getIdCustomer()+"','"+b.getIdEmployee()+"','"
				+b.getDateBill()+"','" + b.getSumMoney()+"','"+b.getTypePayment()+"','" +b.getDiscountMoney()+"','"+ b.getMoneyPayment()+"','"+ b.getStatus()+"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelecytion+sValueBill));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modifyBill(bill b) {
		String sSelection = "update bill" +" set idCustomer = ?, idEmployee = ?, dateBill = ?, sumMoney = ?"
				+ ", typePayment = ?, discountMoney = ?, moneyPayment = ?, status = ?" + " where idBill  = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, b.getIdCustomer());
			this.getMyConnection().getPreparedStatement().setNString(2, b.getIdEmployee());
			this.getMyConnection().getPreparedStatement().setNString(3, b.getDateBill().toString());
			this.getMyConnection().getPreparedStatement().setFloat(4, b.getSumMoney());
			this.getMyConnection().getPreparedStatement().setNString(5, b.getTypePayment());
			this.getMyConnection().getPreparedStatement().setFloat(6, b.getDiscountMoney());
			this.getMyConnection().getPreparedStatement().setFloat(7, b.getMoneyPayment());
			this.getMyConnection().getPreparedStatement().setString(8, b.getStatus());
			this.getMyConnection().getPreparedStatement().setInt(9, b.getIdBill());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}
	public void deleteBill(bill b) {
		String sSelection = "delete from bill" +" where idBill = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setInt(1,b.getIdBill());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<bill> readBil(){
		String sSelection = "select * from bill";
		ArrayList<bill> arrBill = new ArrayList<bill>();
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				int idBill = this.getMyConnection().getResultSet().getInt("idBill");
				String idCustomer = this.getMyConnection().getResultSet().getNString("idCustomer");
				String idEmployee = this.getMyConnection().getResultSet().getNString("idEmployee");
				Date s = this.getMyConnection().getResultSet().getDate("dateBill");
				String date = s.toString();
				LocalDate dateBill = LocalDate.parse(date);
				float sumMoney= this.getMyConnection().getResultSet().getFloat("sumMoney");
				float discountMoney = this.getMyConnection().getResultSet().getFloat("discountMoney");
				float moneyPayment = this.getMyConnection().getResultSet().getFloat("moneyPayment");
				String typePayment = this.getMyConnection().getResultSet().getNString("typePayment");
				String status  = this.getMyConnection().getResultSet().getNString("status");
				bill b = new bill(idBill, idCustomer, idEmployee, dateBill, sumMoney, discountMoney, moneyPayment, typePayment, status);
				arrBill.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrBill;
		
	}
}
