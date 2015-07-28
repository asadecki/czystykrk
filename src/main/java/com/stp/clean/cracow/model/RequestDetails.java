package com.stp.clean.cracow.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;
import java.util.List;

public class RequestDetails {

    @Length(max = 128)
    @QueryParam("userName")
    private String userName;

    @QueryParam("email")
    private String email;

    @QueryParam("phoneNumber")
    private String phoneNumber;

    @NotNull
    @QueryParam("latitude")
    private Double latitude;

    @NotNull
    @QueryParam("longitude")
    private Double longitude;

    @QueryParam("photos")
    private List<String> photos;


    public RequestDetails() {
        // Jackson deserialization
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
