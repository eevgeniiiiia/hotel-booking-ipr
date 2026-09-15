package com.example.hotelbooking.controller;

import com.example.hotelbooking.model.Hotel;
import com.example.hotelbooking.service.HotelService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private static final Logger logger =
            LoggerFactory.getLogger(HotelController.class);

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        logger.info("GET /hotels request received");

        List<Hotel> hotels = hotelService.getAllHotels();

        logger.info("GET /hotels completed, returned {} hotels", hotels.size());

        return ResponseEntity.ok(hotels);
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotel) {
        logger.info("POST /hotels request received for hotel: {}", hotel.getName());

        Hotel createdHotel = hotelService.createHotel(hotel);

        logger.info("Hotel created successfully with id={}", createdHotel.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }
}
