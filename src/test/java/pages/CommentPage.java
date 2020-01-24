package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommentPage {

    private BaseFunction baseFunc;
    private final Logger LOGGER = LogManager.getLogger(CommentPage.class);

    private final By COMMENT_PAGE_TITLE = By.xpath("//*[@class = 'article-title']");
    private final By COMMENT_PAGE_COMMENT_COUNT = By.className("type-cnt");

    public CommentPage(BaseFunction baseFunc) {
        this.baseFunc = baseFunc;
        LOGGER.info("Start working in Comment Page class");
        WebElement title = baseFunc.getElementList(COMMENT_PAGE_TITLE).get(0);
        Assertions.assertNotNull(title, "There is no title on Article page");
        WebElement comments = baseFunc.getElementList(COMMENT_PAGE_COMMENT_COUNT).get(0);
        Assertions.assertNotNull(comments, "There is no comment on Article page");
    }
// ПЕРЕДЕЛАТЬ МЕТОД
    public String getTitleText() {
        List<WebElement> titleList = baseFunc.getElementList(COMMENT_PAGE_TITLE);
        return baseFunc.getElementText(titleList,0);
    }

//    public Integer getCommentCount() {
//        List<WebElement> commentList = baseFunc.getElementList(COMMENT_PAGE_COMMENT_COUNT);
//        if (!commentList.isEmpty()) {
//            Integer commentCountAnonymous = Integer.valueOf(baseFunc.removeBrackets(commentList.get(0).getText()));
//            Integer commentCountRegistered = Integer.valueOf(baseFunc.removeBrackets(commentList.get(1).getText()));
//            return commentCountAnonymous + commentCountRegistered;
//        } else {
//            Integer commentCount = 0;
//            return commentCount;
//        }
//    }

    public Integer getCommentCount() {
        List<WebElement> commentList = baseFunc.getElementList(COMMENT_PAGE_COMMENT_COUNT);
        Integer commentCountAnonymous = Integer.valueOf(baseFunc.getElementText(commentList,0));
        Integer commentCountRegistered = Integer.valueOf(baseFunc.getElementText(commentList,1));
            return commentCountAnonymous + commentCountRegistered;
    }

}
