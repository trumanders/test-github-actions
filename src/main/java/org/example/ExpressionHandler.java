package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionHandler {
    final private Calculator calculator = new Calculator();
    private Expression expression;

    public ExpressionHandler(Expression expression) {
        setExpression(expression);
    }

    public double getResult() {
        double result = this.expression.getNumbers().getFirst();

        for (int i = 1; i < expression.getNumbers().size(); i++) {
            double currentValue = expression.getNumbers().get(i);

            result = switch (expression.getOperators().get(i - 1)) {
                case "+" -> calculator.getSumOf(result, currentValue);
                case "-" -> calculator.getDifferenceOf(result, currentValue);
                case "*" -> calculator.getProductOf(result, currentValue);
                case "/" -> calculator.getQuotientOf(result, currentValue);
                default -> result;
            };
        }
        return result;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
