import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPagePOM {

    public static void submitForm(WebDriver driver) {
        //TODO First Name
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Abdullah");

        //TODO Last Name
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Ali");

        //TODO JobTitle
        WebElement JobTitle = driver.findElement(By.id("job-title"));
        JobTitle.sendKeys("Sr Software Tester");

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

    }
}
