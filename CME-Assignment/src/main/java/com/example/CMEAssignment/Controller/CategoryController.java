package com.example.CMEAssignment.Controller;


import com.example.CMEAssignment.model.Category;
import com.example.CMEAssignment.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/restaurant")
@RestController
@CrossOrigin("*")
public class CategoryController {

    private final RestaurantService restaurantService;

    @Autowired
    public CategoryController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(path="/categories")
    public List<Category> selectAllCategories(){
        return restaurantService.selectAllCategories();
    }

    @GetMapping(path="/{id}")
    public Category getCategoryName(@PathVariable("id") int id){return restaurantService.getCategoryName(id).orElse(null);}


}
