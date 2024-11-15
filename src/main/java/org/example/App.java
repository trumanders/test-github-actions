package org.example;

import java.util.Scanner;

/**
 * This program allows the user to input mathematical expressions and evaluates them.
 * It supports basic arithmetic operations including addition (+), subtraction (-),
 * multiplication (*), and division (/). The user can enter multiple expressions,
 * such as "7*8/7+9-5*8", and the program will calculate the result for each input.

 * Restrictions:
 * - Parentheses () are not supported for grouping expressions.
 * - Expressions like "-1 + 1" (with a leading negative sign) are not allowed.

 * The program runs in a continuous loop, prompting the user to enter an expression,
 * evaluates the expression using the `ExpressionHandler` class, and outputs the result.
 * If an invalid expression is entered, an `InvalidExpressionException` is thrown,
 * and an error message is displayed to the user.

 * The `Expression` class is used to represent the mathematical expression, and
 * the `ExpressionHandler` class is responsible for processing and evaluating
 * the expression to produce the result.
 */

/* TEST PUSH */

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Expression expression;
    static ExpressionHandler expressionHandler;
    static private String userInputExpression;

    public static void main( String[] args ) {
        while(true) {
            try {
                System.out.println("Enter expression > ");
                initialize();
                System.out.println(expressionHandler.getResult());
            }
            catch (InvalidExpressionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void initialize() throws InvalidExpressionException {
        expressionHandler = new ExpressionHandler(new Expression(scanner.nextLine()));
    }
}
