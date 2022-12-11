import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        ArrayList<String> desc = new ArrayList<>();
        boolean flag = true;
        Functions.LineBreak();
        System.out.print("Please enter your name: ");
        String name = input.nextLine();

        while (flag) {
            System.out.println();
            System.out.println("Main Menu");
            Functions.LineBreak(189, "-");
            System.out.println("|Commands are: 'a' - Add to list | 'm' - Mark task to 'Done' " +
                    "| 'r' - Remove task from list | 'c' - Clear entire list | 'e' - Edit the list " +
                    "| 'd' - Display the list | 'x' - Exit the program|");
            Functions.LineBreak(189, "-");
            System.out.print("Enter command: ");
            String command = input.nextLine().toLowerCase();
            System.out.println();
            switch (command) {
                case "a":
                    Functions.add(items, date, status, desc);
                    break;
                case "m":
                    Functions.mark(items, date, status, desc, name);
                    break;
                case "r":
                    Functions.remove(items, date, status, desc, name);
                    break;
                case "c":
                    Functions.clear(items, date, status, desc);
                    break;
                case "e":
                    Functions.edit(items, date, status, desc, name);
                    break;
                case "d":
                    Functions.display(items, date, status, desc, name);
                    break;
                case "x":
                    flag = false;
                    System.out.println("Mischief managed.");
                    break;
                default:
                    System.out.println("Invalid command, please try again.");
            }
        }
    }
}