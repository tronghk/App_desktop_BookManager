package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import DTO.book;
import main.main;

public class BookDAO {
	private connection myConnection;
	public BookDAO() {
		this.setMyConnection(new connection());
	}
	public connection getMyConnection() {
		return myConnection;
	}
	public void setMyConnection(connection myConnection) {
		this.myConnection = myConnection;
	}
	public void addBook(book b) {
		PreparedStatement p;
		String sSelection = "insert into book(idBook, nameBook, unitPrice, 	datePublishing,"
				+ " quantityBook, idTypeBook, idPublishingCompany, status )";
		String sValueBook = " values('"+ b.getIdBook()+"','"+b.getNameBook()+"','"
				+b.getUnitPrice()+"','"+b.getDatePublishing()+"','"+b.getQuantityBook()+"','"+b.getIdTypeBook()
				+"','"+b.getIdPublishingCompany()+"','"+ b.getStatus()+"')";
		try {
			p= this.getMyConnection().getConn().prepareStatement(sSelection+sValueBook);
			p.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		System.out.println(new BookDAO().read().size());
	}
	public void modifyBook(book b) {
		String sSelection = "update book" + " set nameBook = ?, unitPrice = ?, datePublishing = ?, quantityBook = ?"
				+ ", idTypeBook = ?, idPublishingCompany = ?, status = ? " + "where idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, b.getNameBook());
			this.getMyConnection().getPreparedStatement().setFloat(2, b.getUnitPrice());
			this.getMyConnection().getPreparedStatement().setNString(3, b.getDatePublishing().toString());
			this.getMyConnection().getPreparedStatement().setInt(4, b.getQuantityBook());
			this.getMyConnection().getPreparedStatement().setNString(5, b.getIdTypeBook());
			this.getMyConnection().getPreparedStatement().setNString(6, b.getIdPublishingCompany());
			this.getMyConnection().getPreparedStatement().setNString(7, b.getStatus());
			this.getMyConnection().getPreparedStatement().setNString(8, b.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBook(book b) {
		String sSelection = "delete from book" +" where idBook = ?";
		try {
			this.getMyConnection().setPreparedStatement(this.getMyConnection().getConn().prepareStatement(sSelection));
			this.getMyConnection().getPreparedStatement().setNString(1, b.getIdBook());
			this.getMyConnection().getPreparedStatement().execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<book> readBook(){
		ArrayList<book> arrBook = new ArrayList<book>();
		String sSelection = "select * from book";
		try {
			this.getMyConnection().setStatement(this.getMyConnection().getConn().createStatement());
			this.getMyConnection().setResultSet(this.getMyConnection().getStatement().executeQuery(sSelection));
			while(this.getMyConnection().getResultSet().next()) {
				String idBook = this.getMyConnection().getResultSet().getString("idBook");
				String nameBook = this.getMyConnection().getResultSet().getString("nameBook");
				float unitPrice = this.getMyConnection().getResultSet().getFloat("unitPrice");
				LocalDate datePublishing = LocalDate.parse(this.getMyConnection().getResultSet().getString("datePublishing")) ;
				int quantityBook = this.getMyConnection().getResultSet().getInt("quantityBook");
				String idTypeBook = this.getMyConnection().getResultSet().getString("idTypeBook");
				String status = this.getMyConnection().getResultSet().getString("status");
				String idPublishingCompany = this.getMyConnection().getResultSet().getString("idPublishingCompany");
				book b = new  book(idBook, nameBook, unitPrice, datePublishing, quantityBook, idTypeBook, idPublishingCompany, status);
				arrBook.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrBook;
	}
	public ArrayList<book> read(){
		String sSelection = "select * from book";
		connection cn = new connection();
		ArrayList<book> arr = new ArrayList<book>();
		try {
		Statement statement =  cn.getConn().createStatement();
		ResultSet resultSet = statement.executeQuery(sSelection);
		
		while(resultSet.next()) {
			String idBook = resultSet.getString("idBook");
			String nameBook = resultSet.getString("nameBook");
			float unitPrice = resultSet.getFloat("unitPrice");
			LocalDate datePublishing = LocalDate.parse(resultSet.getString("datePublishing")) ;
			int quantityBook = resultSet.getInt("quantityBook");
			String idTypeBook = resultSet.getString("idTypeBook");
			String status = resultSet.getString("status");
			String idPublishingCompany =resultSet.getString("idPublishingCompany");
			book b = new book(idBook, nameBook, unitPrice, datePublishing, quantityBook, idTypeBook, idPublishingCompany, status);
			arr.add(b);
		}
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return arr;
	}
	public void them(book b) {
		/*
		 * cho lớp kết nối là CSDL
		 * biến kết nối là mysqlConnect
		 * để gọi biến kết nối sử dụng getMysqlConnect();
		 */
		String sSelection = "insert into NhaKyChi(ID, Ngay, MucChi, SoTien, GhiChu)";
		String sValues = " values('" + b.getIdBook()+"','" + b.getNameBook()+"','" + b.getIdTypeBook()+"','";
		try {
		PreparedStatement preparedStament = myConnection.getConn().prepareStatement(sSelection+sValues);
		preparedStament.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
