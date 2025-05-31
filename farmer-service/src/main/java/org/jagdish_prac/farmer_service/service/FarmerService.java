package org.jagdish_prac.farmer_service.service;

import org.jagdish_prac.farmer_service.entity.Farmer;
import org.jagdish_prac.farmer_service.exception.ResouceNotFoundException;
import org.jagdish_prac.farmer_service.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;


    public Farmer saveFarmer(Farmer farmer){
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAllFarmer(){
        return farmerRepository.findAll();
    }
    public Farmer findFarmerById(Long id){
        return farmerRepository.findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("Farmer Not Found" + id));
    }

    public void deleteFarmer(Long id){
        farmerRepository.deleteById(id);
    }
}
