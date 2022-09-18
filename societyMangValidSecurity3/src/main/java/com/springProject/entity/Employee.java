package com.springProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	@NotNull(message="field souldnt be empty")
private String firstname;
	@NotNull(message="field souldnt be empty")
private String lastname;
	@NotNull(message="field souldnt be empty")
private double salary;
	@NotNull(message="field souldnt be empty")
private int phone;
}
