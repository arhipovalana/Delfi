package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunction {

    private WebDriver browserDrv;
    private WebDriverWait wait;

    public BaseFunction() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browserDrv = new ChromeDriver();
        browserDrv.manage().window().maximize();
        browserDrv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(browserDrv, 10, 500);
    }

    public void goToUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        browserDrv.get(url);
    }

    public void waitForVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibilityOfElementList(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement getElement(By locator) {
        waitForVisibilityOfElement(locator);
        return browserDrv.findElement(locator);
    }

    public List<WebElement> getElementList(By locator) {
        waitForVisibilityOfElementList(locator);
        return browserDrv.findElements(locator);
    }

    public String getElementText (List<WebElement> elementList, int elementIndex) {
        if (!elementList.isEmpty()) {
            return removeBrackets(elementList.get(elementIndex).getText().trim());
        } else {
            return null;
        }
    }

    public String removeBrackets(String textWithBrackets) {
        return textWithBrackets.replaceAll("([()])", "").trim();
    }

    public Integer changeStringToInteger(String text) {
        return Integer.valueOf(text);
    }

    public void waitForElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(WebElement element) {
        waitForElementIsClickable(element);
        element.click();
    }

    public void quit() {
        browserDrv.close();
    }

}
