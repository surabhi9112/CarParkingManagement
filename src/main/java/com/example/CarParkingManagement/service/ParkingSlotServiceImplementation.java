package com.example.CarParkingManagement.service;

import com.example.CarParkingManagement.Exception.ParkingSlotNotAvailable;
import com.example.CarParkingManagement.Repo.ParkingSlotRepo;
import com.example.CarParkingManagement.Request.UpdateParkingSlot;
import com.example.CarParkingManagement.model.ParkingSlot;
import com.example.CarParkingManagement.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingSlotServiceImplementation implements ParkingSlotService {

  //  private final ParkingSlotService parkingSlotService;

    private final ParkingSlotRepo parkingSlotRepo;

    @Autowired
    public ParkingSlotServiceImplementation(ParkingSlotRepo parkingSlotRepo){
       // this.parkingSlotService=parkingSlotService;
        this.parkingSlotRepo=parkingSlotRepo;
    }


    public List<ParkingSlot> findUnbookedParkingSlots(){
        List<ParkingSlot> parkingSlots = parkingSlotRepo.findUnbookedParkingSlots();
        return parkingSlots;

    }

    public ParkingSlot updateParkingSlot(Long id,UpdateParkingSlot updateParkingSlot) {
        ParkingSlot parkingSlot = getParkingSlotById(id);
      if(updateParkingSlot.getTime()<=4 && updateParkingSlot.getTime() >=1 && parkingSlot.getStatus().equals(Status.unbooked)) {
          Calendar cal = Calendar.getInstance();
          cal.setTime(new Date());
          cal.add(Calendar.HOUR_OF_DAY, updateParkingSlot.getTime());
          parkingSlot.setStatus(Status.booked);
          parkingSlot.setExpiryTime(cal.getTime());
          parkingSlotRepo.save(parkingSlot);
          return parkingSlot;
      }else {

          throw  new ParkingSlotNotAvailable("Sorry! Maximum permissible booking time is 4 hours.");

      }

    }

   public void updateBookedParkingSlot(Long id, UpdateParkingSlot updateParkingSlot){
        ParkingSlot parkingSlot = getParkingSlotById(id);
        if(updateParkingSlot.getTime() == 0) {
            parkingSlot.setStatus(Status.unbooked);
            parkingSlot.setExpiryTime(null);
            parkingSlotRepo.save(parkingSlot);
        }else{
            Calendar cal = Calendar.getInstance();
            cal.setTime(parkingSlot.getBookingDate());
            cal.add(Calendar.HOUR_OF_DAY, updateParkingSlot.getTime());
            parkingSlot.setExpiryTime(cal.getTime());
            parkingSlotRepo.save(parkingSlot);
        }
   }

    public  void updateBookedParkingSlotStatus(){
        List<ParkingSlot> parkingSlot = parkingSlotRepo.updateBookedParkingSlotStatus();
        for(ParkingSlot parkingSlot1 : parkingSlot){
            if(parkingSlot1.getExpiryTime().before(new Date())){
                parkingSlot1.setStatus(Status.unbooked);
                parkingSlot1.setExpiryTime(null);
                parkingSlotRepo.save(parkingSlot1);
            }else {
                parkingSlotRepo.save(parkingSlot1);
            }
        }
    }

    public ParkingSlot getParkingSlotById(Long id) {
        Optional<ParkingSlot> parkingSlot = parkingSlotRepo.findById(id);
        return parkingSlot.get();
    }


}
