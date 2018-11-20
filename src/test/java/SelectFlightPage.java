import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Select flight #3.*/
public class SelectFlightPage {
    /** Constructor.
     * @param driver */
    SelectFlightPage(final WebDriver driver) {
        wait = new WebDriverWait(driver,  10,
                 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /** Wait. */
    private Wait<WebDriver> wait;

    /** Driver.*/
    WebDriver driver;

    /** Depart.*/
    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[3]//font")
    WebElement strDepart;

    /** Depart date.*/
    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[4]//font")
    WebElement strDepartDate;

    /** Depart airlines.*/
    @FindBy(xpath = "(//input[@name = 'outFlight'])[4]")
    WebElement departAirlines;

    /** Depart price.*/
    @FindBy(xpath = "(//td[@class = 'data_verb_xcols']//b)[4]")
    WebElement strDepartPrice;

    /** Return.*/
    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[7]//font")
    WebElement strReturn;

    /** Return date.*/
    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[8]//font")
    WebElement strReturnDate;

    /** Return airlines.*/
    @FindBy(xpath = "(//input[@name = 'inFlight'])[2]")
    WebElement returnAirlines;

    /** PReturn price.*/
    @FindBy(xpath = "(//td[@class = 'data_verb_xcols']//b)[6]")
    WebElement strReturnPrice;

    /** Continue button.*/
    @FindBy(xpath = "//input[@name = 'reserveFlights']")
    WebElement reserveFlights;

    /** Select flight method realization.*/
    public void selectFlight() {
        strDepart.getText();
        strDepartDate.getText();
        departAirlines.click();
        strDepartPrice.getText();

        strReturn.getText();
        strReturnDate.getText();
        returnAirlines.click();
        strReturnPrice.getText();

        reserveFlights.click();
    }

    /** Waiting method.*/
    public void pageWaiting() {
        wait.until(ExpectedConditions.
                titleContains("Select a Flight"));
    }
}
