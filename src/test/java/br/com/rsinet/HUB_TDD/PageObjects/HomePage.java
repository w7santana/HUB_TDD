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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private static WebElement element = null;

	public static WebElement btnUser(WebDriver navegador) {
		element = navegador.findElement(By.id("menuUser"));
		return element;
	}

	public static String usuarioLogado(WebDriver navegador) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(navegador, 10);

		WebElement usuarioLogado = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span")));
		
		String textoUsuarioLogado = usuarioLogado.getText();
		return textoUsuarioLogado;
	}

	public static WebElement selecionaCategoriaProduto(WebDriver navegador, String categoria) {
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions
				.elementToBeClickable(navegador.findElement(By.xpath("//*[. ='" + categoria + "']"))));
		element = navegador.findElement(By.xpath("//*[. ='" + categoria + "']"));
		return element;
	}

	public static WebElement selecionaMouse(WebDriver navegador) {
		element = navegador.findElement(By.xpath("//*[@id=\"31\"]"));
		return element;
	}
	
	public static WebElement filtraScroller(WebDriver navegador) {
		element = navegador.findElement(By.id("accordionAttrib0"));
		return element;
	}
	
	public static WebElement filtraCor(WebDriver navegador) {
		element = navegador.findElement(By.id("accordionColor"));
		return element;
	}
	
	public static WebElement chkTouchScroll(WebDriver navegador) {
		element = navegador.findElement(By.name("scroller_type_4"));
		return element;
	}
	
	public static WebElement chkCorAzul(WebDriver navegador) {
		element = navegador.findElement(By.id("productsColors3683D1"));
		return element;
	}

	public static String lblProduto(WebDriver navegador) {
		WebElement lblProduto = navegador.findElement(By.xpath("/html/body/div[3]/nav/a[3]"));
		String txtLblProduto = lblProduto.getText();
		return txtLblProduto;
	}

	public static WebElement btnLupa(WebDriver navegador) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(navegador).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		element = wait.until(ExpectedConditions.visibilityOf(navegador.findElement(By.id("menuSearch"))));
		return element;
	}

	public static WebElement campoBusca(WebDriver navegador) {
		element = navegador.findElement(By.id("autoComplete"));
		return element;
	}

	public static WebElement buscarProduto(WebDriver navegador, String produto) {
		JavascriptExecutor ex = (JavascriptExecutor) navegador;
		ex.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");
		
		element = navegador.findElement(By.xpath("//*[. ='" + produto + "']"));
		System.out.println("Produto pesquisado: " + element.getText());
		ex.executeScript("arguments[0].click();", element);

		return element;
	}

	public static WebElement descProduto(WebDriver navegador) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(navegador).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Description\"]/h1")));
			
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println(element.getText());
		return element;
	}
	
	

}
