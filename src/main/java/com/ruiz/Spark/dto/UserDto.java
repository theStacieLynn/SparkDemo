package com.ruiz.Spark.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public class UserDto {
	private Long id;
	@NotEmpty
	private String fName;
	@NotEmpty
	private String lName;
	@NotEmpty(message="Email should not be empty")
	@Email
	private String email;
	
	@NotEmpty(message="Password should not be empty")
	private String password;

	public UserDto() {
		super();
	}

	public UserDto(@NotEmpty String fName, @NotEmpty String lName,
			@NotEmpty(message = "Email should not be empty") @Email String email,
			@NotEmpty(message = "Password should not be empty") String password) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

}
