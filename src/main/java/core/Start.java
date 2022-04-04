package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CalculatePage;
import pages.MainPage;

import java.time.Duration;


public class Start {

    public WebDriver driver;
    public MainPage mainPage;
    public CalculatePage calculatePage;

    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        calculatePage = PageFactory.initElements(driver, CalculatePage.class);
    }

    @AfterEach
    public void finish() {
        driver.quit();
    }
}
