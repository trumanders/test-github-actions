package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionValidator {
    static final private Pattern validExpressionRegexPattern = Pattern.compile("^\\s*(\\d*\\.?\\d+\\s*)([+\\-*/]\\s*(\\d*\\.?\\d+\\s*))*$");
    static public boolean isValidExpression(String expression) {
        return validExpressionRegexPattern.matcher(expression).matches();
    }

    static public Pattern getValidExpressionRegexPattern() {
        return validExpressionRegexPattern;
    }
}