package com.example.githubuserdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.githubuserdetails.model.UserDetails;
import com.example.githubuserdetails.network.RetrofitClientInstance;
import com.example.githubuserdetails.service.GetDataService;
import retrofit2.Call;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataService service= RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<UserDetails>> call = service.getAllUserDetails();
        call.enqueue(new Callback<List<UserDetails>>() {
            @Override
            public void onResponse(Call<List<UserDetails>> call, Response<List<UserDetails>> response) {
                Log.d("data",response.body().get(0).toString());

            }

            @Override
            public void onFailure(Call<List<UserDetails>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
