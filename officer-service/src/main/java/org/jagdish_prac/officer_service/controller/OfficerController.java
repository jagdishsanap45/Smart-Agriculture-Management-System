package org.jagdish_prac.officer_service.controller;


import org.jagdish_prac.officer_service.entity.OfficerEvent;
import org.jagdish_prac.officer_service.repository.OfficerEventRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/officer")
public class OfficerController {


    @Autowired
    private OfficerEventRepositry officerEventRepositry;


    @GetMapping("/events")
    public List<OfficerEvent> getEvents(){
        return officerEventRepositry.findAll();
    }

}
