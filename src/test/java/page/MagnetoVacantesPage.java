package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MagnetoVacantesPage {
    private WebDriver driver;

    public MagnetoVacantesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME,using = "font-company-primary")
    private WebElement primerTitulo;
    @FindBy(how = How.CLASS_NAME,using = "offerTitle")
    private WebElement segundoTitulo;
    @FindBy(how = How.CSS,using = "div[class=numberOffer] > h3 > span")
    private WebElement cantidadOfertas;
    @FindBy(how = How.CSS,using = "h2[id^=v_title_]")
    private List<WebElement> titulosVacantes;
    @FindBy(how = How.LINK_TEXT,using = "Ver oferta completa")
    private List<WebElement> verOfertas;


    public String obtenerPrimerTitulo(){
        return primerTitulo.getText();
    }
    public String obtenerSegundoTitulo(){
        return segundoTitulo.getText();
    }
    public boolean tamañoListaVacantes(){
        return Integer.parseInt(cantidadOfertas.getText())==titulosVacantes.size();
    }
    public List<String> obtenerNombresVacantes(){
        List<String> nombres = new ArrayList<>();
        for (int i=0; i<titulosVacantes.size();i++){
            nombres.add(titulosVacantes.get(i).getText());
        }
        return nombres;
    }

    public void clickVerOferta(int pos){
        verOfertas.get(pos).click();
    }
}
