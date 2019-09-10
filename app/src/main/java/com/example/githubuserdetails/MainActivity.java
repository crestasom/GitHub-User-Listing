package com.example.githubuserdetails;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.githubuserdetails.adapter.UserListAdapter;
import com.example.githubuserdetails.databinding.ActivityMainBinding;
import com.example.githubuserdetails.model.UserDetails;
import com.example.githubuserdetails.model.UserListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    UserListViewModel userListViewModel;
    UserListAdapter userListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        userListViewModel= ViewModelProviders.of(this).get(UserListViewModel.class);
        observeViewModel(userListViewModel);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userListAdapter=new UserListAdapter();
        binding.userList.setAdapter(userListAdapter);





    }

    private void observeViewModel(UserListViewModel userListViewModel) {
        // Update the list when the data changes
        userListViewModel.getUserListObservable().observe(this, new Observer<List<UserDetails>>() {
            @Override
            public void onChanged(@Nullable List<UserDetails> projects) {
                if (projects != null) {
                    //binding.setIsLoading(false);
                    userListAdapter.setProjectList(projects);
                }
            }
        });
    }
}
