package com.rk.oop.practice.todolist;

import com.rk.oop.practice.todolist.rbac.permission.PermissionBuilder;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        PermissionBuilder permissionBuilder = PermissionBuilder.getInstance();
//
//        permissionBuilder.getPermissionById("sdfdsfdsf");

        Test t = new Test("§12");
        ArrayList<Test> ar = new ArrayList<>();

        ar.add(t);
        System.out.println(ar.get(0).getB());
        t.setB("1234");
        System.out.println(ar.get(0).getB());

    }
}
