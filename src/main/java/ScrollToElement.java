import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/scroll");
        driver.manage().window().maximize();

        WebElement name = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver); // take driver as a parameter
        actions.moveToElement(name);
        name.sendKeys("Abdullah");

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("04/05/2024");

        driver.quit();
    }
}
