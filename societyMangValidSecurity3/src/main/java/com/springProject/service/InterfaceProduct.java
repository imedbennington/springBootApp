package com.springProject.service;

import java.util.List;

import javax.validation.Valid;
import com.springProject.entity.Product;

public interface InterfaceProduct {
public void AddProduct(Product prod);
public List<Product>getAllproduct();
public void updateProd(Product prod);
public void DeleteProd(Long id);
public Product GetProductById(Long id);
public List<Product>getProductByName(String name);
public void DeleteProduct(Long id);
}
