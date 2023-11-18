package StepDefinition;

import java.awt.Window;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Highlighter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.google.errorprone.annotations.Var;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.support.FileReader;

public class assessment1 {
	public static WebDriver driver;
	@Given("user launches firefox browser")
	public void user_launches_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Driver" + File.separator +"geckodriver.exe");
		driver.manage().window().maximize();
		driver.get("https://legacy.reactjs.org/");
	}

	@When("user open the link https:\\/\\/legacy.reactjs.org\\/ then user should be able to click Docs link")
	public void user_open_the_link_https_legacy_reactjs_org_then_user_should_be_able_to_click_docs_link() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("/html/body/div/div[1]/div/header/div[2]/div/nav/a[1]")).click();
	   // throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on Main Concepts link")
	public void user_clicks_on_main_concepts_link() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Main Concepts')]")));
		//driver.findElement(By.xpath("//div[contains(@class, 'css-1luyeat') and normalize-space(.)='Main Concepts']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Main Concepts')]")).click();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Navigate to all the sub elements available under main concepts and get text and save it to file")
	public void navigate_to_all_the_sub_elements_available_under_main_concepts_and_get_text_and_save_it_to_file() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement div = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[1]/div/div/div/div/div[1]/div/nav/div[2]"));
		WebElement ul = div.findElement(By.xpath("//ul[@class= 'css-ts0qly']"));
		File file = new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "Driver" + File.separator +"main concepts.txt");
		FileWriter fw = new FileWriter(file, true);
		List<WebElement> li = ul.findElements(By.xpath("//li[@class = 'css-atv6j6']"));
		for (WebElement i:li) {
			System.out.println(i.getText());
			System.out.println();
			String lineSeparator = System.getProperty("line.separator");
			String[] output = "".split("\n");
			for (int j = 0; j <= output.length-1; j++) {
			    fw.write(output[j]);
			    fw.write(lineSeparator);
			  }
			fw.write(i.getText());	  
			fw.write(lineSeparator);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", i);
		}
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("user clicks on Advance Guide tab")
	public void user_clicks_on_advance_guide_tab() {
	    // Write code here that turns the phrase above into concrete actions
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Advanced Guide')]")));
		//driver.findElement(By.xpath("//div[contains(@class, 'css-1luyeat') and normalize-space(.)='Main Concepts']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Main Concepts')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Advanced Guide')]")).click();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("Navigate to all the sub elements available under advanced guide and get text and save it to file")
	public void navigate_to_all_the_sub_elements_available_under_advanced_guide_and_get_text_and_save_it_to_file() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement div = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[1]/div/div/div/div/div[1]/div/nav/div[2]"));
		WebElement ul = div.findElement(By.xpath("//ul[@class= 'css-ts0qly']"));
		File file = new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "Driver" + File.separator +"advanced guide.txt");
		FileWriter fw = new FileWriter(file, true);
		List<WebElement> li = ul.findElements(By.xpath("//li[@class = 'css-atv6j6']"));
		for (WebElement i:li) {
			System.out.println();
			String lineSeparator = System.getProperty("line.separator");
			String[] output = "".split("\n");
			for (int j = 0; j <= output.length-1; j++) {
			    fw.write(output[j]);
			    fw.write(lineSeparator);
			  }
			fw.write(i.getText());	  
			fw.write(lineSeparator);
		}
		 fw.flush();
		 fw.close();
	 //   throw new io.cucumber.java.PendingException();
	}
	@When("user clicks on Tutorials link")
	public void user_clicks_on_tutorials_link() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/header/div[2]/div/nav/a[2]")).click();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("user scroll down to the end")
	public void user_scroll_down_to_the_end() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("validates the highlightion and color visiblity of text")
	public void validates_the_highlightion_and_color_visiblity_of_text() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		JavascriptExecutor scrolldown = (JavascriptExecutor)driver;
		for (int i=0;i<36;i++) {
		scrolldown.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		boolean present;
		try {
		   driver.findElement(By.xpath("//span[@class = 'css-ifgy4z']"));
		   present = true;
		   System.out.println("element is present");
		} catch (NoSuchElementException e) {
			present = false; 
		}
		}
		driver.quit();
		}
	   }
	    //throw new io.cucumber.java.PendingException();

