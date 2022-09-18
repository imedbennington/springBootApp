package com.springProject.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springProject.DTO.ProductDto;
import com.springProject.entity.Product;
import com.springProject.repository.ProductRepository;

@Service
public class ProductService implements InterfaceProduct{
@Autowired
ProductRepository ProdRepo;
	@Override
	public void AddProduct(Product prod) {
		// TODO Auto-generated method stub
		ProdRepo.save(prod);
	}
	@Override
	public List<Product> getAllproduct() {
		// TODO Auto-generated method stub
		return ProdRepo.findAll();
	}
	@Override
	public void updateProd(Product prod) {
		// TODO Auto-generated method stub
		ProdRepo.save(prod);
	}
	@Override
	public void DeleteProd(Long id) {
		// TODO Auto-generated method stub
		ProdRepo.deleteById(id);
	}
	@Override
	public Product GetProductById(Long id) {
		// TODO Auto-generated method stub
		return ProdRepo.findById(id).orElse(null);
	}
	@Override
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return ProdRepo.getByName(name);
	}
	@Override
	public void DeleteProduct(Long id) {
		ProdRepo.deleteById(id);
		
	}

}
