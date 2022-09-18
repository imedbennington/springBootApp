package com.springProject.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
private Long id;
@NotEmpty(message="field souldnt be empty")
private String name;
@NotEmpty(message="field souldnt be empty")
private int quantity;
@NotEmpty(message="field souldnt be empty")
@NotNull(message="field souldnt be empty")
private double price;
@NotNull(message="field souldnt be empty")
@NotEmpty(message="field souldnt be empty")
private String category;
}
