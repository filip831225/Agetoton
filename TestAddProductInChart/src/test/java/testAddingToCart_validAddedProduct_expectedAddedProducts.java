import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class testAddingToCart_validAddedProduct_expectedAddedProducts {

    private WebDriver selenium;
    private Scanner Console;
    private static final String NUMBER_OF_WISHED_BEERS = "3";

    @Before
    public void setUp() {
        selenium = new FirefoxDriver();
        Console = new Scanner(System.in);
        selenium.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        selenium.manage().window().maximize();

    }
    private void navigateToBeer (){
        selenium.get("http://100beers.bg");
        WebElement byColor =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/ul/li[5]/a"));
        Actions action = new Actions(selenium);
        action.moveToElement(byColor).build().perform();
        WebElement light =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[3]/ul/li[5]/div/ul/li[1]/a"));
        light.click();

    }

    @Test
   public void TestOnlyAddProduct(){
        navigateToBeer();
        WebElement onlyAddToCart =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[1]/div[4]/div[12]/div[5]"));
        onlyAddToCart.click();
        WebElement priceFor1BeerLV =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[1]/div[4]/div[12]/div[4]"));
        String priceString = priceFor1BeerLV.getText();
        String price1Beer = priceString.substring(0,priceString.length()-4);
        System.out.println(price1Beer);
        WebElement cartNumberProducts =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/a/span"));
        System.out.println(cartNumberProducts.getText());
        System.out.println("1 продукт(и) - "+price1Beer+" лв.");
      boolean ddd = cartNumberProducts.getText().contains(price1Beer);
       Assert.assertTrue(ddd);
   }
    @Test
    public void TestAddAndModifyCartExpectedScenario() {

        navigateToBeer();
        WebElement priceFor1BeerLV =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[4]"));
        String priceString = priceFor1BeerLV.getText();
      //  System.out.println(priceString);
        String price1Beer = priceString.substring(0,priceString.length()-4);
       // System.out.println(price1Beer);

        WebElement openBeer =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[1]/a"));
        openBeer.click();

        WebElement countOfProductsAddingField =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[3]/div[1]/div/input[1]"));
        countOfProductsAddingField.clear();

        try {
            Thread.sleep(1);

            countOfProductsAddingField.sendKeys("3");
            WebElement addingTochartButton =
                    selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[3]/div[1]/input"));
            addingTochartButton.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            WebElement cartNumberProducts =
                    selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a/span"));

        String checkCart = cartNumberProducts.getText();
        String[] currentCartInput = checkCart.split("[\\s]");
        String allProductsNumber = currentCartInput[0];
        String allProductPrice = currentCartInput[3];
        System.out.println(allProductPrice);
        System.out.println(allProductsNumber);
         Assert.assertEquals(
                 NUMBER_OF_WISHED_BEERS,
                 allProductsNumber
         );
        Assert.assertEquals(
                Double.parseDouble(price1Beer)* Double.parseDouble(NUMBER_OF_WISHED_BEERS),
                Double.parseDouble(allProductPrice),  0.001
        );
    }
    @Test
    public void TestAddStringCartScenario() {

        navigateToBeer();
        WebElement priceFor1BeerLV =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[4]"));
        String priceString = priceFor1BeerLV.getText();
        //  System.out.println(priceString);
        String price1Beer = priceString.substring(0,priceString.length()-4);
        // System.out.println(price1Beer);

        WebElement openBeer =
                selenium.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[1]/div[4]/div[2]/div[1]/a"));
        openBeer.click();

        WebElement countOfProductsAddingField =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[3]/div[1]/div/input[1]"));
        countOfProductsAddingField.clear();

        try {
            Thread.sleep(1);

            countOfProductsAddingField.sendKeys("fdgfdgd");
            WebElement addingTochartButton =
                    selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[3]/div[1]/input"));
            addingTochartButton.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cartNumberProducts =
                selenium.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a/span"));

        String checkCart = cartNumberProducts.getText();
        String[] currentCartInput = checkCart.split("[\\s]");
        String allProductsNumber = currentCartInput[0];
        String allProductPrice = currentCartInput[3];
        System.out.println(allProductPrice);
        System.out.println(allProductsNumber);
        Assert.assertEquals(
        "Wrong input",
                cartNumberProducts
        );
//        Assert.assertEquals(
//                Double.parseDouble(price1Beer)* Double.parseDouble(NUMBER_OF_WISHED_BEERS),
//                Double.parseDouble(allProductPrice),  0.001
//        );
    }

    @After
    public void tearDown() {

      selenium.quit();
    }

}

