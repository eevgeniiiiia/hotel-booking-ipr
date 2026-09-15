package com.example.hotelbooking.service;

import com.example.hotelbooking.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class HotelServiceImpl implements HotelService {

    private final List<Hotel> hotels = new ArrayList<>();
    
    private final AtomicLong idGenerator = new AtomicLong(1);

    public HotelServiceImpl() {
        hotels.add(new Hotel(
                idGenerator.getAndIncrement(),
                "Minsk Central Hotel",
                "Minsk",
                "Standard",
                80
        ));

        hotels.add(new Hotel(
                idGenerator.getAndIncrement(),
                "Grand Palace Hotel",
                "Minsk",
                "Deluxe",
                120
        ));

        hotels.add(new Hotel(
                idGenerator.getAndIncrement(),
                "Riverside Hotel",
                "Brest",
                "Standard",
                65
        ));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return new ArrayList<>(hotels);
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setId(idGenerator.getAndIncrement());
        hotels.add(hotel);
        return hotel;
    }
}
