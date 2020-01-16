package br.com.rsinet.HUB_TDD.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.PageObjects.HomePage;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.Print;

public class PesquisaProdutoTestNG {
	
private WebDriver navegador = new ChromeDriver();
	
	@BeforeMethod
	public void Setup() throws Exception{
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://advantageonlineshopping.com/#/");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}
	
	@Test
	public void devePesquisarProduto() throws Exception {
		HomePage.btnLupa(navegador).click();
		HomePage.campoBusca(navegador).sendKeys(ExcelUtils.getCellData(6, 0), Keys.ENTER);
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
