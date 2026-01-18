package com.carbontracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Carbon Tracker Application.
 * <p>
 * This Spring Boot application tracks carbon emissions from household appliances
 * and helps users monitor their environmental impact.
 * </p>
 *
 * @author Carbon Tracker Team
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class CarbonTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarbonTrackerApplication.class, args);
	}

}
