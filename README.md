# Project Overview

 

This project handles car parking management, and addresses all scenarios mentioned in the problem statement. This contains all the REST APIs to handle slot booking, slot modification, and slot release. It uses Spring Boot Java and SQL database to store the car parking data.

 

This project stores the slot booking time, slot expiry time, slot status (booked/unbooked) for each parking slot number and id.

 

Through a scheduler, it keeps checking every 5 seconds whether a slot has expired. If the slot expiry time has passed, it releases the slot automatically and marks it as unbooked.

 

The user also has the capability to release a slot early or to extend the booking time.

 

There is no restriction on maximum number of car park slots, and can be modified as per requirement.

 

## APIs

 

The project consists of the following APIs:

 

1) Retrieve available parking slots:

```

GET http://locahost:8080/api/parkingSlots/

```

2) Book an available parking slot:

```

PUT http://locahost:8080/api/parkingSlots/<slot number>

 

 

## The requestor would put the slot number that they are booking,

## and number of hours for which the slot needs to be booked in the

## time field

 

```

 

3) Release slot or modify the booking time:

 

```

PUT http://locahost:8080/api/parkingSlots/<slot number>/modifyslot

 

## This API allows user to release the slot before the

## slot expiry time (by entering the time field as NULL) or

## to enhance the slot booking time (by entering a value between 1 and 4 in the time field)

 

```

 

## Other Comments

The maximum time for which a slot can be booked in one go is 4 hours, but it can be extended beyond 4 hours simply through the update API.