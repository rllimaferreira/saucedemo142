// 1 - bibliotecas / imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // biblioteca principal do Selenium
import org.openqa.selenium.chrome.ChromeDriver; // biblioteca do ChromeDriver
import io.github.bonigarcia.wdm.WebDriverManager;
  // 2 - Classe
public class TesteInformaesdeMochilanoCarrinhodeComprasTest {
  // 2.1 - Atributos
  private WebDriver driver;
  // 2.2. - Funções e Métodos
  // Antes do Teste
  @BeforeEach
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();  // instanciar o objeto do Selenium como ChromeDriver
    driver.manage().window().maximize(); // maximiza a janela do browser
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
  }
  // Depois do Teste
  @AfterEach
  public void tearDown() {
    driver.quit(); // destrói o objeto do Selenium
  }
  // Teste
  @Test
  public void testeInformaesdeMochilanoCarrinhodeCompras() {
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // Transição de Página
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();
    assertEquals(driver.findElement(By.cssSelector(".cart_quantity")).getText(), "1");
    assertEquals(driver.findElement(By.cssSelector("*[data-test='inventory-item-name']")).getText(), "Sauce Labs Backpack");
    assertEquals(driver.findElement(By.cssSelector("*[data-test='inventory-item-price']")).getText(), "$29.99");
    driver.findElement(By.id("react-burger-menu-btn")).click();
    driver.findElement(By.cssSelector("*[data-test='logout-sidebar-link']")).click();
    driver.findElement(By.cssSelector(".login_container")).click();
  }
}