package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WhiskyRepositoryCustom {

//    List<Whisky> findWhiskiesFromDistilleryOfAge(String distilleryName, int age);

    List<Whisky> findWhiskiesFromRegion(String region);

}
