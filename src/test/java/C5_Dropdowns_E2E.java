import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class C5_Dropdowns_E2E {

	public static void main(String[] args) throws InterruptedException {
		// For Practice use below
		//https://rahulshettyacademy.com/dropdownsPractise/
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement e1 = driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"));
		Select dropwown = new Select(e1);
		dropwown.selectByValue("AED");
		dropwown.selectByIndex(3);
		String t1 = dropwown.getFirstSelectedOption().getText();
		System.out.println(t1);
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(@id,'hrefIncAdt')]")).click();
		driver.findElement(By.id("hrefIncChd")).click();
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("span#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='PNQ']")).click();
		Thread.sleep(1000);
		//Using Indexing
		//driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> lstopt = driver.findElements(By.cssSelector("li.ui-menu-item a"));
		for(WebElement wd : lstopt) {
			if(wd.getText().equalsIgnoreCase("India")) {
				wd.click();
				break;
			}
		}
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		boolean chk1 = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		int s1 = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(chk1);
		System.out.println(s1);
		Assert.assertTrue(chk1);
		//boolean chk2 = driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
		//System.out.println(chk2);
		String chk3 = driver.findElement(By.cssSelector("div.picker-second")).getAttribute("style");
		if(chk3.contains("opacity: 0.5")){
			System.out.println("disabled");
		}
		else{
			System.out.println("enabled");
		}
		driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
