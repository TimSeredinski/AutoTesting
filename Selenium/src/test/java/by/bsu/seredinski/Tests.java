package by.bsu.seredinski;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Tests {

    private WebDriver driver;
    private Page page;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.flysas.com/gb-en/");
        page = new Page(driver);
    }

    @Test
    public void bookingMoreThenOneInfantPerAdult() {
        String expectError = "It's not possible to book more than one infant ticket per adult";
        assertEquals(expectError, page.tryToBookMoreThenOneInfantPerAdult());
    }

    @After
    public void end() {
        driver.quit();
    }
}
