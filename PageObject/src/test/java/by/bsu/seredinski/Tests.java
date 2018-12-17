package by.bsu.seredinski;

import by.bsu.seredinski.common.SearchDataParameters;
import by.bsu.seredinski.step.PageSteps;
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
    private PageSteps page;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.flysas.com/gb-en/");
        page = new PageSteps(driver);
    }

    @Test
    public void bookingMoreThenOneInfantPerAdult() {
        SearchDataParameters data = new SearchDataParameters();
        data.setOriginCity("London");
        data.setDestinationCity("Paris");
        data.setNumOfAdults(0);
        data.setNumOfInfant(2);
        String expectError = "It's not possible to book more than one infant ticket per adult";
        assertEquals(expectError, page.tryToBookMoreThenOneInfantPerAdult(data));
    }

    @Test
    public void findTicketWhenDepartureAirportIsEmpty() {
        SearchDataParameters data = new SearchDataParameters();
        data.setDestinationCity("Paris");
        data.setNumOfDaysFromNowInDepartureDate(1);
        data.setNumOfDaysFromNowInReturnDate(1);
        String expectError = "Please enter a valid city, airport or country you're leaving from.";
        assertEquals(expectError, page.getErrorWhenDepartureAirportIsEmpty(data));
    }

    @Test
    public void getInfoWhenBookYouthsTickets() {
        SearchDataParameters data = new SearchDataParameters();
        data.setOriginCity("London");
        data.setDestinationCity("Paris");
        String expectError = "Youth tickets can't be combined with other tickets and must be booked seperately.";
        assertEquals(expectError, page.tryToBookYouthsTickets(data));
    }

    @Test
    public void isEmptyReturnDateWhenReturnDateIsEarlier() {
        SearchDataParameters data = new SearchDataParameters();
        data.setOriginCity("Copenhagen");
        data.setDestinationCity("London");
        data.setNumOfDaysFromNowInDepartureDate(5);
        data.setNumOfDaysFromNowInReturnDate(1);
        String expectError = "";
        assertEquals(expectError, page.isChangeDepartureDateWhenReturnDateIsEarlier(data));
    }

    @Test
    public void findTicketWhenTheSameAirports() {
        SearchDataParameters data = new SearchDataParameters();
        data.setOriginCity("Copenhagen");
        data.setDestinationCity("Copenhagen");
        data.setNumOfDaysFromNowInDepartureDate(1);
        data.setNumOfDaysFromNowInReturnDate(1);
        String expectError = "Please check your selected cities.";
        assertEquals(expectError, page.getErrorWhenTheSameAirports(data));
    }

    @Test
    public void stageOfRegistrationWhenAllFieldsAreCurrect() {
        SearchDataParameters data = new SearchDataParameters();
        data.setOriginCity("Copenhagen");
        data.setDestinationCity("London");
        data.setNumOfDaysFromNowInDepartureDate(1);
        data.setNumOfDaysFromNowInReturnDate(1);
        String expectStage = "1. Select flights";
        assertEquals(expectStage, page.tryToFindFlightWithCurrentData(data));
    }

    @Test
    public void secondStageOfRegistrationWhenAllFieldsAreCurrect() {
        SearchDataParameters data = new SearchDataParameters();
        data.setOriginCity("Copenhagen");
        data.setDestinationCity("London");
        data.setNumOfDaysFromNowInDepartureDate(2);
        data.setNumOfDaysFromNowInReturnDate(9);
        String expectStage = "This traveler will receive the receipt for the trip";
        assertEquals(expectStage, page.tryToChooseTickets(data));
    }

    @After
    public void end() {
        driver.quit();
    }
}
