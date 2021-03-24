package com.trendyol.bootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class seleniumTest extends BaseTest {
    WebDriver webDriver;

    @Test
    public void shouldSearch() {

        String keyword="bilgisayar";
        HomePage homePage = new HomePage(webDriver);
        homePage.search(keyword);

        SearchResultPage searchResultPage = new SearchResultPage();
        String resultText = searchResultPage.getResultText();
        Assert.assertEquals(resultText, keyword);
   }


    @Test
    public void shouldDisplayRecommendationOnSearchBox() {
        String keyword="bilgisayar";
        HomePage homePage = new HomePage(webDriver);
        homePage.enterSearchKeyword(keyword);
        boolean searchCommendation = homePage.isSuggestionDisplayed();
        assertEquals(searchCommendation,true);

    }


    @Test
    public void shouldLoginAndTests() {
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage= homePage.getLoginPage();
        //loginPage.login("",""); böyle de oolabilirdi

        User user= new User("******","*******");
        homePage= loginPage.login(user.getEmail(),user.getPassword());

        String accountButtonText=homePage.getAccountText();
        assertEquals(accountButtonText,"Hesabım");

    }
    //Siteden logout olunur
    @Test
    public void shouldLogout() {
        webDriver.findElement(By.className("i-logout")).click();
    }


}
