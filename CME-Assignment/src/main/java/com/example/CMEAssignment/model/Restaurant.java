package com.example.CMEAssignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Restaurant {

    private final UUID id;
    private String Name;
    private int CategoryId;
    private float Average;
    private String Address;
    private String PhoneNumber;
    private boolean checked;
    private String checked_at;
    private String path;


    public Restaurant(@JsonProperty("id") UUID id,
                      @JsonProperty("Name") String Name,
                      @JsonProperty("CategoryId") int CategoryId,
                      @JsonProperty("Average") float Average,
                      @JsonProperty("Address") String Address,
                      @JsonProperty("PhoneNumber") String PhoneNumber,
                      @JsonProperty("Checked") boolean checked,
                      @JsonProperty("Checked_at") String checked_at,
                      @JsonProperty("path") String path
                      ){
        this.id=id;
        this.Name=Name;
        this.CategoryId=CategoryId;
        this.Address=Address;
        this.Average=Average;
        this.PhoneNumber=PhoneNumber;
        this.checked=checked;
        this.checked_at=checked_at;
        this.path=path;

    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCategory() {
        return CategoryId;
    }

    public void setCategory(int category) {
        CategoryId = category;
    }

    public float getAverage() {
        return Average;
    }

    public void setAverage(float average) {
        Average = average;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getChecked_at() {
        return checked_at;
    }

    public void setChecked_at(String checked_at) {
        this.checked_at = checked_at;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
