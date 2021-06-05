package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private String urlBase = "https://www.choucairtesting.com/";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Hooks.driver = driver;
    }

    @Before
    public void beforeScenario(){
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();

        getDriver().get(urlBase);
    }


    @After
    public void afterScenario(){
        getDriver().quit();
    }
}
