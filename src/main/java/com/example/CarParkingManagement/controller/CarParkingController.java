package com.example.CarParkingManagement.controller;


import com.example.CarParkingManagement.Request.UpdateParkingSlot;
import com.example.CarParkingManagement.Response.SuccessResponse;
import com.example.CarParkingManagement.model.ParkingSlot;
import com.example.CarParkingManagement.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/parkingSlots")
public class CarParkingController {

    private final ParkingSlotService parkingSlotService;

    @Autowired
    public CarParkingController(ParkingSlotService parkingSlotService){
        this.parkingSlotService=parkingSlotService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingSlot>> getUnbookedParkingSlots() {
        List<ParkingSlot> parkingSlots = parkingSlotService.findUnbookedParkingSlots();
        return ResponseEntity.ok().body(parkingSlots);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<SuccessResponse> updateUnbookedParkingSlotById(@PathVariable("id") Long id ,@RequestBody  UpdateParkingSlot updateParkingSlot)  {
        ParkingSlot parkingSlot = parkingSlotService.updateParkingSlot(id,updateParkingSlot);

        return ResponseEntity.ok().body(new SuccessResponse(parkingSlot.getId(), "ParkingSlot updated successfully"));
    }

    @PutMapping(value = "/{id}/modifySlot")
    public void updateBookedParkingSlotById(@PathVariable("id") Long id, @RequestBody UpdateParkingSlot updateParkingSlot ) {
         parkingSlotService.updateBookedParkingSlot(id,updateParkingSlot);
    }
}
