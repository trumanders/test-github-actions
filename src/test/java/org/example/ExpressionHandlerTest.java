package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExpressionHandlerTest {
    private ExpressionHandler expressionHandler;

    @BeforeEach
    public void setup() {
        expressionHandler = new ExpressionHandler();
    }

    @ParameterizedTest
    @MethodSource("isValidExpressionArguments")
    public void testIsValidExpression(boolean expected, String expression) {
        assertEquals(expected, expressionHandler.isValidExpression(expression));
    }

    static Stream<Arguments> isValidExpressionArguments() {
        return Stream.of(
                Arguments.of(false, "1 1"),
                Arguments.of(false, "1 ++ 1"),
                Arguments.of(false, "1++1"),
                Arguments.of(false, "1+-1"),
                Arguments.of(false, "1-/1"),
                Arguments.of(false, "1+*1"),
                Arguments.of(false, "1*/1"),
                Arguments.of(false, "1*-1"),
                Arguments.of(false, "1-/1"),
                Arguments.of(false, "1**1"),
                Arguments.of(false, "1//1"),
                Arguments.of(false, "1--1"),
                Arguments.of(false, "1 a"),
                Arguments.of(false, "11 a 1"),
                Arguments.of(false, "1 +q 3"),
                Arguments.of(false, "+"),
                Arguments.of(false, "-"),
                Arguments.of(false, "/"),
                Arguments.of(false, "*"),
                Arguments.of(false, "+1+1"),
                Arguments.of(false, "-1-1"),
                Arguments.of(false, "*2+1"),
                Arguments.of(false, "/1+1"),
                Arguments.of(false, "a1+2"),
                Arguments.of(false, "1+1+"),
                Arguments.of(false, "1+1-"),
                Arguments.of(false, "1+1/"),
                Arguments.of(false, "1+1*"),
                Arguments.of(false, "1+1-"),
                Arguments.of(false, "1+1-"),
                Arguments.of(false, "1+1-"),

                Arguments.of(true, "1+1"),
                Arguments.of(true, "1 + 1"),
                Arguments.of(true, "1  +  1"),
                Arguments.of(true, "  1+1"),
                Arguments.of(true, "1+1  "),
                Arguments.of(true, "  1+1  "),
                Arguments.of(true, "  1 + 1  "),
                Arguments.of(true, " 1 +1"),
                Arguments.of(true, " 1 + 1"),
                Arguments.of(true, "1 + 1 "),

                Arguments.of(true, "1*1"),
                Arguments.of(true, "1/1"),
                Arguments.of(true, "1-1"),

                Arguments.of(true, "1+1+1"),
                Arguments.of(true, "1+1-1"),
                Arguments.of(true, "1+1*1"),
                Arguments.of(true, "1+1/1"),
                Arguments.of(true, "1*1*1-9"),
                Arguments.of(true, "1-1/2*1-9"),
                Arguments.of(true, "1+1+1+1+1+1+1+1+1+1+1+1+1"),

                Arguments.of(true, "1.0+0.5 * 4 + 3.873/ 43.98"),
                Arguments.of(false, "1.0+0.5 * 4 + 3.873/ 43."),
                Arguments.of(false, "5.0 - 1.")
        );
    }

    @ParameterizedTest
    @MethodSource("getResultArguments")
    public void testGetResults(double expected, String expression) {
        assertEquals(expected, expressionHandler.getResult(expression));
    }

    static Stream<Arguments> getResultArguments() {
        return Stream.of(
                Arguments.of(2, "1 + 1"),
                Arguments.of(0, "1 - 1"),
                Arguments.of(2, "2 / 1"),
                Arguments.of(1.5, "3 / 2"),
                Arguments.of(2.8, "1.4 * 2"),
                Arguments.of(2000, "1000 * 2"),
                Arguments.of(-5, "5 - 5 - 5"),
                Arguments.of(1.25, "5 / 2 / 2"),
                Arguments.of(0, "5 * 2 / 2 - 5"),
                Arguments.of(45, "10 - 1 / 2 * 10"),
                Arguments.of(-12000, "0 -12 /2 *    1000/0.5"),
                Arguments.of(Double.NaN, "0/0")
        );
    }

    @ParameterizedTest
    @MethodSource("extractDoublesInExpressionArguments")
    public void testExtractExpressionDoubles(List<Double> expected, String expression) {
        assertEquals(expected, expressionHandler.extractExpressionDoubles(expression));
    }

    static Stream<Arguments> extractDoublesInExpressionArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(1.0, 2.0, 3.0), "1+2+3"),
                Arguments.of(Arrays.asList(1.1, 2.1, 3.33), "1.1 * 2.1 + 3.33"),
                Arguments.of(Arrays.asList(0.5, 0.03, 33.33), "0.5/ 0.03-33.33")
        );
    }

    @ParameterizedTest
    @MethodSource("extractOperatorsInExpressionArguments")
    public void testExtractExpressionOperators(List<String> expected, String expression) {
        assertEquals(expected, expressionHandler.extractOperatorsInExpression(expression));
    }

    static Stream<Arguments> extractOperatorsInExpressionArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList("+", "+", "+"), "1+2+3+4"),
                Arguments.of(Arrays.asList("+", "-", "/", "*"), "1+2 -3 / 4   *   2"),
                Arguments.of(Arrays.asList("/"), "1/   3"),
                Arguments.of(Arrays.asList("*"), "1  *4"),
                Arguments.of(Arrays.asList("+","-","-","*","*","/"), "1.9+2.222-0.980 -4*33.0983  * 0.00034/1")
        );
    }
}
