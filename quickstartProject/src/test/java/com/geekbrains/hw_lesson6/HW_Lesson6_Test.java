package com.geekbrains.hw_lesson6;

import com.geekbrains.lesson7.CustomLoggerNew;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

public class HW_Lesson6_Test {
    WebDriver driver;
    private final static String AFISHA_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
//        driver = new ChromeDriver();
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
        driver.get(AFISHA_URL);
    }

    @Test
    @Description("Проверка перехода на страницу Театры Екатеринбурга")
    void changeCityTest() {
        new MainPage(driver)
                .clickCitySwitcherButton()
                .visibleDropDown()
                .clickChangeCityButton()
                .moveToTheatre()
                .clickTheatreElement();

        Assertions.assertTrue(driver.getCurrentUrl().contains("theatre_list"));
    }

    @AfterEach
    void killDriver() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logEntries.iterator();

//        "Тоже работает"
//        while (iterator.hasNext()) {
//            Allure.addAttachment("Лог браузера: ", iterator.next().getMessage());
//        }

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера: ", log.getMessage());
        }
        driver.quit();
    }
}
