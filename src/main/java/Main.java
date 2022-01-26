import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
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


    List<WebElement> cajas = new ArrayList<>();
    List<String> names = new ArrayList<>();
    cajas = driver.findElements(new By.ByClassName("f1-uppercase"));

    for (WebElement name : cajas ){
//      System.out.println(names);
      names.add(name.getText());
      System.out.println(name.getText());
    }
  }

}
