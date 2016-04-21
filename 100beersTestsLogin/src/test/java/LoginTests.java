import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Crash on 19.4.2016 г..
 */
public class LoginTests {

    private WebDriver driver;

    @Before
    public void  setUp(){
        driver = new  FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://100beers.bg/index.php?route=account/login");

    }

    @Test
    public void loginTest1(){

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("rjcrash@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("100beers");

        WebElement loginButton  = driver.findElement(By.xpath("//input[@value='Влез']"));
        loginButton.click();

        String userName = driver.findElement(By.xpath("//*[@id='header']/div[1]/div/a[1]")).getText();

        Assert.assertEquals("Rj", userName);

    }


    @Test
    public void loginTest2(){

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("rjcrash@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("100beers");

        WebElement loginButton  = driver.findElement(By.xpath("//input[@value='Влез']"));
        loginButton.click();



        WebElement logout  = driver.findElement(By.xpath("//*[@id='header']/div[1]/div/a[2]"));
        logout.click();

        String textLogout = driver.findElement(By.xpath("//*[@id='content']/p[1]")).getText();

        Assert.assertEquals("Излязохте успешно от профила си.", textLogout);

    }

    @Test
    public void loginTest10()  {

        WebElement forgottenPassword  = driver.findElement(By.linkText("Забравена парола"));
        forgottenPassword.click();

        WebElement emailForgottenPassword  = driver.findElement(By.linkText("Забравена парола"));
        emailForgottenPassword.click();

        WebElement forgottenEmail = driver.findElement(By.name("email"));
        forgottenEmail.sendKeys("rjcrash@abv.bg");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Продължи']"));
        continueButton.click();

        driver.get("http://www.abv.bg/");

        WebElement mailName  = driver.findElement(By.name("username"));
        mailName.sendKeys("rjcrash@abv.bg");

        WebElement mailPassword  = driver.findElement(By.name("password"));
        mailPassword.sendKeys("");

        WebElement mailLoginButton  = driver.findElement(By.name("loginBut"));
        mailLoginButton.click();


        WebElement mailBox  = driver.findElement(By.xpath("//tr[1][@__gwt_row='0']"));
        mailBox.click();


        WebElement firstLetter  = driver.findElement(By.xpath("//*[@id='inboxTable']/tbody[1]/tr[1]/td[2]/div"));
        firstLetter.click();

        String textFromMail = driver.findElement(By.xpath("//div[@class='abv-omExternalClass']")).getText();
        //System.out.println(textFromMail);

        String pass = textFromMail.substring(textFromMail.length() - 10);
        //System.out.println(pass);

        driver.get("http://100beers.bg/index.php?route=account/login");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("rjcrash@abv.bg");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(pass);

        WebElement loginButton  = driver.findElement(By.xpath("//input[@value='Влез']"));
        loginButton.click();

        String userName = driver.findElement(By.xpath("//*[@id='header']/div[1]/div/a[1]")).getText();

        Assert.assertEquals("rj", userName);
    }

    @After
    public void tearDown (){
        //driver.close();
    }
}
