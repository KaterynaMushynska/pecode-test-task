package com.pecode.mushynska.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

import static com.pecode.mushynska.utils.PropertyUtil.getBasePageUrl;

@Listeners(UiTestListener.class)
public class TestRunner {
    protected WebDriver driver;

    @BeforeMethod
    public void initDriver(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        context.setAttribute("myDriver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(getBasePageUrl());
    }

    @AfterMethod
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
