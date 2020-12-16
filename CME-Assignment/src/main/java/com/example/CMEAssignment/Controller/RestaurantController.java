package com.example.CMEAssignment.Controller;



import com.example.CMEAssignment.model.Category;
import com.example.CMEAssignment.model.Restaurant;
import com.example.CMEAssignment.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("api/v1/restaurant")
@RestController
@CrossOrigin("*")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public void addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
    }


    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }



    @PutMapping(path = "/true/{id}")
    public void updateRestaurantById(@PathVariable("id") UUID id){
        Date date1 = new Date();
        String date=""+date1;
        restaurantService.updateRestaurantByID(id,date);
    }

    @PutMapping(path = "/false/{id}")
    public void updateRestaurantFalse(@PathVariable("id") UUID id){
        String date="";
        restaurantService.updateRestaurantFalse(id,date);
    }


    @GetMapping(path="/checked")
    public List<Restaurant> selectAllChecked(){
        return restaurantService.getAllChecked();
    }

    @GetMapping(path="/search/{search}")
    public List<Restaurant> SearchedRestaurants(@PathVariable("search") String search){
        return restaurantService.SearchedRestaurants(search);
    }

    @GetMapping(path="/filter/{filter}")
    public List<Restaurant> FilterRestaurants(@PathVariable("filter") String filter){
        return restaurantService.FilterRestaurants(filter);
    }


}
