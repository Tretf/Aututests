package com.geekbrains.hw_lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Войти']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@data-test='BUTTON CITY-SWITCHER']")
    private WebElement citySwitcherButton;

    @Step("Клик на кнопк выбора города")
    public DropDownPage clickCitySwitcherButton() {
        citySwitcherButton.click();
        return new DropDownPage(driver);
    }

    @Step("Отобразить скрыторе меню")
    public MainPage moveToTheatre() {
        actions.moveToElement(driver.findElement(By.xpath("//a[.='ТЕАТР']")))
                .build()
                .perform();
        return this;
    }

    @FindBy(xpath = "//div[@DATA-TEST='SUGGEST']//a[.='Театры Екатеринбурга']")
    private WebElement theatreElement;

    @Step("Выбрать пункт меню Театры Екатеринбурга")
    public MainPage clickTheatreElement() {
        theatreElement.click();
        assert driver.getCurrentUrl().contains("theatre_list");
        return this;
    }

}
