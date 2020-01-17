package br.com.rsinet.HUB_TDD.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	private static WebDriver navegador;
	
	public static WebDriver getDriver() {
		if (navegador == null) {
			createDriver();
		}
		return navegador;
	}
	
	private static WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://advantageonlineshopping.com/#/");
		return navegador;
	}
	
	public static void killDriver() {
		if(navegador != null) {
			navegador.quit();
			navegador = null;
		}
	}

}
