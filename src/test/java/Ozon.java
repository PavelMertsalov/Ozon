import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private By NameError = By.xpath("//div[contains(@class,'item--error')]//input[@id='name']");
    private By PostomatsError = By.xpath("//div[contains(@class,'item--error')]//input[@id='postamats']");
    private By PhoneError = By.xpath("//div[contains(@class,'item--error')]//input[@id='phone']");
    private By EmailError = By.xpath("//div[contains(@class,'item--error')]//input[@id='email']");
    private By CityError = By.xpath("//div[contains(@class,'item--error')]//input[@class='prompt search-input']");
    private By AddressError = By.xpath("//div[contains(@class,'item--error')]//input[@id='address']");
    private By checkBoxError = By.xpath("//div[@class='ozon-box-form__checkbox--real ozon-box-form__checkbox--real-invalid']");
    private By ButtonError = By.xpath("//div[contains(@class,'btn-wrapper--invalid')]//button[@class='ozon-box-form__btn js-submit']");


    private final String NAME25LOWER = "йцукенгшщзйцукенгшщзйцуке";//нижний регистр 25 символов
    private final String NAME1 = "й";//нижний регистр 1 символ
    private final String NAME25UPPER = "ЙЦУКЕНГШЩЗФЫВАПРОЛДЖЯЧСМИ";//верхний регистр 25 символов
    private final String NAME25MIXED = "ЙЦУКЕНГШЩЗфывапролджЯЧСМИ";//смешанный регистр 25 символов
    private final String NAME26 = "йцукенгшщзйцукенгшщзйцукей";//длинна больше максимальной
    private final String SPECSYMBOLS = "@#$%^&;.?,>|\\/№\"!()_{}[<~";//специальные символы
    private final String NUMBERS = "1234567890123456789012345";//только цифры
    private final int NUMBER1 = 1;//1 цыфра
    private final double SCORE = 1.5;//дробное число

    //Тест телефона

    private final String PHONENUMBERMIN = "1234567891";//10 цифр1
    private final String PHONENUMBERMAX = "12345678910";//11 цифр


    //private final long NUMBER18 = 922337203685477580L;


    //private final char group = 'Z';


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


        //Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[1]")).getText(),"Обязательно к заполнению");//Под всеми полями используется пояснение: “Обязательно к заполнению”
        //Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[2]")).getText(),"Обязательно к заполнению");
        //Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[3]")).getText(),"Обязательно к заполнению");
        //Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[4]")).getText(),"Обязательно к заполнению");
        //Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[5]")).getText(),"Обязательно к заполнению");
        //Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])[6]")).getText(),"Обязательно к заполнению");

        for(int i = 1; i < 7; i++){
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='ozon-box-form__validation-text'])" +        //Под всеми полями используется пояснение: “Обязательно к заполнению”
                    "[" + i + "]")).getText(),"Обязательно к заполнению");
        }

        Assert.assertTrue(driver.findElement(Button).isDisplayed());                                                    //кнопка активна

        Assert.assertTrue(driver.findElement(checkBox).isDisplayed());                                                  //чекбокс выключен

        driver.findElement(Button).click();                                                                             //клик по "Отправить заявку"

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(NameError).isDisplayed());                                                 //Подсветился контур всех полей
        Assert.assertTrue(driver.findElement(PostomatsError).isDisplayed());
        Assert.assertTrue(driver.findElement(PhoneError).isDisplayed());
        Assert.assertTrue(driver.findElement(EmailError).isDisplayed());
        Assert.assertTrue(driver.findElement(CityError).isDisplayed());
        Assert.assertTrue(driver.findElement(AddressError).isDisplayed());

        //Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[1]")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[2]")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[3]")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[4]")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[5]")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class='ozon-box-form__validation-text'])[6]")).isDisplayed());

        for(int i = 1; i < 7; i++){
            Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class=" +     //Подсветились пояснения “Обязательно к заполнению”
                    "'ozon-box-form__validation-text'])[" + i + "]")).getText(),"Обязательно к заполнению");
        }

        Assert.assertTrue(driver.findElement(checkBoxError).isDisplayed());                                             //Подсветился контур чекбокса

        Assert.assertTrue(driver.findElement(ButtonError).isDisplayed());                                               //Не активна кнопка “Отправить заявку”

        driver.findElement(Name).sendKeys("Иван Иванов");                                                  //корректно заполнены поля
        driver.findElement(Postomats).sendKeys("1");
        driver.findElement(Phone).sendKeys("9999999999");
        driver.findElement(Email).sendKeys("ИванИванов@yandex.ru");
        driver.findElement(City).sendKeys("к");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("у");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("р");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("с");
        Thread.sleep(500);
        driver.findElement(City).sendKeys("к");

        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='title'])[1]")));               // ОЖИДАНИЕ!!!

        //WebDriverWait wait = new WebDriverWait(driver, 1000);
        //wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));

        driver.findElement(By.xpath("(//div[@class='title'])[1]")).click();
        driver.findElement(Address).sendKeys("Блинова");
        driver.findElement(By.xpath("//div[@class='ozon-box-form__checkbox--real " +                                    //клик по чек-боксу
                "ozon-box-form__checkbox--real-invalid']")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();                                                                                    //обновить страницу

        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(Name).isDisplayed());                                                      // Произошла очистка введённой информации
        Assert.assertTrue(driver.findElement(Postomats).isDisplayed());
        Assert.assertTrue(driver.findElement(Phone).isDisplayed());
        Assert.assertTrue(driver.findElement(Email).isDisplayed());
        Assert.assertTrue(driver.findElement(City).isDisplayed());
        Assert.assertTrue(driver.findElement(Address).isDisplayed());
        Assert.assertTrue(driver.findElement(checkBox).isDisplayed());                                                  //Чекбокс выключен

        driver.findElement(checkBox).click();                                                                           //Включить чекбокс
        driver.findElement(Button).click();                                                                             //Нажать кнопку “Отправить заявку”

        Assert.assertTrue(driver.findElement(NameError).isDisplayed());                                                 //Подсветился контур всех полей
        Assert.assertTrue(driver.findElement(PostomatsError).isDisplayed());
        Assert.assertTrue(driver.findElement(PhoneError).isDisplayed());
        Assert.assertTrue(driver.findElement(EmailError).isDisplayed());
        Assert.assertTrue(driver.findElement(CityError).isDisplayed());
        Assert.assertTrue(driver.findElement(AddressError).isDisplayed());

        for(int i = 1; i < 7; i++){
            Assert.assertEquals(driver.findElement(By.xpath("(//div[contains(@class,'item--error')]//div[@class=" +     //Подсветились пояснения “Обязательно к заполнению”
                    "'ozon-box-form__validation-text'])[" + i + "]")).getText(),"Обязательно к заполнению");
        }

        Assert.assertTrue(driver.findElement(checkBox).isDisplayed());                                                  //чекбокс включен
        Assert.assertTrue(driver.findElement(ButtonError).isDisplayed());                                               //кнопка не активна

        Actions actions = new Actions(driver);

        //driver.findElement(Name).sendKeys(NAME32);                                                                      //Заполнить все доступные поля 1 символом латиницы
        //driver.findElement(Postomats).sendKeys(SCORE + "");                                                //Заполнить поле постомат 1.5
        driver.findElement(Postomats).sendKeys(NUMBERS + "");
        //driver.findElement(Phone).sendKeys("цуацуфа");
        //driver.findElement(Email).sendKeys("цуацуфа");
        //driver.findElement(City).sendKeys("цуацуфа");
        //driver.findElement(Address).sendKeys("цуацуфа");

        //WebElement nameInput = driver.findElement(Name);
        //String nameInputActual = nameInput.getAttribute("value");
        //Assert.assertEquals(NAME32,nameInputActual);
        //System.out.println(nameInputActual);

        //WebElement postomatsInput = driver.findElement(Postomats);                                                      //нашли веб элемент по локатору
        //String postomatsInputActual = postomatsInput.getAttribute("value");                                          //получили текст из строки
        //Assert.assertEquals("15",postomatsInputActual);                                                              //сравнение ожидаемого и реального значения
        //System.out.println(postomatsInputActual);

        WebElement postomatsInputnumbers = driver.findElement(Postomats);                                                      //нашли веб элемент по локатору
        String postomatsInputActualnumbers = postomatsInputnumbers.getAttribute("value");                                          //получили текст из строки
        Assert.assertEquals("123",postomatsInputActualnumbers);                                                              //сравнение ожидаемого и реального значения
        System.out.println(postomatsInputActualnumbers);

        driver.findElement(By.xpath("(//img[@class='ozon-box-form__cross'])[2]")).click();

        driver.findElement(Postomats).sendKeys(NUMBER1 + "");

        WebElement postomatsInput1 = driver.findElement(Postomats);                                                      //нашли веб элемент по локатору
        String postomatsInputActual1 = postomatsInput1.getAttribute("value");                                          //получили текст из строки
        Assert.assertEquals("1",postomatsInputActual1);                                                              //сравнение ожидаемого и реального значения
        System.out.println(postomatsInputActual1);

        driver.findElement(By.xpath("(//img[@class='ozon-box-form__cross'])[2]")).click();

        driver.findElement(Postomats).sendKeys(NAME25LOWER + "");

        WebElement postomatsInputsymbols25 = driver.findElement(Postomats);
        String postomatsInputActualsymbols25 = postomatsInputsymbols25.getAttribute("value");
        Assert.assertTrue(postomatsInputActualsymbols25.isEmpty()));                                                    //проверка на пустую строку
        System.out.println(postomatsInputActualsymbols25);

























        //Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ozon-box-form__title']")).getText(),
                //"Оставьте заявку,\n" + "и мы с вами свяжемся");
        //Assert.assertEquals(driver.findElement(By.xpath("//div[@ccontains'ozon-box-form__title']")).getAttribute(),
               // "disabled");





    }
}
