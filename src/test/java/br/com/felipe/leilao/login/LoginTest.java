package br.com.felipe.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
		
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
		
	}
	
	@Test
	public void efetuarLoginComDadosValidos() {
		
		paginaDeLogin.preencheFormulrioDeLogin("fulano", "pass");
		paginaDeLogin.efetuaLogin();
		
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		
	}

	@Test
	public void naoEfetuarLoginComDadosInvalidos() {
		
		paginaDeLogin.preencheFormulrioDeLogin("invalidUser", "777777");
		paginaDeLogin.efetuaLogin();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}

	@Test
	public void naoAcessarPaginaRestritaSemEstarLogado() {
		
		paginaDeLogin.navegaParaPaginaDeLances();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
		
	}
}
