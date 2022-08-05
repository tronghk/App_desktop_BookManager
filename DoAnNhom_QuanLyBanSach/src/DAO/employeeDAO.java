package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import DTO.employee;
public class employeeDAO {
	private connection myConnection;

	public employeeDAO() {
		this.setMyConnection(new connection());
	}

	public connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(connection myconnection) {
		this.myConnection = myconnection;
	}
	
	public void addEmployee(employee em) {
		String sSelection = "insert into employee(	idEmployee, name, phoneNumber, address, turnover, totalSales, permission, position)";
		String sValueEmployee = " values('"+ em.getIdEmployee()+"','" + em.getName()+"','"
		+em.getPhoneNumber()+"','"+em.getAddress()+"','"+em.getTurnover()+"','"+em.getTotalSales()+"','"+em.getPermission()+"','"+em.getPosition()+"')";
		try {
			
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValueEmployee));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	public void modifyEmployee(employee em) {
		String sSelection = "update employee "+ "set name = ?" + ", phoneNumber = ?" + ", address = ?"
	 + ", turnover = ?" + ", totalSales = ?, permission = ?"
	+ " where idEmployee  = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, em.getName());
			this.getMyConnection().getPreparedStatement().setNString(2, em.getPhoneNumber());
			this.getMyConnection().getPreparedStatement().setNString(3, em.getAddress());
			
			this.getMyConnection().getPreparedStatement().setFloat(4, em.getTurnover());
			this.getMyConnection().getPreparedStatement().setFloat(5, em.getTotalSales());
			this.getMyConnection().getPreparedStatement().setNString(6, em.getPermission());
			this.getMyConnection().getPreparedStatement().setNString(7, em.getIdEmployee());
			this.getMyConnection().getPreparedStatement().execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void deleteEmployee(employee em) {
		String sSelection = "delete from employee "+ " where idEmployee = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1,em.getIdEmployee());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<employee> readEmployee(){
		ArrayList<employee> arrEmployee = new  ArrayList<employee>();
		String sSelection = "select * from employee";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String idEmployee  = this.getMyConnection().getResultSet().getNString("idEmployee");
				String name = this.getMyConnection().getResultSet().getNString("name");
				String phoneNumber = this.getMyConnection().getResultSet().getNString("phoneNumber");
				String address = this.getMyConnection().getResultSet().getNString("address");
				float turnover = this.getMyConnection().getResultSet().getFloat("turnover");
				int totalSales = this.getMyConnection().getResultSet().getInt("totalSales");
				String permission = this.getMyConnection().getResultSet().getString("permission");
				String position = this.getMyConnection().getResultSet().getNString("position");
				employee em = new employee(name, phoneNumber, address, idEmployee, turnover, totalSales, permission, position);
				arrEmployee.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrEmployee;
	}
}
