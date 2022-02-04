package com.geekbrains.hw_lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.exception.ExceptionContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_Lesson6_Test {
    WebDriver driver;
    private final static String AFISHA_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(AFISHA_URL);
    }

    @Test
    void changeCityTest() {
        new MainPage(driver)
                .clickCitySwitcherButton()
                .visibleDropDown()
                .clickChangeCityButton()
                .moveToTheatre()
                .clickTheatreElement();

    }


    @AfterEach
    void killDriver() {
        driver.quit();
    }
}
