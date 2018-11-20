
import org.hamcrest.MatcherAssert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/** Test for newtours.demoaut.com.
 * @author Pavel Shakhov.
 * @version 1.0.
 */

public class FirstTest {
    /** Init WebDriver variable.*/
    private static WebDriver drv;

    /** Init var for parsed taxes.*/
    private static int parsedTaxes;
    /** Init var for parsed total $.*/
    private static int parsedTotal;

    /** Init var for page object storage.*/
    private static HomePage homePage;
    /** Init var for page object storage.*/
    private static FlightFinderPage flightFinderPage;
    /** Init var for page object storage.*/
    private static SelectFlightPage selectFlightPage;
    /** Init var for page object storage.*/
    private static BookFlightPage bookFlightPage;
    /** Init var for page object storage.*/
    private static FlightConfirmationPage flightConfirmationPage;

    /** Var for login string.*/
    private static final String LOGIN = "test1";
    /** Var for login password.*/
    private static final String PASSWORD = "test1";
    /** Var for number of passengers. */
    private static final String PASS_COUNT = "2";
    /** Var for from port. */
    private static final String PORT_FROM = "Paris";
    /** Var for port to. */
    private static final String PORT_TO = "Seattle";
    /** Var for from month. */
    private static final String MONTH_FROM = "11";
    /** Var for date month. */
    private static final String MONTH_TO = "12";
    /** Var for from day. */
    private static final String DAY_FROM = "20";
    /** Var for to day. */
    private static final String DAY_TO = "19";
    /** Var for airlines. */
    private static final String AIRLINES = "Pangea Airlines";

    /** Var for credit cardholder first name. */
    private static final String CC_FIRST = "Ivan";
    /** Var for credit cardholder middle name. */
    private static final String CC_MID = "Ivanovich";
    /** Var for credit cardholder last name. */
    private static final String CC_LAST = "Ivanov";
    /** Var for credit card number. */
    private static final String CC_NUMBER = "5479540454132487";
    /** Var for credit card type. */
    private static final String CC_TYPE = "Visa";
    /** Var for credit card expiration month. */
    private static final String CC_EXP_MONTH = "05";
    /** Var for credit card expiration year. */
    private static final String CC_EXP_YEAR = "2009";

    /** Var for 1st passenger name. */
    private static final String FIRST_PASS_NAME = CC_FIRST;
    /** Var for 1st pass last name. */
    private static final String FIRST_PASS_LAST = CC_LAST;

    /** Var for 2nd passenger name. */
    private static final String SEC_PASS_NAME = "Irina";
    /** Var for 2nd pass last name. */
    private static final String SEC_PASS_LAST = "Ivanova";

    /** Var for 1st passenger meal. */
    private static final String FIRST_PASS_MEAL = "Bland";
    /** Var for 2nd passenger meal. */
    private static final String SEC_PASS_MEAL = "Bland";

    /** Var for billing address. */
    private static final String BILL_ADDRESS = "1085 Borregas Ave.";
    /** Var for billing city. */
    private static final String BILL_CITY = "Albuquerque";
    /** Var for billing state. */
    private static final String BILL_STATE = "New Mexico";
    /** Var for billing zip. */
    private static final String BILL_ZIP = "94089";
    /** Var for billing country. */
    private static final String BILL_COUNTRY = "UNITED STATES";

    /** Var for delivery address. */
    private static final String DEL_ADDRESS = "1225 Borregas Ave.";
    /** Var for delivery city. */
    private static final String DEL_CITY = "Boston";
    /** Var for delivery state. */
    private static final String DEL_STATE = "Massachusetts";
    /** Var for delivery zip. */
    private static final String DEL_ZIP = "91089";
    /** Var for delivery country. */
    private static final String DEL_COUNTRY = "UNITED STATES";
    /** Var for taxes. */
    private static final int TAXES = 91;

    /** Test class.*/
    public FirstTest() {
        System.out.print("Constructor created. ");
    }
    /** WebDriver init and preconditioning method.*/
    @BeforeClass
    public static void setUp() {
        System.out.println("@BeforeClass static method invoked. "
                + "WebDriver initialising, preconditioned.");
        System.setProperty("webdriver.chrome.driver",
                "webdrivers/chromedriver.exe");
        drv = new ChromeDriver();
        /** EventFiringWebDriver init using Chrome WebDriver instance*/
        drv = new EventFiringWebDriver(drv);
        ((EventFiringWebDriver) drv).register(new EventHandler());
        /** Window maximizing.*/
        drv.manage().window().maximize();
        /** Create page objects and save it to vars.*/
        homePage = new HomePage(drv);
        flightFinderPage = new FlightFinderPage(drv);
        selectFlightPage = new SelectFlightPage(drv);
        bookFlightPage = new BookFlightPage(drv);
        flightConfirmationPage = new FlightConfirmationPage(drv);
        /** Page open.*/
        drv.get("http://newtours.demoaut.com");
        homePage.pageWaiting();
    }

    /** Main test.*/
    @Test
    public void test() {
        /** Logpas typing. */
        homePage.signInAs(LOGIN, PASSWORD);
        /** Page open wait. */
        flightFinderPage.pageWaiting();
        /** Find a Flight Page opened assertion.*/
        MatcherAssert.assertThat("Login failed or TimeOut!",
                drv.getTitle().contains("Find a Flight"));
        flightFinderPage.findFlightsFrom(PASS_COUNT, PORT_FROM,
                MONTH_FROM, DAY_FROM);
        flightFinderPage.findFlightsIn(PORT_TO, MONTH_TO, DAY_TO);
        flightFinderPage.setPreferences(AIRLINES);
        selectFlightPage.pageWaiting();
        /** Select a Flight Page opened assertion.*/
        MatcherAssert.assertThat("Can`t open page"
                        + " Select a Flight!",
                drv.getTitle().contains("Select a Flight"));
        MatcherAssert.assertThat("Incorrect departing!",
                selectFlightPage.strDepart.
                        getText().contains("Paris to Seattle"));
        MatcherAssert.assertThat("Incorrect departing date!",
                selectFlightPage.strDepartDate.getText().contains("11/20/"));
        selectFlightPage.departAirlines.click();
//        selectFlightPage.strDepartPrice.getText();
//        parsedPriceTo = Integer.parseInt(selectFlightPage.strDepartPrice.
//                getText().substring(8));
        MatcherAssert.assertThat("Incorrect returning destination!",
                selectFlightPage.strReturn.getText().
                        contains("Seattle to Paris"));
        MatcherAssert.assertThat("Incorrect returning date!",
                selectFlightPage.strReturnDate.getText().
                        contains("12/19/"));
        selectFlightPage.returnAirlines.click();
        selectFlightPage.strReturnPrice.getText();
//        parsedPriceFrom = Integer.parseInt(selectFlightPage.strReturnPrice.
//                getText().substring(8));
        selectFlightPage.reserveFlights.click();
        bookFlightPage.pageWaiting();
        /** Book a Flight Page opened assertion.*/
        MatcherAssert.assertThat("Can`t open page"
                        + "Book a Flight!",
                drv.getTitle().contains("Book a Flight"));
        MatcherAssert.assertThat("Incorrect departing destination!",
                bookFlightPage.strTo.getText().contains("Paris to Seattle"));
        MatcherAssert.assertThat("Incorrect departing to date!",
                bookFlightPage.strDateTo.getText().contains("11/20/"));
        MatcherAssert.assertThat("Incorrect carrier!",
                bookFlightPage.strAirlinesTo.getText().contains("363"));
        MatcherAssert.assertThat("Incorrect class!",
                bookFlightPage.strServClassTo.getText().contains("Business"));
        MatcherAssert.assertThat("Incorrect price!",
                bookFlightPage.strPriceTo.getText().contains("281"));
        int parsePriceTo = Integer.parseInt(bookFlightPage.strPriceTo.
                getText());
        MatcherAssert.assertThat("Incorrect returning!",
                bookFlightPage.strFrom.getText().contains("Seattle to Paris"));
        MatcherAssert.assertThat("Incorrect returning from date!",
                bookFlightPage.strDateFrom.getText().contains("12/19/"));
        MatcherAssert.assertThat("Incorrect carrier!",
                bookFlightPage.strAirlinesFrom.getText().contains("631"));
        MatcherAssert.assertThat("Incorrect class!",
                bookFlightPage.strServClassFrom.getText().contains("Business"));
        MatcherAssert.assertThat("Incorrect price!",
                bookFlightPage.strPriceFrom.getText().contains("273"));
        int parsePriceFrom = Integer.parseInt(bookFlightPage.strPriceFrom.
                getText());
        MatcherAssert.assertThat("Incorrect number of passengers!",
                bookFlightPage.strPassCount.getText().contains("2"));
        parsedTaxes = Integer.parseInt(bookFlightPage.strTaxes.
                getText().substring(1));
        MatcherAssert.assertThat("Incorrect taxes!",
                parsedTaxes == TAXES);
        parsedTotal = Integer.parseInt(bookFlightPage.strTotal.
                getText().substring(1));
        /** Total Price рассчитывается из сумм в Summary.
         *  * 2 пассажира, + сумма из «Taxes».*/
        int parsedSummary = parsePriceFrom * 2 + parsePriceTo * 2 + parsedTaxes;
        MatcherAssert.assertThat("Incorrect total price,"
                        + " including taxes!", parsedTotal == parsedSummary);
        bookFlightPage.bookFlight();
        bookFlightPage.setPassengers(FIRST_PASS_NAME, FIRST_PASS_LAST,
                FIRST_PASS_MEAL, SEC_PASS_NAME, SEC_PASS_LAST, SEC_PASS_MEAL);
        bookFlightPage.setCreditCard(CC_TYPE, CC_NUMBER, CC_EXP_MONTH,
                CC_EXP_YEAR, CC_FIRST, CC_MID, CC_LAST);
        bookFlightPage.setBillAddress(BILL_ADDRESS, BILL_CITY, BILL_STATE,
                BILL_ZIP, BILL_COUNTRY);
        bookFlightPage.setDeliveryAddress(DEL_ADDRESS, DEL_CITY, DEL_STATE,
                DEL_ZIP, DEL_COUNTRY);
        flightConfirmationPage.pageWaiting();
        /** Flight confirmation page opened assertion.*/
        MatcherAssert.assertThat("Can`t open page"
                        + " Flight Confirmation or Timeout!",
                drv.getTitle().contains("Flight Confirmation"));
        MatcherAssert.assertThat("Incorrect departing destination!",
                flightConfirmationPage.strTo.getText().
                        contains("Paris to Seattle"));
        MatcherAssert.assertThat("Incorrect departing date!",
                flightConfirmationPage.strDateTo.getText().contains("11/20/"));
        MatcherAssert.assertThat("Incorrect departing carrier!",
                flightConfirmationPage.strAirlinesTo.getText().
                        contains("Unified Airlines 363"));
        MatcherAssert.assertThat("Incorrect returning destination!",
                flightConfirmationPage.strFrom.getText().
                        contains("Seattle to Paris"));
        MatcherAssert.assertThat("Incorrect returning date!",
                flightConfirmationPage.strDateFrom.getText().
                        contains("12/19"));
        MatcherAssert.assertThat("Incorrect returning carrier!",
                flightConfirmationPage.strAirlinesFrom.getText().
                        contains("Blue Skies Airlines 631"));
        int parsedPriceTo = Integer.parseInt(flightConfirmationPage.
                strPriceTo.getText().split("\\$")[1].
                replaceAll("[^0-9]", ""));
        int parsedPriceFrom = Integer.parseInt(flightConfirmationPage.
                strPriceFrom.getText().split("\\$")[1].
                replaceAll("[^0-9]", ""));
        int parseTaxes = Integer.parseInt(flightConfirmationPage.
                strTotalTaxes.getText().replaceAll("[^0-9]", ""));
        int parseTotal = parsedPriceFrom * 2 + parsedPriceTo * 2
                + parseTaxes;
        MatcherAssert.assertThat("Incorrect number of passengers!",
                flightConfirmationPage.strPassCount.getText().contains("2"));
        MatcherAssert.assertThat("Incorrect billing receiver!",
                flightConfirmationPage.strBillTo.getText().
                        contains("Ivan Ivanovich Ivanov"));
        MatcherAssert.assertThat("Incorrect billing street!",
                flightConfirmationPage.strBillTo.getText().
                        contains("1085 Borregas Ave."));
        MatcherAssert.assertThat("Incorrect billing address!",
                flightConfirmationPage.strBillTo.getText().
                        contains("Albuquerque, New Mexico, 94089"));
        MatcherAssert.assertThat("Incorrect delivery street!",
                flightConfirmationPage.strDelTo.getText().
                        contains("1225 Borregas Ave."));
        MatcherAssert.assertThat("Incorrect delivery address!",
                flightConfirmationPage.strDelTo.getText().
                        contains("Boston, Massachusetts, 91089"));
        int parseTotalPrice = Integer.parseInt(flightConfirmationPage.
                strTotalPrice.getText().replaceAll("[^0-9]", ""));
        /** Total price assertion.*/
        MatcherAssert.assertThat("Incorrect total price,",
                parseTotalPrice == parseTotal);
        /** Back to Home button click.*/
        flightConfirmationPage.backToHome.click();
        /** Wait.*/
        homePage.pageWaiting();
        /** HomePage is opened assertion.*/
        MatcherAssert.assertThat("Can`t open home page!",
                drv.getTitle().contains("Welcome"));
    }
    /** Close WebDriver, post-conds.*/
    @AfterClass
    public static void afterClassMethod() {
        drv.close();
    }
}
