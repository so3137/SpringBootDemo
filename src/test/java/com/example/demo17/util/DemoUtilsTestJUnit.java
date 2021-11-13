package com.example.demo17.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.example.demo17.util.DemoUtils.maxValue;
import static com.example.demo17.util.DemoUtils.weekday;

public class DemoUtilsTestJUnit {

    @ParameterizedTest
    @CsvSource({
            "2021-11-01, true",
            "2021-11-02, true",
            "2021-11-03, true",
            "2021-11-04, true",
            "2021-11-05, true",
            "2021-11-06, false",
            "2021-11-07, false",
            ", false"
    })
    void weekdayTest(LocalDate date, boolean expected) {
        Assertions.assertEquals(expected, weekday(date));
    }

    @ParameterizedTest
    @MethodSource("maxValueTestProvider")
    void maxValueTest(List<Integer> values, int expected) {
        Assertions.assertEquals(expected, maxValue(values));
    }

    public static Stream<Arguments> maxValueTestProvider() {
        return Stream.of(
                Arguments.arguments(null, -1),
                Arguments.arguments(Collections.EMPTY_LIST, -1),
                Arguments.arguments(Arrays.asList(null, 1, -1), 1)
        );
    }
}
