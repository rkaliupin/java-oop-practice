package com.rk.oop.practice.todolist.user;

import java.util.ArrayList;

/**
 * Idea of this class is to mock user create in DB.
 */
public class UserMgr {
    private static UserMgr userMgr;
    private ArrayList<User> users;

    private UserMgr() {}

    public static UserMgr getInstance() {
        if (userMgr == null) {
            userMgr = new UserMgr();
        }
        return userMgr;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);

        this.users.add(user);

        return user;
    }
}
