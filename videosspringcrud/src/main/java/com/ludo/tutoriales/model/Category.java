package com.ludo.tutoriales.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category extends DateColumns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	@Size(max = 225, min = 1, message = "{category.name.invalid}")
	@NotEmpty(message = "{category.name.required}")
	private String name;

	public Category(long id,
			@Size(max = 225, min = 1, message = "{category.name.invalid}") @NotEmpty(message = "{category.name.required}") String name) {
		this.id = id;
		this.name = name;
	}

	public Category(
			@Size(max = 225, min = 1, message = "{category.name.invalid}") @NotEmpty(message = "{category.name.required}") String name) {

		this.name = name;
	}

	public Category(Date createdAt, Date updatedAt, long id,
			@Size(max = 225, min = 1, message = "{category.name.invalid}") @NotEmpty(message = "{category.name.required}") String name) {
		super(createdAt, updatedAt);
		this.id = id;
		this.name = name;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Date createdAt, Date updatedAt) {
		super(createdAt, updatedAt);
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

	@Override
	public String toString() {
		return String.format("Category [getId()=%s, getName()=%s, getCreatedAt()=%s, getUpdatedAt()=%s]", getId(),
				getName(), getCreatedAt(), getUpdatedAt());
	}

}
