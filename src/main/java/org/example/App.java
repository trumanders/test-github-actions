package org.example;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args ) {
        ExpressionHandler expressionHandler = new ExpressionHandler();
        while(true) {
            try {
                System.out.println(expressionHandler.getResult(scanner.nextLine()));
            }
            catch (InvalidExpressionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
