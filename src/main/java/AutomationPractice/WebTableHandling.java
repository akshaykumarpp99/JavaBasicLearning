package AutomationPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebTableHandling {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        String URL="https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
        driver.get(URL);
        WebElement table = driver.findElement(By.xpath("//*[@id='customers']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement row: rows){
            System.out.println(row.getText());
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
        }
    }
}
