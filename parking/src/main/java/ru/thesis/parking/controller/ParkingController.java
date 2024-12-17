package ru.thesis.parking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.thesis.parking.model.Parking;
import ru.thesis.parking.service.ParkingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/parking")
public class ParkingController {
    private final ParkingService parkingService;

    @GetMapping("/{parking_id}")
    public ResponseEntity<Parking> getParking(@PathVariable("parking_id") String parkingId) {
        return ResponseEntity.ok(parkingService.getById(parkingId));
    }

    @PostMapping
    public ResponseEntity<Parking> createParking(@RequestBody Parking parking) {
        return ResponseEntity.status(201).body(parkingService.create(parking));
    }

    @PutMapping
    public ResponseEntity<Parking> updateParking(@RequestBody Parking parking) {
        return ResponseEntity.ok(parkingService.update(parking));
    }

    @DeleteMapping("/{parking_id}")
    public ResponseEntity<String> deleteParking(@PathVariable("parking_id") String parkingId) {
        parkingService.delete(parkingId);
        return ResponseEntity.ok().build();
    }
}
