import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunction;
import pages.HomePage;

public class ArticleAndCommentCompareTest {

    // Open Browser
    private BaseFunction baseFunc = new BaseFunction();

    @Test
    public void titleAndCommentsTest() {

        // Open Delfi Home Page
        baseFunc.goToUrl("rus.delfi.lv");

        HomePage homePage = new HomePage(baseFunc);

        Integer articleNumber = 0;

        // Get first article title text
        String homepageTitle = homePage.getTitleText(articleNumber);
        System.out.println("Home page article Nm " + (articleNumber+1) + " title is: " + homepageTitle);

        // Get first article comment count number
        Integer homepageComments = homePage.getCommentCount(articleNumber);
        System.out.println("Home page article Nm " + (articleNumber+1) + " comment count is: " + homepageComments);

        // Open article page
        homePage.openArticlePage(articleNumber);

        ArticlePage articlePage = new ArticlePage(baseFunc);

        // Get article title text
        String articlepageTitle = articlePage.getTitleText();
        System.out.println((articleNumber+1) +" Article page title is: "articlepageTitle);

        // Get comment count number
        Integer articlepageComments = articlePage.getCommentCount();
        System.out.println((articleNumber+1) + " Article page comment count is: "articlepageComments);

        // Check titles
        // Check comment count
        // Open comments page
        // Find title
        // Check titles
        // Find comment count on comment page
        // Check comment count
        // Close browser

    }
}
