package com.ludo.tutoriales.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ludo.tutoriales.model.Book;
import com.ludo.tutoriales.other.EqualFields;
import com.ludo.tutoriales.other.UniqueField;

@EqualFields(message = "{user.fields.not.igual}", baseField = "password", matchField = "confirmPassword")
public class UserDto {

	@Size(max = 50, min = 3, message = "{user.username.invalid}")
	@NotEmpty(message = "{user.username.required}")
	private String username;

	@Size(max = 50, min = 3, message = "{user.name.invalid}")
	private String name;

	@Size(max = 50, min = 3, message = "{user.surname.invalid}")
	private String surname;

	@Email(message = "{user.email.invalid}")
	@NotEmpty(message = "{user.email.required}")
	@UniqueField
	private String email;

	@Size(max = 255, min = 3, message = "{user.password.invalid}")
	@NotEmpty(message = "{user.password.required}")
	private String password;

	@NotEmpty(message = "{user.confirm_password.required}")
	private String confirmPassword;

	private boolean enabled;

	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
