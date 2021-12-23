package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Page7FinalPage extends Utility {


    public Page7FinalPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class='jfThankYou-description form-subHeader']")
    WebElement verificationText;

    public void verifyThatSubmissionHasBeenReceived(String expectedMessage){
        Reporter.log("Verifying the submission message: " + verificationText.toString() + "<br>");
        String actualMessage = pmGetTextFromElement(verificationText);
        pmVerifyElements(expectedMessage,actualMessage ,"Incorrect submission" );
    }
}
