package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PicturePage extends BasePage {
    public PicturePage(WebDriver driver) {
        super(driver);
    }

    public PicturePage clickOnPictureNumber(int elemNumber) {
        click(By.xpath("(//a[@jsname='sTFXNd'])["+ elemNumber +"]"));
        return this;
    }

    public PicturePage savePicture() {
        saveFileByLink(By.xpath("(//img[@class='n3VNCb'])[1]"),".jpg");
        return this;
    }

    public void close() {
        closeBrowser();
    }
}
