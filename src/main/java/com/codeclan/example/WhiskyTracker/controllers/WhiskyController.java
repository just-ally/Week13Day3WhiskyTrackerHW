package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "{year}")
    public List<Whisky> getWhiskyFromYear(@PathVariable int year){
        return whiskyRepository.findWhiskyByYear(2018);
    }

//    @GetMapping(value = "{distilleryName}/{age}")
//    public List<Whisky> getWhiskyFromDistilleryOfAge(@PathVariable String distilleryName, @PathVariable int age){
//        return whiskyRepository.findWhiskiesFromDistilleryOfAge(distilleryName, age);
//    }

    @GetMapping(value = "region/{region}")
    public List<Whisky> getWhiskyByRegion(@PathVariable String region){
        return whiskyRepository.findWhiskiesFromRegion(region);
    }

}
