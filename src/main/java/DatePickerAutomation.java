import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://formy-project.herokuapp.com/datepicker");
            driver.manage().window().maximize();

            // Open the date picker
            WebElement dateField = driver.findElement(By.id("datepicker"));
            dateField.click();
            Thread.sleep(2000);

            // Navigate to the correct month and year
            String targetMonthYear = "August 2024";
            String targetDay = "5";

            while (true) {
                WebElement datePickerMonthYear = driver.findElement(By.className("datepicker-switch"));
                String currentMonthYear = datePickerMonthYear.getText();

                if (currentMonthYear.equals(targetMonthYear)) {
                    break;
                }

                WebElement nextButton = driver.findElement(By.className("next"));
                nextButton.click();
            }

            // Select the specific date
            WebElement dayElement = driver.findElement(By.xpath("//td[@class='day' and text()='" + targetDay + "']"));
            dayElement.click();
            Thread.sleep(2000);

            // Verify the selected date
            String selectedDate = dateField.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
