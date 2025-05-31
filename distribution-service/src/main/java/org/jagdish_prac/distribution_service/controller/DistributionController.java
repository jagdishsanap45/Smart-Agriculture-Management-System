package org.jagdish_prac.distribution_service.controller;


import org.jagdish_prac.distribution_service.entity.Distribution;
import org.jagdish_prac.distribution_service.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distributions")
public class DistributionController {



    @Autowired
    private DistributionService distributionService;


    @PostMapping
    public Distribution create(@RequestBody Distribution distribution){
        return distributionService.save(distribution);
    }

    @GetMapping
    public List<Distribution> get(){

        return distributionService.getAll();
    }


}
