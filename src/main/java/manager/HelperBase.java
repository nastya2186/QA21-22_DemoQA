package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppManager{

    default void clickBase(By locator){
        driver.findElement(locator).click();

    }

    default void pause(int time){
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    default void type(By locator, String text){
        WebElement element = driver.findElement(locator);
        clickBase(locator);
        element.clear();
        element.sendKeys(text);
    }
}
