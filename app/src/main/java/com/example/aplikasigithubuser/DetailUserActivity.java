package com.example.aplikasigithubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.aplikasigithubuser.databinding.ActivityDetailUserBinding;
import com.example.aplikasigithubuser.databinding.ActivityMainBinding;

public class DetailUserActivity extends AppCompatActivity {

    private ActivityDetailUserBinding binding;
    public static final String EXTRA_USER_DATA = "extra_user_data";


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Users users = getIntent().getParcelableExtra(EXTRA_USER_DATA);
        Glide.with(DetailUserActivity.this)
                .load(users.getAvatar())
                .apply(new RequestOptions().override(144, 144))
                .into(binding.ivAvatar);
        binding.tvName.setText(users.getName());
        binding.tvUsername.setText(users.getUsername());
        binding.tvCompany.setText(users.getCompany());
        binding.tvLocation.setText(users.getLocation());
        binding.tvFollowersInt.setText(String.valueOf(users.getFollowers()));
        binding.tvFollowingInt.setText(String.valueOf(users.getFollowing()));
        binding.tvRepositoryInt.setText(String.valueOf(users.getRepository()));

        if (users.getFollowers() <= 1) {
            binding.tvFollowers.setText("Follower");
        } else if (users.getFollowing() <= 1) {
            binding.tvFollowing.setText("Following");
        } else if (users.getRepository() <= 1) {
            binding.tvRepositoryInt.setText("");
            binding.tvRepository.setText("There is no repository yet :(");
        }

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}