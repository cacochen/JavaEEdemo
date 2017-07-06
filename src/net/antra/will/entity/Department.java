package net.antra.will.entity;

import java.util.*;

import net.antra.will.entity.Employee;

public class Department {
	private Integer id;
	private String name;
	private String email;
	private List<Employee> employeeList;
	public Department() {}
	public Department(Integer id, String name, String email, List<Employee> employeeList) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeList = employeeList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	
	
	
}
