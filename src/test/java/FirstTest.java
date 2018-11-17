import org.hamcrest.MatcherAssert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/** Test for newtours.demoaut.com.
 * @author Pavel Shakhov.
 * @version 1.0.
 */

public class FirstTest {
    /** Init WebDriver variable.*/
    private static WebDriver drv;
    /** Init WebDriverEventListener var.*/
    private static WebDriverEventListener eventListener;

    /** Init var for Waits.*/
    private static final int WAIT_LENGTH = 100;
    /** Init var for Timeout.*/
    private static final int TIMEOUT = 100;
    /** Init var for cycling.*/
    private static final int SLEEP = 100;
    /** Init var for parsed price TO dest.*/
    private static int parsedPriceTo;
    /** Init var for parsed price From dest.*/
    private static int parsedPriceFrom;
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
        System.out.print("Constructor created.");
    }

    /* Инициализируем драйвер и выполняем
    предварительные действия:
    - перейти на сайт http://newtours.demoaut.com;
    - поля UserName и Password пустые.**/
    /** WebDriver init and preconditioning method.*/
    @BeforeClass
    public static void setUp() {

        System.out.println("@BeforeClass static method invoked. "
                + "WebDriver initialising, preconditioned.");

        System.setProperty("webdriver.chrome.driver",
                "webdrivers/chromedriver.exe");
        drv = new ChromeDriver();

        /** EventFiringWebDriver init using Chrome WebDriver instance*/
        EventFiringWebDriver eventDriver = new
                EventFiringWebDriver(drv); //Wrapper

        /** Realise.*/
        eventDriver.register(eventListener);

        /** Window maximizing.*/
        drv.manage().window().maximize();
        //drv.manage().timeouts().implicitlyWait(waitLengthMs,
        // TimeUnit.SECONDS);

        /** Create page objects and save it to vars.*/
        homePage = new HomePage(drv);
        flightFinderPage = new FlightFinderPage(drv);
        selectFlightPage = new SelectFlightPage(drv);
        bookFlightPage = new BookFlightPage(drv);
        flightConfirmationPage = new FlightConfirmationPage(drv);

        /** Page open.*/
        drv.get("http://newtours.demoaut.com");

        /** Create Wait obj.*/
        final Wait<WebDriver> wait = new WebDriverWait(drv, TIMEOUT, SLEEP);

        //wait.until(ExpectedConditions.urlContains("/index.php"));
    }

    /** Login test method.*/
    @Test
    public void test1() {

        System.out.println("Login @Test method 1 invoked."
                + " Login and assert.");

        /** Logpas typing. */
        homePage.signInAs(LOGIN, PASSWORD);

        /** Page open wait. */
        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        /** Find a Flight Page opened assertion. */
        MatcherAssert.assertThat("Login failed or TimeOut!",
                drv.getCurrentUrl().contains("/mercuryreservation.php"));
                //drv.getTitle().contains("Find a Flight"));
    }

    /** Flight finding test method.*/
    @Test
    public void test2() {

        System.out.println("Flight Finder @Test method 2 invoked."
                + " Find a flight.");

        /* Find a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Login failed or TimeOut!",
                drv.getTitle().contains("Find a Flight"));

        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

       flightFinderPage.findFlightsFrom(PASS_COUNT, PORT_FROM,
               MONTH_FROM, DAY_FROM);
       flightFinderPage.findFlightsIn(PORT_TO, MONTH_TO, DAY_TO);
       flightFinderPage.setPreferences(AIRLINES);

        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        /* Select a Flight Page opened assertion.**/
       MatcherAssert.assertThat("Can`t open page"
                       + " Select a Flight!",
               //drv.getTitle().contains("Select a Flight"));
               drv.getCurrentUrl().contains("/mercuryreservation2.php"));
    }

    /** Flight selecting test method.*/
    @Test
    public void test3() {

        System.out.println("Select a Flight @Test method 3 invoked."
                + " Select a Flight.");

        /* Select a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Select a Flight!",
                drv.getTitle().contains("Select a Flight"));

        MatcherAssert.assertThat("Incorrect departing!",
                selectFlightPage.strDepart.
                        getText().contains("Paris to Seattle"));

        MatcherAssert.assertThat("Incorrect departing date!",
                selectFlightPage.strDepartDate.getText().contains("11/20/"));

        selectFlightPage.departAirlines.click();

        selectFlightPage.strDepartPrice.getText();
        parsedPriceTo = Integer.parseInt(selectFlightPage.strDepartPrice.
                getText().substring(8));

        MatcherAssert.assertThat("Incorrect returning destination!",
                selectFlightPage.strReturn.getText().
                        contains("Seattle to Paris"));

        MatcherAssert.assertThat("Incorrect returning date!",
                selectFlightPage.strReturnDate.getText().
                        contains("12/19/"));

        selectFlightPage.returnAirlines.click();

        selectFlightPage.strReturnPrice.getText();
        parsedPriceFrom = Integer.parseInt(selectFlightPage.strReturnPrice.
                getText().substring(8));


        selectFlightPage.reserveFlights.click();

        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        //drv.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        /* Book a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Book a Flight!",
                drv.getCurrentUrl().contains("/mercurypurchase.php"));
    }

    /** Flight booking assertion test method.*/
    @Test
    public void test4() {

        System.out.println("Book a Flight @Test method 4 invoked."
                + " Book a flight.");

        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        /* Book a Flight Page opened assertion.**/
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

        MatcherAssert.assertThat("Incorrect number of passengers!",
                bookFlightPage.strPassCount.getText().contains("2"));

        parsedTaxes = Integer.parseInt(bookFlightPage.strTaxes.
                getText().substring(1));
        MatcherAssert.assertThat("Incorrect taxes!",
                //bookFlightPage.strTaxes.getText().contains("$91"));
                parsedTaxes == TAXES);

        parsedTotal = Integer.parseInt(bookFlightPage.strTotal.
                getText().substring(1));

        int parsedSummary = parsedPriceFrom * 2 + parsedPriceTo * 2
                + parsedTaxes;
        //System.out.println(parsedSummary);

        MatcherAssert.assertThat("Incorrect total price,"
                        + " including taxes!",
                parsedTotal == parsedSummary);

        bookFlightPage.bookFlight();
        bookFlightPage.setPassengers(FIRST_PASS_NAME, FIRST_PASS_LAST,
                FIRST_PASS_MEAL, SEC_PASS_NAME, SEC_PASS_LAST, SEC_PASS_MEAL);

        bookFlightPage.setCreditCard(CC_TYPE, CC_NUMBER, CC_EXP_MONTH,
                CC_EXP_YEAR, CC_FIRST, CC_MID, CC_LAST);

        bookFlightPage.setBillAddress(BILL_ADDRESS, BILL_CITY, BILL_STATE,
                BILL_ZIP, BILL_COUNTRY);

        bookFlightPage.setDeliveryAddress(DEL_ADDRESS, DEL_CITY, DEL_STATE,
                DEL_ZIP, DEL_COUNTRY);

        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        /* Flight Confirmation page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Flight Confirmation or TimeOut!",
                drv.getCurrentUrl().contains("/mercurypurchase2.php"));
    }

    /** Flight confirmation assertion test method.*/
    @Test
    public void test5() { //correct last assertion!

        System.out.println("Flight Confirmation @Test method 5 invoked."
                + " Flight Confirmation.");

        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        /* Page opened assertion.**/
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

        MatcherAssert.assertThat("Incorrect number of passengers!",
                flightConfirmationPage.strPassCount.getText().
                        contains("2"));

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

        /** .*/
        MatcherAssert.assertThat("Incorrect total price,"
                        + "including taxes!",
                flightConfirmationPage.strTotalPrice.getText().
                        contains("$1199")); //correct this assert

        /** Back to Home button click.*/
        flightConfirmationPage.backToHome.click();

        /** Wait.*/
        drv.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

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
