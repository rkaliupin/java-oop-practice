package com.rk.oop.practice.todolist;

import com.rk.oop.practice.todolist.rbac.permission.PermissionBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        PermissionBuilder permissionBuilder = PermissionBuilder.getInstance();

        permissionBuilder.getPermissionById("sdfdsfdsf");
    }
}
