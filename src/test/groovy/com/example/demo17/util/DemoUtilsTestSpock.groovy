package com.example.demo17.util

import spock.lang.Specification

import java.time.LocalDate

import static com.example.demo17.util.DemoUtils.maxValue
import static com.example.demo17.util.DemoUtils.weekday

class DemoUtilsTestSpock extends Specification {

    def "test weekday"() {
        expect:
        expected == weekday(date)

        where:
        date                      | expected
        LocalDate.of(2021, 11, 1) | true
        LocalDate.of(2021, 11, 2) | true
        LocalDate.of(2021, 11, 3) | true
        LocalDate.of(2021, 11, 4) | true
        LocalDate.of(2021, 11, 5) | true
        LocalDate.of(2021, 11, 6) | false
        LocalDate.of(2021, 11, 7) | false
        null                      | false
    }

    def "test maxValue"() {
        expect:
        expected == maxValue(values)

        where:
        values        | expected
        null          | -1
        []            | -1
        [null, 1, -1] | 1
    }
}
