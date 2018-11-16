package test.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class WD {

    private WebDriver driver;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("https://www.flysas.com/gb-en/");
    }

    @Test
    public void findTicketWhenDepartureDateIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, 0);
        WebElement origin = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("origin")));
        WebElement destination = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("destination")));
        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-button")));
        origin.clear();
        origin.sendKeys("London");
        origin.submit();
        destination.sendKeys("Paris");
        destination.submit();
        search.submit();
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        String expectError = "Please select a departure date";
        assertEquals(expectError, error.getText());
    }

    @After
    public void end() {
        driver.quit();
    }
}
