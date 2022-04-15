package pages;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void isElementDisplayed (By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    public void fillField(By elementBy, String textOfSearch) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(textOfSearch);
    }

    public String readField(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void saveFileByLink(By elementBy, String typeOfFile) {
        try {
        String downloadLink = driver.findElement(elementBy).getAttribute("src");
        File fileToSave = new File("/path/to/file"+ typeOfFile);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(downloadLink);

            HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());
            copyInputStreamToFile(response.getEntity().getContent(), fileToSave);
        }
        catch  (IOException e) {
            assertTrue(false,"Файл не загружен");
        }
    }

}
