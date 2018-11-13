import org.hamcrest.MatcherAssert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver drv;

    public FirstTest() {
        System.out.print("Constructor created.");
    }

    /* Инициализируем драйвер и выполняем
    предварительные действия:
    - перейти на сайт http://newtours.demoaut.com;
    - поля UserName и Password пустые.**/
    @BeforeClass
    public static void beforeClassMethod() { // done method

        System.out.println("@BeforeClass static method invoked. "
                + "WebDriver initialising, preconditioned.");

        System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver.exe");
        drv = new ChromeDriver();

        drv.get("http://newtours.demoaut.com");

        final Wait<WebDriver> wait = new WebDriverWait(drv, 5,100);

        wait.until(ExpectedConditions.titleContains("Find a Flight"));
    }

    @Test
    public void test1() { // done method

        System.out.println("Login @Test method 1 invoked."
                + " Login and assert.");

        //drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        HomePage page = new HomePage(drv);
        page.login("test1", "test1");

        /* Find a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Login failed or TimeOut!",
                drv.getCurrentUrl().contains("/mercuryreservation.php"));
    }

    @Test
    /* Flight Finder test method 2.**/
    public void test2() { //done method

        System.out.println("Flight Finder @Test method 2 invoked."
                + " Find a flight.");

        /* Find a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Login failed or TimeOut!",
                drv.getTitle().contains("Find a Flight"));

        FlightFinderPage page = new FlightFinderPage(drv);
        page.findFlight("2", "Paris","11",
                "20", "Seattle", "12", "19",
                "Pangea Airlines");

        drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        /* Select a Flight Page opened assertion.**/
       MatcherAssert.assertThat("Can`t open page"
                       + " Select a Flight!",
               drv.getTitle().contains("Select a Flight"));
    }

    @Test
    /* Select a Flight test method 3.**/
    public void test3() {

        System.out.println("Select a Flight @Test method 3 invoked."
                + " Select a Flight.");

        /* Select a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Select a Flight!",
                drv.getTitle().contains("Select a Flight"));

        SelectFlightPage page = new SelectFlightPage(drv);

        MatcherAssert.assertThat("Incorrect departing!",
                page.strTo.getText().contains("Paris to Seattle"));

        MatcherAssert.assertThat("Incorrect departing date!",
                page.strDateTo.getText().contains("11/20/"));

        page.airlinesTo.click();

        page.priceTo.getText();

        MatcherAssert.assertThat("Incorrect returning destination!",
                page.strFrom.getText().contains("Seattle to Paris"));

        MatcherAssert.assertThat("Incorrect returning date!",
                page.strDateFrom.getText().contains("12/19/"));

        page.airlinesFrom.click();

        page.priceFrom.getText();

        page.reserveFlights.click();

        drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //drv.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        /* Book a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Book a Flight!",
                drv.getCurrentUrl().contains("/mercurypurchase.php"));
    }

    @Test
    /* Book Flight assertion method 4.**/
    public void test4() {

        System.out.println("Book a Flight @Test method 4 invoked."
                + " Book a flight.");

        drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        /* Book a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + "Book a Flight!",
                drv.getTitle().contains("Book a Flight"));

        BookFlightPage page = new BookFlightPage(drv);

        MatcherAssert.assertThat("Incorrect departing destination!",
                page.strTo.getText().contains("Paris to Seattle"));

        MatcherAssert.assertThat("Incorrect departing to date!",
                page.strDateTo.getText().contains("11/20/"));

        MatcherAssert.assertThat("Incorrect carrier!",
                page.strAirlinesTo.getText().contains("363"));

        MatcherAssert.assertThat("Incorrect class!",
                page.strServClassTo.getText().contains("Business"));

        MatcherAssert.assertThat("Incorrect price!",
                page.strPriceTo.getText().contains("281"));

        MatcherAssert.assertThat("Incorrect returning!",
                page.strFrom.getText().contains("Seattle to Paris"));

        MatcherAssert.assertThat("Incorrect returning from date!",
                page.strDateFrom.getText().contains("12/19/"));

        MatcherAssert.assertThat("Incorrect carrier!",
                page.strAirlinesFrom.getText().contains("631"));

        MatcherAssert.assertThat("Incorrect class!",
                page.strServClassFrom.getText().contains("Business"));

        MatcherAssert.assertThat("Incorrect price!",
                page.strAirlinesFrom.getText().contains("273"));

        MatcherAssert.assertThat("Incorrect number of passengers!",
                page.strPassCount.getText().contains("2"));

        MatcherAssert.assertThat("Incorrect taxes!",
                page.strTaxes.getText().contains("$91"));

        MatcherAssert.assertThat("Incorrect total price," +
                        "including taxes!",
                page.strTotal.getText().contains("$1199")); //correct this assert!

        page.bookFlight("Ivan","Ivanov","Bland",
                "Irina", "Ivanova", "Bland",
                "Visa", "5479540454132487",
                "05", "2009", "Ivan",
                "Ivanovich", "Ivanov",
                "1085 Borregas Ave.", "Albuquerque",
                "New Mexico", "94089", "UNITED STATES",
                "1225 Borregas Ave.", "Boston",
                "Massachusetts", "91089",
                "UNITED STATES");

        drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        /* Flight Confirmation page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Flight Confirmation or TimeOut!",
                drv.getCurrentUrl().contains("/mercurypurchase2.php"));
    }

    /* Flight Confirmation assert test method 5.**/
    @Test
    public void test5() {//correct last assertion!

        System.out.println("Flight Confirmation @Test method 5 invoked."
                + " Flight Confirmation.");

        drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        /* Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Flight Confirmation or Timeout!",
                drv.getTitle().contains("Flight Confirmation"));

        FlightConfirmationPage page = new FlightConfirmationPage(drv);

        MatcherAssert.assertThat("Incorrect departing destination!",
                page.strTo.getText().contains("Paris to Seattle"));

        MatcherAssert.assertThat("Incorrect departing date!",
               page.strDateTo.getText().contains("11/20/"));

        MatcherAssert.assertThat("Incorrect departing carrier!",
                page.strAirlinesTo.getText().contains("Unified Airlines 363"));

        MatcherAssert.assertThat("Incorrect returning destination!",
                page.strFrom.getText().contains("Seattle to Paris"));

        MatcherAssert.assertThat("Incorrect returning date!",
                page.strDateFrom.getText().contains("12/19"));

        MatcherAssert.assertThat("Incorrect returning carrier!",
                page.strAirlinesFrom.getText().contains("Blue Skies Airlines 631"));

        MatcherAssert.assertThat("Incorrect number of passengers!",
                page.strPassCount.getText().contains("2"));

        MatcherAssert.assertThat("Incorrect billing receiver!",
                page.strBillTo.getText().contains("Ivan Ivanovich Ivanov"));
        MatcherAssert.assertThat("Incorrect billing street!",
                page.strBillTo.getText().contains("1085 Borregas Ave."));
        MatcherAssert.assertThat("Incorrect billing address!",
                page.strBillTo.getText().contains("Albuquerque, New Mexico, 94089"));

        MatcherAssert.assertThat("Incorrect delivery street!",
                page.strDelTo.getText().contains("1225 Borregas Ave."));
        MatcherAssert.assertThat("Incorrect delivery address!",
                page.strDelTo.getText().contains("Boston, Massachusetts, 91089"));

        MatcherAssert.assertThat("Incorrect total price,"
                        + "including taxes!",
                page.strTotalPrice.getText().contains("$1199")); //correct this assert

        page.backToHome.click();

        drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        /* Homepage opened assertion.**/
        MatcherAssert.assertThat("Can`t open home page!",
                drv.getTitle().contains("Welcome"));
    }

    @AfterClass
    /* Post-conditions methods, webdriver close.**/
    public static void AfterClassMethod() {
        drv.close();
    }
}
