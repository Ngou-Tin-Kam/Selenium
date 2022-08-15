package com.qa.selenium.exercises.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "#acceptCookieButton")
    private WebElement acceptCookieButton;

    @FindBy(css = "#view-constituents > ul > li:nth-child(2) > a > strong")
    private WebElement risersButton;

    @FindBy(css = "#view-constituents > ul > li:nth-child(3) > a > strong")
    private WebElement fallersButton;

    public void acceptCookies() {
        this.acceptCookieButton.click();
    }

    public void viewRisers() {
        this.risersButton.click();
    }

    public void viewFallers() {
        this.fallersButton.click();
    }
}
