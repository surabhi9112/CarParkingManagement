package com.example.CarParkingManagement.Request;

import com.example.CarParkingManagement.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UpdateParkingSlot {

    private int time;
}
