import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClockAutomation {

  public static void main(String[] args) throws InterruptedException {

    // Set the path to your ChromeDriver executable (if using Chrome)
	  System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Documents/seleniumdriver/chromedriver.exe");

    WebDriver driver = new ChromeDriver();

    // Replace "https://www.example.com" with the target URL
    String[] urlList = {"https://edge.media/avanti-menopause-support-gift-bag/",
    					"https://edge.media/death-of-russian-opposition-leader/", 
    					"https://edge.media/british-habits-that-the-rest-of-the-world-dont-get/", 
    					"https://edge.media/poll-show-tories-call-for-a-charismatic-pm/"};
    

    List urlArrayList = Arrays.asList(urlList);
    
    for(int i=0; i<urlArrayList.size();i++) {
    
    driver.get(urlArrayList.get(i).toString());
    driver.manage().window().maximize();

    // Find the element to click (replace with your element identifier)
    //WebElement element = driver.findElement(By.id("h-2-public-goods-organic-cotton-kitchen-towels-set-of-2"));
    Thread.sleep(2000);
    WebElement searchElement = driver.findElement(By.cssSelector("span.icon-search"));
    List<WebElement> headingElements = driver.findElements(By.cssSelector("h2 span"));
    
    // Set the program start time
    long startTime = System.currentTimeMillis();
    // Set the timeout duration in milliseconds (2 hours = 7200000 ms)
    long timeout = 300000;

    String keySequence = "Torries News in The UK"; // Your desired key sequence

    while (true) {
      

      // Create an Actions object
      Actions actions = new Actions(driver);
      actions.moveToElement(searchElement).click().sendKeys(keySequence).build().perform();
      Thread.sleep(5000);
      actions.moveToElement(searchElement).click();
      // Send the defined key sequence 
      
      for(int j=0; j<headingElements.size();j++) {
      
    	  actions.moveToElement(headingElements.get(j)).doubleClick().build().perform();
    	  Thread.sleep(2000); // Sleep for 5 seconds
      }
      
      driver.findElement(By.id("comment")).sendKeys("This is my first ever comment");
      Thread.sleep(5000);
      driver.findElement(By.id("comment")).clear();
      // Check if program has exceeded the timeout
      if (System.currentTimeMillis() - startTime > timeout) {
        break;
      }
    }

    driver.switchTo().newWindow(WindowType.TAB);
    }
    
  }
}