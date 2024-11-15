package org.example;

//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;

//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressionHandlerTest {
    private ExpressionHandler expressionHandler;

    @Test
    public void setup() throws InvalidExpressionException {
        try {
            expressionHandler = new ExpressionHandler(new Expression("1+2-3*4/5"));
        } catch (Exception e) {
            fail("Exception was thrown: " + e.getMessage());
        }
    }

//    @ParameterizedTest
//    @MethodSource("getResultArguments")
//    public void testGetResult(Double expectedResult, String validExpression) throws InvalidExpressionException {
//        expressionHandler = new ExpressionHandler(new Expression(validExpression));
//        assertEquals(expectedResult, expressionHandler.getResult());
//    }
//
//    static Stream<Arguments> getResultArguments() {
//        return Stream.of(
//                Arguments.of(2.0, "1 + 1"),
//                Arguments.of(0.0, "1 - 1"),
//                Arguments.of(2.0, "2 / 1"),
//                Arguments.of(1.5, "3 / 2"),
//                Arguments.of(2.8, "1.4 * 2"),
//                Arguments.of(2000.0, "1000 * 2"),
//                Arguments.of(-5.0, "5 - 5 - 5"),
//                Arguments.of(1.25, "5 / 2 / 2"),
//                Arguments.of(0.0, "5 * 2 / 2 - 5"),
//                Arguments.of(45.0, "10 - 1 / 2 * 10"),
//                Arguments.of(-12000.0, "0 -12 /2 *    1000/0.5"),
//                Arguments.of(Double.NaN, "0/0")
//        );
//    }
}