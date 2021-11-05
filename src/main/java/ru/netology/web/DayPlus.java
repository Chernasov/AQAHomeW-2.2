package ru.netology.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayPlus {
    LocalDate today = LocalDate.now();
//    LocalDate today = LocalDate.of(2021, 12, 25); // проверял тест

    public String dayPlus(int plus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return today.plusDays(plus).format(formatter);
    }

    public String day(int plus) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        return String.valueOf(Integer.parseInt(today.plusDays(plus).format(formatter)));
    }

    public boolean month() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        int now = Integer.parseInt(today.format(formatter));
        int forward = Integer.parseInt(today.plusDays(7).format(formatter));
        if (forward > now) {
            return true;
        }
        if (now == 12 && forward == 1) {
            return true;
        }
        return false;
    }
}
