package game.models;

import game.models.enums.StateEnum;
import game.models.enums.TaskEnum;

public class Task {
    private TaskEnum task;
    private int priority;
    private StateEnum state;

    public Task(TaskEnum task, int priority, StateEnum state) {
        this.task = task;
        this.priority = priority;
        this.state = state;
    }

    public TaskEnum getTask() {
        return task;
    }

    public void setTask(TaskEnum task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }
}
