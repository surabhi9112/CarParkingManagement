package com.example.CarParkingManagement.Repo;

import com.example.CarParkingManagement.model.ParkingSlot;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParkingSlotRepo extends CrudRepository<ParkingSlot,Long> {

    @Query("SELECT p from ParkingSlot p where p.status = 0 order by p.bookingDate DESC ")
    List<ParkingSlot> findUnbookedParkingSlots();


    @Query("SELECT p from ParkingSlot p where p.status = 1 order by p.bookingDate DESC ")
    List<ParkingSlot> updateBookedParkingSlotStatus();





}
