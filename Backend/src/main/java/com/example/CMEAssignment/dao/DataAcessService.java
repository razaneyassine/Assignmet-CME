package com.example.CMEAssignment.dao;

import com.example.CMEAssignment.model.Category;
import com.example.CMEAssignment.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class DataAcessService implements com.example.CMEAssignment.dao.RestaurantDao {

    private final JdbcTemplate jdbcTemplate;

    public DataAcessService(JdbcTemplate jdbcTemplate) {
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
            return new Category(id,resultSet.getString("Name"));


        }));
        return Optional.ofNullable(category);
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
