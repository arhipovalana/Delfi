package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage {

    private BaseFunction baseFunc;

//    private final By ARTICLE_PAGE_TITLE = By.className("text-size-22 text-size-md-30 d-inline");
    private final By ARTICLE_PAGE_TITLE = By.xpath("//h1[contains(@class,'text-size-22')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath("//a[contains(@class,'text-size-md-28 text-red-ribbon')]");

    public ArticlePage(BaseFunction baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleText(){
       List<WebElement> titleList = baseFunc.getElementList(ARTICLE_PAGE_TITLE);
       if (!titleList.isEmpty()) {
           return titleList.get(0).getText().trim();
       } else {
           return null;
       }
    }

    public Integer getCommentCount(){
        List<WebElement> commentList = baseFunc.getElementList(ARTICLE_PAGE_COMMENTS);
        if (!commentList.isEmpty()) {
            String commentCount = baseFunc.removeBrackets(commentList.get(0).getText());
            return baseFunc.changeStringToInteger(commentCount);
        } else {
            Integer commentCount = 0;
            return commentCount;
        }
    }

    public void openCommentPage() {
        WebElement element = baseFunc.getElement(ARTICLE_PAGE_COMMENTS);
        baseFunc.clickOnElement(element);
    }

}
