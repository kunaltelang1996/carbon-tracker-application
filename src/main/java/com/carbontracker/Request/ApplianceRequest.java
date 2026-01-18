package com.carbontracker.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ApplianceRequest {

    @NotBlank(message = "Appliance name is required")
    private String name;
    
    @Positive(message = "Power consumption must be positive")
    private double powerWatts;
}
