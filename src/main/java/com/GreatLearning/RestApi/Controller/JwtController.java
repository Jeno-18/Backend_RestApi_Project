package com.GreatLearning.RestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GreatLearning.RestApi.Entity.AuthenticateRequest;
import com.GreatLearning.RestApi.Entity.AuthenticateResponse;
import com.GreatLearning.RestApi.Entity.Employees;
import com.GreatLearning.RestApi.Entity.User;
import com.GreatLearning.RestApi.Service.EmployeeService;
import com.GreatLearning.RestApi.Service.FullInfoUser;
import com.GreatLearning.RestApi.Service.UserService;
import com.GreatLearning.RestApi.Util.JwtUtil;

@RestController
public class JwtController {

	@Autowired
	private FullInfoUser userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	EmployeeService emp;

	@Autowired
	UserService user;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticateResponse(jwt));
	}

	@GetMapping("/getUsers")
	public List<User> getUser()
	{
		return user.getUser();
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User newUser) {
		return user.addUser(newUser);
	}

	@PostMapping("/addEmployees")
	public String addEMployee(@RequestBody Employees employee) {
		emp.addEmployee(employee);
		return "Employee added succesfully";
	}

	@GetMapping("/getAllEmployeesList")
	public List<Employees> getAllEmployeesList() {
		return emp.getAllEMployees();
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employees getEmployeeById(@PathVariable("id") Integer id) {
		return emp.getEMployeeById(id);
	}

	@PostMapping("/updateEployee/{id}")
	public Employees updateEmployeebyId(@PathVariable("id") Integer id, @RequestBody Employees newEmp) {
		Employees employee = emp.getEMployeeById(id);
		employee.setFirstName(newEmp.getFirstName());
		employee.setLastName(newEmp.getLastName());
		employee.setEmail(newEmp.getEmail());
		return emp.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		emp.deleteEmployeeById(id);
		return ("Deleted Employee with id - " + id);
	}

	@PostMapping("/findEmployeeByFirstName")
	public List<Employees> findByFirstName(@RequestParam("FirstName") String FirstName) {
		return emp.getByName(FirstName);
	}

	@GetMapping("/employeeSortedListASC")
	public List<Employees> getEmployeeListSortedASC() {
		return emp.sortedAsc();
	}

	@GetMapping("/employeeSortedListDESC")
	public List<Employees> getEmployeeListSortedDESC() {
		return emp.sortedDesc();
	}

}
