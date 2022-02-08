package com.sunglowsys.service.Impl;


import com.sunglowsys.domain.Hotel;
import com.sunglowsys.repository.HotelRepository;
import com.sunglowsys.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel, Integer id) {
        Hotel result = hotelRepository.getById(id);
        result.setName(hotel.getName());
        result.setCode(hotel.getCode());
        result.setHotelType(hotel.getHotelType());
        result.setEmail(hotel.getEmail());
        result.setMobile(hotel.getMobile());
        return hotelRepository.save(result);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findHotelById(Integer id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public void deleteHotelById(Integer id) {
        hotelRepository.deleteById(id);
    }
}
