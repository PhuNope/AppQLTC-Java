package information;

public class NguoiDung {
	private String User;
	private String Password;
	private String VaiTro;
	
	public NguoiDung() {
	
	}
	
	public NguoiDung(String User, String Password, String VaiTro) {
		this.User = User;
		this.Password = Password;
		this.VaiTro = VaiTro;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getVaiTro() {
		return VaiTro;
	}

	public void setVaiTro(String vaiTro) {
		VaiTro = vaiTro;
	}
	
	
}
