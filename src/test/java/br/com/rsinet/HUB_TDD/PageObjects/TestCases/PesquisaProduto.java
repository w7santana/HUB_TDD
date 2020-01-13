package br.com.rsinet.HUB_TDD.PageObjects.TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.PageObjects.HomePage;

public class PesquisaProduto {
	
private WebDriver navegador = new ChromeDriver();
	
	@Before
	public void Setup(){
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void devePesquisarProduto() {
		HomePage.btnLupa(navegador).click();
		HomePage.campoBusca(navegador).sendKeys("Logitech X100", Keys.ENTER);
		
		HomePage.produtoPesquisado(navegador).click();
		
	}
}
