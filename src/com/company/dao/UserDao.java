package com.company.dao;

import com.company.model.User;

import java.util.*;

public class UserDao {

    private List<User> userArrayList = new LinkedList<>();

    public UserDao() {}

    public void addUser(User user) {
        userArrayList.add(user);
    }

    public List<User> getUsers() {

        return new ArrayList<>(userArrayList);
    }
    public List<User> getUsers(int id) {

        return new ArrayList<>(userArrayList);
    }

    public User naydi(int id) {
        User user1 = new User();
        for (User user : userArrayList) {
            if (user.getId() == id) {
                user1 = user;
            }
        }
        return user1;
    }

    public boolean yesOrNo(int id) {
        for (User user : userArrayList) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(List<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void delete(int id) {

        User naydi = naydi(id);
        userArrayList.remove(naydi);
    }
}
