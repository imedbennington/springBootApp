package com.springProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springProject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	@Query("select emp from Employee emp where emp.firstname like %:x%")
	List<Employee> getByName(@Param("x") String mc);
}
