import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C19_PaginationStreams {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> price;
		List<WebElement> lst;
		do {
			lst = driver.findElements(By.cssSelector(".table.table-bordered tbody tr  td:nth-child(1)"));
			price = lst.stream().filter(s->s.getText().equalsIgnoreCase("Cherry")).map(s->GetPrice(s)).collect(Collectors.toList());
			if(price.size()<1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
		price.forEach(s->System.out.println(s));
		System.out.println("---><---");
		
		Thread.sleep(10000);
		driver.quit();
	}

	private static String GetPrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceval = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceval;
	}

}
