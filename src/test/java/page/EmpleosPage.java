package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpleosPage {
    private WebDriver driver;

    public EmpleosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS,using = ".elementor-element-d1f45a7 .elementor-button-text")
    private WebElement btnIrPortalEmpleos;
    @FindBy(how = How.CSS,using = ".elementor-size-sm")
    private WebElement btnPopUpContinuar;

    public String obtenerTitulo(){
        return driver.getTitle();
    }

    public void ingresarPortalEmpleos(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        js.executeScript("arguments[0].click();", btnIrPortalEmpleos);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(btnPopUpContinuar));
        btnPopUpContinuar.click();
    }

}
