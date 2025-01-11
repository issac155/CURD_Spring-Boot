package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService es;

	@PostMapping(value = "/postEmp")
	public String post(@RequestBody Employee e) {
		return es.post(e);
	}
	// http://localhost:8080/employee/postEmp

	@PostMapping(value = "/postEmployees")
	public String getEmployee(@RequestBody List<Employee> e) {
		return es.post(e);

	}
	// http://localhost:8080/employee/postEmployees

	@GetMapping(value = "/getEmp")
	public List<Employee> getAll() {
		return es.getAll();
	}

	@GetMapping(value = "/getEmpID/{id}")
	public Employee get(@PathVariable int id) {
		return es.get(id);
	}
	// http://localhost:8080/employee/getEmpID/5

	@PutMapping(value = "/updateEmpId/{id}")
	public Employee update(@PathVariable Employee e) {
		return es.update(e);
	}

	@DeleteMapping(value = "/deleteEmp/{id}")
	public String delete(@PathVariable int id) {
		return es.delete(id);
	}

	// get age less than 25 -employees
	@GetMapping(value = "/get25")
	public List<Employee> get25() {
		return es.get25();
	}

	// get only male employees
	@GetMapping(value = "/getMale")
	public List<Employee> getMale() {
		return es.getMale();
	}

	// get the minimum age
	@GetMapping(value = "/minAge")
	public List<Integer> getMin() {
		return es.getMin();
	}

	@GetMapping(value = "/ByAge")
	public List<String> getByAge(@RequestParam int age) {
		return es.getByAge(age);
	}
}
