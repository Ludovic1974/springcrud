package com.ludo.tutoriales.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ludo.tutoriales.other.EqualPasswords;

@Entity
@Table(name = "user")
@EqualPasswords(message = "{user.passwords.not.igual}")
public class User extends DateColumns {

	@Id
	@Column
	@Size(max = 50, min = 3, message = "{user.username.invalid}")
	@NotEmpty(message = "{user.username.required}")
	private String username;

	@Column
	@Size(max = 50, min = 3, message = "{user.name.invalid}")
	private String name;
	@Column
	@Size(max = 50, min = 3, message = "{user.surname.invalid}")
	private String surname;
	@Column(name = "email", length = 70)
	@Email(message = "{user.email.invalid}")
	@NotEmpty(message = "{user.email.required}")
	private String email;
	@Column
	@Size(max = 255, min = 3, message = "{user.password.invalid}")
	@NotEmpty(message = "{user.password.required}")
	private String password;
	@Column(name = "confirm_password")
	@NotEmpty(message = "{user.confirm_password.required}")
	private String confirmPassword;
	@Column
	private boolean enabled;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH })
	@JoinTable(name = "user_book", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "book_id") })
	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public User(@NotEmpty(message = "{user.username.required}") String username,
			@Size(max = 50, min = 3, message = "{user.name.invalid}") String name,
			@Size(max = 50, min = 3, message = "{user.surname.invalid}") String surname,
			@Email(message = "{user.email.invalid}") @NotEmpty(message = "{user.email.required}") String email,
			@Size(max = 255, min = 3, message = "{user.password.invalid}") @NotEmpty(message = "{user.password.required}") String password,
			@NotEmpty(message = "{user.confirm_password.required}") String confirmPassword, boolean enabled) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.enabled = enabled;
	}

	public User(Date createdAt, Date updatedAt, @NotEmpty(message = "{user.username.required}") String username,
			@Size(max = 50, min = 3, message = "{user.name.invalid}") String name,
			@Size(max = 50, min = 3, message = "{user.surname.invalid}") String surname,
			@Email(message = "{user.email.invalid}") @NotEmpty(message = "{user.email.required}") String email,
			@Size(max = 255, min = 3, message = "{user.password.invalid}") @NotEmpty(message = "{user.password.required}") String password,
			@NotEmpty(message = "{user.confirm_password.required}") String confirmPassword, boolean enabled) {
		super(createdAt, updatedAt);
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.enabled = enabled;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Date createdAt, Date updatedAt) {
		super(createdAt, updatedAt);
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return String.format(
				"User [getUsername()=%s, getName()=%s, getSurname()=%s, getEmail()=%s, getPassword()=%s, getConfirmPassword()=%s, isEnabled()=%s, getCreatedAt()=%s, getUpdatedAt()=%s]",
				getUsername(), getName(), getSurname(), getEmail(), getPassword(), getConfirmPassword(), isEnabled(),
				getCreatedAt(), getUpdatedAt());
	}

}
