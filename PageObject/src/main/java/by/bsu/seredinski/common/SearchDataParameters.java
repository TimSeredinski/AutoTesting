package by.bsu.seredinski.common;

public class SearchDataParameters {

    private String originCity;
    private String destinationCity;
    private int numOfDaysFromNowInDepartureDate;
    private int numOfDaysFromNowInReturnDate;
    private int numOfAdults;
    private int numOfInfant;

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getNumOfDaysFromNowInDepartureDate() {
        return numOfDaysFromNowInDepartureDate;
    }

    public void setNumOfDaysFromNowInDepartureDate(int numOfDaysFromNowInDepartureDate) {
        this.numOfDaysFromNowInDepartureDate = numOfDaysFromNowInDepartureDate;
    }

    public int getNumOfDaysFromNowInReturnDate() {
        return numOfDaysFromNowInReturnDate;
    }

    public void setNumOfDaysFromNowInReturnDate(int numOfDaysFromNowInReturnDate) {
        this.numOfDaysFromNowInReturnDate = numOfDaysFromNowInReturnDate;
    }

    public int getNumOfAdults() {
        return numOfAdults;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
    }

    public int getNumOfInfant() {
        return numOfInfant;
    }

    public void setNumOfInfant(int numOfInfant) {
        this.numOfInfant = numOfInfant;
    }
}
