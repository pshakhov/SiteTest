import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {
    @FindBy(xpath = "//input[@name = 'tripType'][@value = 'oneway']")
    WebElement tripType;

    @FindBy(xpath = "//select[@name = 'passCount']")
    Select passCount;

    @FindBy(xpath = "//select[@name = 'fromPort']")
    Select fromPort;

    @FindBy(xpath = "//select[@name = 'fromMonth']")
    Select fromMonth;

    @FindBy(xpath = "//select[@name = 'fromDay']")
    Select fromDay;

    @FindBy(xpath = "//select[@name = 'toPort']")
    Select toPort;

    @FindBy(xpath = "//select[@name = 'toMonth']")
    Select toMonth;

    @FindBy(xpath = "//select[@name = 'toDay']")
    Select toDay;

    @FindBy(xpath = "//input[@name = 'servClass']"
                         + "[@value = 'Business']")
    WebElement servClass;

    @FindBy(xpath = "//select[@name = 'airline']")
    Select airline;

    @FindBy(xpath = "//input[@name = 'findFlights']")
    WebElement continueButton;

    public void findFlight(String countPass, String portFrom, String monthFrom,
                           String dayFrom, String portTo, String monthTo,
                           String dayTo, String airlines) {
        tripType.click();
        passCount.selectByValue(countPass);
        fromPort.selectByValue(portFrom);
        fromMonth.selectByValue(monthFrom);
        fromDay.selectByValue(dayFrom);
        toPort.selectByValue(portTo);
        toMonth.selectByValue(monthTo);
        toDay.selectByValue(dayTo);
        servClass.click();
        airline.selectByVisibleText(airlines);
        continueButton.click();
    }
}
