package com.project.abstracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractWebpage {

    protected final WebDriver driver;

    public AbstractWebpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
