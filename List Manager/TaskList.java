public class TaskList {
    private TaskNode head;

    public void addTask(String description) {
        Task newTask = new Task(description);
        TaskNode newNode = new TaskNode(newTask);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
    }

    public boolean markTaskCompleted(String description) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markCompleted();
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printTasks() {
        TaskNode current = head;
        if (current == null) {
            System.out.println("No tasks.");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
