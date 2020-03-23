package org.example.view;

import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Scanner;

public class ViewService {
    Scanner scanner = new Scanner(System.in);

    public static int intScanner(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        while(!answer.matches("[0-9]+")) {
            System.out.println("Wrong input! Choose only numbers!");
            answer = scanner.next();
        }
        return Integer.valueOf(answer);

    }
}
