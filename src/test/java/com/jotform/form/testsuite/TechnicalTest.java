package com.jotform.form.testsuite;
import com.jotform.form.pages.*;
import com.jotform.form.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.*;


public class TechnicalTest extends TestBase {

    Page1HomePage page1HomePage;
    Page2TestForm page2TestForm ;
    Page3BrowseAndDropFiles page3BrowseAndDropFiles;
    Page4SignaturePage page4SignaturePage ;
    Page5DatePage page5DatePage ;
    Page6SecurityQuestion page6SecurityQuestion;
    Page7FinalPage page7FinalPage;

    @BeforeMethod
    public void init(){
        page1HomePage = new Page1HomePage();
        page2TestForm = new Page2TestForm();
        page3BrowseAndDropFiles = new Page3BrowseAndDropFiles();
        page4SignaturePage = new Page4SignaturePage();
        page5DatePage = new Page5DatePage();
        page6SecurityQuestion = new Page6SecurityQuestion();
        page7FinalPage = new Page7FinalPage();
    }

    @Test
    @Parameters({"firstName", "lastName", "securityQuestion", "securityAnswer", "expectedMessage"})
    public void technicalTest(String fn, String ln, String sq, String sa, String em) throws AWTException, InterruptedException {
        //click on the next button of the home page to navigate to test form page
        page1HomePage.clickOnNextButton();
        //Enter firstname in the firstname field
        page2TestForm.enterFirstNameInTheFirstNameField(fn);
        //Enter last name in the last name field
        page2TestForm.enterLastNameInTheLastNameField(ln);
        //Click on the next button
        page2TestForm.clickOnNextButtonOnTestFormPage();
        //attach file
        page3BrowseAndDropFiles.uploadFile("C:\\Users\\Kinjal\\Desktop\\TestDoc.docx");
        //create a signature
        page4SignaturePage.createSignature();
        //click on next Button
        page4SignaturePage.clickOnNextButton();
        //enter the date
        page5DatePage.selectDate();
        //click on the next button
        page5DatePage.clickOnNext();
        //select the security question
        page6SecurityQuestion.selectFromDropDown(sq);
        //answer the question
        page6SecurityQuestion.enterSecurityAnswer(sa);
        //click on submit button
        page6SecurityQuestion.clickOnSubmitButton();
        //verify that the submission has been received
        page7FinalPage.verifyThatSubmissionHasBeenReceived(em);
    }
}
