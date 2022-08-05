package DTO;

public class employee extends person{
	private String idEmployee;
	private float turnover;
	private int totalSales;
	private String permission;
	private String position;
	public employee(String name, String phoneNumber, String address, String idEmployee, float turnover,
			int totalSales, String permission, String position) {
		super(name, phoneNumber, address);
		this.idEmployee = idEmployee;
		
		this.turnover = turnover;
		this.totalSales = totalSales;
		this.permission = permission;
		this.position = position;
	}
	
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	public float getTurnover() {
		return turnover;
	}
	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	
}
