package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunction {

    private WebDriver browserDrv;
    private WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(BaseFunction.class);

    public BaseFunction() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browserDrv = new ChromeDriver();
        browserDrv.manage().window().maximize();
        browserDrv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(browserDrv, 10, 500);
    }

    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
        } else {
            url = "http://" + url;
        }
        browserDrv.get(url);
    }

    public WebElement getElement(By locator) {
        return browserDrv.findElement(locator);
    }

    public List<WebElement> getElementList(By locator) {
        return browserDrv.findElements(locator);
    }

    public String removeBrackets(String textWithBrackets) {
        return textWithBrackets.replaceAll("([()])", "").trim();
    }

    public Integer changeStringToInteger(String text) {
        return Integer.valueOf(text);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void quit() {
        browserDrv.close();
    }

}
