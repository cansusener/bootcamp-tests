package com.trendyol.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver webDriver;
    By emailBy=By.id("login-email");
    By passwordBy=By.id("login-password-input");
    By submitBy=By.className("submit");
    public LoginPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public HomePage login(String email, String password) {

        webDriver.findElement(emailBy).sendKeys(email);
        webDriver.findElement(passwordBy).sendKeys(password);
        webDriver.findElement(submitBy).click();
        return new HomePage(webDriver);
    }
}
