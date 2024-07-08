
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FormPageTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();

        //TODO FormPagePOM
        FormPagePOM.submitForm(driver);

        //TODO ConfirmationPagePOM
        ConfirmationPagePOM.WaitForAlertBanner(driver);
        ConfirmationPagePOM.getAlertBannerText(driver);

        //TODO assertion
        assertEquals("The form was successfully submitted!", ConfirmationPagePOM.getAlertBannerText(driver));

        //TODO quit
        driver.quit();
    }
}
