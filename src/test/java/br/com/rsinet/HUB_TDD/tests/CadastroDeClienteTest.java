package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroDeClienteTest {
	private WebDriver navegador = new ChromeDriver();
	
	@Before
	public void Setup(){
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://advantageonlineshopping.com/#/");
	}
	
	@Test
	public void deveCadastrarCliente() throws InterruptedException {
	navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	navegador.manage().window().maximize();
	navegador.get("http://advantageonlineshopping.com/#/");
	
	navegador.findElement(By.id("menuUser")).click();
	
	WebDriverWait aguardar = new WebDriverWait(navegador, 10);
	aguardar.until(ExpectedConditions.elementToBeClickable(By.linkText("CREATE NEW ACCOUNT")));
//	Thread.sleep(4000);
	navegador.findElement(By.linkText("CREATE NEW ACCOUNT")).click();
	
	navegador.findElement(By.name("usernameRegisterPage")).sendKeys("joaosilva123");
	navegador.findElement(By.name("emailRegisterPage")).sendKeys("joaosilva@email.com");
	navegador.findElement(By.name("passwordRegisterPage")).sendKeys("@Joao123");
	navegador.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("@Joao123");
	navegador.findElement(By.name("first_nameRegisterPage")).sendKeys("João");
	navegador.findElement(By.name("last_nameRegisterPage")).sendKeys("Silva");
	navegador.findElement(By.name("phone_numberRegisterPage")).sendKeys("+5511988888888");
	WebElement comboCountry = navegador.findElement(By.name("countryListboxRegisterPage"));
	new Select(comboCountry).selectByVisibleText("Brazil");
	
	navegador.findElement(By.name("cityRegisterPage")).sendKeys("São Paulo");
	navegador.findElement(By.name("addressRegisterPage")).sendKeys("Av. Paulista, 200");
	navegador.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");
	navegador.findElement(By.name("postal_codeRegisterPage")).sendKeys("01311-922");
	navegador.findElement(By.name("i_agree")).click();
	navegador.findElement(By.id("register_btnundefined")).click();
	WebElement usuarioLogado = navegador.findElement(By.className("hi-user containMiniTitle ng-binding"));
	String textoUsuarioLogado = usuarioLogado.getText();
	
	Assert.assertEquals("joaosilva123", textoUsuarioLogado);
	}
	
	
	

}
