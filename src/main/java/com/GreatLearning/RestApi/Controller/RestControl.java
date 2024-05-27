package com.GreatLearning.RestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GreatLearning.RestApi.Entity.Employees;
import com.GreatLearning.RestApi.Entity.User;
import com.GreatLearning.RestApi.Service.EmployeeService;
import com.GreatLearning.RestApi.Service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Controller for RestFul APIs")
public class RestControl {

	@Autowired
	EmployeeService emp;
	
	@Autowired
	UserService user;
	
	@PostMapping("addUser")
	@ApiOperation("Add a new user with roles")
	public User addUser(@RequestBody User newUser)
	{
		return user.addUser(newUser);
	}

	@PostMapping("/addEmployees")
	@ApiOperation("Add a new Employee")
	public String addEMployee(@RequestBody Employees employee) {
		emp.addEmployee(employee);
		return "Employee added succesfully";
	}

	@GetMapping("/getAllEmployeesList")
	@ApiOperation("Get All Employees")
	public List<Employees> getAllEmployeesList() {
		return emp.getAllEMployees();
	}

	@GetMapping("/getEmployeeById/{id}")
	@ApiOperation("Get Employees by their ID")
	public Employees getEmployeeById(@PathVariable("id") Integer id) {
		return emp.getEMployeeById(id);
	}

	@PostMapping("/updateEployee/{id}")
	@ApiOperation("Update existing employees")
	public Employees updateEmployeebyId(@PathVariable("id") Integer id, @RequestBody Employees newEmp) {
		Employees employee = emp.getEMployeeById(id);
		employee.setFirstName(newEmp.getFirstName());
		employee.setLastName(newEmp.getLastName());
		employee.setEmail(newEmp.getEmail());
		return emp.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	@ApiOperation("Delete Employees by Id")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		emp.deleteEmployeeById(id);
		return ("Deleted Employee with id - " + id);
	}
	
	@PostMapping("/findEmployeeByFirstName")
	@ApiOperation("Enter The First Name of Employee to get all Records for that name")
	public List<Employees> findByFirstName(@RequestParam("FirstName") String FirstName)
	{
		return emp.getByName(FirstName);
	}
	
	@GetMapping("/employeeSortedListASC")
	@ApiOperation("get List of all employees sorted by their First Name in Ascending Order")
	public List<Employees> getEmployeeListSortedASC()
	{
		return emp.sortedAsc();
	}
	
	@GetMapping("/employeeSortedListDESC")
	@ApiOperation("get List of all employees sorted by their First Name in Descending Order")
	public List<Employees> getEmployeeListSortedDESC()
	{
		return emp.sortedDesc();
	}

}