package by.bsu.seredinski.step;

import by.bsu.seredinski.common.SearchDataParameters;
import by.bsu.seredinski.page.Flight;
import by.bsu.seredinski.page.Page;
import org.openqa.selenium.WebDriver;

public class PageSteps {

    private Page page;
    private Flight flightPage;

    public PageSteps(WebDriver driver) {
        page = new Page(driver);
        flightPage = new Flight(driver);
    }

    public String changeHomeAirport(SearchDataParameters data) {
        page.setHomeAirport();
        page.selectReturnAirport(data.getDestinationCity());
        page.selectDepartureDate(data.getNumOfDaysFromNowInDepartureDate());
        page.selectReturnDate(data.getNumOfDaysFromNowInReturnDate());
        return flightPage.getFirstStage();
    }

    public String tryToBookMoreThenOneInfantPerAdult(SearchDataParameters data) {
        page.selectDepartureAirport(data.getOriginCity());
        page.selectReturnAirport(data.getDestinationCity());
        page.setInfants(data.getNumOfInfant());
        return page.getWarning();
    }

    public String tryToBookYouthsTickets(SearchDataParameters data) {
        page.selectDepartureAirport(data.getOriginCity());
        page.selectReturnAirport(data.getDestinationCity());
        page.setYouth(1);
        return page.getYouthDisclaimer();
    }

    public String getErrorWhenDepartureAirportIsEmpty(SearchDataParameters data) {
        page.clearFields();
        page.selectReturnAirport(data.getDestinationCity());
        page.selectDepartureDate(data.getNumOfDaysFromNowInDepartureDate());
        page.selectReturnDate(data.getNumOfDaysFromNowInReturnDate());
        page.clickSearch();
        return page.getError();
    }

    public String getErrorWhenTheSameAirports(SearchDataParameters data) {
        page.selectDepartureAirport(data.getOriginCity());
        page.selectReturnAirport(data.getDestinationCity());
        page.selectDepartureDate(data.getNumOfDaysFromNowInReturnDate());
        page.selectReturnDate(data.getNumOfDaysFromNowInReturnDate());
        page.setAdults(data.getNumOfAdults());
        page.clickSearch();
        return page.getCityError();
    }

    public String isChangeDepartureDateWhenReturnDateIsEarlier(SearchDataParameters data) {
        page.selectDepartureAirport(data.getOriginCity());
        page.selectReturnAirport(data.getDestinationCity());
        page.selectDepartureDate(data.getNumOfDaysFromNowInDepartureDate());
        page.selectReturnDate(data.getNumOfDaysFromNowInReturnDate());
        return page.getEndDate();
    }

    public String tryToFindFlightWithCurrentData(SearchDataParameters data) {
        page.selectDepartureAirport(data.getOriginCity());
        page.selectReturnAirport(data.getDestinationCity());
        page.selectDepartureDate(data.getNumOfDaysFromNowInDepartureDate());
        page.selectReturnDate(data.getNumOfDaysFromNowInReturnDate());
        return flightPage.getFirstStage();
    }

    public String tryToChooseTickets(SearchDataParameters data) {
        page.selectDepartureAirport(data.getOriginCity());
        page.selectReturnAirport(data.getDestinationCity());
        page.selectDepartureDate(data.getNumOfDaysFromNowInDepartureDate());
        page.selectReturnDate(data.getNumOfDaysFromNowInReturnDate());
        flightPage.chooseOutBoundFlight();
        flightPage.chooseInBoundFlight();
        return flightPage.getTravelInfo();
    }

    public boolean tryToFillTravelerData(SearchDataParameters data) {
        page.selectDepartureAirport(data.getOriginCity());
        page.selectReturnAirport(data.getDestinationCity());
        page.selectDepartureDate(data.getNumOfDaysFromNowInDepartureDate());
        page.selectReturnDate(data.getNumOfDaysFromNowInReturnDate());
        flightPage.chooseOutBoundFlight();
        flightPage.chooseInBoundFlight();
        page.setFirstName(data.getFirstName());
        page.setSurName(data.getSurName());
        page.setEmail(data.getEmail());
        page.setPhoneNumber(data.getPhoneNumber());
        return page.checkRegisterButton();
    }

}
