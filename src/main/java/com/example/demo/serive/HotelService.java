package com.example.demo.serive;

import com.example.demo.Models.Hotel;
import com.example.demo.repository.HotelRepository;
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
