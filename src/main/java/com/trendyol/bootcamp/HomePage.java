package com.trendyol.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    By searchBoxBy = By.className("search-box");
    By suggestionTitleBy = By.className("suggestion-title");
    By accountButtonBy = By.className("account-user");
    By accountButtonListBy = By.className("account-user");
    By accountTextBy = By.className("");
    WebDriver webDriver;

 public HomePage(WebDriver webDriver){
     this.webDriver = webDriver;

 }

    public void search(String keyword) {
    webDriver.findElement(searchBoxBy).sendKeys(keyword + Keys.ENTER);
    //webDriver.findElement(searchBoxBy).sendKeys(Keys.ENTER); ya da bu şekilde ayrı olabilir.
    }

    public void enterSearchKeyword(String keyword){
        webDriver.findElement(searchBoxBy).sendKeys(keyword);
    }

    public boolean isSuggestionDisplayed() {
        return webDriver.findElement(suggestionTitleBy).isDisplayed();
    }
    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public void waitForLoad(){
        WebDriverWait wait= new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-user"))).getText();
    }

    public String accountText() {
    return webDriver.findElement(accountButtonBy).getText();
    }

    public String getAccountText() {
        return webDriver.findElement(accountTextBy).getText();
    }
}
