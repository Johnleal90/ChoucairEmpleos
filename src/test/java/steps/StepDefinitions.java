package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StepDefinitions {

    private WebDriver driver = Hooks.getDriver();
    private EmpleosPage empleosPage;
    private List<String> nombresVacantes = new ArrayList<>();
    private MagnetoVacantesPage magnetoVacantesPage;
    private int posVacante;

    @Dado("que ingreso a la sección de empleos de choucair")
    public void queIngresoALaSecciónDeEmpleosDeChoucair() {
        HomePage index = new HomePage(driver);
        index.ingresarSeccionEmpleo();
        empleosPage = new EmpleosPage(driver);
        Assert.assertEquals("No se obtuvo el título esperado", "empleos testing – Choucair Testing", empleosPage.obtenerTitulo());
    }

    @Cuando("voy al portal de empleos")
    public void voyAlPortalDeEmpleos() {
        empleosPage.ingresarPortalEmpleos();
    }

    @Y("hago click en enlace de nuestras vacantes")
    public void hagoClickEnEnlaceDeNuestrasVacantes() {
        MagnetoHomePage magnetoHomePage = new MagnetoHomePage(driver);
        magnetoHomePage.ingresarNuestrasVacantes();
    }

    @Entonces("Se muestran las ofertas laborales")
    public void seMuestranLasOfertasLaborales() {
        magnetoVacantesPage = new MagnetoVacantesPage(driver);
        Assert.assertEquals("No se obtuvo el título1 esperado", "Ofertas Laborales", magnetoVacantesPage.obtenerPrimerTitulo());
        Assert.assertEquals("No se obtuvo el título2 esperado", "Regístrate y crea tu Video Currículum para aplicar a las vacantes en choucair", magnetoVacantesPage.obtenerSegundoTitulo());
        Assert.assertTrue("La cantidad de vacantes ofertadas no coinciden con el número mostrado.", magnetoVacantesPage.tamañoListaVacantes());
        nombresVacantes = magnetoVacantesPage.obtenerNombresVacantes();
    }


    @Dado("Me ubico en alguna vacante de la lista")
    public void hagoClickEnVerOfertaCompletaDeAlgunaVacanteDeLaLista() {
        Random aleatorio = new Random();
        posVacante = aleatorio.nextInt(nombresVacantes.size());
        System.out.println("El nombre de la vacante escogido es: " + nombresVacantes.get(posVacante));

    }

    @Cuando("Hago click en ver oferta completa")
    public void hagoClickEnVerOfertaCompleta() {
        magnetoVacantesPage.clickVerOferta(posVacante);

    }

    @Entonces("El sistema muestra toda la información de la vacante")
    public void elSistemaMuestraTodaLaInformaciónDeLaVacante() {
        MagnetoDetalleVacantePage magnetoDetalleVacantePage = new MagnetoDetalleVacantePage(driver);
        Assert.assertEquals("El detalle mostrado no corresponde a la vacante seleccionada.", nombresVacantes.get(posVacante), magnetoDetalleVacantePage.obtenerTituloVacante());
    }
}
