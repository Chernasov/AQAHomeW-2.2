package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryTest {
    private DayPlus dayPlus = new DayPlus();

    @Test
    void shouldFormDeliveryPositive() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Владимир");
        $("[data-test-id='date'] input").setValue(dayPlus.dayPlus(3));
        $("[data-test-id='name'] input").setValue("Сергей Сергеев");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification'").shouldBe(appear, Duration.ofSeconds(15));
    }

    @Test
    void shouldFormDeliveryPositiveWithList() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("аб");
        $$(".menu-item__control").last().click();
        $(".input__icon").click();
        if (dayPlus.month()) {
            $("[data-step='1']");
        }
        String day = dayPlus.day(7);
        $$(".calendar__day").find(exactText(day)).click();
        $("[data-test-id='name'] input").setValue("Сергей Сергеев");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id='notification'").shouldBe(appear, Duration.ofSeconds(15));
    }

}
