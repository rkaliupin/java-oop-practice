package com.rk.oop.practice.todolist.board;

import com.rk.oop.practice.todolist.rbac.errors.RbacErrorHandler;
import com.rk.oop.practice.todolist.rbac.permission.PermissionConstants;
import com.rk.oop.practice.todolist.user.User;

import java.util.HashMap;

/**
 * Mock connection to data base
 */
public class ToDoBoardMgr {
    private static ToDoBoardMgr toDoBoardMgr;
    private HashMap<String, ToDoBoard> boards;

    private ToDoBoardMgr() {
        this.boards = new HashMap<>();
    }

    public static ToDoBoardMgr getInstance() {
        if (toDoBoardMgr == null) {
            toDoBoardMgr = new ToDoBoardMgr();
        }

        return toDoBoardMgr;
    }

    public Board createBoard(User user, String name) {
        if (!user.hasCreatePermission(PermissionConstants.CREATE_BOARD)) {
            RbacErrorHandler.accessDeniedError(user, PermissionConstants.CREATE_BOARD);
            return null;
        }

        ToDoBoard newToDoBoard = new ToDoBoard(name);
        this.boards.put(name, newToDoBoard);

        return newToDoBoard;
    }

    public Board getBoard(User user, String name) {
        if (!user.hasPermission(PermissionConstants.VIEW_BOARD, name)) {
            RbacErrorHandler.accessDeniedError(user, PermissionConstants.VIEW_BOARD, name);
            return null;
        }
        return this.boards.getOrDefault(name, null);
    }

    public void deleteBoard(User user, String name) {
        if (!user.hasPermission(PermissionConstants.DELETE_BOARD, name)) {
            RbacErrorHandler.accessDeniedError(user, PermissionConstants.DELETE_BOARD, name);
            return;
        }
        this.boards.remove(name);
    }
}
