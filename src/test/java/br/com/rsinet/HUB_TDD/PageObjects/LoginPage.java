package br.com.rsinet.HUB_TDD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

private static WebElement element = null;
	
	public static WebElement lnkNewAccount(WebDriver navegador) throws InterruptedException {
		element = navegador.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return element;
	}
	
}
