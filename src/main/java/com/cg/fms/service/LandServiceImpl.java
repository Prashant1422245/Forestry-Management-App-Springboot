package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import com.cg.fms.entities.Admin;
import com.cg.fms.entities.Land;
import com.cg.fms.exception.AdminNotFoundException;
import com.cg.fms.exception.LandNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.service.*;

import com.cg.fms.repository.LandRepository;
import com.cg.fms.controller.LandController;

@Service
public class LandServiceImpl implements ILandService{

Logger logger = LoggerFactory.getLogger(LandServiceImpl.class);
	
    private  Land  land;
	@Autowired
	private LandRepository repository;
        
	@Override
	public Land getLand(String surveyNumber) throws LandNotFoundException {
		Optional<Land> land = repository.findBySurveyNumber(surveyNumber);
		if (!land.isPresent())
			throw new LandNotFoundException();

		return land.get();
	}

	@Override
	public Land addLand(Land land) {
		
	 return repository.save(land);
	}

	@Override
	public Land updateLand(Land land) {
		
		return repository.save(land);
	}

	

	@Override
	public List<Land> getAllLands() {
	
		return repository.findAll();
	}

	@Override
	public Long removeLandDetails(String surveyNumber) throws LandNotFoundException {
		Optional<Land> land = repository.findBySurveyNumber(surveyNumber);
		if (!land.isPresent())
			throw new LandNotFoundException();
		return repository.deleteBySurveyNumber(surveyNumber);
		
		
	}

	
	

	

}
