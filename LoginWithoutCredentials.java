
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

public class LoginWithoutCredentials {
     public static String baseUrl = "http://saucedemo.com";
      public static WebDriver driver;
      
    public LoginWithoutCredentials() {
    System.setProperty("webdriver.gecko.driver","C:\\Users\\Korisnik\\Desktop\\geckodriver-v0.30.0-win64\\geckodriver.exe");
    
    }

    @Test
    public void LoginWithoutCredentials() throws InterruptedException{
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String username= "";
        String password= "";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        WebElement nss;
        String str = driver.findElement(By.cssSelector("button[class='error-button']")).getText();
             try{
                 Assert.assertTrue(str.contains("Epic sadface"));
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