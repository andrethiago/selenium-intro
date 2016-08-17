package br.com.andrethiago.selenium;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChamadaAjax {
	
	@Test
	public void pesquisaNaPaginaGoogleTermoTesteAceitacaoComExplicitWait() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com.br");
		driver.findElement(By.name("q")).sendKeys("testes de aceitação");	

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement divResultados = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.srg")));
				
		assertNotNull(divResultados);
		
		driver.quit();
	}

	@Test
	public void pesquisaNaPaginaGoogleTermoTesteAceitacaoComImplicitWait() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.google.com.br");
		driver.findElement(By.name("q")).sendKeys("testes de aceitação");

		assertNotNull(driver.findElement(By.cssSelector("div.srg")));
		
		driver.quit();
	}
	
	

}
