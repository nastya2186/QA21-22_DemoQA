package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstStart {
    WebDriver driver;
    @Test
    public void firstStartTrello(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    public static class SccLocators {

        WebDriver driver;

        @Test
        public void textBox() {
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/text-box");
            WebElement inputFullName = driver.findElement(By.cssSelector("input[id='userName']"));
            System.out.println("--> "+inputFullName.getAttribute("placeholder"));
            WebElement currentAddress = driver.findElement(By.cssSelector("[placeholder = 'Current Address']"));
            System.out.println("-->" + currentAddress.getTagName());
            WebElement address = driver.findElement(By.cssSelector("#permanentAddress-label"));
            WebElement address1 = driver.findElement(By.id("permanentAddress-label"));
            System.out.println("-->"+ address.getText());


        }
        @Test
        public void chexBox() {
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/checkbox");
            WebElement svg = driver.findElement(By.cssSelector("span[class='rct-text']>label>span[class='rct-node-icon']>svg"));
            System.out.println("-->"+ svg.getAttribute("fill"));



        }
    }
}
