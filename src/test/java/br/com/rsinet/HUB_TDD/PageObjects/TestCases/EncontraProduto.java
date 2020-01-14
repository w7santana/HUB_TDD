package br.com.rsinet.HUB_TDD.PageObjects.TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.PageObjects.HomePage;

public class EncontraProduto {
	private WebDriver navegador = new ChromeDriver();
	
	@Before
	public void Setup(){
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void deveEncontrarProduto() {
		HomePage.selecionaCategoriaProduto(navegador, "MICE").click();
		HomePage.selecionaMouse(navegador).click();
		
		Assert.assertEquals("LOGITECH G502 PROTEUS CORE", HomePage.lblProduto(navegador));
	}
	
	@Test
	public void naoDeveEncontrarProduto() {
	}
	
	
}
