package by.bsu.seredinski.common;

public class SearchDataParameters {

    private String originCity;
    private String destinationCity;
    private int numOfDaysFromNowInDepartureDate;
    private int numOfDaysFromNowInReturnDate;
    private int numOfAdults;
    private int numOfInfant;
    private String firstName;
    private String surName;
    private String email;
    private String home;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;

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
