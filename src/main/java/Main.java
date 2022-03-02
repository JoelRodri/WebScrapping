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
  /**
   * En el main tengo todo el inicio de la app, y el webb scrapping.
   */
  public static void main(String[] args) {
    System.out.println(System.getenv("PATH"));
    System.out.println(System.getenv("HOME"));
  //  System.out.println(System.getenv(""));

    /*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);*/
/**
 * Aqui tengo los drivers para usar firefox
 */
    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
    FirefoxOptions options = new FirefoxOptions();
    WebDriver driver = new FirefoxDriver(options);

    /**
     * Esta linea entra al enlace inicial de la pagina
     */
    driver.get("https://www.formula1.com/en/drivers.html");

    String title = driver.getTitle();
    System.out.println(title);

    List<String> enlaces = new ArrayList<>();

/**
 *Creo un web element que tiene la clabe para encontrar los enlaces, y luego los busco y los guardo en una lista con un for.
 */
    List<WebElement> buscaUrl = new ArrayList<>();
    buscaUrl = driver.findElements(new By.ByClassName("listing-item--link"));

    for (WebElement url : buscaUrl ){
      enlaces.add(url.getAttribute("href"));
      System.out.println(url.getAttribute("href"));
    }

    /**
     * Creo una lista de pilotos, despues, por cada enlace encontrado anteriormente, navego a cada uno de ellos
     */
    List<Pilotos> pilotosList = new ArrayList<>();
    WebElement nombre, numero;
    for (String enlace : enlaces){
      driver.navigate().to(enlace);

      /**
       * aqui cojo el nombre y el numero, ya que tienen un nombre que los diferencian del resto
       */
      nombre = driver.findElement(new By.ByClassName("driver-name"));
      numero = driver.findElement(new By.ByClassName("driver-number"));

      /**
       * Como la informacion restante tiene toda la misma etiqueta, las recorro todas con un for, con un contador y un switch se que elemento estoy cojiendo en cada momento y lo guardo donde toca
       */
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

        /**
         * Aqui pinto el dato que estoy cogiendo y sumo uno al contador
         */
        System.out.println(dato.getText());
        contador++;
      }
      /**
       * En esta linea, añado a una lista de pilotos toda la lista que tenia guardada con los datos adquiridos
       */
      pilotosList.add(piloto);
    }


/**
 * Aqui creo las clases para crear el csv y el xml
 */
    Csv csv = new Csv(pilotosList);
    Xml xml = new Xml(pilotosList);
  }
}
