import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class C18_WebTableStreams {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".col-xs-4 div select option:nth-child(3)")).click();
		List<WebElement> lst = driver.findElements(By.cssSelector(".table.table-bordered tbody tr  td:nth-child(1)"));
		List<String> mySortedList = lst.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		//custom method in streams
		List<String> price = lst.stream().filter(s->s.getText().equalsIgnoreCase("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		System.out.println("---><---");
		driver.findElement(By.cssSelector(".sort-icon.sort-descending")).click();
		List<WebElement> lstnew = driver.findElements(By.cssSelector(".table.table-bordered tbody tr  td:nth-child(1)"));
		List<String> actSortedList = lstnew.stream().map(s->s.getText()).collect(Collectors.toList());
		Assert.assertTrue(mySortedList.equals(actSortedList));
		//driver.fin
		Thread.sleep(10000);
		driver.quit();
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String prival = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return prival;
	}


}
