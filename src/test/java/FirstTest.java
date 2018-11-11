import org.hamcrest.MatcherAssert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
    public static void beforeClassMethod() {
        System.out.println("@BeforeClass static method invoked. "
                + "WebDriver init and preconds:");

        System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver.exe");
        drv = new ChromeDriver();

        drv.get("http://newtours.demoaut.com");
    }

    @Test
    public void loginTest() {

        System.out.println("@Test method 1 invoked."
                + " Login and assert.");

        WebElement element = drv.findElement
                (By.xpath("//input[@name = 'userName']"));
        element.sendKeys("test1");

        element = drv.findElement(By.xpath
                ("//input[@name = 'password'][@type = 'password']"));
        element.sendKeys("test1");

        element = drv.findElement(By.xpath
                ("//input[@name = 'login'][@value = 'Login']"));
        element.click();

        MatcherAssert.assertThat("Login failed!",
                drv.getTitle().contains("Find a Flight"));
    }

    @Test
    public void flightFinder() {

        System.out.println("@Test method 2 invoked."
                + " Find a flight.");

        MatcherAssert.assertThat("Login failed!",
                drv.getTitle().contains("Find a Flight"));

       WebElement element = drv.findElement(By.xpath
               ("//input[@name = 'tripType'][@value = 'oneway']"));
       element.click();

       element = drv.findElement(By.xpath
               ("//select[@name = 'passCount']"));

       Select sel = new Select(element);
       sel.selectByValue("2");

       element = drv.findElement(By.xpath
               ("//select[@name = 'fromPort']"));
       sel = new Select(element);
       sel.selectByValue("Paris");

       element = drv.findElement(By.xpath
               ("//select[@name = 'fromMonth']"));
       sel = new Select(element);
       sel.selectByValue("11");

       element = drv.findElement(By.xpath
               ("//select[@name = 'fromDay']"));
       sel = new Select(element);
       sel.selectByValue("20");

       element = drv.findElement(By.xpath
               ("//select[@name = 'toPort']"));
       sel = new Select(element);
       sel.selectByValue("Seattle");

       element = drv.findElement(By.xpath
               ("//select[@name = 'toMonth']"));
       sel = new Select(element);
       sel.selectByValue("12");

       element = drv.findElement(By.xpath
               ("//select[@name = 'toDay']"));
       sel = new Select(element);
       sel.selectByValue("19");

       element = drv.findElement(By.xpath
               ("//select[@name = 'servClass']"
                       + "[@value = 'Business']"));
       element.click();

       element = drv.findElement(By.xpath("//select[@name = 'airline']"));
       sel = new Select(element);
       sel.selectByValue("Pangea Airlines");

       element = drv.findElement(By.xpath
               ("//input[@name = 'findFlights']"));
       element.click();

       MatcherAssert.assertThat("Can`t open page"
                       + "Select a Flight!",
               drv.getTitle().contains("Select a Flight"));
    }

    @Test
    public void selectFlight() {

        System.out.println("@Test method 3 invoked."
                + " Select a flight.");

        MatcherAssert.assertThat("Can`t open page"
                        + "Select a Flight!",
                drv.getTitle().contains("Select a Flight"));

        WebElement element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[3]//font"));
        String strTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing!",
                element.getText().contains("Paris to Seattle"));

        element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[4]//font"));
        String strDateTo = element.getText();
        MatcherAssert.assertThat("Incorrect date!",
                element.getText().contains("11/20/"));

        element = drv.findElement(By.xpath
                ("//input[@name = 'inFlight']"
                        + "[contains[@value, 'Unified Airlines$363')]"));
        element.click();

        element = drv.findElement(By.xpath
                ("//b[contains(.,'$281')]"));
        String priceTo = element.getText();

        element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[7]//font"));
        String strFrom = element.getText();
        MatcherAssert.assertThat("Incorrect returning!",
                element.getText().contains("Paris to Seattle"));

        element = drv.findElement(By.xpath
                ("(//form[@method = 'post']//"
                        + "td[@class = 'title'])[8]//font"));
        String strDateFrom = element.getText();
        MatcherAssert.assertThat("Incorrect date!",
                element.getText().contains("12/19/"));

        element = drv.findElement(By.xpath
                ("//input[@name = 'inFlight']"
                        + "[contains[@value, "
                        + "'Blue Skies Airlines$631')]")); //check it!
        element.click();

        element = drv.findElement(By.xpath
                ("//b[contains(.,'$273')]")); //check it!
        String priceFrom = element.getText();

        element = drv.findElement(By.xpath
                ("//input[@name = 'reserveFlights']"));
        element.click();

        MatcherAssert.assertThat("Can`t open page"
                        + "Book a Flight!",
                drv.getTitle().contains("Book a Flight"));
    }

    @Test
    public void bookFlight() {

        System.out.println("@Test method 4 invoked."
                + " Book a flight.");

        MatcherAssert.assertThat("Can`t open page"
                        + "Book a Flight!",
                drv.getTitle().contains("Book a Flight"));

        WebElement element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[1]/"
                        + "b/font"));
        String strTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing!",
                element.getText().contains("Paris to Seattle"));

        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[2]/"
                        + "b/font"));
        String strDateTo = element.getText();
        MatcherAssert.assertThat("Incorrect departing date!",
                element.getText().contains("11/20/"));

        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[1]//b"));
        String strFlightTo = element.getText();
        MatcherAssert.assertThat("Incorrect airlines!",
                element.getText().contains("Unified Airlines 363"));


        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center_mono'])[1]/font"));
        String strClassTo = element.getText();
        MatcherAssert.assertThat("Incorrect class!",
                element.getText().contains("Business"));


        element = drv.findElement(By.xpath
                ("(//td[@class = 'frame_header_info'])[5]/font"));
        String strPriceTo = element.getText();
        MatcherAssert.assertThat("Incorrect price!",
                element.getText().contains("281"));

        /* From.**/
        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[2]/b/font"));
        String strFrom = element.getText();
        MatcherAssert.assertThat("Incorrect Returning!",
                element.getText().contains("Seattle to Paris"));

        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center_mono'])[2]/b/font"));
        String strDateFrom = element.getText();
        MatcherAssert.assertThat("Incorrect departing date!",
                element.getText().contains("12/19/"));

        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[4]//b"));
        String strFlightFrom = element.getText();
        MatcherAssert.assertThat("Incorrect airlines!",
                element.getText().contains("Unified Airlines 631"));


        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center_mono'])[4]/font"));
        String strClassFrom = element.getText();
        MatcherAssert.assertThat("Incorrect class!",
                element.getText().contains("Business"));


        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_center'])[3]/font"));
        String strPriceFrom = element.getText();
        MatcherAssert.assertThat("Incorrect class!",
                element.getText().contains("273"));

        element = drv.findElement(By.xpath
                ("(//td[@class = 'data_left'])[6]/font"));
        String strPassengers = element.getText();
        MatcherAssert.assertThat("Incorrect passengers!",
                element.getText().contains("2"));


    }
}
