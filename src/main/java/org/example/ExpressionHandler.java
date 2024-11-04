package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionHandler {
    final private Pattern validExpressionPattern = Pattern.compile("^\\s*(\\d*\\.?\\d+\\s*)([+\\-*/]\\s*(\\d*\\.?\\d+\\s*))*$");
    private Calculator calculator = new Calculator();

    private List<Double> expressionDoubles = new ArrayList<>();
    private List<String> expressionOperators = new ArrayList<>();

    public boolean isValidExpression(String expression) {
        return validExpressionPattern.matcher(expression).matches();
    }

    public List<Double> extractExpressionDoubles(String expression) {
        return Arrays.stream(
                        expression.split("[+\\-*/\\s]+"))
                .filter(element -> !element.isEmpty())
                .map(Double::parseDouble)
                .toList();
    }

    public List<String> extractOperatorsInExpression(String expression) {
        return Arrays.asList(expression.replaceAll("[^+\\-*/]", "").split(""));
    }

    public double getResult(String expression) throws InvalidExpressionException  {
        if (!isValidExpression(expression))
            throw new InvalidExpressionException("Invalid expression, try again.");
        expressionDoubles = extractExpressionDoubles(expression);
        expressionOperators = extractOperatorsInExpression(expression);
        double result = expressionDoubles.get(0);

        for (int i = 1; i < expressionDoubles.size(); i++) {
            double currentValue = expressionDoubles.get(i);
            switch (expressionOperators.get(i - 1)) {
                case "+":
                    result = calculator.getSumOf(result, currentValue);
                    break;
                case "-":
                    result = calculator.getDifferenceOf(result, currentValue);
                    break;
                case "*":
                    result = calculator.getProductOf(result, currentValue);
                    break;
                case "/":
                    result = calculator.getQuotientOf(result, currentValue);
                    break;
            }
        }
        return result;
    }
}
