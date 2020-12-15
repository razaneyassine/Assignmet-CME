package com.example.CMEAssignment.api;



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

//    @PostMapping(path="{id}/{name}")
//    public void addChecked(@PathVariable UUID id,@PathVariable String name){restaurantService.addChecked(id,name);}

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }


//    @GetMapping(path="{id}")
//    public Restaurant getRestaurantByID(@PathVariable("id") UUID id){
//        return restaurantService.getRestaurantByID(id)
//                .orElse(null);
//    }

    @DeleteMapping(path="{id}")
    public void deleteRestaurantByID(@PathVariable("id") UUID id){
        restaurantService.deleteRestaurant(id);
    }

    @PutMapping(path = "/true/{id}")
    public void updateRestaurantById(@PathVariable("id") UUID id){
        Date date1 = new Date();
        String date=""+date1;
        System.out.println(date);

        restaurantService.updateRestaurantByID(id,date);
    }

    @PutMapping(path = "/false/{id}")
    public void updateRestaurantFalse(@PathVariable("id") UUID id){
        String date="";
        restaurantService.updateRestaurantFalse(id,date);
    }

    @GetMapping(path="/categories")
    public List<Category> selectAllCategories(){
        return restaurantService.selectAllCategories();
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

    @GetMapping(path="/{id}")
    public Category getCategoryName(@PathVariable("id") int id){return restaurantService.getCategoryName(id).orElse(null);}

}
