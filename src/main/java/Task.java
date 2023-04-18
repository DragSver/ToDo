public class Task {
    public String task;
    public boolean isCompleted;

    public Task(String task) {
        this.task = task;
        isCompleted = false;
    }

    public void check() {
        isCompleted = !isCompleted;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}