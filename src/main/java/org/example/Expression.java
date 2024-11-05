package org.example;

import java.util.Arrays;
import java.util.List;

public class Expression {
    final private String expression;
    private List<Double> numbers;
    private List<String> operators;

    public Expression(String expression) throws InvalidExpressionException {
        if (!ExpressionValidator.isValidExpression(expression))
            throw new InvalidExpressionException("Invalid expression format");
        this.expression = expression;
        extractExpressionDoubles();
        extractOperatorsInExpression();
    }

    private void extractExpressionDoubles() {
        numbers = Arrays.stream(expression
                        .split("[+\\-*/\\s]+"))
                .filter(element -> !element.isEmpty())
                .map(Double::parseDouble)
                .toList();
    }

    private void extractOperatorsInExpression() {
        operators = Arrays.asList(expression.replaceAll("[^+\\-*/]", "").split(""));
    }

    public List<Double> getNumbers() {
        return this.numbers;
    }

    public List<String> getOperators() {
        return operators;
    }
}
