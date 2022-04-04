import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://market.yandex.ru/");
        Thread.sleep(3000);
        //Assert.assertTrue(driver.findElement(By.xpath("//a[span=\"Войти\"]"))).isDisplayed();






    }
}
