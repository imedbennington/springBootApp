package com.springProject.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
private Long id;
@NotEmpty(message="field souldnt be empty")
private String firstname;
@NotEmpty(message="field souldnt be empty")
private String lastname;
@NotEmpty(message="field souldnt be empty")
@Email
private String email;
@NotEmpty(message="field souldnt be empty")
private String password;
}
