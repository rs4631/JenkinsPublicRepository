package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePage {

    public FacebookHomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "email") WebElement emailBox;

    @FindBy(id = "pass") WebElement passwordBox;

    @FindBy(name = "login") WebElement loginButton;

    public void enterEmail(String emailId) {
        emailBox.sendKeys(emailId);
    }

    public void enterPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }




}
