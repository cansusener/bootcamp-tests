package com.trendyol.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

WebDriver webDriver;

    // Chrome u ayağa kaldırır.
    @BeforeMethod
    public void startUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        String projectPath = System.getProperty("user.dir"); // Projenin bizim pcmizdeki pathini döner.
        System.setProperty("webdriver.chrome.driver", projectPath);
        //"C:\\Users\\CANSU\\Downloads\\chromedriver\\chromedriver.exe" == projectPath
        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.trendyol.com/");

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.findElement(By.className("fancybox-close"))
                .click();
    }

    //Chrome u kapatır.
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

}
