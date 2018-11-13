import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookFlightPage {
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[1]/"
            + "b/font")
    WebElement strTo;

    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[2]/"
            + "b/font")
    WebElement strDateTo;

    @FindBy(xpath = "(//td[@class = 'data_left'])[1]//b")
    WebElement strAirlinesTo;

    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[1]/font")
    WebElement strServClassTo;

    @FindBy(xpath = "(//td[@class = 'data_center'])[1]/font")
    WebElement strPriceTo;

    @FindBy(xpath = "(//td[@class = 'data_left'])[2]/b/font")
    WebElement strFrom;

    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[2]/b/font")
    WebElement strDateFrom;

    @FindBy(xpath = "(//td[@class = 'data_left'])[4]//b")
    WebElement strAirlinesFrom;

    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[4]/font")
    WebElement strServClassFrom;

    @FindBy(xpath = "(//td[@class = 'data_center'])[3]/font")
    WebElement strPriceFrom;

    @FindBy(xpath = "(//td[@class = 'data_left'])[6]/font")
    WebElement strPassCount;

    @FindBy(xpath = "(//td[@class = 'data_left'])[8]/font")
    WebElement strTaxes;

    @FindBy(xpath = "(//td[@class = 'data_left'])[10]/font/b")
    WebElement strTotal;

    @FindBy(xpath = "//input[@name = 'passFirst0']")
    WebElement passFirst0;

    @FindBy(xpath = "//input[@name = 'passLast0']")
    WebElement passLast0;

    @FindBy(xpath = "//select[@name = 'passMeal0']")
    Select passMeal0;

    @FindBy(xpath = "//input[@name = 'passFirst1']")
    WebElement passFirst1;

    @FindBy(xpath = "//input[@name = 'passLast1']")
    WebElement passLast1;

    @FindBy(xpath = "//select[@name = 'passMeal1']")
    Select passMeal1;

    @FindBy(xpath = "//select[@name = 'creditCard']")
    Select creditCard;

    @FindBy(xpath = "//input[@name = 'creditnumber']")
    WebElement creditNumber;

    @FindBy(xpath = "//select[@name = 'cc_exp_dt_mn']")
    Select ccExpDtMn;

    @FindBy(xpath = "//select[@name = 'cc_exp_dt_yr']")
    Select ccExpDtYr;

    @FindBy(xpath = "//input[@name = 'cc_frst_name']")
    WebElement ccFirstName;

    @FindBy(xpath = "//input[@name = 'cc_mid_name']")
    WebElement ccMidName;

    @FindBy(xpath = "//input[@name = 'cc_last_name']")
    WebElement ccLastName;

    @FindBy(xpath = "//input[@name = 'billAddress1']")
    WebElement billAddress;

    @FindBy(xpath = "//input[@name = 'billCity']")
    WebElement billCity;

    @FindBy(xpath = "//input[@name = 'billState']")
    WebElement billState;

    @FindBy(xpath = "//input[@name = 'billZip']")
    WebElement billZip;

    @FindBy(xpath = "//select[@name = 'billCountry']")
    Select billCountry;

    @FindBy(xpath = "(//input[@value = 'checkbox'])[2]")
    WebElement sameAsBill;

    @FindBy(xpath = "//input[@name = 'delAddress']")
    WebElement delAddress;

    @FindBy(xpath = "//input[@name = 'delCity']")
    WebElement delCity;

    @FindBy(xpath = "//input[@name = 'delState']")
    WebElement delState;

    @FindBy(xpath = "//input[@name = 'delZip']")
    WebElement delZip;

    @FindBy(xpath = "//select[@name = 'delCountry']")
    Select delCountry;

    @FindBy(xpath = "//input[@name = 'buyFlights']")
    WebElement securePurchase;

    public void bookFlight(String firstName0, String lastName0,
                           String meal0, String firstName1,
                           String lastName1, String meal1,
                           String typeCard, String numberCard,
                           String expMonth, String expYear,
                           String ccNameFirst, String ccNameMid,
                           String ccNameLast, String addressBill,
                           String cityBill, String stateBill,
                           String zipBill, String countryBill,
                           String addressDel, String cityDel,
                           String stateDel, String zipDel,
                           String countryDel) {
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

        passFirst0.sendKeys(firstName0);
        passLast0.sendKeys(lastName0);
        passMeal0.selectByVisibleText(meal0);

        passFirst1.sendKeys(firstName1);
        passLast1.sendKeys(lastName1);
        passMeal1.selectByVisibleText(meal1);

        creditCard.selectByVisibleText(typeCard);
        creditNumber.sendKeys(numberCard);
        ccExpDtMn.selectByVisibleText(expMonth);
        ccExpDtYr.selectByVisibleText(expYear);
        ccFirstName.sendKeys(ccNameFirst);
        ccMidName.sendKeys(ccNameMid);
        ccLastName.sendKeys(ccNameLast);

        billAddress.clear();
        billAddress.sendKeys(addressBill);
        billCity.clear();
        billCity.sendKeys(cityBill);
        billState.clear();
        billState.sendKeys(stateBill);
        billZip.clear();
        billZip.sendKeys(zipBill);
        billCountry.selectByVisibleText(countryBill);

        sameAsBill.click();
        delAddress.clear();
        delAddress.sendKeys(addressDel);
        delCity.clear();
        delCity.sendKeys(cityDel);
        delState.clear();
        delState.sendKeys(stateDel);
        delZip.clear();
        delZip.sendKeys(zipDel);
        delCountry.selectByVisibleText(countryDel);

        securePurchase.click();
    }
}
