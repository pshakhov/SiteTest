
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import java.util.logging.Logger;

/** Listener.*/
public class EventHandler implements WebDriverEventListener {

    /** Listener.*/
    Logger LOGGER = Logger.getLogger(EventHandler.class.getName());

    /** After change value message.
     * @param webElement
     * @param webDriver*/
    public void afterChangeValueOf(final WebElement webElement,
                                   final WebDriver webDriver) {
        LOGGER.info("Value changed");
    }

    /** by default.
     * @param webElement
     * @param webDriver */
    public void afterClickOn(final WebElement webElement,
                             final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("inside method afterClickOn on "
                + webElement.toString());
    }

    /** After change value of message.
     * @param webElement
     * @param webDriver
     * @param charSequences*/
    public void beforeChangeValueOf(final WebElement webElement,
                                    final WebDriver webDriver,
                                    final CharSequence[] charSequences) {
         LOGGER.info("Value of " + webElement
                 + " changed to " + charSequences);
    }

    /** by default.
     * @param webElement
     * @param webDriver
     * @param charSequences*/
    public void afterChangeValueOf(final WebElement webElement,
                                   final WebDriver webDriver,
                                   final CharSequence[] charSequences) {

    }

    /** After find by message.
     * @param webDriver
     * @param str
     * @param by*/
    public void afterFindBy(final By by,
                            final WebElement str,
                            final WebDriver webDriver) {
        LOGGER.info("Element found");
    }

    /** by default.
     * @param webDriver*/
    public void afterNavigateBack(final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Inside the after navigateback to "
                + webDriver.getCurrentUrl());
    }

    /** by default.
     * @param webDriver*/
    public void afterNavigateForward(final WebDriver webDriver) {
        // TODO Auto-generated method stub
       System.out.println("Inside the afterNavigateForward to "
                + webDriver.getCurrentUrl());
    }

    /** by default.
     * @param webDriver*/
    public void beforeNavigateRefresh(final WebDriver webDriver) {

    }

    /** by default.
     * @param webDriver*/
    public void afterNavigateRefresh(final WebDriver webDriver) {

    }

    /** After navigate to message.
     * @param webDriver
     * @param str*/
    public void afterNavigateTo(final String str,
                                final WebDriver webDriver) {
        LOGGER.info("Transition completed");
    }

    /** by default.
     * @param
     * @param webDriver*/
    public void afterScript(final String str,
                            final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Inside the afterScript to, Script is " + webDriver);
    }

    /** by default.
     * @param webDriver
     * @param str*/
    public void beforeSwitchToWindow(final String str,
                                     final WebDriver webDriver) {

    }

    /** by default.
     * @param webDriver
     * @param str */
    public void afterSwitchToWindow(final String str,
                                    final WebDriver webDriver) {

    }

    /** by default.
     * @param webElement
     * @param webDriver*/
    public void beforeChangeValueOf(final WebElement webElement,
                                    final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Inside the beforeChangeValueOf method");
    }

    /** Before click on message.
     * @param webDriver
     * @param webElement */
    public void beforeClickOn(final WebElement webElement,
                              final WebDriver webDriver) {
        LOGGER.info("Click on element " + webElement);

    }

    /** Before find by message.
     * @param webDriver
     * @param by
     * @param str */
    public void beforeFindBy(final By by,
                             final WebElement str,
                             final WebDriver webDriver) {
        LOGGER.info("Before finding element by " + by);

    }

    /** by default.*/
    public void beforeNavigateBack(final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeNavigateBack "
                + webDriver.getCurrentUrl());

    }

    /** by default.*/
    public void beforeNavigateForward(final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeNavigateForward "
                + webDriver.getCurrentUrl());

    }

    /** by default.*/
    public void beforeAlertAccept(final WebDriver webDriver) {

    }

    /** by default.*/
    public void afterAlertAccept(final WebDriver webDriver) {

    }

    /** by default.*/
    public void afterAlertDismiss(final WebDriver webDriver) {

    }

    /** by default.*/
    public void beforeAlertDismiss(final WebDriver webDriver) {

    }

    /** Before navigate to message.*/
    public void beforeNavigateTo(final String str,
                                 final WebDriver webDriver) {
        LOGGER.info("Transition to" + str + "");
    }

    /** by default.*/
    public void beforeScript(final String str,
                             final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeScript "
                + webDriver);
    }

    /** by default.
     * @param webDriver
     * @param throwable*/
    public void onException(final Throwable throwable,
                            final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Exception occured at "
                + throwable.getMessage());

    }

    /** by default.
     * @param outputType */
    public <X> void beforeGetScreenshotAs(final OutputType<X> outputType) {

    }

    /** by default.
     * @param outputType
     * @param x*/
    public <X> void afterGetScreenshotAs(final OutputType<X> outputType,
                                         final X x) {

    }

    /** by default.
     * @param webDriver
     * @param webElement */
    public void beforeGetText(final WebElement webElement,
                              final WebDriver webDriver) {

    }

    /** by default.
     * @param webDriver
     * @param webElement
     * @param str*/
    public void afterGetText(final WebElement webElement,
                             final WebDriver webDriver,
                             final String str) {

    }

}