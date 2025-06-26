public class User {
    private String name;
    private TaskList todoList;

    public User(String name) {
        this.name = name;
        this.todoList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String taskDesc) {
        todoList.addTask(taskDesc);
    }

    public void markTaskCompleted(String taskDesc) {
        if (!todoList.markTaskCompleted(taskDesc)) {
            System.out.println("Task not found for user " + name);
        }
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        todoList.printTasks();
        System.out.println();
    }
}
