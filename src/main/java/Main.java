import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Selene Perez\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        closePopAlert(driver);
        submitForm1(driver);
        submitForm2(driver);
        waitAlertBanner(driver);
        assertEquals("Hola Mundo!", getAlertBannerText(driver));
    }

    private static void closePopAlert(WebDriver driver) {
        driver.findElement(By.id("at-cv-lightbox-close")).click();
    }
    private static void submitForm1(WebDriver driver) {

        driver.findElement(By.id("user-message")).sendKeys("Hola Mundo!");
        driver.findElement(By.xpath("//*[@id='get-input']/button")).click();
    }

    private static void submitForm2(WebDriver driver) {

        driver.findElement(By.id("sum1")).sendKeys("50");
        driver.findElement(By.id("sum2")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();
    }

    public static void waitAlertBanner(WebDriver driver)
    {
        WebDriverWait wait= new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("display")));

    }

    public static String getAlertBannerText(WebDriver driver)
    {
        return driver.findElement(By.id("display")).getText();
    }
}
