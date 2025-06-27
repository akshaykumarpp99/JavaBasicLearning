package AutomationPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class WebTableHandling {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        WebElement element = wait.until(ExpectedCondition.visibilityOfElementLocated(By.xpath("//*[contains(@class,'submit')]"));

        String URL="https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
        driver.get(URL);
        WebElement table = driver.findElement(By.xpath("//*[@id='customers']"));
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//        for(WebElement row: rows){
//            System.out.println(row.getText());
//        }
        highlightElement(driver, table);
        Thread.sleep(5000);
        driver.close();
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Change the background and border styles to highlight
        String script = "arguments[0].style.border='3px solid red'; " +
                "arguments[0].style.backgroundColor='yellow';";
        js.executeScript(script, element);
    }
}
