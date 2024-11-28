package com.farmer.shyam.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmer.shyam.entity.Farmer;
import com.farmer.shyam.service.FarmerService;

@RestController
@RequestMapping("/v1/api/farmer")
@CrossOrigin("http://localhost:4200/")
public class FarmerRestController {
	@Autowired
	private FarmerService farmerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveFarmer(@RequestBody Farmer farmer ){
		Long id = farmerService.saveFarmer(farmer);
		return ResponseEntity.status(HttpStatus.CREATED).body("Farmer Created With Id "+id);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Farmer>> getAllFarmer(){
		return ResponseEntity.ok(farmerService.getALlFarmer());
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Farmer> findFarmerById(@PathVariable Long id){
		return ResponseEntity.ok(farmerService.findFarmerById(id));
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateFarmer(@RequestBody Farmer farmer){
		Long id = farmerService.updateFarmer(farmer);
		return ResponseEntity.ok("Farmer Updated Successfully "+id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFarmer(@PathVariable Long id){
		farmerService.deleteFarmer(id);
		return ResponseEntity.ok("Farmer Deleted With Id : "+id);
	}
}
