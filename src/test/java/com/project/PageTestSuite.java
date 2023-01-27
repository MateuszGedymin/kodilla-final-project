package com.project;

import com.project.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class PageTestSuite {

    WebDriver driver;
    LoginPom loginPom;
    TitleCatalogPom titleCatalogPom;
    CopiesListPom copiesListPom;
    RentsListPom rentsListPom;


    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\JavaProjects\\kodilla-final-project\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://ta-bookrental-fe.onrender.com/login");
        driver.manage().window().maximize();
        loginPom = new LoginPom(driver);
        loginPom.Login("test", "test");
        loginPom.submit();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    void titleFunctionality() {
        titleCatalogPom = new TitleCatalogPom(driver);
        titleCatalogPom.AddTitle("test", "test", "2000");
        titleCatalogPom.EditTitle("test1", "test1", "2001");
        titleCatalogPom.RemoveTitle();
        Assertions.assertEquals("No titles", titleCatalogPom.Alert());
    }

    @Nested
    class Copies {
        @Test
        void copiesListFunctionality() {
            titleCatalogPom = new TitleCatalogPom(driver);
            titleCatalogPom.AddTitle("test", "test", "2000");
            titleCatalogPom.ShowCopies();
            copiesListPom = new CopiesListPom(driver);
            copiesListPom.AddNewCopies("2020", "January", "1");
            copiesListPom.EditCopies("2021", "February", "2");
            copiesListPom.RemoveCopies();
            Assertions.assertEquals("No copies...", copiesListPom.Alert());
        }
        @AfterEach
        public void cleanUp() {
            copiesListPom.ReturnBtn();
            titleCatalogPom.RemoveTitle();
        }
    }

    @Nested
    class Rents {
        @Test
        void rentsListFunctionality() {
            titleCatalogPom = new TitleCatalogPom(driver);
            titleCatalogPom.AddTitle("test", "test", "2000");
            titleCatalogPom.ShowCopies();
            copiesListPom = new CopiesListPom(driver);
            copiesListPom.AddNewCopies("2020", "January", "01");
            copiesListPom.ShowHistory();
            rentsListPom = new RentsListPom(driver);
            rentsListPom.AddRent("test", "2020", "January", "1");
            rentsListPom.EditRent("test1", "2021", "February", "2", "2022", "March", "3");
            rentsListPom.RemoveRent();
            Assertions.assertEquals("No rents...", rentsListPom.Alert());
        }

        @AfterEach
        public void cleanUp() {
            rentsListPom.ReturnBtn();
            copiesListPom.RemoveCopies();
            copiesListPom.ReturnBtn();
            titleCatalogPom.RemoveTitle();
        }

    }

        @Test
        void loginWebPageWorks() {
            Assertions.assertEquals("https://ta-bookrental-fe.onrender.com/login", driver.getCurrentUrl());
        }

        @Test
        void registerWebPageWorks() {
            driver.get("https://ta-bookrental-fe.onrender.com/register");
            Assertions.assertEquals("https://ta-bookrental-fe.onrender.com/register", driver.getCurrentUrl());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

}
