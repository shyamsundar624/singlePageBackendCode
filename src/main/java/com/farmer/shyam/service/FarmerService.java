package com.farmer.shyam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer.shyam.entity.Farmer;
import com.farmer.shyam.repo.FarmerRespository;

@Service
public class FarmerService {
	@Autowired
	private FarmerRespository farmerRespository;

	public Long saveFarmer(Farmer farmer) {
		Farmer saveFarmer = farmerRespository.save(farmer);
		return saveFarmer.getId();
	}
	public Long updateFarmer(Farmer farmer) {
		Farmer saveFarmer = farmerRespository.save(farmer);
		return saveFarmer.getId();
	}
	
	public List<Farmer> getALlFarmer(){
		return farmerRespository.findAll();
	}
	public Farmer findFarmerById(Long id) {
		return farmerRespository.findById(id).orElseThrow(()-> new RuntimeException("Farmer is not Exist for Id "+id));
	}
	
	public void deleteFarmer(long id) {
		farmerRespository.deleteById(id);
	}
	
}
