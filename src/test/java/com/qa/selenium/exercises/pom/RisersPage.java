package com.qa.selenium.exercises.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RisersPage {

    @FindBy(css = "#ls-row-RS1-L > td.name-col.align-left > a")
    private WebElement topRiserResult;

    public String getTopRiserResult() {
        return this.topRiserResult.getText();
    }
}
