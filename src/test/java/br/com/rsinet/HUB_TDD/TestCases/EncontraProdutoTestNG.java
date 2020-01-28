package br.com.rsinet.HUB_TDD.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.PageObjects.HomePage;
import br.com.rsinet.HUB_TDD.utility.Driver;
import br.com.rsinet.HUB_TDD.utility.Print;

public class EncontraProdutoTestNG {
	private WebDriver navegador = null;
	
	@BeforeMethod
	public void Setup(){
		navegador = Driver.getDriver();
	}
	
	@AfterMethod
	public void TearDown() {
		Driver.killDriver();
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
