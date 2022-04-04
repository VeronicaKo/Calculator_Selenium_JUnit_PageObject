package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatePage extends BasePage {

    public CalculatePage(WebDriver driver) {
        super(driver);
    }

    public CalculatePage clickButtonOfCalc(String buttonText) {
        click(By.xpath("//div[text()='" + buttonText + "']"));
        return this;
    }

    public CalculatePage checkMemoryLine(String memoryExpect) {
        assertEquals(memoryExpect, readField(By.id("cwos")));
        return this;
    }

    public CalculatePage checkResultLine(String resultExpect) {
        assertEquals(resultExpect, readField(By.xpath("//span[contains(text(),'Ans')]")));
        return this;
    }
}
