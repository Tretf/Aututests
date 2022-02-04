package com.geekbrains.hw_lesson6;

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

    public DropDownPage clickCitySwitcherButton() {
        citySwitcherButton.click();
        return new DropDownPage(driver);
    }


    public MainPage moveToTheatre() {
        actions.moveToElement(driver.findElement(By.xpath("//a[.='ТЕАТР']")))
                .build()
                .perform();
        return new MainPage(driver);
    }

    @FindBy(xpath = "//div[@DATA-TEST='SUGGEST']//a[.='Театры Екатеринбурга']")
    private WebElement theatreElement;

    public MainPage clickTheatreElement() {
        theatreElement.click();
        return new MainPage(driver);
    }

}
