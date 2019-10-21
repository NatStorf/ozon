package lesson;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

import Pages.OzonPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Before
    public void startTest(){
        System.out.println("----------------------------------Начало теста----------------------------------");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;
        open(OzonPage.URL);
        OzonPage.closeCookies().click();
        WebDriverRunner.driver();
    }

    @Test
    public void buyRandomBook()
    {
        OzonPage.getCatalog().click();
        OzonPage.getBooks().hover();
        OzonPage.getCompTech().click();
        OzonPage.BooksPage.selectBestseller();
        OzonPage.BooksPage.selectPL();
        Random rnd = new Random();
        int i = rnd.nextInt(OzonPage.BooksPage.addToCartButtonList().size()+1) ;
        String buyTitle = OzonPage.BooksPage.tileNameList().get(i).getText();
        OzonPage.BooksPage.addToCartButtonList().get(i).click();
        if (OzonPage.BooksPage.addToCartButtonList().get(i).isDisplayed()) {
            System.out.println("Книга " + "\"" + buyTitle + "\"" + " добавлена в корзину");
        }
        OzonPage.BooksPage.getCart().click();
        if (buyTitle.contains(OzonPage.CartPage.cartTileName().getText())) {
            System.out.println("Книга " + "\"" + OzonPage.CartPage.cartTileName().getText() + "\"" + " в корзине");
        }
    }

//    @Test
//    public void buyRandomBook2()
//    {
//        OzonPage.getCatalog().click();
//        OzonPage.getBooks().hover();
//        OzonPage.getCompTech().click();
//        OzonPage.BooksPage.selectBestseller();
//        OzonPage.BooksPage.selectPL();
//        Random rnd = new Random();
//        int i = rnd.nextInt(OzonPage.BooksPage.addToCartButtonList().size()+1) ;
//        String buyTitle = OzonPage.BooksPage.tileNameList().get(i).getText();
//        OzonPage.BooksPage.addToCartButtonList().get(i).click();
//        if (OzonPage.BooksPage.addToCartButtonList().get(i).isDisplayed()) {
//            System.out.println("Книга " + "\"" + buyTitle + "\"" + " добавлена в корзину");
//        }
//        OzonPage.BooksPage.getCart().click();
//        if (buyTitle.contains(OzonPage.CartPage.cartTileName().getText())) {
//            System.out.println("Книга " + "\"" + OzonPage.CartPage.cartTileName().getText() + "\"" + " в корзине");
//        }
//    }

    @After
    public void closeTest(){
        WebDriverRunner.closeWebDriver();
        System.out.println("----------------------------------Конец теста----------------------------------");
    }
}
