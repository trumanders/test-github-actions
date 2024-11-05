package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionHandler {
    private Calculator calculator = new Calculator();
    private Expression expression;

    public ExpressionHandler(Expression expression) {
        setExpression(expression);
    }

    public double getResult() {
        double result = this.expression.getNumbers().get(0);

        for (int i = 1; i < expression.getNumbers().size(); i++) {
            double currentValue = expression.getNumbers().get(i);

            switch (expression.getOperators().get(i - 1)) {
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

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
