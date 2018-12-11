package com.qa.soph.springGarage1App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.soph.springGarage1App.model.MySpringGarage1Model;

public interface vehicleRepository extends JpaRepository<MySpringGarage1Model,Long>{

}
