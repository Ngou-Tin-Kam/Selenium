package com.qa.selenium.exercises.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTSETest {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    void testRisers() {
        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");

        HomePage homePage = PageFactory.initElements(this.driver, HomePage.class);
        homePage.acceptCookies();

        homePage.viewRisers();

        RisersPage riserPage = PageFactory.initElements(this.driver, RisersPage.class);
        String result = riserPage.getTopRiserResult();

        assertEquals("RS Group plc", result);
    }

    @Test
    void testFallers() {
        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");

        HomePage homePage = PageFactory.initElements(this.driver, HomePage.class);
        homePage.acceptCookies();

        homePage.viewFallers();

        FallersPage fallerPage = PageFactory.initElements(this.driver, FallersPage.class);
        String result = fallerPage.getTopFallersResult();

        assertEquals("Haleon plc", result);
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}
