package com.example.CarParkingManagement;

import com.example.CarParkingManagement.Repo.ParkingSlotRepo;
import com.example.CarParkingManagement.service.ParkingSlotService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarParkingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkingManagementApplication.class, args);


	}



}
