package br.com.usermanagement.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import br.com.usermanagement.entities.Users;


public class UsersDTO {

	private Long id;
	private String fullName;
	private String email;
	private String phone;
	private Date birthDate;
	private String userType;
	
	public enum UserType {
		ADMIN,
		EDITOR,
		VIEWER
	}
	
	public UsersDTO() {}
	
	public UsersDTO(Users entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
