package edu.udemy.pages.flightreservation;

import edu.udemy.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement passengersSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengersSelect));
        return this.passengersSelect.isDisplayed();
    }

    public void selectPassengers(String numOfPassengers) {
        Select passengersSelect = new Select(this.passengersSelect);
        passengersSelect.selectByValue(numOfPassengers);
    }

    public void searchForFlight() {
        this.searchFlightsButton.click();
    }
}
