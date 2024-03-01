import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class C2_Locator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String nmeact = "Mayank";
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(nmeact);
		driver.findElement(By.name("inputPassword")).sendKeys("Maya");
		driver.findElement(By.className("submit")).click();
		String err = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(err);
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Test");
		//custom Locator
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("Test@mail.com");
		//driver.findElement(By.cssSelector("input[type='text']:nth-child(5)")).sendKeys("1231231231");
		//--------------
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("123454321");
		driver.findElement(By.cssSelector("form div button[class='reset-pwd-btn']")).click();
		String getpwdstr = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] tmp = getpwdstr.split(" ");
		String pwd = tmp[4].substring(1, tmp[4].length()-1);
		System.out.println("-->"+pwd+"<--");
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(nmeact);
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='chkboxOne']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		String[] nmestr = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText().split(" ");
		String nme = nmestr[1].substring(0,nmestr[1].length()-1);
		System.out.println(nme);
		String loginStr = driver.findElement(By.tagName("p")).getText();
		System.out.println(loginStr);
		Assert.assertEquals(nme, nmeact);
		Assert.assertEquals(loginStr,"You are successfully logged in.");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();
	}

}
