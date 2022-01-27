package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HW_Lesson3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://afisha.ru");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath("//button[.='Войти']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));

        driver.findElement(By.id("login")).sendKeys("tre_tf");
        driver.findElement(By.id("password")).sendKeys("@Hjvfirf2");

        webDriverWait.until(d->d.findElement(By.id("login")).getAttribute("value").contains("@rambler"));

        driver.findElement(By.xpath("//span[.='Войти']/..")).click();
        Thread.sleep(10000);


        driver.findElement(By.xpath("//button[@data-test='BUTTON CITY-SWITCHER']")).click();

        driver.findElement(By.xpath("//div[@data-test='DROPDOWN-CONTENT']"));
        driver.findElement(By.xpath("//div[@data-test='DROPDOWN-CONTENT']/descendant::li[.='Екатеринбург']/button")).click();

        List<WebElement> filmList = driver.findElements(By.xpath("//a[contains(@href, 'theatre')]/ancestor::div[@data-test='ITEM']"));
        //filmList.stream().filter(f -> f.getText().contains("Юнона и Авось")).findFirst().get().click();

        //driver.findElements(By.xpath("//a[contains(@href, 'theatre')]


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//selection[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));

        driver.findElement(By.xpath("//selection[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();

        Thread.sleep(10000);

        driver.quit();
    }
}
