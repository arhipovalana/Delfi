import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunction;
import pages.CommentPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleAndCommentCompareTest {

    // Open Browser
    private BaseFunction baseFunc = new BaseFunction();
    private final Logger LOGGER = LogManager.getLogger(ArticleAndCommentCompareTest.class);

    @Test
    public void titleAndCommentsTest() {

        LOGGER.info("Open Delfi home page");
        baseFunc.goToUrl("rus.delfi.lv");

        HomePage homePage = new HomePage(baseFunc);

        LOGGER.info("Choose article Nm.");
        Integer articleNumber = 1;

        LOGGER.info("Get article title text");
        String homePageTitle = homePage.getTitleText(articleNumber);
//        System.out.println("(" + (articleNumber+1) + ") article title on Home page is: " + homePageTitle);

        LOGGER.info("Get article comment count number");
        Integer homePageComments = homePage.getCommentCount(articleNumber);
//        System.out.println("(" + (articleNumber+1) + ") article comment count on Home page is: " + homePageComments);

        LOGGER.info("Open article page");
        ArticlePage articlePage = homePage.openArticlePage(articleNumber);

//        LOGGER.info("Open article page");
//        homePage.openArticlePage(articleNumber);

//        LOGGER.info("Start working in article page class");
//        ArticlePage articlePage = new ArticlePage(baseFunc);

        LOGGER.info("Get article title text");
        String articlePageTitle = articlePage.getTitleText();
        assertNotNull(articlePageTitle, "There is no title on Article page");
//        System.out.println("(" + (articleNumber+1) +") article title on Article page is: " + articlePageTitle);

        LOGGER.info("Get comment count number");
        Integer articlePageComments = articlePage.getCommentCount();
        assertNotNull(articlePageComments,"There is no comments on Article page");
//        System.out.println("(" + (articleNumber+1) + ") article comment count on Article page is: " + articlePageComments);

        LOGGER.info("Check titles");
        assertEquals(homePageTitle, articlePageTitle, "Title on article page isn't the same than on Home page");

        LOGGER.info("Check comment count");
        assertEquals(homePageComments, articlePageComments, "Comment count on article page isn't the same than on Home page!");

        LOGGER.info("Open article page");
        CommentPage commentPage = articlePage.openCommentPage();

//        LOGGER.info("Open comments page");
//        articlePage.openCommentPage();
//
//        LOGGER.info("Start working in comment page class");
//        CommentPage commentPage = new CommentPage(baseFunc);

        LOGGER.info("Get article title text");
        String commentPageTitle = commentPage.getTitleText();
//        System.out.println("(" + (articleNumber+1) + ") article title on Comment page is: " + commentPageTitle);

        LOGGER.info("Get comment count number");
        Integer commentPageComments = commentPage.getCommentCount();
//        System.out.println("(" + (articleNumber+1) + ") article comment count on Comment page is: " + commentPageComments);

        LOGGER.info("Check titles");
        assertEquals(articlePageTitle,commentPageTitle,"Title on comment page isn't the same than on Article page");

        LOGGER.info("Check comment count");
        assertEquals(articlePageComments,commentPageComments,"Comment count on comment page isn't the same than on Article page!");

//        LOGGER.info("Close browser");
//        baseFunc.quit();
    }

        @AfterEach
        public void closeBrowser(){
        LOGGER.info("Close browser");
        baseFunc.quit();
        }


}
