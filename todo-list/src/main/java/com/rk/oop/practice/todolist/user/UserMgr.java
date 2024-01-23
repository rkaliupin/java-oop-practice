package com.rk.oop.practice.todolist.user;

import com.rk.oop.practice.todolist.rbac.role.RbacUserMgr;
import com.rk.oop.practice.todolist.rbac.role.RoleMgr;

/**
 * Idea of this class is to mock user create in DB.
 */
public class UserMgr extends RbacUserMgr {
    public static User createUser(String name, String email) {
        return new User(name, email);
    }
}
