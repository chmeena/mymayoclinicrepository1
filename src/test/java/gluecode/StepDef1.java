package gluecode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef1
{
  public Shared1 sh;
  public StepDef1(Shared1 sh)
  {
	  this.sh=sh;
  }
  @Given("open browser")
  public void browserOpen()
  {
	  ChromeOptions co=new ChromeOptions();
	  co.addArguments("--remote-allow-origins=*");
	  WebDriverManager.chromedriver().setup();
	  sh.driver=new ChromeDriver(co);
	  sh.driver.manage().window().maximize();
  }
  @When("launch site {string}")
  public void siteLaunch(String x)
  {
	  sh.driver.get(x);
  }
  @Then("click on symptom checker")
  public void clickOnSymptom()
  {
	 sh.wait =new FluentWait<RemoteWebDriver>(sh.driver) ;
	 sh.wait.withTimeout(Duration.ofSeconds(25));
	 sh.wait.pollingEvery(Duration.ofSeconds(1));
	 sh.wait.until(ExpectedConditions.elementToBeClickable(
			 By.xpath("(//a[@class='button-cta'])[1]"))).click();
  }
  @Then("select one symptom")
  public void selectSymptom()
  {
	  sh.wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//a[text()='Cough in adults']"))).click();
  }
  @Then("select related factors")
  public void selectFactor()
  {
	  sh.wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//legend[text()='Cough is']/following::input[1]"))).click();
	  sh.wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//label[text()='New or recent']/preceding-sibling::input"))).click();
	  sh.wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//label[text()='Allergens or irritants']/preceding-sibling::input"))).click();
	  WebElement chestpain=sh.wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//label[text()='Chest pain or tightness']/preceding-sibling::input")));
	  chestpain.click();
	  if(chestpain.isSelected())
	  {
		  System.out.println("test pass");
	  }
	  else
	  {
		  System.out.println("test fail");
	  }
	  sh.wait.until(ExpectedConditions.elementToBeClickable(
			  By.xpath("//input[@value='Find causes']"))).click();
  }
}
