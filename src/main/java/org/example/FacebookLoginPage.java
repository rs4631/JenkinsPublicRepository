package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

    public FacebookLoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "_9ay7") WebElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
