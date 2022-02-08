import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println(System.getenv("PATH"));
    System.out.println(System.getenv("HOME"));
  //  System.out.println(System.getenv(""));

    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
   // File pathBinary = new File("src/main/resources/firefox");
  //  FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
   // DesiredCapabilities desired = new DesiredCapabilities();
    ChromeOptions options = new ChromeOptions();
   // desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
    WebDriver driver = new ChromeDriver(options);
    driver.get("https://www.formula1.com/en/drivers.html");

    String title = driver.getTitle();
    System.out.println(title);

    List<String> enlaces = new ArrayList<>();


    List<WebElement> buscaUrl = new ArrayList<>();
    buscaUrl = driver.findElements(new By.ByClassName("listing-item--link"));

    for (WebElement url : buscaUrl ){
      enlaces.add(url.getAttribute("href"));
      System.out.println(url.getAttribute("href"));
    }

    List<Pilotos> pilotosList = new ArrayList<>();
    WebElement nombre, numero;
    for (String enlace : enlaces){
      driver.navigate().to(enlace);
      nombre = driver.findElement(new By.ByClassName("driver-name"));
      numero = driver.findElement(new By.ByClassName("driver-number"));
      List<WebElement> datos = driver.findElements(new By.ByClassName("stat-value"));
      int contador = 0;

//      nombre.add()
      Pilotos piloto = new Pilotos();
      piloto.setNombre(nombre.getText());
      piloto.setNumero(numero.getText());

      System.out.println(nombre.getText() + " " + numero.getText());

      for (WebElement dato : datos){
        switch (contador){
          case 0:
            piloto.setEquipo(dato.getText());
            break;
          case 1:
            piloto.setPais(dato.getText());
            break;
          case 2:
            piloto.setPodiums(dato.getText());
            break;
          case 3:
            piloto.setPuntos(dato.getText());
            break;
          case 4:
            piloto.setGpComp(dato.getText());
            break;
          case 5:
            piloto.setTitulos(dato.getText());
            break;
          case 6:
            piloto.setMejorPos(dato.getText());
            break;
          case 7:
            piloto.setMejorClas(dato.getText());
            break;
          case 8:
            piloto.setNacimiento(dato.getText());
            break;
          case 9:
            piloto.setNacionalidad(dato.getText());
            break;
        }
        System.out.println(dato.getText());
        contador++;
      }
      pilotosList.add(piloto);
    }


    Csv csv = new Csv(pilotosList);

    Xml xml = new Xml(pilotosList);

  }
}
