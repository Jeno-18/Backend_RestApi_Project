package com.GreatLearning.RestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GreatLearning.RestApi.Entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
