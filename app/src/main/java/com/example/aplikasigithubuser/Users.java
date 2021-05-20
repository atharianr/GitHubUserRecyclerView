package com.example.aplikasigithubuser;

import android.os.Parcel;
import android.os.Parcelable;

class Users implements Parcelable {

    private String name;
    private String username;
    private String company;
    private String location;
    private int avatar;
    private int repository;
    private int followers;
    private int following;

    public Users() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    protected Users(Parcel parcel) {
        avatar = parcel.readInt();
        name = parcel.readString();
        username = parcel.readString();
        company = parcel.readString();
        location = parcel.readString();
        followers = parcel.readInt();
        following = parcel.readInt();
        repository = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(avatar);
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(company);
        parcel.writeString(location);
        parcel.writeInt(followers);
        parcel.writeInt(following);
        parcel.writeInt(repository);
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };
}
