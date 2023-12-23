package manager;

import models.StudentDTO;
import org.openqa.selenium.By;

public interface HelperStudent extends HelperBase{
    //By buttonElements = By.xpath("//div[@class='card mt-4 top-card']");
    By buttonForms = By.xpath("(//div[@class='card mt-4 top-card'])[2]");
    By buttonPracticeForm = By.xpath("//span[text()='Practice Form']");
    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.id("firstEmail");


    default void selectPracticeForm(){
        //clickBase(buttonElements);
        pause(3);
        clickBase(buttonForms);
        clickBase(buttonPracticeForm);
    }

    private void fillStudentForm(StudentDTO student) {
        type(fieldFirstName, student.getFirstName());
        type(fieldLastName, student.getLastName());
        type(fieldEmail, student.getEmail());
    }


}
