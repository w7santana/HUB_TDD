package br.com.rsinet.HUB_TDD.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class FormDeCadastroPage {
	private static WebElement element = null;
	private static Select select = null;

	public static WebElement fldUserName(WebDriver navegador) {
		element = navegador.findElement(By.name("usernameRegisterPage"));
		return element;
	}

	public static WebElement fldEmail(WebDriver navegador) {
		element = navegador.findElement(By.name("emailRegisterPage"));
		return element;
	}

	public static WebElement fldPassword(WebDriver navegador) {
		element = navegador.findElement(By.name("passwordRegisterPage"));
		return element;
	}

	public static WebElement fldPasswordConfirm(WebDriver navegador) {
		element = navegador.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}

	public static WebElement fldFirstName(WebDriver navegador) {
		element = navegador.findElement(By.name("first_nameRegisterPage"));
		return element;
	}

	public static WebElement fldLastName(WebDriver navegador) {
		element = navegador.findElement(By.name("last_nameRegisterPage"));
		return element;
	}

	public static WebElement fldPhone(WebDriver navegador) {
		element = navegador.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}

	public static Select cmbCountry(WebDriver navegador) {
		WebElement selecionaPais = navegador.findElement(By.name("countryListboxRegisterPage"));
		select = new Select(selecionaPais);
		return select;
	}

	public static WebElement fldCity(WebDriver navegador) {
		element = navegador.findElement(By.name("cityRegisterPage"));
		return element;
	}

	public static WebElement fldAddress(WebDriver navegador) {
		element = navegador.findElement(By.name("addressRegisterPage"));
		return element;
	}

	public static WebElement fldState(WebDriver navegador) {
		element = navegador.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}

	public static WebElement fldPostalCode(WebDriver navegador) {
		element = navegador.findElement(By.name("postal_codeRegisterPage"));
		return element;
	}

	public static WebElement chkIAgree(WebDriver navegador) {
		element = navegador.findElement(By.name("i_agree"));
		JavascriptExecutor jse = (JavascriptExecutor)navegador;
        jse.executeScript("scrollBy(0,200)", "");
		return element;
	}

	public static WebElement btnRegister(WebDriver navegador) {
		element = navegador.findElement(By.id("register_btnundefined"));
		return element;
	}

	public static WebElement lblUsuarioJaExiste(WebDriver navegador) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(navegador).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")));
		return element;
	}

}
