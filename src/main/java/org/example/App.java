package org.example;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Expression expression;
    static ExpressionHandler expressionHandler;
    static private String userInputExpression;

    public static void main( String[] args ) {
        while(true) {
            initialize();
            System.out.println(expressionHandler.getResult());
        }
    }

    private static void initialize() {
        userInputExpression = scanner.nextLine();

        try {
            expression = new Expression(userInputExpression);
        }
        catch (InvalidExpressionException e) {
            System.out.println(e.getMessage());
        }
        expressionHandler = new ExpressionHandler(expression);
    }
}
