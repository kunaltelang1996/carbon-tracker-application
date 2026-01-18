package com.carbontracker.Controller;

import com.carbontracker.Request.ApplianceRequest;
import com.carbontracker.Service.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carbonTracker")
@RequiredArgsConstructor
public class ApplianceController {

    private final ApplianceService applianceService;


//    public ResponseEntity<String> addAppliance(ApplianceRequest applianceRequest) {
//
//    }



}
