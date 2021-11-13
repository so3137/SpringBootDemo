package com.example.demo17.util;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Comparator.comparingInt;

public class DemoUtils {
    public static boolean weekday(LocalDate date) {
        return Optional.ofNullable(date)
                .map(LocalDate::getDayOfWeek)
                .map(dayOfWeek -> switch (dayOfWeek) {
                    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
                    case SATURDAY, SUNDAY -> false;
                })
                .orElse(false);
    }

    public static int maxValue(List<Integer> values) {
        return Optional.ofNullable(values)
                .stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .max(comparingInt(Integer::intValue))
                .orElse(-1);
    }
}
