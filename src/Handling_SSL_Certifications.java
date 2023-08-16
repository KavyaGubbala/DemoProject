import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handling_SSL_Certifications {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\kavya\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		options.setAcceptInsecureCerts(true);
		WebDriver driver=new FirefoxDriver();
		driver.get("https://expired.badssl.com/");
		File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("screenshot.png"));
		driver.quit();
		//File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("C:\\Users\\kavya\\screenshot.jpeg"));

	}

}
