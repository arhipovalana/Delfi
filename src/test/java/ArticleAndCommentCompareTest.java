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

        // передали тесту класс (страницу, на которой будем работать)
        HomePage homePage = new HomePage(baseFunc); // создали копию класса HomePage, чтоб дальше писать тест используя переменные и методы HomePage


        // Find first article
        homePage.homePageFirstArticle();
        // Find first article title

        // Save article to String
        // Find comment count
        // Save comment count to Integer
        // Open article page
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
