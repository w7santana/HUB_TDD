package br.com.rsinet.HUB_TDD.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.PageObjects.HomePage;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.Driver;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.Print;

public class PesquisaProdutoTestNG {
	
private WebDriver navegador = null;
	
	@BeforeMethod
	public void Setup() throws Exception{
		navegador = Driver.getDriver();
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.killDriver();
	}
	
	@Test
	public void devePesquisarProduto() throws Exception {
		HomePage.btnLupa(navegador).click();
		HomePage.campoBusca(navegador).sendKeys(ExcelUtils.getCellData(6, 0) + Keys.ENTER);
		HomePage.buscarProduto(navegador, ExcelUtils.getCellData(6, 0));
		
		AssertJUnit.assertEquals(ExcelUtils.getCellData(6, 0), HomePage.descProduto(navegador).getText());
		Print.captureScreenShot(navegador);
	}
	
	@Test
	public void deveInformarProdutoInexistente() throws Exception {
		HomePage.btnLupa(navegador).click();
		HomePage.campoBusca(navegador).sendKeys(ExcelUtils.getCellData(6, 1), Keys.ENTER);
		System.out.println(navegador.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label")).getText());
		
		AssertJUnit.assertTrue(navegador.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label")).isDisplayed());
		Print.captureScreenShot(navegador);
	}
	
	
}
