package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class OzonPage {
    public static final String URL = "https://www.ozon.ru/";
    public static SelenideElement closeCookies(){
        return $(By.xpath("//button[@class='close']"));
    }

    public static SelenideElement getCatalog(){
        return $(By.xpath("//button[@value='Каталог']"));
    }
    public static SelenideElement getBooks(){
        return $(By.xpath("//span[contains(text(), 'Книги')]"));
    }
    public static SelenideElement getCompTech(){
        return  $(By.xpath("//span[contains(text(), 'Компьютерные технологии')]"));
    }

    public static class BooksPage{
        public static void selectBestseller(){
            SelenideElement bestseller = $(By.xpath("//span[contains(text(),'Бестселлеры')]"));
            if(!bestseller.isSelected()){
                bestseller.click();
            }
        }
        public static void selectPL(){
            SelenideElement PL = $(By.xpath("//span[contains(text(),'Языки программирования')]"));
            if(!PL.isSelected()){
                PL.click();
            }
        }
        public static List<SelenideElement> addToCartButtonList(){
            return $$(By.xpath("//button/*[text() = 'В корзину']"));
        }
        public static List<SelenideElement> tileNameList(){
            return $$(By.xpath("//a[@data-test-id='tile-name']"));
        }
        public static SelenideElement getCart(){
            return $(By.xpath("//a//*[contains(text(),'Корзина')]"));
        }
    }

    public static class CartPage{
        public static SelenideElement cartTileName(){
            return $(By.xpath("//a[@class='title']/span"));
        }
    }

}
