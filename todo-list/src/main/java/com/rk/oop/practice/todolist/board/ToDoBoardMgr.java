package com.rk.oop.practice.todolist.board;

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
        ToDoBoard newToDoBoard = new ToDoBoard(name);

        this.boards.put(name, newToDoBoard);

        return newToDoBoard;
    }

    public Board getBoard(User user, String name) {
        return this.boards.getOrDefault(name, null);
    }

    public void deleteBoard(User user, String name) {
        this.boards.remove(name);
    }
}
