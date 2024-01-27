package com.rk.oop.practice.todolist.rbac.role;

import java.util.ArrayList;
import java.util.HashMap;

public class RoleUpdateMgr {
    private HashMap<String, ArrayList<RbacUser>> RbacUser = new HashMap<>();

    public void subscribe(String roleId, RbacUser rbacUser) {
        ArrayList<RbacUser> RbacUser = this.RbacUser.get(roleId);

        if (RbacUser == null) {
            RbacUser = new ArrayList<>();
        }
        RbacUser.add(rbacUser);

        this.RbacUser.put(roleId, RbacUser);
    }

    public void unsubscribe(String roleId, RbacUser rbacUser) {
        this.RbacUser.remove(roleId, rbacUser);
    }

    public void notify(String roleId, Role role) {
        if (this.RbacUser.containsKey(roleId)) {
            this.RbacUser.get(roleId).forEach(listener -> {
                listener.updateRole(role);
            });
        }
    }
}
