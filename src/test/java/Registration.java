import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration extends Data{

    private By btnLogIn = By.xpath("//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By btnJoinFree = By.xpath("//a[text()='Join']");
    private By inputFirstName = By.xpath("//div[contains(@class,'form-group')]//input[@id='user_first_name']");
    private By inputLastName = By.xpath("//input[@class='form-control']");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@name='user[email]']");
    private By inputUsername = By.xpath("//div[@class='form-group'][2]//input[@class='form-control js-validate-field-on-blur']");
    private By inputPassword = By.xpath("//div[@class='form-group'][3]//input[@class='form-control js-validate-field-on-blur']");
    private By btnJoin = By.xpath("//a[@class='btn btn-default btn-block-level js-fake-join-form-submit-button']");

    @Test
    public void registration() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get(Data.getUrl);
        driver.manage().window().maximize();
        driver.findElement(btnLogIn).click();
        driver.findElement(btnJoinFree).click();
        driver.findElement(inputFirstName).sendKeys(Data.firstName);
        driver.findElement(inputLastName).sendKeys(Data.lastName);
        driver.findElement(inputEmail).sendKeys(Data.email);
        driver.findElement(inputUsername).sendKeys(Data.username);
        driver.findElement(inputPassword).sendKeys(Data.password);
        //driver.findElement(btnJoin).click();
    }

}