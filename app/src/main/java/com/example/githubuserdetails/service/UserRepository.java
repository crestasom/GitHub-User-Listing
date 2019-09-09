package com.example.githubuserdetails.service;

import android.util.Log;
import android.widget.Toast;

import com.example.githubuserdetails.MainActivity;
import com.example.githubuserdetails.model.UserDetails;
import com.example.githubuserdetails.network.RetrofitClientInstance;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.githubuserdetails.model.UserDetails;
import com.example.githubuserdetails.network.RetrofitClientInstance;
import com.example.githubuserdetails.service.GetDataService;
import retrofit2.Call;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


public class UserRepository {
   private GetDataService service;
   private static UserRepository userRepository;


   public synchronized static UserRepository getInstance(){
       if(userRepository==null){
           userRepository=new UserRepository();
       }
       return userRepository;
   }
    public UserRepository() {
    service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    }

    public LiveData<List<UserDetails>>  getUserList(){
        final MutableLiveData<List<UserDetails>> data=new MutableLiveData<>();
        service.getAllUserDetails().enqueue(new Callback<List<UserDetails>>()

        {
            @Override
            public void onResponse
                    (Call < List < UserDetails >> call, Response < List < UserDetails >> response){
                Log.d("data", response.body().get(0).toString());
                data.setValue(response.body());

            }

            @Override
            public void onFailure (Call < List < UserDetails >> call, Throwable t){
                //Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }
}
