package com.rk.oop.practice.todolist.rbac.role;

import com.rk.oop.practice.todolist.rbac.permission.Permission;
import com.rk.oop.practice.todolist.rbac.permission.PermissionBuilder;
import com.rk.oop.practice.todolist.rbac.permission.PermissionConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.MissingResourceException;

/**
 * Class is used to mock DB which should store Roles with Permissions assigned to it
 */
public class RoleMgr {
    private HashMap<String, Role> roles;
    private final PermissionBuilder permissionBuilder;
    private final RoleUpdateMgr roleUpdateMgr;
    private static RoleMgr roleMgr;

    private RoleMgr() {
        this.permissionBuilder = PermissionBuilder.getInstance();
        this.roleUpdateMgr = new RoleUpdateMgr();

        // Emulate connection to the DB and creation of a couple of roles
        this.buildAdminRole();
        this.buildProjectManagerRole();
        this.buildDeveloperRole();
    }

    public static RoleMgr getInstance() {
        if (roleMgr == null) {
            roleMgr = new RoleMgr();
        }
        return roleMgr;
    }

    public Role getRoleById(String roleId) {
        if (!this.roles.containsKey(roleId)) {
            throw new MissingResourceException("The Role with passed ID: " + roleId + ", doesn't exists", "Role", roleId);
        }
        return this.roles.get(roleId);
    }

    public void createRole(String roleId) {
        if (this.roles.containsKey(roleId)) {
            throw new IllegalStateException("Role with ID: " + roleId + ", already exists");
        }

        this.roles.put(roleId, new Role(roleId));
    }

    public void assignRoleToUser(RbacUser rbacUser, Role role) {
        this.roleUpdateMgr.subscribe(role.getId(), rbacUser);
        rbacUser.assignRole(role);
    }

    public void unAssignRoleFromUser(RbacUser rbacUser, Role role) {
        this.roleUpdateMgr.unsubscribe(role.getId(), rbacUser);
        rbacUser.unAssignRole(role);
    }

    public void addPermissionToRole(String roleId, String permissionId, String resourceId) {
        Role roleToExtend = this.getRoleById(roleId);

        if (!roleToExtend.hasPermission(permissionId, resourceId)) {
            roleToExtend.addPermission(this.permissionBuilder.getPermissionById(permissionId));
            // Update all RbacUser with role with new permissions
            this.roleUpdateMgr.notify(roleToExtend.getId(), roleToExtend);
        }
    }
    public void removePermissionFomRole(String roleId, String permissionId, String resourceId) {
        if (!this.roles.containsKey(roleId)) {
            throw new MissingResourceException("The Role with passed ID: " + roleId + ", doesn't exists", "Role", roleId);
        }

        Role roleToExtend = this.roles.get(roleId);

        if (!roleToExtend.hasPermission(permissionId, resourceId)) {
            roleToExtend.removePermission(permissionId);
            // Update all RbacUser with role with new permissions
            this.roleUpdateMgr.notify(roleToExtend.getId(), roleToExtend);
        }
    }

    private void buildAdminRole() {
        Role admin = new Role("admin");

        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.CREATE_BOARD));
        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.UPDATE_BOARD));
        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.DELETE_BOARD));

        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.CREATE_CATEGORY));
        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.UPDATE_CATEGORY));
        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.DELETE_CATEGORY));

        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.CREATE_TASK));
        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.UPDATE_TASK));
        admin.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.DELETE_TASK));

        this.roles.put("admin", admin);
    }
    private void buildProjectManagerRole() {
        Role projectManager = new Role("projectManager");

        projectManager.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.CREATE_CATEGORY));
        projectManager.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.UPDATE_CATEGORY));
        projectManager.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.DELETE_CATEGORY));

        projectManager.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.CREATE_TASK));
        projectManager.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.UPDATE_TASK));
        projectManager.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.DELETE_TASK));

        this.roles.put("projectManager", projectManager);
    }
    private void buildDeveloperRole() {
        Role developer = new Role("developer");

        developer.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.CREATE_TASK));
        developer.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.UPDATE_TASK));
        developer.addPermission(this.permissionBuilder.getPermissionById(PermissionConstants.DELETE_TASK));

        this.roles.put("developer", developer);
    }
}
