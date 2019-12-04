package pages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {

    private BaseFunction baseFunc;

    private final By HOME_PAGE_ARTICLES = By.xpath(".//article[contains(@class, 'headline')]");
    private final By HOME_PAGE_ARTICLE_TITLES = By.xpath(".//*[contains(@class, 'headline__title')]");
    private final By HOME_PAGE_ARTICLE_COMMENTS = By.xpath(".//a[@class = 'comment-count text-red-ribbon']");

    public HomePage(BaseFunction baseFunc) {
        this.baseFunc = baseFunc;
    }

    private List<WebElement> getArticleList() {
        List<WebElement> articleBlockList = baseFunc.getElementList(HOME_PAGE_ARTICLES);
        Assertions.assertFalse(articleBlockList.isEmpty(), "There is no any article on Home Page");
        return articleBlockList;
    }

//    public String getTitleText(int articleIndex) {
//    //    if (!getArticleList().isEmpty()) ; // тут нужна другая проверка - есть ли элемент в элементе
//        return getArticleList().get(articleIndex).findElement(HOME_PAGE_ARTICLE_TITLES).getText().trim();
//    }

    public String getTitleText(int articleIndex) {
        WebElement article = getArticleList().get(articleIndex); // тут получила элемент номер Х
        article.findElements(HOME_PAGE_ARTICLE_TITLES); // тут ищу элемент в элементе Х


    }

//    public Integer getCommentCount(int articleIndex) {
//        if (!baseFunc.getElementList(HOME_PAGE_ARTICLE_COMMENTS).isEmpty()) {
//            String commentCount = baseFunc.removeBrackets(getArticleList().get(articleIndex).findElements(HOME_PAGE_ARTICLE_COMMENTS).get(articleIndex).getText());
//            return baseFunc.changeStringToInteger(commentCount);
//        } else {
//            Integer commentCount = 0;
//            return commentCount;
//        }
//    }

    public Integer getCommentCount(int articleIndex) {
        //    if (!getArticleList().isEmpty()) ; // тут нужна другая проверка - есть ли элемент в элементе
        String commentCount = baseFunc.removeBrackets(getArticleList().get(articleIndex).findElement(HOME_PAGE_ARTICLE_COMMENTS).getText());
        return baseFunc.changeStringToInteger(commentCount);
    }

//    public WebElement openArticlePage(int articleIndex) {
//        WebElement element = articleList().get(articleIndex).findElement(HOME_PAGE_ARTICLE_TITLES);
//        return baseFunc.clickOnElement(element);
//    }

}