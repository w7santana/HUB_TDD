package br.com.rsinet.HUB_TDD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private static WebElement element = null;
	
	public static WebElement btnUser(WebDriver navegador) {
		element = navegador.findElement(By.id("menuUser"));
		return element;
	}
	
	public static String usuarioLogado(WebDriver navegador) throws InterruptedException {
		Thread.sleep(3000);
		WebElement usuarioLogado = navegador.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		String textoUsuarioLogado = usuarioLogado.getText();
		return textoUsuarioLogado;
	}

}
