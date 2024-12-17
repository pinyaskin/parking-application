package ru.thesis.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.thesis.parking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, String> {
}
