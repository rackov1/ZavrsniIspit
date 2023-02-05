
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

public class FinishingOrder {
     public static String baseUrl = "http://saucedemo.com";
      public static WebDriver driver;
      
    public FinishingOrder() {
    System.setProperty("webdriver.gecko.driver","C:\\Users\\Korisnik\\Desktop\\geckodriver-v0.30.0-win64\\geckodriver.exe");
    
    }

    @Test
    public void FinishingOrder() throws InterruptedException{
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String username= "standard_user";
        String password= "secret_sauce";
        String firstName= "Daliborka";
        String lastName= "Rackov";
        String zip = "11000";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.cssSelector("span[class='shopping_cart_badge']")).click();
        driver.findElement(By.cssSelector("button[class='btn btn_action btn_medium checkout_button']")).click();
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String str = driver.findElement(By.className("complete-header")).getText();
        System.out.println(str);
             try{
                 Assert.assertTrue(str.equals("THANK YOU FOR YOUR ORDER"));
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