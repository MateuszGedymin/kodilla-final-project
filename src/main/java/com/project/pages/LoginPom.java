package com.project.pages;

import com.project.abstracts.AbstractWebpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends AbstractWebpage {


    //https://ta-bookrental-fe.onrender.com/login
    public LoginPom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //<input id="login" name="login" type="text" class="input-field__input">
    @FindBy(xpath = "//*[@id=\"login\"]") WebElement loginInput;

    //<input id="password" name="password" type="password" class="input-field__input">
    @FindBy(xpath = "//*[@id=\"password\"]") WebElement passwordInput;

    //<button class="btn btn--primary" id="login-btn">Log in</button>
    @FindBy(xpath = "//*[@id=\"login-btn\"]") WebElement loginButton;
    //<h2 class="sub-title">Log in</h2>


    public void Login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
    }

    public void submit() {
        loginButton.click();
    }



}
