package com.carbonTracker.Controller;

import com.carbonTracker.Request.ApplianceRequest;
import com.carbonTracker.Service.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/carbonTracker")
@RequiredArgsConstructor
public class ApplianceController {

    private final ApplianceService applianceService;


//    public ResponseEntity<String> addAppliance(ApplianceRequest applianceRequest) {
//
//    }



}
