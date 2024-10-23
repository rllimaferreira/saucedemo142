// 1 - bibliotecas / imports

// import org.junit.Test;

// import org.junit.Before;
// import org.junit.After;
// import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // biblioteca principal do Selenium
import org.openqa.selenium.chrome.ChromeDriver; // biblioteca do ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

  // 2 - Classe
public class TesteInformaesdeMochilanoCarrinhodeComprasTest {
  // 2.1 - Atributos
  private WebDriver driver;
  // private Map<String, Object> vars;
  // JavascriptExecutor js;

  // 2.2. - Funções e Métodos

  // Antes do Teste
  @BeforeEach
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();  // instanciar o objeto do Selenium como ChromeDriver
    driver.manage().window().maximize(); // maximiza a janela do browser
    // js = (JavascriptExecutor) driver;
    // vars = new HashMap<String, Object>();
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
    // driver.manage().window().setSize(new Dimension(1936, 1048));
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    // Transição de Página
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();
    {
      // WebDriverWait wait = new WebDriverWait(driver, 1.0);
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_quantity")));
    }
    //assertEquals(driver.findElement(By.cssSelector(".cart_quantity")).getText(), is("1"));
    
    //assertEquals(driver.findElement(By.cssSelector(".cart_quantity")).getText(), is(1));

    assertEquals(driver.findElement(By.cssSelector(".cart_quantity")).getText(), "1");

    
    //assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), is("Sauce Labs Backpack"));

    
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\\\"inventory-item-name\\\"]")).getText(), "Sauce Labs Backpack");
    
    
    
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\\\"inventory-item-price\\\"]")).getText(), "$29.99");



    // assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), is("$29.99"));
    driver.findElement(By.id("react-burger-menu-btn")).click();
    driver.findElement(By.cssSelector("*[data-test=\"logout-sidebar-link\"]")).click();
    driver.findElement(By.cssSelector(".login_container")).click();
  }
}
