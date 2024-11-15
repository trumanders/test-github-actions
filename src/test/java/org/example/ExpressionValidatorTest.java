//package org.example;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import java.util.regex.Pattern;
//import java.util.stream.Stream;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ExpressionValidatorTest {
////    @ParameterizedTest
////    @MethodSource("isValidExpressionArguments")
////    public void testIsValidExpression(boolean expected, String expression) {
////        assertEquals(expected, ExpressionValidator.isValidExpression(expression));
////    }
////
////    static Stream<Arguments> isValidExpressionArguments() {
////        return Stream.of(
////                Arguments.of(false, "1 1"),
////                Arguments.of(false, "1 ++ 1"),
////                Arguments.of(false, "1++1"),
////                Arguments.of(false, "1+-1"),
////                Arguments.of(false, "1-/1"),
////                Arguments.of(false, "1+*1"),
////                Arguments.of(false, "1*/1"),
////                Arguments.of(false, "1*-1"),
////                Arguments.of(false, "1-/1"),
////                Arguments.of(false, "1**1"),
////                Arguments.of(false, "1//1"),
////                Arguments.of(false, "1--1"),
////                Arguments.of(false, "1 a"),
////                Arguments.of(false, "11 a 1"),
////                Arguments.of(false, "1 +q 3"),
////                Arguments.of(false, "+"),
////                Arguments.of(false, "-"),
////                Arguments.of(false, "/"),
////                Arguments.of(false, "*"),
////                Arguments.of(false, "+1+1"),
////                Arguments.of(false, "-1-1"),
////                Arguments.of(false, "*2+1"),
////                Arguments.of(false, "/1+1"),
////                Arguments.of(false, "a1+2"),
////                Arguments.of(false, "1+1+"),
////                Arguments.of(false, "1+1-"),
////                Arguments.of(false, "1+1/"),
////                Arguments.of(false, "1+1*"),
////                Arguments.of(false, "1+1-"),
////                Arguments.of(false, "1+1-"),
////                Arguments.of(false, "1+1-"),
////
////                Arguments.of(true, "1+1"),
////                Arguments.of(true, "1 + 1"),
////                Arguments.of(true, "1  +  1"),
////                Arguments.of(true, "  1+1"),
////                Arguments.of(true, "1+1  "),
////                Arguments.of(true, "  1+1  "),
////                Arguments.of(true, "  1 + 1  "),
////                Arguments.of(true, " 1 +1"),
////                Arguments.of(true, " 1 + 1"),
////                Arguments.of(true, "1 + 1 "),
////
////                Arguments.of(true, "1*1"),
////                Arguments.of(true, "1/1"),
////                Arguments.of(true, "1-1"),
////
////                Arguments.of(true, "1+1+1"),
////                Arguments.of(true, "1+1-1"),
////                Arguments.of(true, "1+1*1"),
////                Arguments.of(true, "1+1/1"),
////                Arguments.of(true, "1*1*1-9"),
////                Arguments.of(true, "1-1/2*1-9"),
////                Arguments.of(true, "1+1+1+1+1+1+1+1+1+1+1+1+1"),
////
////                Arguments.of(true, "1.0+0.5 * 4 + 3.873/ 43.98"),
////                Arguments.of(false, "1.0+0.5 * 4 + 3.873/ 43."),
////                Arguments.of(false, "5.0 - 1.")
////        );
////    }
//
//    @Test
//    public void checkExpressionRegexPatternString() {
//        Pattern expectedRegexPattern = Pattern.compile( "^\\s*(\\d*\\.?\\d+\\s*)([+\\-*/]\\s*(\\d*\\.?\\d+\\s*))*$");
//        assertEquals(expectedRegexPattern.pattern(), ExpressionValidator.getValidExpressionRegexPattern().pattern());
//    }
//}
