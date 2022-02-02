package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW_Lesson5_Test {

        WebDriver driver;
        WebDriverWait webDriverWait;
        Actions actions;
        private final static String AFISHA_URL = "https://afisha.ru";

        @BeforeAll
        static void registerDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void initDriver() {
            driver = new ChromeDriver();
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            actions = new Actions(driver);
            driver.get(AFISHA_URL);
            driver.manage().window().maximize();
            //driver.manage().window().setSize(new Dimension(337, 665));    // для мобильной версии сайта
        }

        @Test
        void changeCityTest() {
        // выбираем город Екатеринбург
            driver.findElement(By.xpath("//button[@data-test='BUTTON CITY-SWITCHER']")).click();
            driver.findElement(By.xpath("//div[@data-test='DROPDOWN-CONTENT']"));
            driver.findElement(By.xpath("//div[@data-test='DROPDOWN-CONTENT']/descendant::li[.='Екатеринбург']/button")).click();
        }

        @Test
        void hoverMenuTest() throws InterruptedException {

            // выбираем город Екатеринбург
            driver.findElement(By.xpath("//button[@data-test='BUTTON CITY-SWITCHER']")).click();
            driver.findElement(By.xpath("//div[@data-test='DROPDOWN-CONTENT']"));
            driver.findElement(By.xpath("//div[@data-test='DROPDOWN-CONTENT']/descendant::li[.='Екатеринбург']/button")).click();

            Thread.sleep(5000);
            actions.moveToElement(driver.findElement(By.xpath("//a[.='ТЕАТР']")))
            //actions.moveToElement(driver.findElement(By.xpath("//a[contains(@href, 'theatre')]/ancestor::div[@data-test='ITEM']")))
                    .build()
                    .perform();
            driver.findElement(By.xpath("//div[@DATA-TEST='SUGGEST']//a[.='Театры Екатеринбурга']")).click();
            Assertions.assertTrue(driver.getCurrentUrl().contains("theatre_list"));
        }


        @AfterEach
        void tearDown() {
            driver.quit();
        }
}
