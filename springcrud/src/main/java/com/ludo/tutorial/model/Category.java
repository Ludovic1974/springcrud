package com.ludo.tutorial.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category extends DateColumns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	@Size(max = 100, min = 3, message = "{category.name.invalid}")
	@NotEmpty(message = "{category.value.required}")
	@NotNull(message = "{category.value.notnull}")
	private String name;

	public Category(long id, Date createdAt, Date updatedAt,
			@Size(max = 100, min = 3, message = "{category.name.invalid}") @NotEmpty(message = "{category.value.required}") String name) {
		super(createdAt, updatedAt);
		this.id = id;
		this.name = name;
	}

	public Category(Date createdAt, Date updatedAt,
			@Size(max = 100, min = 3, message = "{category.name.invalid}") @NotEmpty(message = "{category.value.required}") String name) {
		super(createdAt, updatedAt);
		this.name = name;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
