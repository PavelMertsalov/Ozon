import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {


    public static void main(String[] args) {
        String testString = "цуацуфа";
        WebDriver auto = new ChromeDriver();
        auto.get("https://yandex.ru/");
        WebElement searchField = auto.findElement(By.xpath("//input[@class='input__control input__input mini-suggest__input']"));
        searchField.sendKeys(testString);
        String test2 = searchField.getAttribute("value");
        System.out.println(test2);
      //auto.close();
    }}