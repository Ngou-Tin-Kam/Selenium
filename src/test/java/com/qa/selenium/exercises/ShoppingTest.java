package com.qa.selenium.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingTest {

    private RemoteWebDriver driver;
    private String username = "skykam@test.com";
    private String password = "pass1";

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    void searchTest() {
        this.driver.get("http://automationpractice.com/index.php");
        WebElement searchBox = this.driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        WebElement firstResult = this.driver.findElement(By.cssSelector
                ("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));
        assertEquals("Printed Summer Dress", firstResult.getText());
    }

    @Test
    void checkOutWithWirePaymentTest() {
        this.driver.get("http://automationpractice.com/index.php");
        WebElement searchBox = this.driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        WebElement firstResult = this.driver
                .findElement(By.cssSelector
                        ("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));
        firstResult.click();


        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#add_to_cart > button > span")));

        addToCartButton.click();

        WebElement proceedToCheckOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 " +
                        "> div.button-container > a > span")));

        proceedToCheckOutButton.click();

        WebElement proceedButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")));
        proceedButton.click();

        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        WebElement passwordBox = this.driver.findElement(By.cssSelector("#passwd"));

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);

        WebElement signInButton = this.driver.findElement(By.cssSelector("#SubmitLogin"));
        signInButton.click();

        WebElement proceedButtonTwo = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#center_column > form > p > button")));
        proceedButtonTwo.click();

        WebElement termsAndConditionsCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#form > div > p.checkbox > label")));

        termsAndConditionsCheck.click();

        WebElement proceedButtonThree = this.driver.findElement(By.cssSelector("#form > p > button"));
        proceedButtonThree.click();


        WebElement payByWire = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a")));
        payByWire.click();


        WebElement confirmOrderButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#cart_navigation > button")));
        confirmOrderButton.click();

        WebElement checkField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#center_column > div > p > strong")));

        assertEquals("Your order on My Store is complete.", checkField.getText());
    }

    @Test
    void checkOutWithCheckPaymentTest() {
        this.driver.get("http://automationpractice.com/index.php");
        WebElement searchBox = this.driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        WebElement firstResult = this.driver
                .findElement(By.cssSelector
                        ("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));
        firstResult.click();


        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#add_to_cart > button > span")));

        addToCartButton.click();

        WebElement proceedToCheckOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 " +
                        "> div.button-container > a > span")));

        proceedToCheckOutButton.click();

        WebElement proceedButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")));
        proceedButton.click();

        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        WebElement passwordBox = this.driver.findElement(By.cssSelector("#passwd"));

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);

        WebElement signInButton = this.driver.findElement(By.cssSelector("#SubmitLogin"));
        signInButton.click();

        WebElement proceedButtonTwo = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#center_column > form > p > button")));
        proceedButtonTwo.click();

        WebElement termsAndConditionsCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#form > div > p.checkbox > label")));

        termsAndConditionsCheck.click();

        WebElement proceedButtonThree = this.driver.findElement(By.cssSelector("#form > p > button"));
        proceedButtonThree.click();

        WebElement payByCheck = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p > a")));
        payByCheck.click();

        WebElement confirmOrderButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#cart_navigation > button")));
        confirmOrderButton.click();

        WebElement checkField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#center_column > p.alert.alert-success")));

        assertEquals("Your order on My Store is complete.", checkField.getText());
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}
