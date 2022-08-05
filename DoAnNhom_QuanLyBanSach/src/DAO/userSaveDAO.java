package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.user;
import DTO.userSave;
public class userSaveDAO{
	
private connection myConnection;
	
	public connection getMyConnection() {
		return myConnection;
	}
	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	
	public userSaveDAO() {
		this.setMyConnection(new connection());
	
	}
	public ArrayList<userSave> readUser (){
		ArrayList<userSave> arrUser = new ArrayList<userSave>();
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			String sSelection = "select * from usersave";
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String idPc = this.getMyConnection().getResultSet().getString("idPc");
				String user = this.getMyConnection().getResultSet().getString("user");
				String status = this.getMyConnection().getResultSet().getNString("status");
				userSave us = new userSave(idPc, user, status);
				arrUser.add(us);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrUser;
	}
	public void addUser(userSave us) {
		String sSelection = "insert into usersave(idPc, user, status) ";
		String sValue = "values('"+ us.getIpPc()+"','"+ us.getUser()+"','"+ us.getStatus()+"')";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection+sValue));
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modifyUser (userSave us) {
		String sSelection = "update usersave" + " set user = ?, status = ?" + " where idPc = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1,us.getUser());
			this.getMyConnection().getPreparedStatement().setNString(2,us.getStatus());
			this.getMyConnection().getPreparedStatement().setNString(3,us.getIpPc());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// xóa tài khoản
	public void deleteUser(userSave us) {
		String drop = "delete from usersave "+" where idPc = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(drop));
			this.getMyConnection().getPreparedStatement().setNString(1, us.getIpPc());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ngừng hoạt động tài khoản
	public void disbleUser(user us) {
		String sSelection = "update usersave" + " set status = ?" + " where idPc = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1,us.getStatus());
			this.getMyConnection().getPreparedStatement().setNString(2,us.getUsers());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
