package com.rk.oop.practice.todolist.rbac.permission;

import java.lang.reflect.Field;
import java.util.*;

public class PermissionBuilder {
    private static PermissionBuilder instance;
    private HashSet<String> permissionIds = new HashSet<String>();

    // Create a list of all available permission ids to validate on permission creation.
    private PermissionBuilder() {
        PermissionConstants permissionConstants = new PermissionConstants();
        Field[] fields = PermissionConstants.class.getFields();

        for (Field field : fields) {
            String propertyName = field.getName();

            try {
                String propertyValue = field.get(permissionConstants).toString();
                this.permissionIds.add(propertyValue);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static PermissionBuilder getInstance() {
        if (instance == null) {
            instance = new PermissionBuilder();
        }
        return instance;
    }

    public Permission getPermissionById(String permissionId) {
        if (!this.permissionIds.contains(permissionId)) {
            throw new MissingResourceException("The Permission with passed ID: " + permissionId + ", doesn't exists", "Permission", permissionId);
        }
        return new Permission(permissionId);
    }
}
