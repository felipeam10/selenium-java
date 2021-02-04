package br.com.felipe.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.felipe.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;

	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
		
	}
	
	@Test
	public void cadastraLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormulrioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
		
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
		
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
}
