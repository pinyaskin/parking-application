package ru.thesis.booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "bookings")
@Entity
@Getter @Setter
public class Booking {
    @Id
    @Column(name = "booking_id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "plate", nullable = false)
    private String plate;

    @Column(name = "parking_id", nullable = false)
    private String parkingId;

    @Transient
    private Parking parking;
}
