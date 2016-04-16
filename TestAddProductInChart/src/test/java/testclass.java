/**
 * Created by Lili on 4/15/2016.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//import static org.junit.Assert.*;

public class testclass {

    private WebDriver selenium;
    private Scanner Console;

    @Before
    public void setUp() {
        selenium = new FirefoxDriver();
        Console = new Scanner(System.in);
        selenium.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        selenium.manage().window().maximize();
    }

    @Test
    public void TestLoginExpectedScenario() {

        selenium.get("http://100beers.bg");

        WebElement byColor =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/ul/li[5]/a"));
        Actions action = new Actions(selenium);
        action.moveToElement(byColor).build().perform();

        WebElement light =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/ul/li[5]/div/ul/li[1]/a"));
        light.click();

        WebElement openBeer =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[1]/a"));
        openBeer.click();

        WebElement chart =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[3]/div[1]/input"));
        chart.click();

        //try {

            WebElement chartCount =
                    selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a/span"));
           // Thread.sleep(400L);
       // } catch (InterruptedException e) {
      //      e.printStackTrace();
     //   }

        //String checkChart = chartCount.getText();
       // AssertEquals(checkChart, chartCount);
       // boolean isAddToChart =
       // selenium.manage().wait(200000l);

      //  assertEquals(
       //         "https://softuni.bg/account/authenticate",
       //         selenium.getCurrentUrl()
     //   );

//        WebElement usernameField =
//                selenium.findElement(
//                        By.id("LoginUserName")
//                );
//
//        WebElement passwordField =
//                selenium.findElement(
//                        By.id("LoginPassword")
//                );
//
//        usernameField.clear();
//
//        //String usernameInput = Console.nextLine(); // pesho
//        //usernameField.sendKeys(validUsername);
//
//        passwordField.clear();
//
//        //String passwordInput = Console.nextLine(); // parolatanapesho
//     //   passwordField.sendKeys(validPassword);
//
//        WebElement loginButton =
//                selenium.findElement(
//                        By.xpath("//input[@value='????']")
//                );
//
//        loginButton.click();
//
//        assertEquals(
//                "https://softuni.bg/users/profile/show",
//                selenium.getCurrentUrl()
//        );
//
//        WebElement dropDownUserName =
//                selenium.findElement(
//                        By.xpath("/html/body/header/div/div/div/div/nav/div/div[2]/form/ul/li[2]/a")
//                );
//
//       // assertEquals(
//             //   validUsername.toUpperCase(),
//        //        dropDownUserName.getText().trim()
//       // );

    }


    @After
    public void tearDown() {

        selenium.quit();
    }

}

