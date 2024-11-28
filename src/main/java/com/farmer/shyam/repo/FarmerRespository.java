package com.farmer.shyam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmer.shyam.entity.Farmer;

public interface FarmerRespository extends JpaRepository<Farmer, Long>{

}
