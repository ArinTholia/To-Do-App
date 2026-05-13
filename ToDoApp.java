import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean completed;

    Task(String title) {
        this.title = title;
        this.completed = false;
    }

    void markCompleted() {
        completed = true;
    }

    public String toString() {
        return (completed ? "[Completed] " : "[Pending] ") + title;
    }
}

public class ToDoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== TO-DO APP MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    tasks.add(new Task(title));
                    System.out.println("Task added successfully.");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to complete.");
                    } else {
                        System.out.print("Enter task number to mark completed: ");
                        int completeIndex = sc.nextInt() - 1;

                        if (completeIndex >= 0 && completeIndex < tasks.size()) {
                            tasks.get(completeIndex).markCompleted();
                            System.out.println("Task marked as completed.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                    } else {
                        System.out.print("Enter task number to remove: ");
                        int removeIndex = sc.nextInt() - 1;

                        if (removeIndex >= 0 && removeIndex < tasks.size()) {
                            tasks.remove(removeIndex);
                            System.out.println("Task removed successfully.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting To-Do App...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
