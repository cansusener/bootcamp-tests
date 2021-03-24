package com.trendyol.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver webDriver;

    By descriptionBy = By.cssSelector(".dscptn>h1");


    public void SearchResultPage(){
        this.webDriver=webDriver;
    }


    public String getResultText() {
        return webDriver.findElement(descriptionBy).getText();
    }
}
