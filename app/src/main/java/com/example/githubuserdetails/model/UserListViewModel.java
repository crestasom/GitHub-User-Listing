package com.example.githubuserdetails.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.githubuserdetails.service.UserRepository;

import java.util.List;

public class UserListViewModel extends AndroidViewModel {
 private LiveData<List<UserDetails>> userListObservable;

    public UserListViewModel(@NonNull Application application) {
        super(application);
        userListObservable= UserRepository.getInstance().getUserList();
    }

    public LiveData<List<UserDetails>> getUserListObservable() {
        return userListObservable;
    }
}
