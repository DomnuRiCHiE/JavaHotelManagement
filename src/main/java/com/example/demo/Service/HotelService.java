package com.example.demo.Service;

import com.example.demo.Models.Hotel;
import com.example.demo.Repository.JPA.HotelRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void add(Hotel hotel){
        hotelRepository.save(hotel);
    }
}
