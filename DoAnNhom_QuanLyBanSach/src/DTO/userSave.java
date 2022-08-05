package DTO;

public class userSave {
	private String ipPc;
	private String user;
	private String status;
	public userSave(String ipPc, String user, String status) {
		super();
		this.ipPc = ipPc;
		this.user = user;
		this.status = status;
	}
	public userSave() {
		
	}
	public String getIpPc() {
		return ipPc;
	}
	public void setIpPc(String ipPc) {
		this.ipPc = ipPc;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
