package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DeliveryTest {
    @Test
    void shouldFormDeliveryPositive() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Владимир");
        $("[data-test-id='date'] input").setValue(Date());
        $("[data-test-id='name'] input").setValue("Сергей Сергеев");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification'").shouldBe(appear, Duration.ofSeconds(15));
    }

    public static String Date() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = today.plusDays(3).format(formatter);
        return date;
    }
}
