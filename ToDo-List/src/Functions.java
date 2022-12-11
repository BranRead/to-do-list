import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class Functions {

    public static void LineBreak() {
        for (int i = 0; i < 80; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void LineBreak(int x, String line) {
        for (int i = 0; i < x; i++) {
            System.out.print(line);
        }
        System.out.println();
    }

    public static void add(ArrayList<String> t, ArrayList<String> d,
                           ArrayList<String> s, ArrayList<String> de){
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("You have chosen to add a task to the list.");
            System.out.print("Please confirm this choice (y/n): ");
            String command = input.nextLine().toLowerCase();
            System.out.println();

            if(command.equals("y")){

                System.out.print("Enter to-do list item: ");
                t.add(input.nextLine());

                System.out.print("Enter due date: ");
                d.add(input.nextLine());

                s.add("Not done");

                System.out.print("Enter description: ");
                de.add(input.nextLine());
                flag = false;
                System.out.println("You have successfully added the task!");
            } else if(command.equals("n")){
                flag = false;
                System.out.println("You have chosen to not add an item to the list.");
            } else {
                System.out.println("Invalid command, please try again.");
            }
        }
    }

    public static void mark(ArrayList<String> t, ArrayList<String> d,
                            ArrayList<String> s, ArrayList<String> de, String name){
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("You have chosen to mark a task as done.");
            System.out.print("Please confirm this choice (y/n): ");
            String command = input.nextLine().toLowerCase();
            System.out.println();

            if(command.equals("y")){

                display(t, d, s, de, name);
                System.out.println("Please select which item you would like to mark as done (1-" + t.size() + "): ");
                int num = input.nextInt();
                String blank = input.nextLine();
                s.set(num - 1, "Done");
                flag = false;
                System.out.println("You have finished " + t.get(num-1) + ", great job!");
            } else if(command.equals("n")) {
                flag = false;
                System.out.println("You have chosen to not mark as task as done.");
            } else {
                System.out.println("Invalid command, please try again.");
            }
        }
    }

    public static void remove(ArrayList<String> t, ArrayList<String> d,
                              ArrayList<String> s, ArrayList<String> de, String name){
        Scanner input = new Scanner(System.in);
        System.out.println("You have chosen to remove a task from the list.");
        System.out.print("Please confirm this choice (y/n): ");
        String command = input.nextLine().toLowerCase();
        System.out.println();
        try {
            if (command.equals("y")) {
                display(t, d, s, de, name);
                System.out.print("Please select which item you would like to remove (1-" + t.size() + "): ");
                int num = input.nextInt();
                String blank = input.nextLine();
                System.out.println("Removed " + t.get(num - 1) + " from the To-Do List.");
                t.remove(num - 1);
                d.remove(num - 1);
                s.remove(num - 1);
                de.remove(num - 1);
            } else if (command.equals("n")) {
                System.out.println("You have chosen to not remove a task from the list.");
            } else {
                System.out.println("Invalid command, please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer value, which refers to the list item number.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter an integer value, which exists within the To-do List.");
        }
    }

    public static void clear(ArrayList<String> t, ArrayList<String> d,
                             ArrayList<String> s, ArrayList<String> de) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("You have chosen to clear the entire list.");
            System.out.print("Please confirm this choice (y/n): ");
            String command = input.nextLine().toLowerCase();
            System.out.println();

            if (command.equals("y")) {
                System.out.print("Are you sure? Clearing the list can't be undone (y/n): ");
                command = input.nextLine().toLowerCase();
                System.out.println();
                if (command.equals("y")) {
                    flag = false;
                    System.out.println("You have removed all items from the the To-Do List.");
                    t.clear();
                    d.clear();
                    s.clear();
                    de.clear();
                } else {
                    flag = false;
                    System.out.println("You have chosen to not clear the list.");
                }
            } else if (command.equals("n")){
                flag = false;
                System.out.println("You have chosen to not clear the list.");
            } else {
                System.out.println("Invalid command, please try again.");
            }
        }

    }

    public static void edit(ArrayList<String> t, ArrayList<String> d,
                            ArrayList<String> s, ArrayList<String> de, String name) {
        Scanner input = new Scanner(System.in);
        boolean trigger = true;

        while (trigger) {
            display(t, d, s, de, name);
            System.out.println("You have chosen to edit the list.");
            System.out.print("Please confirm this choice (y/n): ");
            String command = input.nextLine().toLowerCase();
            System.out.println();

            if(command.equals("y")) {
                System.out.print("Please select which item you would like to edit(1-" + t.size() + "): ");
                int num = 0;

                try {
                    num = input.nextInt();
                    String blank = input.nextLine();
                    System.out.println("You have chosen to edit: " + t.get(num - 1));


                     System.out.print("Is this correct? (y/n): ");
                     command = input.nextLine().toLowerCase();
                     System.out.println();
                     boolean flag = true;

                     switch (command) {
                         case ("y"):
                         while (flag) {
                             LineBreak(123, "-");
                             System.out.println("|Commands are: 'n' - Task name | 'd' - Due date " +
                                     "| 's' - Done/Not Done status | 'w' - Description " +
                                     "| 'x' - Exit from editing|");
                             LineBreak(123, "-");
                             System.out.println("What would you like to edit about this task?");
                             command = input.nextLine().toLowerCase();
                             System.out.println();

                             switch (command) {
                                 case "n":
                                     System.out.print("Enter new name: ");
                                     t.set(num - 1, input.nextLine());
                                     break;
                                 case "d":
                                     System.out.print("Enter due date: ");
                                     d.set(num - 1, input.nextLine());
                                     break;
                                 case "s":
                                     System.out.println("The current status of " + t.get(num - 1) + " is: " +
                                             s.get(num - 1) + ".");
                                     System.out.print("Please confirm that you would like to change this (y/n): ");
                                     command = input.nextLine().toLowerCase();
                                     System.out.println();
                                     switch (command) {
                                         case "y":
                                             if (s.get(num - 1).equals("Done")) {
                                                 s.set(num - 1, "Not done");
                                             } else {
                                                 s.set(num - 1, "Done");
                                             }
                                             break;
                                         case "n":
                                             System.out.println("You have chosen to not change the status for " +
                                                     t.get(num - 1));
                                             break;
                                         default:
                                             System.out.println("Invalid command, please try again.");
                                     }
                                     break;
                                 case "w":
                                     System.out.print("Enter description: ");
                                     de.set(num - 1, input.nextLine());
                                     break;
                                 case "x":
                                     System.out.println("You have chosen to exit from editing.");
                                     flag = false;
                                     trigger = false;
                                     break;
                                 default:
                                     System.out.println("Invalid command, please try again!");
                                 }
                             }
                             break;
                         case ("n"):
                             flag = false;
                             System.out.println("You have chosen to exit editing this item.");
                             break;
                         default:
                         System.out.println("Invalid command, please try again.");
                     }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer value, which refers to the list item number.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please enter an integer value, which exists within the To-do List.");
                }
            } else if(command.equals("n")){
                trigger = false;
                System.out.println("You have chosen to exit editing.");
            } else {
                System.out.println("Invalid command, please try again.");
            }
        }
    }

    public static void display(ArrayList<String> t, ArrayList<String> d,
                               ArrayList<String> s, ArrayList<String> de, String name) {
        LineBreak();
        System.out.println(name + "'s To-Do List:");
        for (int i = 0; i < t.size(); i++) {
            LineBreak();
            System.out.println("#" + (i + 1) + ": " + t.get(i));
            System.out.println("Due date: " + d.get(i));
            System.out.println("Status: " + s.get(i));
            System.out.println(de.get(i));
        }
        LineBreak();
    }
}
