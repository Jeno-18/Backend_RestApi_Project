package com.GreatLearning.RestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GreatLearning.RestApi.Entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

}