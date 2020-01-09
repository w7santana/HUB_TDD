package br.com.rsinet.HUB_TDD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormularioDeCadastroPage {
private static WebElement element = null;
	
	public static WebElement userName(WebDriver navegador) {
		element = navegador.findElement(By.name("usernameRegisterPage"));
		return element;
	}
	
	public static WebElement email(WebDriver navegador) {
		element = navegador.findElement(By.name("usernameRegisterPage"));
		return element;
	}
	
	public static WebElement password(WebDriver navegador) {
		element = navegador.findElement(By.name("passwordRegisterPage"));
		return element;
	}
	
	public static WebElement passwordConfirm(WebDriver navegador) {
		element = navegador.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}
	
	public static WebElement firstName(WebDriver navegador) {
		element = navegador.findElement(By.name("first_nameRegisterPage"));
		return element;
	}
	
	public static WebElement lastName(WebDriver navegador) {
		element = navegador.findElement(By.name("last_nameRegisterPage"));
		return element;
	}
	
	public static WebElement phone(WebDriver navegador) {
		element = navegador.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}
	
	public static WebElement cmbCountry(WebDriver navegador) {
		element = navegador.findElement(By.name("countryListboxRegisterPage"));
		return element;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
