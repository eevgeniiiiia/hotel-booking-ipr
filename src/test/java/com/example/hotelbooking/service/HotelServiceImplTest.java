package com.example.hotelbooking.service;

import com.example.hotelbooking.model.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelServiceImplTest {

    private HotelService hotelService;

    @BeforeEach
    void setUp() {
        hotelService = new HotelServiceImpl();
    }

    @Test
    void shouldReturnInitialHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();

        assertEquals(3, hotels.size());
        assertEquals("Minsk Central Hotel", hotels.get(0).getName());
    }

    @Test
    void shouldCreateNewHotel() {
        Hotel hotel = new Hotel(
                null,
                "Victoria Hotel",
                "Minsk",
                "Deluxe",
                150
        );

        Hotel created = hotelService.createHotel(hotel);

        assertNotNull(created.getId());
        assertEquals("Victoria Hotel", created.getName());
        assertEquals(4, hotelService.getAllHotels().size());
    }
}
