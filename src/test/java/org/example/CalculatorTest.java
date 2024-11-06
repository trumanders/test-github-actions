package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    /* ADDITION */
    @ParameterizedTest
    @MethodSource("additionTestCasesArguments")
    @DisplayName("Addition test cases:")
    public void testAddition(double expected, double a, double b, String testCaseName) {
        assertEquals(expected, calculator.getSumOf(a, a), testCaseName);
    }

    static Stream<Arguments> additionTestCasesArguments() {
        return Stream.of(
                Arguments.of(3,1,2, "1 + 2 = 3"),
                Arguments.of(-1,0,-1, "0 + -1 = -1"),
                Arguments.of(1,0,1, "0 + 1 = 1"),
                Arguments.of(Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, "Max value + max value"),
                Arguments.of(Double.NEGATIVE_INFINITY, -Double.MAX_VALUE, -Double.MAX_VALUE, "-Max value + -max value")

        );
    }

    /* SUBTRACTION */
    @ParameterizedTest
    @MethodSource("subtractionTestCasesArguments")
    @DisplayName("Subtraction test cases:")
    public void testSubtraction(double expected, double a, double b, String testCaseName) {
        assertEquals(expected, calculator.getDifferenceOf(a, b), testCaseName);
    }

    static Stream<Arguments> subtractionTestCasesArguments() {
        return Stream.of(
                Arguments.of(0,0,0, "0 - 0 = 0"),
                Arguments.of(-1,0,1, "0 - 1 = -1"),
                Arguments.of(1,0,-1, "0 - -1 = 1"),
                Arguments.of(0,Double.MAX_VALUE, Double.MAX_VALUE, "Max value - max value"),
                Arguments.of(0,-Double.MAX_VALUE, -Double.MAX_VALUE, "Min value - min value"),
                Arguments.of(Double.POSITIVE_INFINITY, Double.MAX_VALUE, -Double.MAX_VALUE, "Max value - min value"),
                Arguments.of(Double.NEGATIVE_INFINITY, -Double.MAX_VALUE, Double.MAX_VALUE, "Min value - max value")
        );
    }


    /* MULTIPLICATION */
    @ParameterizedTest
    @MethodSource("multiplicationTestCasesArguments")
    @DisplayName("Multiplication test cases:")
    public void testMultiplication(double expected, double a, double b, String testCaseName) {
        assertEquals(expected, calculator.getProductOf(a, b), testCaseName);
    }

    static Stream<Arguments> multiplicationTestCasesArguments() {
        return Stream.of(
                Arguments.of(2,1,2, "1 * 2"),
                Arguments.of(2,-1,-2, "-1 * -2"),
                Arguments.of(-2,1,-2, "1 * -2"),
                Arguments.of(-2,-1,2, "-1 * 2"),
                Arguments.of(-Double.MAX_VALUE + 1, Double.MAX_VALUE, -1, "Max value * -1"),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE, 1, "Max value * 1"),
                Arguments.of(-Double.MAX_VALUE, -Double.MAX_VALUE, 1, "Min value * 1"),
                Arguments.of(Double.POSITIVE_INFINITY, Double.MAX_VALUE, 2, "Man value * 2"),
                Arguments.of(Double.NEGATIVE_INFINITY, Double.MAX_VALUE, -2, "Man value * 2"),
                Arguments.of(Double.POSITIVE_INFINITY, -Double.MAX_VALUE, -2, "Min value * -2"),
                Arguments.of(Double.NEGATIVE_INFINITY, -Double.MAX_VALUE, 2, "Min value * 2")
        );
    }

    /* DIVISION */
    @ParameterizedTest
    @MethodSource("divisionTestCasesArguments")
    @DisplayName("Division test cases:")
    public void testDivision(double expected, double a, double b, String testCaseName) {
        assertEquals(expected, calculator.getQuotientOf(a, b), testCaseName);
    }

    static Stream<Arguments> divisionTestCasesArguments() {
        return Stream.of(
             Arguments.of(0,0,1, "0 / 1"),
             Arguments.of(1,1,1, "1 / 1"),
             Arguments.of(1,-1,-1, "-1 / -1"),
             Arguments.of(-1,-1,1, "-1 / 1"),
             Arguments.of(Double.POSITIVE_INFINITY,1,0, "1 / 0"),
             Arguments.of(Double.NEGATIVE_INFINITY,-1,0, "-1 / 0"),
             Arguments.of(Double.NaN,0,0, "0 / 0"),
             Arguments.of(Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.5, "Max value / 0.5"),
             Arguments.of(Double.NEGATIVE_INFINITY, Double.MAX_VALUE, -0.5, "Max value / -0.5"),
             Arguments.of(Double.POSITIVE_INFINITY, -Double.MAX_VALUE, -0.5, "Mix value / -0.5"),
             Arguments.of(Double.NEGATIVE_INFINITY, -Double.MAX_VALUE, 0.5, "Mix value / -0.5")
        );
    }
}
