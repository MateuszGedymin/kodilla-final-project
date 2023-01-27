package com.project.pages;

import com.project.abstracts.AbstractWebpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CopiesListPom extends AbstractWebpage {


    //https://ta-bookrental-fe.onrender.com/items/27
    public CopiesListPom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //<button class="show-rents-btn btn--small btn btn--primary">Show history</button>
    @FindBy(className = "show-rents-btn")
    WebElement showHistoryButtonPom;

    //<button class="edit-btn btn--small btn btn--warning">Edit</button>
    @FindBy(className = "edit-btn")
    WebElement editCopiesButtonPom;

    //<button class="remove-btn btn--small btn btn--error">Remove</button>
    @FindBy(className = "remove-btn")
    WebElement removeCopiesButtonPom;

    //<button class="btn btn--default" name="add-item-button" id="add-item-button">Add new</button>
    @FindBy(name = "add-item-button")
    WebElement addNewCopiesButtonPom;

    //<button class="btn btn--primary" name="submit-button">Add copy</button>
    @FindBy(name = "submit-button")
    WebElement innerAddBtn;

    //<input type="text" name="purchase-date" id="id" readonly="readonly" autocomplete="off">
    @FindBy(name = "purchase-date")
    WebElement innerDateInput;

    //<span class="day__month_btn up">Feb 2020</span>
    @FindBy(className = "day__month_btn")
    WebElement datePickerDayMonthBtnUp;

    //<span class="month__year_btn up">2020</span>
    @FindBy(className = "month__year_btn")
    WebElement datePickerMonthYearBtnUp;

    //<div class="alert alert--info"><p class="alert__content">No titles</p></div>
    @FindBy(className = "alert") WebElement copiesAlert;

    //<button class="btn--small flex-grow--0 btn btn--default" name="return-button" id="return-button">&lt; Return</button>
    @FindBy(name = "return-button") WebElement returnBtn;

    WebDriverWait wait = new WebDriverWait(driver, 2);


    public void ShowHistory() {
        showHistoryButtonPom.click();
    }

    public void AddNewCopies(String year, String month, String day) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(addNewCopiesButtonPom)).click();
        wait.until(ExpectedConditions.elementToBeClickable(innerDateInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerDayMonthBtnUp)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerMonthYearBtnUp)).click();

        //We have to find those elements here, DOM hides them
        List<WebElement> yearList = driver.findElements(By.className("year"));
        //year pick
        yearList.stream()
                .filter(element -> element.getText().equals(year))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> monthList = driver.findElements(By.className("month"));
        //month pick
        monthList.stream()
                .filter(element -> element.getText().equals(month))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> dayList = driver.findElements(By.className("day"));
        //pick day
        dayList.stream()
                .filter(element -> element.getText().equals(day))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        innerAddBtn.click();
    }

    public void EditCopies(String year, String month, String day) {
        wait.until(ExpectedConditions.elementToBeClickable(editCopiesButtonPom)).click();
        wait.until(ExpectedConditions.elementToBeClickable(innerDateInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerDayMonthBtnUp)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerMonthYearBtnUp)).click();

        //We have to find those elements here, DOM hides them
        List<WebElement> yearList = driver.findElements(By.className("year"));
        //year pick
        yearList.stream()
                .filter(element -> element.getText().equals(year))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> monthList = driver.findElements(By.className("month"));
        //month pick
        monthList.stream()
                .filter(element -> element.getText().equals(month))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> dayList = driver.findElements(By.className("day"));
        //pick day
        dayList.stream()
                .filter(element -> element.getText().equals(day))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        innerAddBtn.click();
    }

    public void RemoveCopies() {
        removeCopiesButtonPom.click();
    }

    public String Alert(){
        return copiesAlert.getText();
    }

    public void ReturnBtn() {
        returnBtn.click();
    }
}
