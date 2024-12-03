package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();          // настройки браузера Chrome
        chromeOptions.addArguments("--disable-notifications");      // отключение всплывающих окон

        chromeOptions.addArguments("--headless");     // настройка для отключения интерфейса ("без головы")
        // настройка, чтобы сайт был выше в поисковой выдаче Google и Yandex, т.е. отдельные сранички сайта для поисковых роботов
        // (версия для людей, версия для поисковых роботов, на ней не работает Javascript)
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");

        WebDriver driver = new ChromeDriver(chromeOptions);     // передаём насройки в конструктор драйвера

        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
