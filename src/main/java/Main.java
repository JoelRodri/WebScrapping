import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println(System.getenv("PATH"));
    System.out.println(System.getenv("HOME"));
  //  System.out.println(System.getenv(""));

    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
   // File pathBinary = new File("src/main/resources/firefox");
  //  FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
   // DesiredCapabilities desired = new DesiredCapabilities();
    FirefoxOptions options = new FirefoxOptions();
   // desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
    WebDriver driver = new FirefoxDriver(options);
    driver.get("https://www.formula1.com/en/drivers.html");

    String title = driver.getTitle();
    System.out.println(title);

    List<Pilotos> piloto = new ArrayList<>();
    List<String> enlaces = new ArrayList<>();


    List<WebElement> buscaUrl = new ArrayList<>();
    buscaUrl = driver.findElements(new By.ByClassName("listing-item--link"));
    for (WebElement url : buscaUrl ){
      enlaces.add(url.getAttribute("href"));
      System.out.println(url.getAttribute("href"));
    }

    for (String enlace : enlaces){
      driver.navigate().to(enlace);
      List<WebElement> nombre = buscaUrl = driver.findElements(new By.ByClassName("driver-name"));
      List<WebElement> numero = buscaUrl = driver.findElements(new By.ByClassName("driver-number"));
      List<WebElement> datos = buscaUrl = driver.findElements(new By.ByClassName("listing-item--link"));

      nombre.add()

    }



  }
}
