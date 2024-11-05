package org.example;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Expression expression;
    static ExpressionHandler expressionHandler;
    static private String userInputExpression;

    public static void main( String[] args ) {
        while(true) {
            try {
                initialize();
                System.out.println(expressionHandler.getResult());
            }
            catch (InvalidExpressionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void initialize() throws InvalidExpressionException {
        userInputExpression = scanner.nextLine();
        expression = new Expression(userInputExpression);
        expressionHandler = new ExpressionHandler(expression);
    }
}
