package ru.thesis.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.thesis.booking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
}