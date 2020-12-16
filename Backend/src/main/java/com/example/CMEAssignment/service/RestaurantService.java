package com.example.CMEAssignment.service;

import com.example.CMEAssignment.dao.RestaurantDao;
import com.example.CMEAssignment.model.Category;
import com.example.CMEAssignment.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {
    private final RestaurantDao restaurantDao;

    @Autowired
    public RestaurantService(@Qualifier("postgres") RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public int addRestaurant(Restaurant restaurant){
        return restaurantDao.insertRestaurant(restaurant);
    }

    public List<Restaurant>getAllRestaurants(){
        return restaurantDao.seletAllRestaurants();
    }



    public List<Category>selectAllCategories(){return restaurantDao.selectAllCategories();}
    public Optional<Category> getCategoryName(int id){return restaurantDao.getCategoryName(id);}
    public List<Restaurant>getAllChecked(){
        return restaurantDao.selectAllChecked();
    }
    public int updateRestaurantByID(UUID id, String date){return restaurantDao.updateRestaurantByID(id,date);}
    public int updateRestaurantFalse(UUID id,String date){return restaurantDao.updateRestaurantFalse(id,date);}
    public List<Restaurant> SearchedRestaurants(String search){return restaurantDao.SearchedRestaurants(search);}
    public List<Restaurant> FilterRestaurants(String search){return restaurantDao.FilterRestaurants(search);}


}

