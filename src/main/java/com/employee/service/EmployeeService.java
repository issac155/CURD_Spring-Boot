package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRespositoty;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRespositoty ed;

	public String post(Employee e) {

		ed.save(e);
		return "Successfully saved";
	}

	public String post(List<Employee> e) {
		ed.saveAll(e);
		return "Save list of data";
	}

	public List<Employee> getAll() {
		return ed.findAll();
	}

	public Employee get(int id) {

		return ed.findById(id).get();
	}

	public Employee update(Employee e) {
		e.setName(e.getName());
		return ed.save(e);
	}

	public String delete(int id) {

		ed.deleteById(id);
		return "deleted successfully";
	}

	/// servie class Implementation

	public List<Employee> get25() {
		List<Employee> emps = ed.findAll();
		List<Employee> a = emps.stream().filter(x -> x.getAge() > 24).collect(Collectors.toList());
		return a;
	}

	public List<Employee> getMale() {
		List<Employee> male = ed.findAll();
		List<Employee> b = male.stream().filter(x -> x.getGender().equalsIgnoreCase("male"))
				.collect(Collectors.toList());
		return b;
	}

	public List<Integer> getMin() {
		List<Employee> minAge = ed.findAll();
		List<Integer> min = minAge.stream().map(x -> x.getAge()).sorted().limit(1).collect(Collectors.toList());
		return min;
	}

	public List<String> getByAge(int age) {
		List<Employee> datas = ed.findAll();
		List<String> x = datas.stream().filter(y -> y.getAge() == age).map(z -> z.getName())
				.collect(Collectors.toList());
		return x;
	}

}
