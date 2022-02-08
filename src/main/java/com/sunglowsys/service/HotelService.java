package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Hotel updateHotel(Hotel hotel, Integer id);

    List<Hotel> findAllHotels();

    Hotel findHotelById(Integer id);

    void deleteHotelById(Integer id);
}
