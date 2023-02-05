
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductsTest {
     public static String baseUrl = "http://saucedemo.com";
      public static WebDriver driver;
      
    public AddProductsTest() {
    System.setProperty("webdriver.gecko.driver","C:\\Users\\Korisnik\\Desktop\\geckodriver-v0.30.0-win64\\geckodriver.exe");
    
    }

    @Test
    public void AddProductsTest() throws InterruptedException{
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        String username= "standard_user";
        String password= "secret_sauce";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        String str = driver.findElement(By.cssSelector("span[class='shopping_cart_badge']")).getText();
             try{
                 Assert.assertTrue(str.equals("2"));
                 System.out.println("PASS");
             } catch(Throwable e){
                 System.out.println("FAIL");
             }
        
        driver.quit();
        
        
   
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}