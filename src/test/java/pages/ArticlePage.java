package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ArticlePage {

    private BaseFunction baseFunc;
    private final Logger LOGGER = LogManager.getLogger(ArticlePage.class);

    private final By ARTICLE_PAGE_TITLE = By.xpath("//h1[contains(@class,'text-size-22')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath("//a[contains(@class,'text-size-md-28 text-red-ribbon')]");

    public ArticlePage(BaseFunction baseFunc) {
        this.baseFunc = baseFunc;
        LOGGER.info("Start working in Article Page class");
        WebElement title = baseFunc.getElementList(ARTICLE_PAGE_TITLE).get(0);
        Assertions.assertNotNull(title, "There is no title on Article page");
        LOGGER.info("Checking title");
        WebElement comments = baseFunc.getElementList(ARTICLE_PAGE_COMMENTS).get(0);
        Assertions.assertNotNull(comments, "There is no comment on Article page");
        LOGGER.info("Checking comments");
    }

    // assertNotNull(articlePageTitle, "There is no title on Article page");

    public String getTitleText() {
        List<WebElement> titleList = baseFunc.getElementList(ARTICLE_PAGE_TITLE);
        if (!titleList.isEmpty()) {
            return titleList.get(0).getText().trim();
        } else {
            return null;
        }
    }

    public Integer getCommentCount() {
        List<WebElement> commentList = baseFunc.getElementList(ARTICLE_PAGE_COMMENTS);
        if (!commentList.isEmpty()) {
            String commentCount = baseFunc.removeBrackets(commentList.get(0).getText());
            return baseFunc.changeStringToInteger(commentCount);
        } else {
            Integer commentCount = 0;
            return commentCount;
        }
    }

    public CommentPage openCommentPage() {
        WebElement element = baseFunc.getElement(ARTICLE_PAGE_COMMENTS);
        baseFunc.clickOnElement(element);
        return new CommentPage(baseFunc);
    }

}