package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ResultOfSearchPage extends BasePage {

    public ResultOfSearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultOfSearchPage clickButtonOfCalc(String buttonText) {
        click(By.xpath("//div[text()='" + buttonText + "']"));
        return this;
    }

    public ResultOfSearchPage checkMemoryLineOfCalc(String memoryExpect) {
        assertEquals(memoryExpect, readField(By.id("cwos")));
        return this;
    }

    public ResultOfSearchPage checkResultLineOfCalc(String resultExpect) {
        assertEquals(resultExpect, readField(By.xpath("//span[contains(text(),'Ans')]")));
        return this;
    }

    public ResultOfSearchPage clickButtonTypeOfResult(String buttonRequisite) {
        click(By.xpath("//a[@data-hveid='" + buttonRequisite + "']"));
        return this;
    }

    public void close() {
        closeBrowser();
    }
}
