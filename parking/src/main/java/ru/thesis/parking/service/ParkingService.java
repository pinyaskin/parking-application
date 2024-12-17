package ru.thesis.parking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.thesis.parking.model.Parking;
import ru.thesis.parking.repository.ParkingRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;

    public Parking getById(String id) {
        return parkingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Parking not found by id %s".formatted(id)));
    }

    public Parking create(Parking parking) {
        parking.setId(UUID.randomUUID().toString());
        return parkingRepository.save(parking);
    }

    public Parking update(Parking parking) {
        return parkingRepository.save(parking);
    }

    public void delete(String id) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Parking not found by id %s".formatted(id)));
        parkingRepository.delete(parking);
    }
}
