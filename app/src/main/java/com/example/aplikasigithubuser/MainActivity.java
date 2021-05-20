package com.example.aplikasigithubuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.aplikasigithubuser.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TypedArray dataAvatar;
    private String[] dataName, dataUsername, dataCompany, dataLocation;
    private int[] dataRepository, dataFollowing, dataFollowers;
    private ArrayList<Users> usersArrayList;
    private UserAdapter userAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userAdapter = new UserAdapter(usersArrayList);

        prepare();
        addItem();

        showRecyclerList();


    }

    private void addItem() {
        usersArrayList = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Users users = new Users();
            users.setAvatar(dataAvatar.getResourceId(i, -1));
            users.setName(dataName[i]);
            users.setUsername(dataUsername[i]);
            users.setCompany(dataCompany[i]);
            users.setLocation(dataLocation[i]);
            users.setFollowers(dataFollowers[i]);
            users.setFollowing(dataFollowing[i]);
            users.setRepository(dataRepository[i]);
            usersArrayList.add(users);
        }
        userAdapter.setUsersArrayList(usersArrayList);
    }

    private void prepare() {
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        dataName = getResources().getStringArray(R.array.name);
        dataUsername = getResources().getStringArray(R.array.username);
        dataCompany = getResources().getStringArray(R.array.company);
        dataLocation = getResources().getStringArray(R.array.location);
        dataFollowers = getResources().getIntArray(R.array.followers);
        dataFollowing = getResources().getIntArray(R.array.following);
        dataRepository = getResources().getIntArray(R.array.repository);
    }

    private void showRecyclerList() {
        binding.rvUserMain.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(usersArrayList);
        binding.rvUserMain.setAdapter(userAdapter);

        userAdapter.setOnItemClickCallback(new UserAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Users users) {

                users.setAvatar(users.getAvatar());
                users.setName(users.getName());
                users.setUsername(users.getUsername());
                users.setCompany(users.getCompany());
                users.setLocation(users.getLocation());
                users.setFollowers(users.getFollowers());
                users.setFollowing(users.getFollowing());
                users.setRepository(users.getRepository());

                Intent intentKeDetail = new Intent(MainActivity.this, DetailUserActivity.class);
                intentKeDetail.putExtra(DetailUserActivity.EXTRA_USER_DATA, users);
                startActivity(intentKeDetail);
            }
        });

    }
}