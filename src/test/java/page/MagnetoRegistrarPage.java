package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class MagnetoRegistrarPage {
    private WebDriver driver;

    public MagnetoRegistrarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS,using = "#wrapperRegister > div.signup-country-container > div > div.signup-country-container__countries > div > label>span>img")
    private List<WebElement> listaPaises;
    @FindBy(how = How.CSS,using = "#wrapperRegister > div.signup-country-container > div > div.signup-country-container__submit > button > span")
    private WebElement btncontinuar;
    @FindBy(how = How.ID,using = "emailId")
    private WebElement inputEmail;
    @FindBy(how = How.ID,using = "emailConfirmationId")
    private WebElement inputConfirmarEmail;
    @FindBy(how = How.ID,using = "formBasicCheckbox")
    private WebElement checkTratamientosDatos;
    @FindBy(how = How.ID,using = "d-correo")
    private WebElement btnContinuarRegistro;
    @FindBy(how = How.CSS,using = "#wrapperRegister > div.subnav.subnavRegister > div > div > div.signup-title.d-none.d-sm-block.text-center.mb-3")
    private WebElement confirmacionNombreVacante;

    private WebDriverWait wait;

    public void seleccionAleatoriaPais(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(btncontinuar)
        ));

        Random aleatorio = new Random();
        listaPaises.get(aleatorio.nextInt(listaPaises.size()-1)).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btncontinuar);

    }

    public void escribirCorreoElectronico(String correo){
        inputEmail.sendKeys(correo);
        inputConfirmarEmail.sendKeys(correo);
    }

    public void hacerClickCheckTratamientoDatos(){
        checkTratamientosDatos.click();
    }
    public void clickContinuarRegistro(){
        btnContinuarRegistro.click();
    }
    public String obtenerNombreVacantePostulacion(){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(confirmacionNombreVacante)
        ));
        System.out.println("Nombre postulación: "+confirmacionNombreVacante.getText());
        return confirmacionNombreVacante.getText();
    }
}
