import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**Flight booking #4.*/
public class BookFlightPage {
    /** Create constructor.
     * @param driver */
    public BookFlightPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /** Driver.*/
    public WebDriver driver;

    /** To dest string find.*/
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[1]/"
            + "b/font")
    WebElement strTo;

    /** Date TO dest string find.*/
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[2]/"
            + "b/font")
    WebElement strDateTo;

    /** Airlines TO dest string find.*/
    @FindBy(xpath = "(//td[@class = 'data_left'])[1]//b")
    WebElement strAirlinesTo;

    /** Service class TO dest string find.*/
    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[1]/font")
    WebElement strServClassTo;

    /** Price TO dest string find.*/
    @FindBy(xpath = "(//td[@class = 'data_center'])[1]/font")
    WebElement strPriceTo;

    /** From dest string find.*/
    @FindBy(xpath = "(//td[@class = 'data_left'])[2]/b/font")
    WebElement strFrom;

    /** Date From dest string find.*/
    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[2]/b/font")
    WebElement strDateFrom;

    /** Airlines From dest find.*/
    @FindBy(xpath = "(//td[@class = 'data_left'])[4]//b")
    WebElement strAirlinesFrom;

    /** Service class From find.*/
    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[4]/font")
    WebElement strServClassFrom;

    /** Service class TO string find.*/
    @FindBy(xpath = "(//td[@class = 'data_center'])[3]/font")
    WebElement strPriceFrom;

    /** Service class TO string find.*/
    @FindBy(xpath = "(//td[@class = 'data_left'])[6]/font")
    WebElement strPassCount;

    /** Service class TO string find.*/
    @FindBy(xpath = "(//td[@class = 'data_left'])[8]/font")
    WebElement strTaxes;

    /** Service class TO string find.*/
    @FindBy(xpath = "(//td[@class = 'data_left'])[10]/font/b")
    WebElement strTotal;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'passFirst0']")
    WebElement passFirst0;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'passLast0']")
    WebElement passLast0;

    /** Service class TO string find.*/
    @FindBy(xpath = "//select[@name = 'pass.0.meal']")
    WebElement passMeal0;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'passFirst1']")
    WebElement passFirst1;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'passLast1']")
    WebElement passLast1;

    /** Service class TO string find.*/
    @FindBy(xpath = "//select[@name = 'pass.1.meal']")
    WebElement passMeal1;

    /** Service class TO string find.*/
    @FindBy(xpath = "//select[@name = 'creditCard']")
    WebElement creditCard;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'creditnumber']")
    WebElement creditNumber;

    /** Service class TO string find.*/
    @FindBy(xpath = "//select[@name = 'cc_exp_dt_mn']")
    WebElement CCExpDtMn;

    /** Service class TO string find.*/
    @FindBy(xpath = "//select[@name = 'cc_exp_dt_yr']")
    WebElement CCExpDtYr;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'cc_frst_name']")
    WebElement ccFirstName;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'cc_mid_name']")
    WebElement ccMidName;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'cc_last_name']")
    WebElement ccLastName;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'billAddress1']")
    WebElement billAddress;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'billCity']")
    WebElement billCity;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'billState']")
    WebElement billState;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'billZip']")
    WebElement billZip;

    /** Service class TO string find.*/
    @FindBy(xpath = "//select[@name = 'billCountry']")
    WebElement billCountry;

    /** Service class TO string find.*/
    @FindBy(xpath = "(//input[@value = 'checkbox'])[2]")
    WebElement sameAsBill;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'delAddress1']")
    WebElement delAddress;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'delCity']")
    WebElement delCity;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'delState']")
    WebElement delState;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'delZip']")
    WebElement delZip;

    /** Service class TO string find.*/
    @FindBy(xpath = "//select[@name = 'delCountry']")
    WebElement delCountry;

    /** Service class TO string find.*/
    @FindBy(xpath = "//input[@name = 'buyFlights']")
    WebElement securePurchase;

    /** Flight booking method realise. */
    public void bookFlight() {
        strTo.getText();
        strDateTo.getText();
        strAirlinesTo.getText();
        strServClassTo.getText();
        strPriceTo.getText();

        strFrom.getText();
        strDateFrom.getText();
        strAirlinesFrom.getText();
        strServClassFrom.getText();
        strPriceFrom.getText();

        strPassCount.getText();

        strTaxes.getText();
        strTotal.getText();
    }

    /** Passengers set method.
     * @param lastName0
     * @param firstName0
     * @param lastName1
     * @param firstName1
     * @param meal0
     * @param meal1 .*/
    public void setPassengers(final String firstName0, final String lastName0,
                              final String meal0, final String firstName1,
                              final String lastName1, final String meal1) {
        passFirst0.sendKeys(firstName0);
        passLast0.sendKeys(lastName0);

        Select passMeals0 = new Select(passMeal0);
        passMeals0.selectByVisibleText(meal0);

        passFirst1.sendKeys(firstName1);
        passLast1.sendKeys(lastName1);

        Select passMeals1 = new Select(passMeal1);
        passMeals1.selectByVisibleText(meal1);
    }

    /** Credit card set method.
     * @param typeCard
     * @param numberCard
     * @param expMonth
     * @param expYear
     * @param ccNameFirst
     * @param ccNameMid
     * @param ccNameLast .*/
    public void setCreditCard(final String typeCard, final String numberCard,
                              final String expMonth, final String expYear,
                              final String ccNameFirst, final String ccNameMid,
                              final String ccNameLast) {

        Select creditCardTypes = new Select(creditCard);
        creditCardTypes.selectByVisibleText(typeCard);
        creditNumber.sendKeys(numberCard);

        Select ccExpDtMn = new Select(CCExpDtMn);
        ccExpDtMn.selectByVisibleText(expMonth);

        Select ccExpDtYr = new Select(CCExpDtYr);
        ccExpDtYr.selectByValue(expYear);

        ccFirstName.sendKeys(ccNameFirst);
        ccMidName.sendKeys(ccNameMid);
        ccLastName.sendKeys(ccNameLast);

    }

    /** Billing address card set method.
     * @param zipBill
     * @param stateBill
     * @param countryBill
     * @param cityBill
     * @param addressBill */
    public void setBillAddress(final String addressBill,
                               final String cityBill, final String stateBill,
                               final String zipBill, final String countryBill) {
        billAddress.clear();
        billAddress.sendKeys(addressBill);
        billCity.clear();
        billCity.sendKeys(cityBill);
        billState.clear();
        billState.sendKeys(stateBill);
        billZip.clear();
        billZip.sendKeys(zipBill);

        Select billCountries = new Select(billCountry);
        billCountries.selectByVisibleText(countryBill);

    }

    /** Set delivery address method.
     * @param zipDel
     * @param stateDel
     * @param countryDel
     * @param cityDel
     * @param addressDel .*/
    public void setDeliveryAddress(final String addressDel,
                                   final String cityDel, final String stateDel,
                                   final String zipDel,
                                   final String countryDel) {
        sameAsBill.click();
        delAddress.clear();
        delAddress.sendKeys(addressDel);
        delCity.clear();
        delCity.sendKeys(cityDel);
        delState.clear();
        delState.sendKeys(stateDel);
        delZip.clear();
        delZip.sendKeys(zipDel);

        Select delCountries = new Select(delCountry);
        delCountries.selectByVisibleText(countryDel);

        securePurchase.click();
    }
}
