package amazonphase1test;



import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazonphase1test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);


		WebElement SearchBar= driver.findElement(By.id("twotabsearchtextbox"));
		SearchBar.sendKeys("Samsung");
		WebElement SearchClicked=driver.findElement(By.id("nav-search-submit-button"));
		SearchClicked.click();
		//List<WebElement>SearchSamsungProductName=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement>ProductList=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2/a"));
		//	List<WebElement>SearchSamsungProductPrice=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> ProductPrice=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));
		System.out.println("Total product are: " + ProductList.size());
		for (int i=0 ;i<ProductList.size();i++)
		{
				System.out.println(ProductList.get(i).getText() + " : " + ProductPrice.get(i).getText()) ;

		}

		Set<String> ParentWh=driver.getWindowHandles();	
		String ExpectedValue=ProductList.get(0).getText();
		ProductList.get(0).click();

		Set<String> AllWinds=driver.getWindowHandles();
		for (String win: AllWinds)
		{
			System.out.println(win);

			if (!win.equals(ParentWh))
			{
				driver.switchTo().window(win);
			}

		}
		WebElement title=driver.findElement(By.id("productTitle"));
		String str= title.getText();
		if(str.equals(ExpectedValue))
		{
			System.out.println("Title matching");
		}
		else
		{
			System.out.println("Title is not matching");
		}

		driver.quit();
		
		}

}
