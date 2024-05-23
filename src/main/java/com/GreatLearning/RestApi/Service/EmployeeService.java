package com.GreatLearning.RestApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.GreatLearning.RestApi.Entity.Employees;
import com.GreatLearning.RestApi.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public void addEmployee(Employees employee) {
		empRepo.saveAndFlush(employee);
	}

	public List<Employees> getAllEMployees() {
		return empRepo.findAll();
	}

	public Employees getEMployeeById(Integer id) {
		return empRepo.findById(id).get();
	}
	
	public Employees updateEmployee(Employees employee)
	{
		return empRepo.saveAndFlush(employee);
	}

	public void deleteEmployeeById(Integer id) {
		empRepo.deleteById(id);
	}
	
	public List<Employees> getByName(String FirstName)
	{
		Employees e1 = new Employees();
		e1.setFirstName(FirstName);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");
		Example<Employees> searchResults = Example.of(e1, exampleMatcher);
		
		return empRepo.findAll(searchResults);
	}

	public List<Employees> sortedAsc() {
		return empRepo.findAll(Sort.by(Direction.ASC, "firstName"));
	}
	
	public List<Employees> sortedDesc() {
		return empRepo.findAll(Sort.by(Direction.DESC, "firstName"));
	}

}