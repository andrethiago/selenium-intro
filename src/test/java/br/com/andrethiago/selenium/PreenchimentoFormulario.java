package br.com.andrethiago.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PreenchimentoFormulario {
	
	@Test
	public void preencheFormularioCorreiosBuscaLogradouroPorBairro() {
		
//		System.setProperty("webdriver.chrome.driver", "/home/andrethiago/chromedriver");
		//ChromeOptions options = new ChromeOptions();
		//options.setBinary("/usr/bin/google-chrome");
		
		WebDriver driver = new FirefoxDriver();
		// Visita a página do Correios
		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaLogBairro.cfm");
		
		// Escolhe o valor de UF
		Select selectUF = new Select(driver.findElement(By.name("UF")));
		selectUF.selectByVisibleText("RJ");
		// Preenche a Localidade com o valor "Rio de Janeiro"
		WebElement inputLocalidade = driver.findElement(By.name("Localidade"));
		inputLocalidade.sendKeys("Rio de Janeiro");
		// Preenche o campo Bairro com o valor "Copacabana"
		WebElement inputBairro = driver.findElement(By.name("Bairro"));
		inputBairro.sendKeys("Copacabana");
		
		// clica no botão Buscar
		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonBuscar.click();
		
	}

}
