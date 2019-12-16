package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CommentPage {

    private BaseFunction baseFunc;


    private final By COMMENT_PAGE_TITLE = By.xpath("//*[@class = 'article-title']");
    private final By COMMENT_PAGE_COMMENT_COUNT = By.className("type-cnt");


    public CommentPage(BaseFunction baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleText(){
        List<WebElement> titleList = baseFunc.getElementList(COMMENT_PAGE_TITLE);
        if (!titleList.isEmpty()) {
            return titleList.get(0).getText().trim();
        } else {
            return null;
        }
    }

    public Integer getCommentCount(){
        List<WebElement> commentList = baseFunc.getElementList(COMMENT_PAGE_COMMENT_COUNT);
        if (!commentList.isEmpty()) {
            Integer commentCountAnonymous = baseFunc.changeStringToInteger(baseFunc.removeBrackets(commentList.get(0).getText()));
            Integer commentCountRegistered = baseFunc.changeStringToInteger(baseFunc.removeBrackets(commentList.get(1).getText()));
            return commentCountAnonymous + commentCountRegistered;
        } else {
            Integer commentCount = 0;
            return commentCount;
        }
    }


}
