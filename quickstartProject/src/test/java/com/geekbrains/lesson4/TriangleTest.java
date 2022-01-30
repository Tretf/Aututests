package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

//    public static void main(String[] args) {
//        Triangle triangle1 = new Triangle(3, 4, 5);
//
//        Double S1 = triangle1.areaTriangle();
//        System.out.println("S1 = " + S1);
//
//        Triangle triangle2 = new Triangle(3, 4, 0);
//
//        Double S2 = triangle2.areaTriangle();
//        System.out.println("S2 = " + S2);
//    }

    private static Logger logger = LoggerFactory.getLogger("TriangleTest.class");

    @BeforeAll
    static void beforeAll() {
        System.out.println("Выполнимся 1 раз перед всеми тестами, например загрузка данных в базу!");
        //TRACE, DEBUG, INFO, ERROR
        logger.info("log data");
        logger.trace("trace log data");
        logger.error("err log data");
    }

    @Nested
    class WhenEmpty {

        @Test
        void exceptionWhenSidesAreNull() {
            Triangle triangle3 = new Triangle(0, 0, 0);
            ;
            Assertions.assertThrows(TriangleException.class, () -> triangle3.sidesOfTheTriangle());
        }
    }


    @ParameterizedTest
    @MethodSource("triangleDataProviderWithBoolean")
    void dataProviderTest2(Triangle testTriangle, Boolean result) {
        assertEquals(result, testTriangle.areaTriangle() == 6);
        System.out.println(testTriangle.areaTriangle());
    }

    private static Stream<Arguments> triangleDataProviderWithBoolean() {
        return Stream.of(
                Arguments.of(new Triangle(3, 4, 5), true),
                Arguments.of(new Triangle(0, 0, 0), false),
                Arguments.of(new Triangle(1, 2, 4), false)
        );
    }

}
