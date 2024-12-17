package ru.thesis.booking.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.thesis.booking.model.Parking;

@FeignClient("parking-service")
public interface ParkingClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/parking/{id}", consumes = "application/json")
    Parking getParking(@PathVariable("id") String id);
}
