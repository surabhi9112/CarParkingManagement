package com.example.CarParkingManagement.service;

import com.example.CarParkingManagement.Request.UpdateParkingSlot;
import com.example.CarParkingManagement.model.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {

    List<ParkingSlot> findUnbookedParkingSlots();

    ParkingSlot updateParkingSlot(Long id, UpdateParkingSlot updateParkingSlot) ;

    void updateBookedParkingSlotStatus();

    void updateBookedParkingSlot(Long id, UpdateParkingSlot updateParkingSlot);
}
