package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    String SITE_URL = "https://www.google.com/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goTo() {
        driver.get(SITE_URL);
        return this;
    }

    public MainPage fillTextSearch(String searchText) {
        fillField(By.cssSelector("input[name='q']"), searchText);
        return this;
    }

    public MainPage clickSearchButton() {
        click(By.cssSelector("input[name='btnK']"));
        return this;
    }

}
