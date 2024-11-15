//package org.example;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;
//
//
//public class ExpressionTest {
//
//    @Test
//    public void instantiate() throws InvalidExpressionException {
//        String validExpressions = "1 + 1";
//        assertDoesNotThrow(() -> new Expression(validExpressions));
//    }
//
//    @ParameterizedTest
//    @MethodSource("extractNumbersFromExpressionArguments")
//    public void testExtractNumbersFromExpression(List<Double> expected, Expression expression) {
//        assertEquals(expected, expression.getNumbers());
//    }
//
//    static Stream<Arguments> extractNumbersFromExpressionArguments() throws InvalidExpressionException {
//        return Stream.of(
//                Arguments.of(Arrays.asList(1.0, 2.0, 3.0), new Expression("1+2+3")),
//                Arguments.of(Arrays.asList(1.1, 2.1, 3.33), new Expression("1.1 * 2.1 + 3.33")),
//                Arguments.of(Arrays.asList(0.5, 0.03, 33.33), new Expression("0.5/ 0.03-33.33"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("extractOperatorsFromExpressionArguments")
//    public void testExtractOperatorsFromExpression(List<String> expected, Expression expression) {
//        assertEquals(expected, expression.getOperators());
//    }
//
//    static Stream<Arguments> extractOperatorsFromExpressionArguments() throws InvalidExpressionException {
//        return Stream.of(
//                Arguments.of(Arrays.asList("+", "+", "+"), new Expression("1+2+3+4")),
//                Arguments.of(Arrays.asList("+", "-", "/", "*"), new Expression("1+2 -3 / 4   *   2")),
//                Arguments.of(Arrays.asList("/"), new Expression("1/   3")),
//                Arguments.of(Arrays.asList("*"), new Expression("1  *4")),
//                Arguments.of(Arrays.asList("+","-","-","*","*","/"), new Expression("1.9+2.222-0.980 -4*33.0983  * 0.00034/1"))
//        );
//    }
//}
