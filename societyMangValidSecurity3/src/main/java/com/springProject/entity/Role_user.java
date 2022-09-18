package com.springProject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role_user")
public class Role_user {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	@Column(nullable=false)
private String name; 
	@ManyToMany(mappedBy= "roles")
	private List<User> users=new ArrayList<>();
}
