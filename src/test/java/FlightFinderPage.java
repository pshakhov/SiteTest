import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Flight finder #2.*/
public class FlightFinderPage {
    /** Constructor.
     * @param driver */
    public FlightFinderPage(final WebDriver driver) {
        wait = new WebDriverWait(driver, 10,
                500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /** Waiting. */
    private Wait<WebDriver> wait;

    /** Driver. */
    public WebDriver driver;

    /** Waiting method. */
    public void pageWaiting() {
        wait.until(ExpectedConditions.
                titleContains("Find a Flight"));
    }

    /** Type radio button. */
    @FindBy(xpath = "//input[@name = 'tripType'][@value = 'oneway']")
    WebElement type;

    /** Passengers. */
    @FindBy(xpath = "//select[@name = 'passCount']")
    WebElement passengers;

    /** Departing. */
    @FindBy(xpath = "//select[@name = 'fromPort']")
    WebElement departingFrom;

    /** On month. */
    @FindBy(xpath = "//select[@name = 'fromMonth']")
    WebElement onMonth;

    /** On day. */
    @FindBy(xpath = "//select[@name = 'fromDay']")
    WebElement onDay;

    /** Arriving In. */
    @FindBy(xpath = "//select[@name = 'toPort']")
    WebElement arrivingIn;

    /** Returning month. */
    @FindBy(xpath = "//select[@name = 'toMonth']")
    WebElement returningMonth;

    /** Returning day. */
    @FindBy(xpath = "//select[@name = 'toDay']")
    WebElement returningDay;

    /** Service class radio button. */
    @FindBy(xpath = "//input[@name = 'servClass']"
                         + "[@value = 'Business']")
    WebElement serviceClass;

    /** Airline. */
    @FindBy(xpath = "//select[@name = 'airline']")
    WebElement airline;

    /** Continue button. */
    @FindBy(xpath = "//input[@name = 'findFlights']")
    WebElement continueButton;

    /** Find flights from method.
     * @param countPass is number of passengers
     * @param portFrom is departing from port
     * @param monthFrom is month
     * @param dayFrom is day*/
    public void findFlightsFrom(final String countPass, final String portFrom,
                                final String monthFrom, final String dayFrom) {

        type.click();

        Select passCount = new Select(passengers);
        passCount.selectByValue(countPass);

        Select fromPort = new Select(departingFrom);
        fromPort.selectByValue(portFrom);

        Select fromMonth = new Select(onMonth);
        fromMonth.selectByValue(monthFrom);

        Select fromDay = new Select(onDay);
        fromDay.selectByValue(dayFrom);
    }

    /** Find returning flights method.
     * @param portTo is arriving in port
     * @param monthTo is month
     * @param dayTo is day */
    public void findFlightsIn(final String portTo,
                              final String monthTo, final String dayTo) {

        Select toPort = new Select(arrivingIn);
        toPort.selectByValue(portTo);

        Select toMonth = new Select(returningMonth);
        toMonth.selectByValue(monthTo);

        Select toDay = new Select(returningDay);
        toDay.selectByValue(dayTo);

    }

    /** Preferences method.
     * @param airlinesParam */
    public void setPreferences(final String airlinesParam) {

        serviceClass.click();

        Select airlines = new Select(airline);
        airlines.selectByVisibleText(airlinesParam);

        continueButton.click();
    }
}
