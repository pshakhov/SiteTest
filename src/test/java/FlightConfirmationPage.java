import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {
    public FlightConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[3]/font/b")
    WebElement strTo;

    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[3]/font")
    WebElement strDateTo;

    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[3]/font")
    WebElement strAirlinesTo;

    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[5]/font/b")
    WebElement strFrom;

    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[5]/font")
    WebElement strDateFrom;

    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[5]/font")
    WebElement strAirlinesFrom;

    @FindBy(xpath = "(//td[@class = 'data_left'])[2]/font")
    WebElement strPassCount;

    @FindBy(xpath = "((//p)[5]/font)[1]")
    WebElement strBillTo;

    @FindBy(xpath = "(//p)[6]/font")
    WebElement strDelTo;

    @FindBy(xpath = "((//td[@class = 'data_left'])[3]//font)[14]")
    WebElement strTotalPrice;

    @FindBy(xpath = "(//a)[13]")
    WebElement backToHome;

    public void flightConfirmation() {
        strTo.getText();
        strDateTo.getText();
        strAirlinesTo.getText();

        strFrom.getText();
        strDateFrom.getText();
        strAirlinesFrom.getText();

        strPassCount.getText();
        strBillTo.getText();
        strDelTo.getText();
        strTotalPrice.getText();

        backToHome.click();
    }
}
