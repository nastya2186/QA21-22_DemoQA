package manager;

import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface HelperStudent extends HelperBase{
    //By buttonElements = By.xpath("//div[@class='card mt-4 top-card']");
    By buttonForms = By.xpath("(//div[@class='card mt-4 top-card'])[2]");
    By buttonPracticeForm = By.xpath("//span[text()='Practice Form']");
    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.id("userEmail");
    By fieldMobile = By.id("userNumber");
    By fieldBDay = By.id("dateOfBirthInput");
    By fieldSubject = By.id("subjectsInput");

    By checkBoxSport = By.xpath("//label[@for='hobbies-checkbox-1']");
    By checkBoxReading = By.xpath("//label[@for='hobbies-checkbox-2']");
    By checkBoxMusic = By.xpath("//label[@for='hobbies-checkbox-3']");



    default void selectPracticeForm(){
        //clickBase(buttonElements);
        //pause(3);
        clickBase(buttonForms);
        hideFooter();
        pause(3);
        clickBase(buttonPracticeForm);
    }

  default void fillStudentForm(StudentDTO student) {
        type(fieldFirstName, student.getFirstName());
        type(fieldLastName, student.getLastName());
        type(fieldEmail, student.getEmail());
        selectGender(student.getGender());
        type(fieldMobile,student.getMobile());
        //type(fieldBDay,student.getDateOfBirth());
      typeBDayByKeys(fieldBDay,student.getDateOfBirth());
      addSubject(fieldSubject,student.getSubjects());
      selectHobby(student.getHobbies());

    }

    default void selectHobby(String hobbies){
        switch (hobbies){
            case "Sports":
                clickBase(checkBoxSport);
                break;
            case "Reading":
                clickBase(checkBoxReading);
                break;
            case "Music":
                clickBase(checkBoxMusic);
                break;
        }
    }

    default void addSubject(By fieldSubject, String subjects){
        String [] splitArray = subjects.split(",");
        clickBase(fieldSubject);
        for (String subject : splitArray){
            driver.findElement(fieldSubject).sendKeys(subject);
            driver.findElement(fieldSubject).sendKeys(Keys.ENTER);

        }

    }

    default void typeBDayByKeys(By fieldBDay, String dateOfBirth){
       WebElement element = driver.findElement(fieldBDay);
       element.click();
       String operationSystem = System.clearProperty("os.name");
       System.out.println("OS-->"+operationSystem);
       if(operationSystem.startsWith("Win")){
           element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
       }else{
           element.sendKeys(Keys.chord(Keys.COMMAND,"a"));
       }
       element.sendKeys(dateOfBirth);
       element.sendKeys(Keys.ENTER);
   }

    default void selectGender(String gender){
        if (gender.equals("Male")){
            clickBase(By.xpath("//label[@for='gender-radio-1']"));
        }else if(gender.equals("Female")){
            clickBase(By.xpath("//label[@for='gender-radio-2']"));
        }else{
            clickBase(By.xpath("//label[@for='gender-radio-3']"));
        }
    }


}
