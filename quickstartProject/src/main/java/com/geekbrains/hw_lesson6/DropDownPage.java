package com.geekbrains.hw_lesson6;

import io.qameta.allure.Step;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DropDownPage extends BasePage {

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-test='DROPDOWN']")
    private WebElement cityDropDown;

    @Step("Открыть окно выбора города")
    public DropDownPage visibleDropDown() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cityDropDown));
        return this;
    }

    @FindBy(xpath = "//div[@data-test='DROPDOWN-CONTENT']/descendant::li[.='Екатеринбург']/button")
    private WebElement changeCityButton;

    @Step("Выбрать город")
    public MainPage clickChangeCityButton() {
        changeCityButton.click();
        webDriverWait.until(ExpectedConditions.invisibilityOf(cityDropDown));
        return new MainPage(driver);
    }
}
