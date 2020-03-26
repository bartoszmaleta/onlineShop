package org.example.Services;

import java.util.Scanner;

public class TerminalManager {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static String multiSign(int multiplication, String sign) {
        String out = "";

        for (int i = 0; i < multiplication; i++) {
            out += sign;
        }
        return out;
    }

    public static String askForString(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.nextLine();
        return out;
    }

    public static int askForInt(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.next();
        while (!out.matches("[0-9]+")) {
            printString("Use only numbers");
            out = scanner.next();
        }
        return Integer.valueOf(out);
    }

    public static Double askForDouble(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.next();
        while (!out.matches("([0-9]*)\\.([0-9]*)")) {
            printString("Use only doubles with . as separator ");
            out = scanner.next();
        }
        return Double.valueOf(out);
    }

    public static void printString(String message) {
        System.out.println(message);
    }
}
