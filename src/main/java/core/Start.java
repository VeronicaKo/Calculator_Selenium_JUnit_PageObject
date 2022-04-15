package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.PicturePage;
import pages.ResultOfSearchPage;
import pages.MainPage;

import java.time.Duration;


public class Start {

    public WebDriver driver;
    public MainPage mainPage;
    public ResultOfSearchPage resultOfSearchPage;
    public PicturePage picturePage;


    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        resultOfSearchPage = PageFactory.initElements(driver, ResultOfSearchPage.class);
        picturePage = PageFactory.initElements(driver, PicturePage.class);
    }
}
