package br.com.teste.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.teste.browser.EnumBrowser;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			System.setProperty("webdriver.gecko.driver", "C:\\adriano\\libs\\driverBrowserSelenium/geckodriver.exe");
			driver = new FirefoxDriver();
			
			/*System.setProperty("webdriver.chrome.driver", "C:\\adriano\\libs\\driverBrowserSelenium/chromedriver.exe");
			driver = new ChromeDriver();*/
			driver.manage().window().setSize(new Dimension(1200, 765));			
		}
		return driver;
	}
	
	public static WebDriver getDriver(EnumBrowser browser){
		if(driver == null) {
			driver = retornarBrowser(browser);
			driver.manage().window().setSize(new Dimension(1200, 765));			
		}
		return driver;
	}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	private static WebDriver retornarBrowser(EnumBrowser browser) {
		if (browser.equals(EnumBrowser.CHROME)) {
			System.setProperty("webdriver.gecko.driver", "C:\\adriano\\libs\\driverBrowserSelenium/geckodriver.exe");
			driver = new FirefoxDriver();
		} if (browser.equals(EnumBrowser.FIREFOX)) {
			System.setProperty("webdriver.chrome.driver", "C:\\adriano\\libs\\driverBrowserSelenium/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}
