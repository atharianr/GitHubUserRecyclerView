package com.example.aplikasigithubuser;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.aplikasigithubuser.databinding.ItemUserRowBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Users> usersArrayList = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;


    public UserAdapter(ArrayList<Users> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    public ArrayList<Users> getUsersArrayList() {
        return usersArrayList;
    }

    public void setUsersArrayList(ArrayList<Users> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserAdapter.ViewHolder holder, int position) {
        Users users = usersArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(users.getAvatar())
                .apply(new RequestOptions().override(64,64))
                .into(holder.ivAvatar);
        holder.tvName.setText(users.getName());
        holder.tvUsername.setText(users.getUsername());
        holder.tvCompany.setText(users.getCompany());
        holder.tvLocation.setText(users.getLocation());
        holder.llUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(usersArrayList.get(holder.getAdapterPosition()));
            }
        });
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Users users);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAvatar;
        TextView tvName, tvUsername, tvCompany, tvLocation;
        LinearLayout llUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvCompany = itemView.findViewById(R.id.tv_company);
            tvLocation = itemView.findViewById(R.id.tv_location);
            llUser = itemView.findViewById(R.id.ll_user);

        }
    }
}
