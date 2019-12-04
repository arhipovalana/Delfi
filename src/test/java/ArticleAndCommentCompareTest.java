import org.junit.jupiter.api.Test;
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

        // Get first article title text
        String homepageTitle = homePage.getTitleText(1);
        System.out.println("Home page first article title is: " + homepageTitle);

        // Get first article comment count number
        Integer homepageComments = homePage.getCommentCount(1);
        System.out.println("Home page First article comment count is: " + homepageComments);

        // Open article page
        //homePage.openArticlePage(0);

        // Find title on article page
        // Check titles
        // Find comment count on article page
        // Check comment count
        // Open comments page
        // Find title
        // Check titles
        // Find comment count on comment page
        // Check comment count
        // Close browser

    }
}
