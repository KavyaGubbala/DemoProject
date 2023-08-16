import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webpage_Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\kavya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/guru99home/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//To scroll down the web page by pixel
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		//To scroll down the web page by the visibility of the element.
		WebElement Element = driver.findElement(By.xpath("//div[@class='rt-block']//p//a//img"));	
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
        Thread.sleep(2000);
        //To scroll down the web page at the bottom of the page.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
		 ////To scroll down the web page to the Up of the page.
        js.executeScript("window.scrollTo(0, -(document.body.scrollHeight))");
        Thread.sleep(2000);
        driver.quit();

	}

}
