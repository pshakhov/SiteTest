import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage {
    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[3]//font")
    WebElement strTo;

    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[4]//font")
    WebElement strDateTo;

    @FindBy(xpath = "(//input[@name = 'outFlight'])[4]")
    WebElement airlinesTo;

    @FindBy(xpath = "(//td[@class = 'data_verb_xcols']//b)[4]")
    WebElement priceTo;

    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[7]//font")
    WebElement strFrom;

    @FindBy(xpath = "(//form[@method = 'post']//"
                       + "td[@class = 'title'])[8]//font")
    WebElement strDateFrom;

    @FindBy(xpath = "(//input[@name = 'inFlight'])[2]")
    WebElement airlinesFrom;

    @FindBy(xpath = "(//td[@class = 'data_verb_xcols']//b)[6]")
    WebElement priceFrom;

    @FindBy(xpath = "//input[@name = 'reserveFlights']")
    WebElement reserveFlights;

    public void selectFlight() {
        strTo.getText();
        strDateTo.getText();
        airlinesTo.click();
        priceTo.getText();
        strFrom.getText();
        strDateFrom.getText();
        airlinesFrom.click();
        priceFrom.getText();
        reserveFlights.click();
    }
}
