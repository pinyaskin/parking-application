package ru.thesis.booking.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.thesis.booking.feign.ParkingClient;
import ru.thesis.booking.model.Booking;
import ru.thesis.booking.repository.BookingRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;

    private final ObjectMapper objectMapper;

    private final ParkingClient parkingClient;

    @GetMapping
    public PagedModel<Booking> getAll(Pageable pageable) {
        Page<Booking> bookings = bookingRepository.findAll(pageable);
        return new PagedModel<>(bookings);
    }

    @GetMapping("/{id}")
    public Booking getOne(@PathVariable String id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        Booking booking = bookingOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
        booking.setParking(parkingClient.getParking(booking.getParkingId()));
        return booking;
    }

    @GetMapping("/by-ids")
    public List<Booking> getMany(@RequestParam List<String> ids) {
        return bookingRepository.findAllById(ids);
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        booking.setId(UUID.randomUUID().toString());
        return bookingRepository.save(booking);
    }

    @PatchMapping("/{id}")
    public Booking patch(@PathVariable String id, @RequestBody JsonNode patchNode) throws IOException {
        Booking booking = bookingRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        objectMapper.readerForUpdating(booking).readValue(patchNode);

        return bookingRepository.save(booking);
    }

    @PatchMapping
    public List<Booking> patchMany(@RequestParam List<String> ids, @RequestBody JsonNode patchNode) throws IOException {
        Collection<Booking> bookings = bookingRepository.findAllById(ids);

        for (Booking booking : bookings) {
            objectMapper.readerForUpdating(booking).readValue(patchNode);
        }

        return bookingRepository.saveAll(bookings);
    }

    @DeleteMapping("/{id}")
    public Booking delete(@PathVariable String id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            bookingRepository.delete(booking);
        }
        return booking;
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<String> ids) {
        bookingRepository.deleteAllById(ids);
    }
}
