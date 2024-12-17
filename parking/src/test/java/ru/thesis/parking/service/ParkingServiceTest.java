package ru.thesis.parking.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.thesis.parking.model.Parking;
import ru.thesis.parking.repository.ParkingRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ParkingServiceTest {
    @Mock
    private ParkingRepository parkingRepository;

    @InjectMocks
    private ParkingService parkingService;

    private Parking parking;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        parking = new Parking();
        parking.setName("Parking Test");
        parking.setCity("Parking City");
        parking.setAddress("Parking Address");
    }

    @Test
    void contextLoads() {

    }

    @Test
    void createParking_shouldReturnValidParking() {
        doReturn(parking).when(parkingRepository).save(parking);

        Parking actual = parkingService.create(parking);

        assertNotNull(actual.getId());
        assertEquals(actual.getName(), parking.getName());

        verify(parkingRepository).save(parking);
    }
}
