package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Page6SecurityQuestion extends Utility {


    public Page6SecurityQuestion() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//select[@id='input_11_field_1']")
    WebElement questionDropDown;

    @FindBy (id = "input_11_field_2")
    WebElement answerField;

    @FindBy (xpath = "//button[@class='jfInput-button forSubmit form-submit-button u-right']")
    WebElement submitButton;

    public void selectFromDropDown(String question){
        Reporter.log("Selecting from question dropdown : " + question + "<br>");
        pmSelectByVisibleTextFromDropDown(questionDropDown, question );
    }

    public void enterSecurityAnswer(String answer){
        Reporter.log("Entering the security answer : " + answer + "<br>");
        pmSendTextToElement(answerField, answer);
    }

    public void clickOnSubmitButton(){
        Reporter.log("Click on the Submit button : " + submitButton.toString() + "<br>");
        pmClickOnElement(submitButton);
    }


}
