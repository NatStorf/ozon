package lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class Search {
    private static final String bookXPath = "//div/a[@class='inner-link']";
    private static final String buttonXPath = "//button[@data-test-id='tile-buy-button']";


    public Search(WebElement el) {
        //String xPath = String.format(buttonCaption, el.getAttribute("data-ri"));
        String button = el.findElement(By.xpath(buttonXPath)).getText();
    }



    public static List<Search> getPicRes() {
        List<WebElement> els = App.driver.findElements(By.xpath(bookXPath));
        List<Search> resList = new LinkedList<>();
        for (WebElement el : els){
            resList.add(new Search(el));
        }
        return resList;
    }


}
