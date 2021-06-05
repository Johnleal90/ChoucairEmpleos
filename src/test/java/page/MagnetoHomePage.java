package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MagnetoHomePage {
    private WebDriver driver;

    public MagnetoHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT,using = "Nuestras Vacantes")
    private WebElement nuestrasVacantes;

    public void ingresarNuestrasVacantes(){
        nuestrasVacantes.click();
    }
}
