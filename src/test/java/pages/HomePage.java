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

    private List<WebElement> articleList() {
        List<WebElement> articleBlockList = baseFunc.getElementList(HOME_PAGE_ARTICLES);
        Assertions.assertFalse(articleBlockList.isEmpty(), "There is no any article on Home Page");
        return articleBlockList;
    }

    public String getTitleText(int articleIndex) {
        if (!articleList().isEmpty()) ;
        return articleList().get(articleIndex).findElement(HOME_PAGE_ARTICLE_TITLES).getText().trim();
    }

//    public Integer getCommentCount(int articleIndex){
//        if (!articleList().isEmpty()) {
//            return baseFunc.removeBrackets(articleList().get(articleIndex).findElement(HOME_PAGE_ARTICLE_COMMENTS).getText());
//        } else {
//            Integer commentList = 0;
//            return commentList;
//        }

    public Integer getCommentCount(int articleIndex) {
        if (!articleList().isEmpty()) ;
        return baseFunc.removeBrackets(articleList().get(articleIndex).findElement(HOME_PAGE_ARTICLE_COMMENTS).getText());
    }

    public WebElement openArticlePage(int articleIndex) {
        WebElement element = articleList().get(articleIndex).findElement(HOME_PAGE_ARTICLE_TITLES);
        return baseFunc.clickOnElement(element);
    }

}