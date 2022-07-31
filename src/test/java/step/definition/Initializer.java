package step.definition;

import org.openqa.selenium.By;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base{
	
	@Before // we have also @BeforeAll for all scenarios to run
	public void beforeHooks(Scenario scenario) {
		logger.info("Scenario " + scenario.getName() + " started");
		browser();
		openBrowser();
	}
	@After // we have also @AfterAll for all scenarios to run
	public void afterHooks(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Last step Screenshot");
			
		tearDown();
		logger.info("Scenario " + scenario.getName() + " " + scenario.getStatus());
		
	}
}
