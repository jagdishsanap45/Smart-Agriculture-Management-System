package org.jagdish_prac.farmer_service.controller;

import jakarta.validation.Valid;
import org.jagdish_prac.farmer_service.entity.Farmer;
import org.jagdish_prac.farmer_service.repository.FarmerRepository;
import org.jagdish_prac.farmer_service.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;


    @PostMapping
    public ResponseEntity<Farmer> createFarmer(@Valid @RequestBody Farmer farmer){
        Farmer saved = farmerService.saveFarmer(farmer);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }

    @GetMapping
    public List<Farmer> getAllFarmer(){
        return farmerService.getAllFarmer();
    }

    @GetMapping("/{id}")
    public Farmer getFarmerById(@PathVariable Long id){
        return farmerService.findFarmerById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteFarmer(@PathVariable Long id){
        farmerService.deleteFarmer(id);
    }
}
