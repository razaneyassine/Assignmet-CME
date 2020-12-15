package com.example.CMEAssignment.dao;
import com.example.CMEAssignment.model.Category;
import com.example.CMEAssignment.model.Restaurant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantDao {

    int insertRestaurant(UUID id, Restaurant restaurant);

    default int insertRestaurant(Restaurant restaurant){
        UUID id=UUID.randomUUID();
        return insertRestaurant(id,restaurant);
    }

    List<Restaurant>seletAllRestaurants();
//    Optional<Restaurant>selectRestaurantByID(UUID id);
    int deleteRestaurantByID(UUID id);
    List<Category>selectAllCategories();
    Optional<Category> getCategoryName(int id);
    int insertChecked(UUID id,String name);
    List<Restaurant>selectAllChecked();
    int updateRestaurantByID(UUID id,String date);
    int updateRestaurantFalse(UUID id,String date);
    List<Restaurant>SearchedRestaurants(String search);
    List<Restaurant>FilterRestaurants(String search);

}
