package com.project.pages;

import com.project.abstracts.AbstractWebpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitleCatalogPom extends AbstractWebpage {

    //https://ta-bookrental-fe.onrender.com/
    public TitleCatalogPom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //<button class="show-copies-btn btn--small btn btn--primary">Show copies</button>
    @FindBy(className = "show-copies-btn")
    WebElement showCopiesButtonPom;

    //<button class="edit-btn btn--small btn btn--warning">Edit</button>
    @FindBy(className = "edit-btn")
    WebElement editTitleButtonPom;

    //<button class="remove-btn btn--small btn btn--error">Remove</button>
    @FindBy(className = "remove-btn")
    WebElement removeButtonPom;

    //<button class="btn btn--default" name="add-title-button" id="add-title-button">Add new</button>
    @FindBy(xpath = "//*[@id=\"add-title-button\"]")
    WebElement addNewButtonPom;

    //<input name="title" type="text" class="input-field__input">
    @FindBy(xpath = "//*[@id=\"titles\"]/div/div/form/div[1]/label/input")
    WebElement innerTitleInputPom;

    //<input name="author" type="text" class="input-field__input">
    @FindBy(xpath = "//*[@id=\"titles\"]/div/div/form/div[2]/label/input")
    WebElement innerAuthorInputPom;

    //<input name="year" type="number" class="input-field__input">
    @FindBy(xpath = "//*[@id=\"titles\"]/div/div/form/div[3]/label/input")
    WebElement innerYearInputPom;

    //<button class="btn btn--primary" name="submit-button">Edit title</button>
    @FindBy(xpath = "//*[@id=\"titles\"]/div/div/form/button")
    WebElement innerTitleButtonPom;

    //<button class="btn--small flex-grow--0 btn btn--default" name="return-button" id="return-button">&lt; Return</button>
    @FindBy(name = "return-button") WebElement returnButton;

    //<div class="alert alert--info"><p class="alert__content">No titles</p></div>
    @FindBy(className = "alert") WebElement titleAlert;

    WebDriverWait wait = new WebDriverWait(driver, 2);


    public void ShowCopies() {
        showCopiesButtonPom.click();
    }

    public void AddTitle(String title, String author, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
        addNewButtonPom.click();

        innerTitleInputPom.sendKeys(title);
        innerAuthorInputPom.sendKeys(author);
        innerYearInputPom.sendKeys(year);

        innerTitleButtonPom.click();
    }
    public void EditTitle(String title, String author, String year) {
        wait.until(ExpectedConditions.elementToBeClickable(editTitleButtonPom));
        editTitleButtonPom.click();

        innerTitleInputPom.clear();
        innerTitleInputPom.sendKeys(title);

        innerAuthorInputPom.clear();
        innerAuthorInputPom.sendKeys(author);

        innerYearInputPom.clear();
        innerYearInputPom.sendKeys(year);
        innerTitleButtonPom.click();
    }

    public String Alert() {
        return titleAlert.getText();
    }



    public void RemoveTitle() {
        removeButtonPom.click();
    }



}
