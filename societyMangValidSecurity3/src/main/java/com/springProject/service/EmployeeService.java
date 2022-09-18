package com.springProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springProject.entity.Employee;
import com.springProject.repository.EmployeeRepository;
@Service
public class EmployeeService implements InterfaceEmployee{
@Autowired
EmployeeRepository employeeRepo;
	@Override
	public void AddEmployee(Employee empl) {
		// TODO Auto-generated method stub
		employeeRepo.save(empl);
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}
	@Override
	public Employee GetEmpById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id).get();
	}
	@Override
	public void UpdateEmployee(Employee empl) {
		// TODO Auto-generated method stub
		employeeRepo.save(empl);
	}
	@Override
	public List<Employee> getEmployeeByName(String firstname) {
		// TODO Auto-generated method stub
		return employeeRepo.getByName(firstname);
	}
	@Override
	public void DeleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		
	}

}
