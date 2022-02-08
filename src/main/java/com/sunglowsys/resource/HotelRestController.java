package com.sunglowsys.resource;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
        Hotel result = hotelService.createHotel(hotel);
        return ResponseEntity.ok().body("Hotel is created Successfully: " + result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHotel(@RequestBody Hotel hotel, @PathVariable("id") Integer id) {
        hotelService.updateHotel(hotel, id);
        return ResponseEntity.ok().body("Hotel is Successfully Updated: " + id);
    }

    @GetMapping("/find_all_hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> result = hotelService.findAllHotels();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/find_hotel_by_id/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Integer id) {
        Hotel result = hotelService.findHotelById(id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete_hotel_by_id/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable("id") Integer id) {
        hotelService.deleteHotelById(id);
        return ResponseEntity.ok().body("Hotel is deleted Successfully: " + id);
    }
}
