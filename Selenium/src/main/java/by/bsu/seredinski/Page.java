package by.bsu.seredinski;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

    private WebDriver webDriver;

    @FindBy(id = "origin")
    private WebElement originCity;
    @FindBy(id = "destination")
    private WebElement destinationCity;
    @FindBy(xpath = "//p[@id=\"group-booking\"]/span")
    private WebElement error;
    @FindBy(id = "passengers")
    private WebElement passengers;
    @FindBy(id = "cepAddInfant")
    private WebElement buttonToAddInfant;

    public Page(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public String tryToBookMoreThenOneInfantPerAdult() {
        originCity.clear();
        originCity.sendKeys("London");
        originCity.submit();
        destinationCity.sendKeys("Paris");
        destinationCity.submit();
        clickButton(passengers);
        clickButton(buttonToAddInfant);
        return error.getText();
    }

    private void clickButton(WebElement element){
        element.click();
    }

}
