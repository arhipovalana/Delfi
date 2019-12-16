import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunction;
import pages.CommentPage;
import pages.HomePage;

public class ArticleAndCommentCompareTest {

    // Open Browser
    private BaseFunction baseFunc = new BaseFunction();

    @Test
    public void titleAndCommentsTest() {

        // Open Delfi Home Page
        baseFunc.goToUrl("rus.delfi.lv");

        HomePage homePage = new HomePage(baseFunc);

        Integer articleNumber = 1;

        // Get article title text
        String homePageTitle = homePage.getTitleText(articleNumber);
        System.out.println("(" + (articleNumber+1) + ") article title on Home page is: " + homePageTitle);

        // Get article comment count number
        Integer homePageComments = homePage.getCommentCount(articleNumber);
        System.out.println("(" + (articleNumber+1) + ") article comment count on Home page is: " + homePageComments);

        // Open article page
        homePage.openArticlePage(articleNumber);

        ArticlePage articlePage = new ArticlePage(baseFunc);

        // Get article title text
        String articlePageTitle = articlePage.getTitleText();
        Assertions.assertNotNull(articlePageTitle, "There is no title on Article page");
        System.out.println("(" + (articleNumber+1) +") article title on Article page is: " + articlePageTitle);

        // Get comment count number
        Integer articlePageComments = articlePage.getCommentCount();
        Assertions.assertNotNull(articlePageComments,"There is no comments on Article page");
        System.out.println("(" + (articleNumber+1) + ") article comment count on Article page is: " + articlePageComments);

        // Check titles
        Assertions.assertEquals(homePageTitle, articlePageTitle, "Title on article page isn't the same than on Home page");

        // Check comment count
        Assertions.assertEquals(homePageComments, articlePageComments, "Comment count on article page isn't the same than on Home page!");

        // Open comments page
        articlePage.openCommentPage();

        CommentPage commentPage = new CommentPage(baseFunc);

        // Get article title text
        String commentPageTitle = commentPage.getTitleText();
        System.out.println("(" + (articleNumber+1) + ") article title on Comment page is: " + commentPageTitle);

        // Get comment count number
        Integer commentPageComments = commentPage.getCommentCount();
        System.out.println("(" + (articleNumber+1) + ") article comment count on Comment page is: " + commentPageComments);


        // Check titles
        Assertions.assertEquals(articlePageTitle,commentPageTitle,"Title on comment page isn't the same than on Article page");

        // Check comment count
        Assertions.assertEquals(articlePageComments,commentPageComments,"Comment count on comment page isn't the same than on Article page!");

        // Close browser
        baseFunc.quit();

    }
}
