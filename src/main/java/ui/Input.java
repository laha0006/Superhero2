package ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static void back() {
        System.out.println("Press ENTER to go BACK.");
        String input = inputString(">");
    }

    public static String inputString(String prompt) {
        String output = "";
        System.out.print(prompt);

        try {
            //scanner.nextLine();
            output = scanner.nextLine();
            return output;
        } catch (NoSuchElementException e) {
            return output;
        }
    }

    public static String inputStringAsInt(String prompt) {
        String output = "";
        while(true) {
            System.out.print(prompt);
            try {
                output = scanner.nextLine();
                int testParse = Integer.parseInt(output);
                return output;
            } catch (Exception e) {
                System.out.println("Must be number!");
            }
        }
    }

    public static char inputChar(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                char value = scanner.next().charAt(0);
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                return '?';
            }
        }
    }

    public static int inputInt(String prompt) {

        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Must be a number!");
                scanner.nextLine();
            }
        }
    }
}
