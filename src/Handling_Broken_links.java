import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Handling_Broken_links {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\kavya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    	WebDriver driver=new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link:links) {
			String url=link.getAttribute("href");
			HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int responsecode=con.getResponseCode();
			System.out.println(responsecode);
			if(responsecode>400)
			{
				System.out.println("The link with text "+link.getText()+" is broken with code "+responsecode);
				Assert.assertTrue(false);
			}
		}


	}

}
