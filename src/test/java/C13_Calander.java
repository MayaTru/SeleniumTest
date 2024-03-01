import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C13_Calander {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.findElement(By.id("first_date_picker")).click();
		int s = driver.findElements(By.cssSelector("a.ui-state-default")).size();
		List<WebElement> lst = driver.findElements(By.cssSelector("a.ui-state-default"));
		System.out.println(s);
		for(int i=0;i<s;i++) {
			String dt1 = lst.get(i).getText();
			if(dt1.equalsIgnoreCase("23")) {
				lst.get(i).click();
				break;
			}
		}
	}

}
