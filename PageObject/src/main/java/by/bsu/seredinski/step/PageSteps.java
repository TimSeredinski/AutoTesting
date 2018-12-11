package by.bsu.seredinski.step;

import by.bsu.seredinski.page.Page;
import org.openqa.selenium.WebDriver;

public class PageSteps {

    private Page page;

    public PageSteps(WebDriver driver) {
        page = new Page(driver);
    }

    public String tryToBookMoreThenOneInfantPerAdult() {
        page.selectDepartureAirport();
        page.selectReturnAirport();
        page.setPassengers(1);
        page.setInfants(2);
        return page.getWarning();
    }

    public String getErrorWhenDepartureAirportIsEmpty() {
        page.clearFields();
        page.selectReturnAirport();
        page.selectDepartureDate(1);
        page.selectReturnDate(1);
        page.setPassengers(1);
        page.clickSearch();
        return page.getError();
    }

    public String getErrorWhenTheSameAirports() {
        page.selectDepartureDate(1);
        page.selectReturnDate(1);
        page.setPassengers(1);
        page.selectDepartureAirport();
        page.selectReturnAirport("London");
        return page.getCityError();
    }

    public String isChangeDepartureDateWhenReturnDateIsEarlier() {
        page.selectDepartureAirport();
        page.selectReturnAirport();
        page.selectDepartureDate(4);
        page.selectReturnDate(3);
        return page.getEndDate();
    }
}
