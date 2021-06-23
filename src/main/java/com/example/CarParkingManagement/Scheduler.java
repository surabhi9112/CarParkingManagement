package com.example.CarParkingManagement;

import com.example.CarParkingManagement.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Scheduler {


    @Autowired
    private ParkingSlotService parkingSlotService;

    @Scheduled(fixedDelay = 5000)
    public void invokeScheduled() {
        parkingSlotService.updateBookedParkingSlotStatus();
    }
}
