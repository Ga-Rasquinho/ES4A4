package model;

public class User {
	private int userId;
	private String name;
	private String cpf;
	private String email;
	private String password;
	private int permission;

	public User() {

	}

	public User(int userId, String name, String cpf, String email, String password, int permission) {
		this.userId = userId;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.permission = permission;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

}
