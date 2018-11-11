import org.hamcrest.MatcherAssert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
                + "WebDriver init and preconds:");

        System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver.exe");
        drv = new ChromeDriver();

        drv.get("http://newtours.demoaut.com");
    }

    @Test
    public void test1() { // done method

        System.out.println("@Test method 1 invoked."
                + " Login and assert.");

        drv.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        /* UserName input.**/
        WebElement element = drv.findElement
                (By.xpath("//input[@name = 'userName']"));
        element.sendKeys("test1");

        /* Password input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'password'][@type = 'password']"));
        element.sendKeys("test1");

        /* Login button click.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'login'][@value = 'Login']"));
        element.click();

        drv.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        /* Find a Flight PAge opened assertion.**/
        MatcherAssert.assertThat("Login failed or TimeOut!",
                drv.getTitle().contains("Find a Flight"));
    }

    @Test
    /* Flight Finder test method.**/
    public void test2() { //done method

        System.out.println("@Test method 2 invoked."
                + " Find a flight.");

        /* Find a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Login failed!",
                drv.getTitle().contains("Find a Flight"));

        /* Trip Type select.**/
       WebElement element = drv.findElement(By.xpath
               ("//input[@name = 'tripType'][@value = 'oneway']"));
       element.click();

        /* Numbers of Passengers select.**/
       element = drv.findElement(By.xpath
               ("//select[@name = 'passCount']"));
       Select sel = new Select(element);
       sel.selectByValue("2");

        /* From Port select.**/
       element = drv.findElement(By.xpath
               ("//select[@name = 'fromPort']"));
       sel = new Select(element);
       sel.selectByValue("Paris");

        /* From Month select.**/
       element = drv.findElement(By.xpath
               ("//select[@name = 'fromMonth']"));
       sel = new Select(element);
       sel.selectByValue("11");

        /* From Day select.**/
       element = drv.findElement(By.xpath
               ("//select[@name = 'fromDay']"));
       sel = new Select(element);
       sel.selectByValue("20");

        /* Port To select.**/
       element = drv.findElement(By.xpath
               ("//select[@name = 'toPort']"));
       sel = new Select(element);
       sel.selectByValue("Seattle");

        /* Month To select.**/
       element = drv.findElement(By.xpath
               ("//select[@name = 'toMonth']"));
       sel = new Select(element);
       sel.selectByValue("12");

        /* Day To select.**/
       element = drv.findElement(By.xpath
               ("//select[@name = 'toDay']"));
       sel = new Select(element);
       sel.selectByValue("19");

        /* Class select.**/
       element = drv.findElement(By.xpath
               ("//input[@name = 'servClass']"
                       + "[@value = 'Business']"));
       element.click();

        /* Carrier select.**/
       element = drv.findElement(By.xpath("//select[@name = 'airline']"));
       sel = new Select(element);
       sel.selectByVisibleText("Pangea Airlines");

        /* Button click.**/
       element = drv.findElement(By.xpath
               ("//input[@name = 'findFlights']"));
       element.click();

        drv.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        /* Select a Flight Page opened assertion.**/
       MatcherAssert.assertThat("Can`t open page"
                       + "Select a Flight!",
               drv.getTitle().contains("Select a Flight"));
    }

    @Test
    /* Select a Flight test method.**/
    public void test3() {

        System.out.println("@Test method 3 invoked."
                + " Select a Flight.");

        /* Select a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + "Select a Flight!",
                drv.getTitle().contains("Select a Flight"));

        /* Departing To Destination assertion.**/
        WebElement element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[3]//font"));
        String strTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing!",
                element.getText().contains("Paris to Seattle"));

        /* Departing To Date assertion.**/
        element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[4]//font"));
        String strDateTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing date!",
                element.getText().contains("11/20/"));

        /* Carrier Depart choose.**/
        element = drv.findElement(By.xpath
                ("(//input[@name = 'outFlight'])[4]"));
        element.click();

        /* Carrier Return choose.**/
        element = drv.findElement(By.xpath
                ("(//input[@name = 'inFlight'])[2]"));
        element.click();

        /* Price To save.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_verb_xcols']//b)[4]"));
        String priceTo = element.getText(); //saves?
        element.click();

        /* Returning From Destination assertion.**/
        element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[7]//font"));
        String strFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning destination!",
                element.getText().contains("Seattle to Paris"));

        /* Returning Date From assertion.**/
        element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[8]//font"));
        String strDateFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning date!",
                element.getText().contains("12/19/"));

        /* Carrier From choose.**/
        element = drv.findElement(By.xpath
                ("(//input[@name = 'inFlight'])[2]")); //check it!
        element.click();

        /*Price From Saving.**/
        element = drv.findElement(By.xpath
                ("//b[contains(.,'$273')]")); //check it!
        String priceFrom = element.getText();

        /* Button click.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'reserveFlights']"));
        element.click();

        drv.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        /* Book a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Book a Flight!",
                drv.getCurrentUrl().contains("/mercurypurchase.php"));
    }

    @Test
    /* Book Flight assertion method.**/
    public void test4() {

        System.out.println("@Test method 4 invoked."
                + " Book a flight.");

        /* Book a Flight Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + "Book a Flight!",
                drv.getTitle().contains("Book a Flight"));

        /* Departing To Destination assertion.**/
        WebElement element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[1]/"
                        + "b/font"));
        String strTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing destination!",
                element.getText().contains("Paris to Seattle"));

        /* Departing To Date assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[2]/"
                        + "b/font"));
        String strDateTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing to date!",
                element.getText().contains("11/20/"));

        /* Carrier To assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[1]//b"));
        String strFlightTo = element.getText();
        MatcherAssert.assertThat("Incorrect carrier!",
                element.getText().contains("363"));

        /* Class To assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center_mono'])[1]/font"));
        String strClassTo = element.getText();
        MatcherAssert.assertThat("Incorrect class!",
                element.getText().contains("Business"));

        /* Price To assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center'])[1]/font"));
        String strPriceTo = element.getText();
        MatcherAssert.assertThat("Incorrect price!",
                element.getText().contains("281"));

        /* Destination Returning From assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[2]/b/font"));
        String strFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning!",
                element.getText().contains("Seattle to Paris"));

        /* Returning From Date assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center_mono'])[2]/b/font"));
        String strDateFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning from date!",
                element.getText().contains("12/19/"));

        /* Carrier From assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[4]//b"));
        String strFlightFrom = element.getText();
        MatcherAssert.assertThat("Incorrect carrier!",
                element.getText().contains("631"));

        /* Class From assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center_mono'])[4]/font"));
        String strClassFrom = element.getText();
        MatcherAssert.assertThat("Incorrect class!",
                element.getText().contains("Business"));

        /* Price From assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center'])[3]/font"));
        String strPriceFrom = element.getText();
        MatcherAssert.assertThat("Incorrect price!",
                element.getText().contains("273"));

        /* Number of passengers assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[6]/font"));
        String strPassengers = element.getText();
        MatcherAssert.assertThat("Incorrect number of passengers!",
                element.getText().contains("2"));

        /* Taxes assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[8]/font"));
        String strTaxes = element.getText();
        MatcherAssert.assertThat("Incorrect taxes!",
                element.getText().contains("$91"));

        /* Total Price assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[10]/font/b"));
        String strTotal = element.getText();
        MatcherAssert.assertThat("Incorrect total price," +
                        "including taxes!",
                element.getText().contains("$1199")); //correct this assert!

        /* Passenger First Name input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'passFirst0']"));
        element.sendKeys("Ivanov");

        /* Passenger Last Name input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'passLast0']"));
        element.sendKeys("Ivan");

        /* Passenger Meal select.**/
        element = drv.findElement(By.xpath
                ("//select[@name = 'pass.0.meal']"));
        Select sel = new Select(element);
        sel.selectByVisibleText("Bland");

        /* Next Passenger First Name input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'passFirst1']"));
        element.sendKeys("Ivanova");

        /* Next Passenger Last Name input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'passLast1']"));
        element.sendKeys("Irina");

        /* Next Passenger Meal select.**/
        element = drv.findElement(By.xpath
                ("//select[@name = 'pass.1.meal']"));
        sel = new Select(element);
        sel.selectByVisibleText("Bland");

        /* Credit Card type select.**/
        element = drv.findElement(By.xpath
                ("//select[@name = 'creditCard']"));
        sel = new Select(element);
        sel.selectByVisibleText("Visa");

        /* Credit Card Number input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'creditnumber']"));
        element.sendKeys("5479540454132487");

        /* Expiration Month select.**/
        element = drv.findElement(By.xpath
                ("//select[@name = 'cc_exp_dt_mn']"));
        sel = new Select(element);
        sel.selectByVisibleText("05");

        /* Expiration Year select.**/
        element = drv.findElement(By.xpath
                ("//select[@name = 'cc_exp_dt_yr']"));
        sel = new Select(element);
        sel.selectByVisibleText("2009");

        /* First Name input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'cc_frst_name']"));
        element.sendKeys("Ivan");

        /* Mid Name input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'cc_mid_name']"));
        element.sendKeys("Ivanovich");

        /* Last Name input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'cc_last_name']"));
        element.sendKeys("Ivanov");

        /* Billing Address input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'billAddress1']"));
        element.clear();
        element.sendKeys("1085 Borregas Ave.");

        /* Billing City input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'billCity']"));
        element.clear();
        element.sendKeys("Albuquerque");

        /* Billing State input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'billState']"));
        element.clear();
        element.sendKeys("New Mexico");

        /* Billing Zip input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'billZip']"));
        element.clear();
        element.sendKeys("94089");

        /* Billing Country select.**/
        element = drv.findElement(By.xpath
                ("//select[@name = 'billCountry']"));
        sel = new Select(element);
        sel.selectByVisibleText("UNITED STATES");

        /* Same as Billing Address checking.**/
        element = drv.findElement(By.xpath
                ("(//input[@value = 'checkbox'])[2]"));
        element.click();

        /* Delivery Address input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'delAddress1']"));
        element.clear();
        element.sendKeys("1225 Borregas Ave.");

        /* Delivery City input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'delCity']"));
        element.clear();
        element.sendKeys("Boston");

        /* Delivery State input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'delState']"));
        element.clear();
        element.sendKeys("Massachusetts");

        /* Delivery Zip input.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'delZip']"));
        element.clear();
        element.sendKeys("91089");

        /* Delivery Country select.**/
        element = drv.findElement(By.xpath
                ("//select[@name = 'delCountry']"));
        sel = new Select(element);
        sel.selectByVisibleText("UNITED STATES");

        /* Secure Purchase button click.**/
        element = drv.findElement(By.xpath
                ("//input[@name = 'buyFlights']"));
        element.click();

        drv.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        /* Flight Confirmation page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Flight Confirmation or TimeOut!",
                drv.getCurrentUrl().contains("/mercurypurchase2.php"));
    }

    /* Flight Confirmation assert test method.**/
    @Test
    public void test5() {//correct last assertion!

        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("@Test method 5 invoked."
                + " Flight Confirmation.");

        /* Page opened assertion.**/
        MatcherAssert.assertThat("Can`t open page"
                        + " Flight Confirmation!",
                drv.getTitle().contains("Flight Confirmation"));

        /* Departing From assertion.**/
        WebElement element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[3]/font/b"));
        String strTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing destination!",
                element.getText().contains("Paris to Seattle"));

        /* Departing From Date assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[3]/font"));
        String strDateTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing date!",
                element.getText().contains("11/20/"));

        /* Departing carrier assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[3]/font"));
        String strAirlinesTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing carrier!",
                element.getText().contains("Unified Airlines 363"));

        /* Returning destination assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[5]/font/b"));
        String strFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning destination!",
                element.getText().contains("Seattle to Paris"));

        /* Returning date assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[5]/font"));
        String strDateFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning date!",
                element.getText().contains("12/19"));

        /* Avia-carrier assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[5]/font"));
        String strAirlinesFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning carrier!",
                element.getText().contains("Blue Skies Airlines 631"));

        /* Number of passengers assertion.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[2]/font"));
        String strPassengers = element.getText();
        MatcherAssert.assertThat("Incorrect number of passengers!",
                element.getText().contains("2"));

        /* Billing address assertion.**/
        element = drv.findElement(By.xpath
                ("((//p)[5]/font)[1]"));
        String strBillTo = element.getText();
        MatcherAssert.assertThat("Incorrect billing receiver!",
                element.getText().contains("Ivan Ivanovich Ivanov"));
        MatcherAssert.assertThat("Incorrect billing street!",
                element.getText().contains("1085 Borregas Ave."));
        MatcherAssert.assertThat("Incorrect billing address!",
                element.getText().contains("Albuquerque, New Mexico, 94089"));

        /* Delivery address assertion.**/
        element = drv.findElement(By.xpath
                ("(//p)[6]/font"));
        String strDelTo = element.getText();
        MatcherAssert.assertThat("Incorrect delivery street!",
                element.getText().contains("1225 Borregas Ave."));
        MatcherAssert.assertThat("Incorrect delivery address!",
                element.getText().contains("Boston, Massachusetts, 91089"));

        /* Total price including taxes assertion.**/
        element = drv.findElement(By.xpath
                ("((//td[@class = 'data_left'])[3]//font)[14]"));
        String strTotalPrice = element.getText();
        MatcherAssert.assertThat("Incorrect total price,"
                        + "including taxes!",
                element.getText().contains("$1199")); //correct this assert

        /* Click to the Back Home button.**/
        element = drv.findElement(By.xpath
                ("(//a)[13]"));
        element.click();

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
