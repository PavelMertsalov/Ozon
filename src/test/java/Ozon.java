import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Ozon {
    private By Name = By.xpath("//input[@id='name']"); //Имя и фамилия
    private By Postomats = By.xpath("//input[@id='postamats']");
    private By Phone = By.xpath("//input[@id='phone']");
    private By Email = By.xpath("//input[@id='email']");
    private By City = By.xpath("//input[@class='prompt search-input']");
    private By Address = By.xpath("//input[@id='address']");
    private By Button = By.xpath("//button[@class='ozon-box-form__btn js-submit']");
    private By checkBox = By.xpath("//div[@class='ozon-box-form__checkbox--real']");
        //private final By FRFE =

    @Test
        public void ozonTest () throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ozon.ru/ozon-box/#ozonbox-form-place");
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='name']")).isDisplayed());                           //поля формы подписаны
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='postamats']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='phone']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='email']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(@class,'label--city')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for='address']")).isDisplayed());


        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[1]")).getText(),"Обязательно к заполнению");//Под всеми полями используется пояснение: “Обязательно к заполнению”
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[2]")).getText(),"Обязательно к заполнению");
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[3]")).getText(),"Обязательно к заполнению");
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[4]")).getText(),"Обязательно к заполнению");
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[5]")).getText(),"Обязательно к заполнению");
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[6]")).getText(),"Обязательно к заполнению");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ozon-box-form__btn-wrapper']//button[contains(@class,'ozon-box-form__btn js-submit')]")).isDisplayed()); //кнопка активна


        driver.findElement(By.xpath("//div[@class='ozon-box-form__btn-wrapper']//button[contains(@class,'ozon-box-form__btn js-submit')]")).click();

        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='name']")).isDisplayed()); //
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='postamats']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='phone']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='email']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[contains(@class,'label--city')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='address']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[3]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[4]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[5]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[6]")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'btn-wrapper--invalid')]//button[@class='ozon-box-form__btn js-submit']")).isDisplayed());

        driver.findElement(Name).sendKeys("Иван Иванов"); //корректно заполнены поля
        driver.findElement(Postomats).sendKeys("1");
        driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='phone']")).sendKeys("9999999999");
        driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='email']")).sendKeys("ИванИванов@yandex.ru");
        driver.findElement(City).sendKeys("к");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("у");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("р");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("с");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("к");
                Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='title'])[1]")).click();
        //driver.findElement(By.xpath("//div[contains(@class,'item--error')]//label[@for='address']")).sendKeys("Блинова");
        //driver.findElement(By.xpath("//div[@class='ozon-box-form__checkbox--real ozon-box-form__checkbox--real-invalid']")).click();

        //driver.navigate().refresh();                                                                                       //обновить страницу









        //Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ozon-box-form__title']")).getText(),
                //"Оставьте заявку,\n" + "и мы с вами свяжемся");
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@ccontains'ozon-box-form__title']")).getAttribute(),
               // "disabled");





    }
}
