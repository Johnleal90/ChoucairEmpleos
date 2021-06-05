package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MagnetoDetalleVacantePage {
    private WebDriver driver;

    public MagnetoDetalleVacantePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID,using = "v_title_1")
    private WebElement tituloVacante;

    public String obtenerTituloVacante() {
        return tituloVacante.getText();
    }
}
