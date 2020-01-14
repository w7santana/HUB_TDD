package br.com.rsinet.HUB_TDD.PageObjects.TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.PageObjects.FormDeCadastroPage;
import br.com.rsinet.HUB_TDD.PageObjects.HomePage;
import br.com.rsinet.HUB_TDD.PageObjects.LoginPage;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.Print;

public class CadastroClienteTest {
	private static WebDriver navegador = null;
	
	@Before
	public void setup() throws Exception {
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://advantageonlineshopping.com/#/");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}
	
	@Test
	public void deveCadastrarUsuario() throws Exception {
		
		HomePage.btnUser(navegador).click();
		LoginPage.lnkNewAccount(navegador).sendKeys(Keys.ENTER);
		
		FormDeCadastroPage.fldUserName(navegador).sendKeys(ExcelUtils.getCellData(1, 0));
		FormDeCadastroPage.fldEmail(navegador).sendKeys(ExcelUtils.getCellData(1, 1));
		FormDeCadastroPage.fldPassword(navegador).sendKeys(ExcelUtils.getCellData(1, 2));
		FormDeCadastroPage.fldPasswordConfirm(navegador).sendKeys(ExcelUtils.getCellData(1, 3));
		FormDeCadastroPage.fldFirstName(navegador).sendKeys(ExcelUtils.getCellData(1, 4));
		FormDeCadastroPage.fldLastName(navegador).sendKeys(ExcelUtils.getCellData(1, 5));
		FormDeCadastroPage.fldPhone(navegador).sendKeys(ExcelUtils.getCellData(1, 6));
		FormDeCadastroPage.cmbCountry(navegador).selectByVisibleText(ExcelUtils.getCellData(1, 7));
		FormDeCadastroPage.fldCity(navegador).sendKeys(ExcelUtils.getCellData(1, 8));
		FormDeCadastroPage.fldAddress(navegador).sendKeys(ExcelUtils.getCellData(1, 9));
		FormDeCadastroPage.fldState(navegador).sendKeys(ExcelUtils.getCellData(1, 10));
		FormDeCadastroPage.fldPostalCode(navegador).sendKeys(ExcelUtils.getCellData(1, 11));
		FormDeCadastroPage.chkIAgree(navegador).click();
		FormDeCadastroPage.btnRegister(navegador).click();
		
		System.out.println(HomePage.usuarioLogado(navegador));
				
		Assert.assertEquals(ExcelUtils.getCellData(1, 0), HomePage.usuarioLogado(navegador));
	}
	
	@Test
	public void deveRecusarUserNameDuplicado() throws Exception {
		HomePage.btnUser(navegador).click();
		LoginPage.lnkNewAccount(navegador).sendKeys(Keys.ENTER);
		
		FormDeCadastroPage.fldUserName(navegador).sendKeys(ExcelUtils.getCellData(1, 0));
		FormDeCadastroPage.fldEmail(navegador).sendKeys(ExcelUtils.getCellData(1, 1));
		FormDeCadastroPage.fldPassword(navegador).sendKeys(ExcelUtils.getCellData(1, 2));
		FormDeCadastroPage.fldPasswordConfirm(navegador).sendKeys(ExcelUtils.getCellData(1, 3));
		FormDeCadastroPage.fldFirstName(navegador).sendKeys(ExcelUtils.getCellData(1, 4));
		FormDeCadastroPage.fldLastName(navegador).sendKeys(ExcelUtils.getCellData(1, 5));
		FormDeCadastroPage.fldPhone(navegador).sendKeys(ExcelUtils.getCellData(1, 6));
		FormDeCadastroPage.cmbCountry(navegador).selectByVisibleText(ExcelUtils.getCellData(1, 7));
		FormDeCadastroPage.fldCity(navegador).sendKeys(ExcelUtils.getCellData(1, 8));
		FormDeCadastroPage.fldAddress(navegador).sendKeys(ExcelUtils.getCellData(1, 9));
		FormDeCadastroPage.fldState(navegador).sendKeys(ExcelUtils.getCellData(1, 10));
		FormDeCadastroPage.fldPostalCode(navegador).sendKeys(ExcelUtils.getCellData(1, 11));
		FormDeCadastroPage.chkIAgree(navegador).click();
		FormDeCadastroPage.btnRegister(navegador).click();
		
		String usuarioDuplicado = FormDeCadastroPage.lblUsuarioJaExiste(navegador).getText();
		System.out.println(usuarioDuplicado);
		
		Assert.assertEquals("User name already exists", usuarioDuplicado);
		Print.captureScreenShot(navegador);
	}
	
	
	@Test
	public void deveEncontrarProduto() {
		
		HomePage.selecionaCategoriaProduto(navegador, "MICE").click();
		HomePage.selecionaMouse(navegador).click();
		
		Assert.assertEquals("LOGITECH G502 PROTEUS CORE", HomePage.lblProduto(navegador));
		Print.captureScreenShot(navegador);
	}
	
	
	

}
