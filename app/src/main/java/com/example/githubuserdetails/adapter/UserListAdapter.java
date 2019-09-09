package com.example.githubuserdetails.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubuserdetails.R;
import com.example.githubuserdetails.databinding.UserListItemBinding;
import com.example.githubuserdetails.model.UserDetails;

import java.util.List;
import java.util.Objects;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    List<? extends UserDetails> userList;

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.user_list_item,
                        parent, false);



        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.binding.setUser(userList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    public void setProjectList(final List<? extends UserDetails> userList) {
        if (this.userList == null) {
            this.userList = userList;
            notifyItemRangeInserted(0, userList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return UserListAdapter.this.userList.size();
                }

                @Override
                public int getNewListSize() {
                    return userList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return UserListAdapter.this.userList.get(oldItemPosition).getId() ==
                            userList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    UserDetails userDetails = userList.get(newItemPosition);
                    UserDetails old = userList.get(oldItemPosition);
                    return userDetails.getId() == old.getId()
                            && Objects.equals(userDetails.getUrl(), old.getUrl());
                }
            });
            this.userList = userList;
            result.dispatchUpdatesTo(this);
        }
    }




    static class UserViewHolder extends RecyclerView.ViewHolder {

        final UserListItemBinding binding;

        public UserViewHolder(UserListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
