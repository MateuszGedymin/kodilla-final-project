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

public class RentsListPom extends AbstractWebpage {
    //https://ta-bookrental-fe.onrender.com/rents/29

    public RentsListPom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //<button class="edit-btn btn--small btn btn--warning">Edit</button>
    @FindBy(className = "edit-btn")
    WebElement editBtn;

    //<button class="remove-btn btn--small btn btn--error">Remove</button>
    @FindBy(className = "remove-btn")
    WebElement removeBtn;

    //<button class="btn btn--default" name="add-rent-button" id="add-rent-button">Rent this copy</button>
    @FindBy(name = "add-rent-button")
    WebElement addRentBtn;

    //<input name="customer-name" type="text" class="input-field__input">
    @FindBy(name = "customer-name")
    WebElement customerName;

    //<button class="btn btn--primary" name="submit-button">Add copy</button>
    @FindBy(name = "submit-button")
    WebElement innerAddCopyBtn;

    //<span class="day__month_btn up">Feb 2020</span>
    @FindBy(className = "day__month_btn")
    WebElement datePickerDayMonthBtnUp;

    //expiration__date_btn
    @FindBy(xpath = "//*[@id=\"rents\"]/div[2]/div/form/div[3]/div/div/div[2]/header/span[2]")
    WebElement datePickerDayMonthExpirationBtn;

    @FindBy(xpath = "//*[@id=\"rents\"]/div[2]/div/form/div[3]/div/div/div[3]/header/span[2]")
    WebElement datePickerMonthYearExpirationBtn;

    //<span class="month__year_btn up">2020</span>
    @FindBy(className = "month__year_btn")
    WebElement datePickerMonthYearBtnUp;

    //<input type="text" name="rent-date" id="id" readonly="readonly" autocomplete="off">
    @FindBy(name = "rent-date")
    WebElement innerRateDateBtn;

    //<input type="text" name="expiration-date" id="id" readonly="readonly" autocomplete="off">
    @FindBy(name = "expiration-date")
    WebElement innerExpirationDateBtn;

    //<div class="alert alert--info"><p class="alert__content">No titles</p></div>
    @FindBy(className = "alert") WebElement rentsAlert;

    //<button class="btn--small flex-grow--0 btn btn--default" name="return-button" id="return-button">&lt; Return</button>
    @FindBy(name = "return-button") WebElement returnBtn;

    WebDriverWait wait = new WebDriverWait(driver, 2);

    public void AddRent(String customerName, String year, String month, String day) {


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(addRentBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(this.customerName)).sendKeys(customerName);
        wait.until(ExpectedConditions.elementToBeClickable(innerRateDateBtn)).click();
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
        wait.until(ExpectedConditions.elementToBeClickable(innerAddCopyBtn)).click();
    }

    public void EditRent(String customerName, String rentYear, String rentMonth, String rentDay, String expireYear, String expireMonth, String expireDay) {
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
        this.customerName.clear();
        wait.until(ExpectedConditions.elementToBeClickable(this.customerName)).sendKeys(customerName);
        wait.until(ExpectedConditions.elementToBeClickable(innerRateDateBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerDayMonthBtnUp)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerMonthYearBtnUp)).click();
        //We have to find those elements here, DOM hides them
        List<WebElement> yearList = driver.findElements(By.className("year"));
        //year pick
        yearList.stream()
                .filter(element -> element.getText().equals(rentYear))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> monthList = driver.findElements(By.className("month"));
        //month pick
        monthList.stream()
                .filter(element -> element.getText().equals(rentMonth))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> dayList = driver.findElements(By.className("day"));
        //pick day
        dayList.stream()
                .filter(element -> element.getText().equals(rentDay))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(innerExpirationDateBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerDayMonthExpirationBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePickerMonthYearExpirationBtn)).click();
        //We have to find those elements here, DOM hides them
        yearList = driver.findElements(By.className("year"));
        //year pick
        yearList.stream()
                .filter(element -> element.getText().equals(expireYear))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        monthList = driver.findElements(By.className("month"));
        //month pick
        monthList.stream()
                .filter(element -> element.getText().equals(expireMonth))
                .findFirst()
                .ifPresent(WebElement::click);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        dayList = driver.findElements(By.className("day"));
        //pick day
        dayList.stream()
                .filter(element -> element.getText().equals(expireDay))
                .findFirst()
                .ifPresent(WebElement::click);
        wait.until(ExpectedConditions.elementToBeClickable(innerAddCopyBtn)).click();
    }

    public void RemoveRent() {
    removeBtn.click();
    }

    public String Alert(){
        return rentsAlert.getText();
    }

    public void ReturnBtn() {
        returnBtn.click();
    }
}
