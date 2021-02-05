package br.com.felipe.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;

	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		if (browser == null) {
			this.browser = new ChromeDriver();
		} else {
			this.browser = browser;
		}
		/*
		this.browser.manage().timeouts()
			.implicitlyWait(5, TimeUnit.SECONDS) //toda vez que o selenium for buscar um elemento na pagina ele vai esperar no maximo 5 segundos.
			.pageLoadTimeout(10, TimeUnit.SECONDS); // se pagina nao carregar em 10 segundos, o selenium joga erro
		*/
	}
	
	public void fechar() {
		this.browser.quit();
		
	}
	
	
}
