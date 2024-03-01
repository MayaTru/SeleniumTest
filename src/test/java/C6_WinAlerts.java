import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C6_WinAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input#name")).sendKeys("Maya");
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		String chk1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(chk1);
		driver.findElement(By.cssSelector("input#name")).sendKeys("Maya");
		driver.findElement(By.cssSelector("input#confirmbtn")).click();
		chk1 = driver.switchTo().alert().getText();
		System.out.println(chk1);
		driver.switchTo().alert().dismiss();
		Thread.sleep(5000);
		driver.quit();
	}

}
