package com.geekbrains.hw_lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDownPage extends BasePage{

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@data-test='DROPDOWN']")
    private WebElement cityDropDown;

    public DropDownPage visibleDropDown() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cityDropDown));
        return this;
    }


  //  @FindBy(xpath ="//div[@data-test='DROPDOWN-CONTENT']")
    @FindBy(xpath="//div[@data-test='DROPDOWN-CONTENT']/descendant::li[.='Екатеринбург']/button")
    private WebElement changeCityButton;

    public MainPage clickChangeCityButton() {
        changeCityButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MainPage(driver);
    }
}
