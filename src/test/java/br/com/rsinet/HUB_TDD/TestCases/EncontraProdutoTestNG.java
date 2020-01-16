package br.com.rsinet.HUB_TDD.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.PageObjects.HomePage;
import br.com.rsinet.HUB_TDD.utility.Print;

public class EncontraProdutoTestNG {
	private WebDriver navegador = new ChromeDriver();
	
	@BeforeMethod
	public void Setup(){
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void deveEncontrarProduto() {
		HomePage.selecionaCategoriaProduto(navegador, "MICE").click();
		HomePage.selecionaMouse(navegador).click();
		
		AssertJUnit.assertEquals("LOGITECH G502 PROTEUS CORE", HomePage.lblProduto(navegador));
		Print.captureScreenShot(navegador);

	}
	
	@Test
	public void naoDeveEncontrarProduto() {
		HomePage.selecionaCategoriaProduto(navegador, "MICE").click();
		HomePage.filtraScroller(navegador).click();
		HomePage.chkTouchScroll(navegador).click();
		HomePage.filtraCor(navegador).click();
		HomePage.chkCorAzul(navegador).click();
		
		AssertJUnit.assertTrue(navegador.findElement(By.xpath("/html/body/div[3]/section/article/div[3]/div/div/div[3]/label/span")).isDisplayed());
		Print.captureScreenShot(navegador);
	}
	
	
}
