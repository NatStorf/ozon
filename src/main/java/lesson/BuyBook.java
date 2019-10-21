package lesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class BuyBook {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;
        open("https://www.ozon.ru/");

        $(By.xpath("//button[@class='close']")).click();

        $(By.xpath("//button[@value='Каталог']")).click();
        $(By.xpath("//span[contains(text(), 'Книги')]")).hover();
        $(By.xpath("//span[contains(text(), 'Компьютерные технологии')]")).click();

        SelenideElement best = $(By.xpath("//span[contains(text(),'Бестселлеры')]"));
        if (!best.isSelected()) {
            best.click();
        }
        SelenideElement pl = $(By.xpath("//span[contains(text(),'Языки программирования')]"));
        if (!pl.isSelected()) {
            pl.click();
        }

        List<SelenideElement> buyButtonList = $$(By.xpath("//button/*[text() = 'В корзину']"));
        Random rnd = new Random();
        int i = rnd.nextInt(buyButtonList.size()+1) ;
        List<SelenideElement> buyTileName = $$(By.xpath("//a[@data-test-id='tile-name']"));
        String buyTitle = buyTileName.get(i).getText();
        buyButtonList.get(i).click();
        if (buyButtonList.get(i).isDisplayed()) {
            System.out.println("Книга " + "\"" + buyTitle + "\"" + " добавлена в корзину");
        }

        $(By.xpath("//a//*[contains(text(),'Корзина')]")).click();
        SelenideElement cartTileName = $(By.xpath("//a[@class='title']/span"));
        String cartTitle = cartTileName.getText();
        if (buyTitle.contains(cartTitle)) {
            System.out.println("Книга " + "\"" + cartTitle + "\"" + " в корзине");
        }

    }
}
