import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C15_ChromeOptionsAndCerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		//to accept ssl certification
		opt.setAcceptInsecureCerts(true);
		//to set proxy
		Proxy proxy = new Proxy();
		opt.setCapability("proxy", proxy);
		//to block up
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		//to set download directory path
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		opt.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://expired.badssl.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

}
