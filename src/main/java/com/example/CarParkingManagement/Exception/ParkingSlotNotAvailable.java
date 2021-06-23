package com.example.CarParkingManagement.Exception;

public class ParkingSlotNotAvailable extends RuntimeException{

    public ParkingSlotNotAvailable (String message) {
        super(message);
    }
}
