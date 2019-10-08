package lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class App {
    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver",
                "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1000));
        driver.get("https://www.ozon.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.findElement(By.xpath("//button[@class='close']")).click();

        driver.findElement(By.xpath("//button[@value='Каталог']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Книги')]")));
        WebElement books = driver.findElement(By.xpath("//span[contains(text(), 'Книги')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(books).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Компьютерные технологии')]")));
        driver.findElement(By.xpath("//span[contains(text(), 'Компьютерные технологии')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Компьютерные технологии')]")));

        WebElement best = driver.findElement(By.xpath("//span[contains(text(),'Бестселлеры')]"));
        if (!best.isSelected()) {
            best.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/span[contains(text(),'Бестселлеры')]")));

        WebElement pl = driver.findElement(By.xpath("//span[contains(text(),'Языки программирования')]"));
        if (!pl.isSelected()) {
            pl.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/span[contains(text(),'Языки программирования')]")));

        List<WebElement> bookList = driver.findElements(By.xpath("//button[@data-test-id='tile-buy-button']"));
        bookList.get(4).click();
        if (bookList.get(4).isDisplayed()) {
            System.out.println("Книга добавлена в корзину");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tile-builder-action buy-button-container m-with-count m-default']")));

        driver.findElement(By.xpath("//a//*[contains(text(),'Корзина')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-item']")));
        List<WebElement> cartitem = driver.findElements(By.xpath("//div[@class='cart-item']"));
        if (!cartitem.isEmpty()) {
            System.out.println("Книга в корзине");
        }

    }
}
