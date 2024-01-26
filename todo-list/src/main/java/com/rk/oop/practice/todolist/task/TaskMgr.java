package com.rk.oop.practice.todolist.task;

import com.rk.oop.practice.todolist.board.Board;
import com.rk.oop.practice.todolist.user.User;

import java.util.HashMap;

public class TaskMgr {
    private static TaskMgr taskMgr;
    private HashMap<String, Integer> taskIds;
    private HashMap<String, HashMap<Integer, Task>> tasks;

    private TaskMgr() {}

    public static TaskMgr getInstance() {
        if (taskMgr == null) {
            taskMgr = new TaskMgr();
        }
        return taskMgr;
    }

    public Task createTask(User user, Board board, String title, User assignedFrom, User assignedTo) {
        String boardName = board.getName();
        Integer taskId = this.getNextTaskId(board);
        Task newTask = new SimpleTask(title, assignedFrom, assignedTo, taskId);

        if (!this.tasks.containsKey(boardName)) {
            this.tasks.put(boardName, new HashMap<>());
        }

        this.tasks.get(boardName).put(taskId, newTask);

        return newTask;
    }

    public void removeTask(User user, Board board, Integer taskId) {
        String boardName = board.getName();

        if (this.tasks.containsKey(boardName)) {
            this.tasks.get(boardName).remove(taskId);
        }
    }

    public Task getTask(User user, Board board, Integer taskId) {
        String boardName = board.getName();

        if (this.tasks.containsKey(boardName)) {
            return this.tasks.getOrDefault(boardName, null).get(taskId);
        }

        return null;
    }

    private Integer getNextTaskId(Board board) {
        String boardName = board.getName();
        int taskId = 1;

        if (this.taskIds.containsKey(boardName)) {
            taskId = this.taskIds.get(boardName) + 1;
        }
        this.taskIds.put(boardName, taskId);

        return taskId;
    }
}
