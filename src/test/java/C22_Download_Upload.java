import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C22_Download_Upload {
	@Test
	public void Test1() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		String filePath = System.getProperty("user.dir") + "\\target";
		String fileToUp = System.getProperty("user.dir") + "\\target\\download.xlsx";
		String coltoCheck = "price";
		String fruit = "Apple";
		String toUpdateCount = "350";
		prefs.put("download.default_directory", filePath);
		opt.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.findElement(By.cssSelector("#downloadButton")).click();
		Thread.sleep(3000);
		int colNum = getColoumnNumber(filePath, coltoCheck);
		System.out.println(colNum);
		int rowNum = getPriceOfProduct(filePath, fruit);
		System.out.println(rowNum);
		updateexcel(filePath, rowNum, colNum, toUpdateCount);
		/*
		 * while(cells.hasNext()) { Cell c = cells.next();
		 * if(c.getStringCellValue().equalsIgnoreCase("fruit_name")) { coloumnName=k; }
		 * k++; } while(rows.hasNext()) { Row r = rows.next();
		 * if(r.getCell(coloumnName).getStringCellValue().equalsIgnoreCase("Apple")) {
		 * Iterator<Cell> cv = r.cellIterator(); while(cv.hasNext()) { Cell c =
		 * cv.next(); String t1 = c.getCellType().toString();
		 * if(t1.equalsIgnoreCase("STRING")) {
		 * System.out.println(c.getStringCellValue()); } else
		 * if(t1.equalsIgnoreCase("NUMERIC")) {
		 * System.out.println(NumberToTextConverter.toText(c.getNumericCellValue())); }
		 * } } }
		 */
		Thread.sleep(3000);
		WebElement uploadBut = driver.findElement(By.cssSelector("input[type='file']"));
		uploadBut.sendKeys(fileToUp);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		By uploadText = By.cssSelector(".Toastify__toast-body div");
		wait.until(ExpectedConditions.visibilityOfElementLocated(uploadText));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(uploadText));
		List<WebElement> lst = driver.findElements(By.cssSelector("div[id*='row']"));
		for (int i = 0; i < lst.size(); i++) {
			String fruitName = lst.get(i).findElement(By.cssSelector("div:nth-child(2)")).getText();
			String fruitPrice = lst.get(i).findElement(By.cssSelector("div:nth-child(4)")).getText();
			if (fruitName.equalsIgnoreCase("Apple")) {
				Assert.assertEquals(fruitPrice, toUpdateCount);
			}
		}

		Thread.sleep(10000);
		driver.quit();
	}

	public static int getColoumnNumber(String filePath, String coltoCheck) throws IOException {
		FileInputStream fis = new FileInputStream(filePath + "\\download.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		Row firstrow = rows.next();
		Iterator<Cell> cells = firstrow.cellIterator();
		int k = 0;
		int coloumnNumber = 0;
		while (cells.hasNext()) {
			Cell c = cells.next();
			if (c.getStringCellValue().equalsIgnoreCase(coltoCheck)) {
				coloumnNumber = k;
			}
			k++;
		}
		return coloumnNumber;
	}

	public static int getPriceOfProduct(String filePath, String fruit) throws IOException {
		FileInputStream fis = new FileInputStream(filePath + "\\download.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();

		int k = 0;
		int rowNumber = 0;
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				Cell c = cells.next();
				String t1 = c.getCellType().toString();
				if (t1.equalsIgnoreCase("STRING")) {
					if (c.getStringCellValue().equalsIgnoreCase(fruit)) {
						rowNumber = k;
					}
				} else if (t1.equalsIgnoreCase("NUMERIC")) {
					if (NumberToTextConverter.toText(c.getNumericCellValue()).equalsIgnoreCase(fruit)) {
						rowNumber = k;
					}
				}

			}
			k++;
		}
		return rowNumber;
	}

	public static boolean updateexcel(String filePath, int rowNum, int colNum, String toUpdateCount)
			throws IOException {
		FileInputStream fis = new FileInputStream(filePath + "\\download.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row rowField = sheet.getRow(rowNum);
		Cell cellField = rowField.getCell(colNum);
		cellField.setCellValue(toUpdateCount);
		FileOutputStream fos = new FileOutputStream(filePath + "\\download.xlsx");
		workbook.write(fos);
		workbook.close();
		fis.close();
		return true;
	}

}
