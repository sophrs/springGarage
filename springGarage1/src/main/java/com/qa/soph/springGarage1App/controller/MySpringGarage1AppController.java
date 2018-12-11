package com.qa.soph.springGarage1App.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.soph.springGarage1App.exception.ResourceNotFoundException;
import com.qa.soph.springGarage1App.model.MySpringGarage1Model;
import com.qa.soph.springGarage1App.repository.vehicleRepository;



@RestController
@RequestMapping("/api")
public class MySpringGarage1AppController {
	
	@Autowired
	vehicleRepository myRepository;
	
	//Method to create a Vehicle
	@PostMapping("/vehicle")
	public MySpringGarage1Model createVehicle(@Valid @RequestBody MySpringGarage1Model mSGM) {
		return myRepository.save(mSGM);
	}
	
	//Method to get a vehicle
	@GetMapping("/vehicle/{id}")
	public MySpringGarage1Model getVehiclebyID(@PathVariable(value = "id")Long vehicleID) {
		return myRepository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException("MySpringBootDataModel","id", vehicleID));
	}
	
	
	//Method to get all the vehicles
	@GetMapping("/vehicle")
	public List<MySpringGarage1Model> getAllPeople(){
		return myRepository.findAll();
	}
	
	
	//Method to update a vehicle
	public MySpringGarage1Model updateVehicle(@PathVariable(value = "id") Long vehicleID, @Valid @RequestBody MySpringGarage1Model vehicleDetails) {
		MySpringGarage1Model mSGM = myRepository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException ("Vehicle", "id", vehicleID));
		
		mSGM.setVehicleType(vehicleDetails.getVehicleType());
		mSGM.setAge(vehicleDetails.getAge());
		
		MySpringGarage1Model updateData = myRepository.save(mSGM);
		return updateData;
	}
	
	//Method to remove a vehicle
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable(value = "id") Long vehicleID){
		MySpringGarage1Model mSGM = myRepository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException ("Vehicle", "id", vehicleID));
	myRepository.delete(mSGM);
	return ResponseEntity.ok().build();
	}
	

}
