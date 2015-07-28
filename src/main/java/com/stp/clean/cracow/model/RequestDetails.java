package com.stp.clean.cracow.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;
import java.util.List;

public class RequestDetails {

    @Length(max = 128)
    @QueryParam("userName")
    private String userName;

    @NotNull
    @QueryParam("latitude")
    private Double latitude;

    @NotNull
    @QueryParam("longitude")
    private Double longitude;

    @NotNull
    @QueryParam("photoUrls")
    private List<String> photoUrls;

    public RequestDetails() {
        // Jackson deserialization
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getUserName() {
        return userName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }
}
