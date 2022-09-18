package com.springProject.service;

import java.util.List;

import com.springProject.entity.Employee;

public interface InterfaceEmployee {
public void AddEmployee(Employee empl);
public List<Employee>getAllEmployees();
public Employee GetEmpById(Long id);
public void UpdateEmployee(Employee empl);
public List<Employee>getEmployeeByName(String firstname);
public void DeleteEmployee(Long id);
}
