import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_USERS = 10;
        User[] users = new User[MAX_USERS];
        int userCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== To-Do List Manager ====");
            System.out.println("1. Add New User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View User Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: // Add new user
                    if (userCount >= MAX_USERS) {
                        System.out.println("User limit reached.");
                        break;
                    }
                    System.out.print("Enter new user name: ");
                    String name = scanner.nextLine().trim();
                    if (findUser(users, userCount, name) != null) {
                        System.out.println("User already exists!");
                        break;
                    }
                    users[userCount++] = new User(name);
                    System.out.println("User added successfully.");
                    break;

                case 2: // Add task to user
                    System.out.print("Enter user name: ");
                    String userForTask = scanner.nextLine().trim();
                    User user1 = findUser(users, userCount, userForTask);
                    if (user1 == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.print("Enter task description: ");
                    String taskDesc = scanner.nextLine().trim();
                    user1.addTask(taskDesc);
                    System.out.println("Task added.");
                    break;

                case 3: // Mark task as completed
                    System.out.print("Enter user name: ");
                    String userForMark = scanner.nextLine().trim();
                    User user2 = findUser(users, userCount, userForMark);
                    if (user2 == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    System.out.print("Enter task description to mark as completed: ");
                    String markDesc = scanner.nextLine().trim();
                    user2.markTaskCompleted(markDesc);
                    break;

                case 4: // View tasks
                    System.out.print("Enter user name: ");
                    String userForView = scanner.nextLine().trim();
                    User user3 = findUser(users, userCount, userForView);
                    if (user3 == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    user3.printTasks();
                    break;

                case 5: // Exit
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static User findUser(User[] users, int userCount, String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }
}
