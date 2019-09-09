package com.example.githubuserdetails.service;

import com.example.githubuserdetails.model.UserDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/users")
    Call<List<UserDetails>> getAllUserDetails();
}
