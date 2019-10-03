package lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class App {
    static {System.setProperty("webdriver.chrome.driver",
            "C:\\chromedriver\\chromedriver.exe");}
    public static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\chromedriver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.get("https://www.ozon.ru/");

        WebElement catalog = driver.findElement(By.xpath("//button[@value='Каталог']"));
        catalog.click();
        WebElement books = driver.findElement(By.xpath("//span[contains(text(), 'Книги')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(books).build().perform();
        Thread.sleep(2500);
        WebElement ct = driver.findElement(By.xpath("//span[contains(text(), 'Компьютерные технологии')]"));
        ct.click();
        Thread.sleep(2500);
        WebElement best = driver.findElement(By.xpath("//span[contains(text(),'Бестселлеры')]"));
        if(!best.isSelected()){
            best.click();
        }
        Thread.sleep(3500);
        WebElement pl = driver.findElement(By.xpath("//span[contains(text(),'Языки программирования')]"));
        if(!pl.isSelected()){
            pl.click();
        }
        Thread.sleep(10000);
        List<WebElement> bookList = driver.findElements(By.xpath("//button[@data-test-id='tile-buy-button']"));
        Thread.sleep(10000);
        bookList.get(1).click();
//        List<WebElement> bookLisuuuuut = driver.findElements(By.xpath("//span[@data-test-id='tile-name']"));
//        Thread.sleep(1000);
//        System.out.println(bookLisuuuuut.get(1).getText());

    }
}
