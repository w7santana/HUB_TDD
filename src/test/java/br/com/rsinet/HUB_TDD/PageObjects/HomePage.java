package br.com.rsinet.HUB_TDD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private static WebElement element = null;

	public static WebElement btnUser(WebDriver navegador) {
		element = navegador.findElement(By.id("menuUser"));
		return element;
	}

	public static String usuarioLogado(WebDriver navegador) throws InterruptedException {
		WebElement usuarioLogado = navegador.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
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

	public static String lblProduto(WebDriver navegador) {
		WebElement lblProduto = navegador.findElement(By.xpath("/html/body/div[3]/nav/a[3]"));
		String txtLblProduto = lblProduto.getText();
		return txtLblProduto;
	}

	public static WebElement btnLupa(WebDriver navegador) {
		element = navegador.findElement(By.id("menuSearch"));
		return element;
	}

	public static WebElement campoBusca(WebDriver navegador) {
		element = navegador.findElement(By.id("autoComplete"));
		return element;
	}

	public static WebElement buscarProduto(WebDriver navegador, String produto) {
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[. ='" + produto + "']")));
		element = navegador.findElement(By.xpath("//*[. ='" + produto + "']"));
		System.out.println("Produto pesquisado: " + element.getText());
		JavascriptExecutor ex = (JavascriptExecutor) navegador;
		ex.executeScript("arguments[0].click();", element);

		return element;
	}

	public static WebElement descProduto(WebDriver navegador) {
		WebDriverWait wait = new WebDriverWait(navegador, 10);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Description\"]/h1")));
		return element;
	}

}
