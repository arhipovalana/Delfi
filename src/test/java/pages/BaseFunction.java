package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class BaseFunction {

    private WebDriver browserDrv;

    // создаем окно браузера - конструктор
    public BaseFunction() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browserDrv = new ChromeDriver();
        browserDrv.manage().window().maximize();
    }

    // создаем набор функций для работы с созданным окном браузера

    // функция, которая переходит по ссылке
    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {       // две палочки  || - это or
        } else {
            url = "http://" + url;
        }
        browserDrv.get(url);
    }

    // функция, которая ищет первый элемент с помощью локатора
    public WebElement getElement(By locator) {
        return browserDrv.findElement(locator);
    }

    // функция, которая ищет все элементы с помощью локатора и создаёт список
    public List<WebElement> getElementList(By locator) {
        return browserDrv.findElements(locator);
    }

    //функция, которая получает String из элемента


//    // функция, которая удаляет скобки и возвращает Integer
//    public Integer removeBrackets(String valueWithBrackets){
//        return Integer.valueOf(valueWithBrackets.replaceAll("([()])","").trim());
//    }

    // функция, которая удаляет скобки из текста
    public String removeBrackets(String textWithBrackets){
        return textWithBrackets.replaceAll("([()])","").trim();
    }

    // функция, которая меняет тип String на Integer
    public Integer changeStringToInteger(String text){
        return Integer.valueOf(text);
    }

    // функция, которая кликает по элементу
    public void click(WebElement element) {
        element.click();
    }

}
