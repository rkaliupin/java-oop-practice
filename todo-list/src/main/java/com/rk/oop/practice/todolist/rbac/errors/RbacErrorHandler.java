package com.rk.oop.practice.todolist.rbac.errors;

import com.rk.oop.practice.todolist.user.User;

public class RbacErrorHandler {
    public static void accessDeniedError(User user, String permissionId) {
        System.out.println("User with ID: " + user.getId() + ", doesn't have permission with ID: " + permissionId);
    }

    public static void accessDeniedError(User user, String permissionId, String resourceId) {
        System.out.println("User with ID: " + user.getId() + ", doesn't have permission with ID: " + permissionId + ", for resource with ID: " + resourceId);
    }
}
