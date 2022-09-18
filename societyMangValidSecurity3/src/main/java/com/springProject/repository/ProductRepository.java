package com.springProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springProject.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	@Query("select p from Product p where p.name like %:x%")
	List<Product>getByName(@Param("x") String mc);
}
