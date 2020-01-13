package br.com.rsinet.HUB_TDD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

private static WebElement element = null;
	
	public static WebElement lnkNewAccount(WebDriver navegador) throws InterruptedException {
		element = navegador.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return element;
	}
	
}
