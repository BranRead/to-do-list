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
            System.out.print("Enter command: ");
            String command = input.nextLine().toLowerCase();
            System.out.println();
            switch (command) {
                case "a":
                    Functions.add(items, date, status, desc);
                    break;
                case "m":
                    Functions.mark(items, status);
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
                    break;
                default:
                    System.out.println("Invalid command, please try again.");
            }
        }
    }
}