import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();

        //TODO First Name
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Abdullah");

        //TODO Last Name
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Ali");

        //TODO JobTitle
        WebElement JobTitle = driver.findElement(By.id("job-title"));
        JobTitle.sendKeys("QA Software Tester");

        //TODO Education
        WebElement Education = driver.findElement(By.id("radio-button-1"));
        Education.click();

        //TODO Sex
        WebElement Male = driver.findElement(By.id("checkbox-1"));
        Male.click();

        //TODO Experience
        driver.findElement(By.cssSelector("option[value='2']")).click();

        //TODO Date
        driver.findElement(By.id("datepicker")).sendKeys("05/05/2024");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        //TODO Submit
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));

        String alertText = alert.getText();
        assertEquals("The form was successfully submitted!", alertText);
        driver.quit();
    }
}
