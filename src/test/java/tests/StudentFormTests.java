package tests;

import manager.HelperStudent;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentFormTests extends TestBase implements HelperStudent {
    @BeforeClass
    public void goToPracticeForm(){
        selectPracticeForm();
    }


    @Test
    public void registrationStudentPositiveTest(){
        //WebElement element = driver.findElement(By.xpath("#outbrain_widget_0"));
        StudentDTO student = new StudentDTO("Frodo", "Baggins","frodobaggins@mail.com", "Male",
                "1234567890",
                "10 Sep 2020","Math","Sports","J.Washington street","NCR","Delphi");
        fillStudentForm();

    }


}
