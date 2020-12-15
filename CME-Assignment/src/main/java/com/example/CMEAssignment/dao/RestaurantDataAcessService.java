package com.example.CMEAssignment.dao;

import com.example.CMEAssignment.model.Category;
import com.example.CMEAssignment.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class RestaurantDataAcessService implements com.example.CMEAssignment.dao.RestaurantDao {

    private final JdbcTemplate jdbcTemplate;

    public RestaurantDataAcessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertRestaurant(UUID id, Restaurant restaurant) {
        return 0;
    }

    @Override
    public List<Restaurant> seletAllRestaurants() {
        String sql="SELECT * FROM restaurant";
        System.out.println(java.time.LocalDate.now());
         List<Restaurant> restaurants= jdbcTemplate.query(sql,(resultSet,i)-> {
            return new Restaurant(  UUID.fromString(resultSet.getString("id")),
                                    resultSet.getString("Name"),
                                    Integer.parseInt(resultSet.getString("CategoryId")),
                                    Float.parseFloat(resultSet.getString("Average")),
                                    resultSet.getString("Address"),
                                    resultSet.getString("PhoneNumber"),
                                    resultSet.getBoolean("checked"),
                                    resultSet.getString("check_at"),
                                     resultSet.getString("path"));

        });
         return restaurants;
    }

//    @Override
//    public Optional<Restaurant> selectRestaurantByID(UUID id) {
//        String sql="SELECT * FROM restaurant WHERE id=?";
//        Restaurant restaurant= jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet,i)-> {
//            return new Restaurant(  UUID.fromString(resultSet.getString("id")),
//                    resultSet.getString("Name"),
//                    Integer.parseInt(resultSet.getString("Category")),
//                    Float.parseFloat(resultSet.getString("Average")),
//                    resultSet.getString("Address"),
//                    resultSet.getString("PhoneNumber"));
//        });
//        return Optional.ofNullable(restaurant);
//    }

    @Override
    public List<Category> selectAllCategories() {
        String sql="SELECT * FROM category";
        List<Category> categories= jdbcTemplate.query(sql,(resultSet,i)-> {
            return new Category(  Integer.parseInt(resultSet.getString("id")),
                    resultSet.getString("Name"));
        });
        return categories;
    }

    @Override
    public Optional<Category> getCategoryName(int id) {
        String sql="SELECT name FROM category WHERE id=?";
        Category category=jdbcTemplate.queryForObject(sql,new Object[]{id},((resultSet, i) -> {
            System.out.println(resultSet.getString("name"));
            return new Category(id,resultSet.getString("Name"));


        }));
        return Optional.ofNullable(category);
    }

    @Override
    public int insertChecked(UUID id,String name) {
        String sql="INSERT INTO checked (name,restaurantid) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[]{name,id});
        return 1;
    }

    @Override
    public int deleteRestaurantByID(UUID id) {
        String sql="DELETE FROM checked WHERE restaurantid= ?";
        jdbcTemplate.update(sql,new Object[]{id});
        return 1;
    }

    @Override
    public List<Restaurant> selectAllChecked() {
        String sql="SELECT * FROM restaurant WHERE checked=true";
        List<Restaurant> restaurants= jdbcTemplate.query(sql,(resultSet,i)-> {
            return new Restaurant(  UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("Name"),
                    Integer.parseInt(resultSet.getString("CategoryId")),
                    Float.parseFloat(resultSet.getString("Average")),
                    resultSet.getString("Address"),
                    resultSet.getString("PhoneNumber"),
                    resultSet.getBoolean("checked"),
                    resultSet.getString("check_at"),
                    resultSet.getString("path"));

        });
        return restaurants;
    }

        @Override
    public int updateRestaurantByID( UUID id,String checked_at) {
            String sql = "UPDATE restaurant SET checked=true , check_at =? WHERE id=?";
            jdbcTemplate.update(sql, new Object[]{checked_at, id});
            return 1;

        }

    @Override
    public int updateRestaurantFalse(UUID id, String date) {
        String sql = "UPDATE restaurant SET checked=false , check_at =? WHERE id=?";
        jdbcTemplate.update(sql, new Object[]{date, id});
        return 1;

    }

    @Override
    public List<Restaurant> SearchedRestaurants(String search) {
        String sql="SELECT * FROM restaurant WHERE name= '" + search+"'";
        List<Restaurant> restaurants= jdbcTemplate.query(sql,(resultSet,i)-> {
            return new Restaurant(  UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("Name"),
                    Integer.parseInt(resultSet.getString("CategoryId")),
                    Float.parseFloat(resultSet.getString("Average")),
                    resultSet.getString("Address"),
                    resultSet.getString("PhoneNumber"),
                    resultSet.getBoolean("checked"),
                    resultSet.getString("check_at"),
                    resultSet.getString("path"));

        });
        return restaurants;
    }

    @Override
    public List<Restaurant> FilterRestaurants(String search) {
        String sql="SELECT r.* ,c.id FROM restaurant AS r , category AS c WHERE c.name= '" + search+"'AND r.categoryid=c.id ";
        List<Restaurant> restaurants= jdbcTemplate.query(sql,(resultSet,i)-> {
            return new Restaurant(  UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("Name"),
                    Integer.parseInt(resultSet.getString("CategoryId")),
                    Float.parseFloat(resultSet.getString("Average")),
                    resultSet.getString("Address"),
                    resultSet.getString("PhoneNumber"),
                    resultSet.getBoolean("checked"),
                    resultSet.getString("check_at"),
                    resultSet.getString("path"));

        });
        return restaurants;
    }
}
