package Automacao;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreenchendoForm {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {

		// Acessa o site determinado
		System.setProperty("webdriver.chrome.driver", "C://webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automacaocombatista.herokuapp.com/home/index");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		// Vai até o formulário
		driver.findElement(By.xpath("//a[@class='btn waves-light orange']")).click();
		driver.findElement(By.xpath("//a[@class='collapsible-header ']")).click();
		driver.findElement(By.xpath("//a[@data-method='get'][1]")).click();

		// preenchendo o formulário
		driver.findElement(By.name("user[name]")).sendKeys("Teste");
		driver.findElement(By.name("user[lastname]")).sendKeys("Teste");
		driver.findElement(By.name("user[email]")).sendKeys("Teste@teste.com");
		driver.findElement(By.name("user[address]")).sendKeys("Rua teste");
		driver.findElement(By.name("user[university]")).sendKeys("Teste");
		driver.findElement(By.name("user[profile]")).sendKeys("Aluno");
		driver.findElement(By.name("user[gender]")).sendKeys("Masculino");
		driver.findElement(By.name("user[age]")).sendKeys("22");

		// Valida preenchimento
		String nomeRetornado = driver.findElement(By.name("user[name]")).getAttribute("value");
		String sobrenomeRetornado = driver.findElement(By.name("user[lastname]")).getAttribute("value");
		String emailRetornado = driver.findElement(By.name("user[email]")).getAttribute("value");
		String enderecoRetornado = driver.findElement(By.name("user[address]")).getAttribute("value");
		String universidadeRetornada = driver.findElement(By.name("user[university]")).getAttribute("value");
		String profissaoRetornada = driver.findElement(By.name("user[profile]")).getAttribute("value");
		String generoRetornado = driver.findElement(By.name("user[gender]")).getAttribute("value");
		String idadeRetornada = driver.findElement(By.name("user[age]")).getAttribute("value");

		// Valida os dados inseridos se retornam iguais
		assertEquals("Teste", nomeRetornado);
		assertEquals("Teste", sobrenomeRetornado);
		assertEquals("Teste@teste.com", emailRetornado);
		assertEquals("Rua teste", enderecoRetornado);
		assertEquals("Teste", universidadeRetornada);
		assertEquals("Aluno", profissaoRetornada);
		assertEquals("Masculino", generoRetornado);
		assertEquals("22", idadeRetornada);

		// Clica no botão "Criar"
		driver.findElement(By.xpath("//div[@class='actions btn waves-effect green']")).click();

		// Valida mensagem criação de usuário
		String usuarioCriado = driver.findElement(By.id("notice")).getText();
		assertEquals("Usuário Criado com sucesso", usuarioCriado);

		String nome = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[1]")).getText();
		String sobrenome = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[2]")).getText();
		String email = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[3]")).getText();
		String universidade = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[4]")).getText();
		String genero = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[5]")).getText();
		String profissao = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[6]")).getText();
		String idade = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[7]")).getText();
		String endereco = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[8]")).getText();

		assertEquals("Nome: Teste", nome);
		assertEquals("Ultimo Nome: Teste", sobrenome);
		assertEquals("Email: Teste@teste.com", email);
		assertEquals("Univercidade: Teste", universidade);
		assertEquals("Gênero: Masculino", genero);
		assertEquals("Profissão: Aluno", profissao);
		assertEquals("Idade: 22", idade);
		assertEquals("Address: Rua teste", endereco);
	}

}
