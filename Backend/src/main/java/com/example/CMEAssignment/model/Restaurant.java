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
    private boolean Checked;
    private String Checked_at;
    private String Path;


    public Restaurant(@JsonProperty("id") UUID id,
                      @JsonProperty("Name") String Name,
                      @JsonProperty("CategoryId") int CategoryId,
                      @JsonProperty("Average") float Average,
                      @JsonProperty("Address") String Address,
                      @JsonProperty("PhoneNumber") String PhoneNumber,
                      @JsonProperty("Checked") boolean Checked,
                      @JsonProperty("Checked_at") String Checked_at,
                      @JsonProperty("Path") String Path
                      ){
        this.id=id;
        this.Name=Name;
        this.CategoryId=CategoryId;
        this.Address=Address;
        this.Average=Average;
        this.PhoneNumber=PhoneNumber;
        this.Checked=Checked;
        this.Checked_at=Checked_at;
        this.Path=Path;

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
        return Checked;
    }

    public void setChecked(boolean checked) {
        this.Checked = checked;
    }

    public String getChecked_at() {
        return Checked_at;
    }

    public void setChecked_at(String checked_at) {
        this.Checked_at = checked_at;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        this.Path = path;
    }
}
