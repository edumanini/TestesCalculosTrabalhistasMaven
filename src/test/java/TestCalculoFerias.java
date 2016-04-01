import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class TestCalculoFerias {
	  private static WebDriver driver;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private CalculoFeriasPage page;

	  @Before
	  public void setUp() throws Exception {
		driver = Driver.createDriver();
		driver.get(Driver.baseUrl + "/carreira-sucesso/duvidas-trabalhistas/calculo-de-ferias.php");
		page = new CalculoFeriasPage(driver);
	  }

	  @Test
	  public void testSalarioMedio() throws Exception {
	    page.setSalario("4.400,00");
	    page.setNumeroDependentes("1");
	    page.setDiasFerias("20");
	    page.setOpcaoVenderFerias(false);
	    page.calcular();
	    assertEquals("R$ 3.342,00", page.getValorCalculado());
	  }
	  
	  @Test
	  public void testSalarioAlto() throws Exception {
	    page.setSalario("12.000,00");
	    page.setNumeroDependentes("2");
	    page.setDiasFerias("20");
	    page.setOpcaoVenderFerias(false);
	    page.calcular();
	    assertEquals("R$ 8.335,04", page.getValorCalculado());
	  }
	  
	  @Test
	  public void testSalarioBaixo() throws Exception {
	    page.setSalario("800,00");
	    page.setNumeroDependentes("4");
	    page.setDiasFerias("30");
	    page.setOpcaoVenderFerias(false);
	    page.calcular();
	    assertEquals("R$ 981,34", page.getValorCalculado());
	  }
	  
	  @Test
	  public void testVendaFerias() throws Exception {
	    page.setSalario("2.000,00");
	    page.setNumeroDependentes("0");
	    page.setDiasFerias("15");
	    page.setOpcaoVenderFerias(true);
	    page.calcular();
	    assertEquals("R$ 2.115,55", page.getValorCalculado());
	  }
	  
	  @Test
	  public void testMinimoDiasFerias() throws Exception {
	    page.setSalario("1.800,00");
	    page.setNumeroDependentes("0");
	    page.setDiasFerias("10");
	    page.setOpcaoVenderFerias(false);
	    page.calcular();
	    assertEquals("R$ 736,00", page.getValorCalculado());
	  }

	  @After
	  public void tearDown() throws Exception {
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	  
	  @AfterClass
	  public static void tearDownAfterClass(){
		  //driver.close();
		  //driver=null;
	  }
	}
