package steps;

import com.github.javafaker.Faker;
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
    private MagnetoRegistrarPage magnetoRegistrarPage;

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
        posVacante = aleatorio.nextInt(nombresVacantes.size()-1);
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

    @Cuando("Hago click en Aplicar a esta oferta")
    public void hago_click_en_aplicar_a_esta_oferta() {
      magnetoVacantesPage.clickAplicarOferta(posVacante);
    }
    @Cuando("Se selecciona la ubicación")
    public void se_selecciona_la_ubicación() {
        magnetoRegistrarPage = new MagnetoRegistrarPage(driver);
        magnetoRegistrarPage.seleccionAleatoriaPais();
    }
    @Cuando("diligencio el correo electrónico en los campos indicados")
    public void diligencio_el_correo_electrónico_en_los_campos_indicados() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        System.out.println("El email generado es: ".concat(email));
        magnetoRegistrarPage.escribirCorreoElectronico(email);
    }
    @Cuando("Acepto el tratamiento de datos")
    public void acepto_el_tratamiento_de_datos() {
        magnetoRegistrarPage.hacerClickCheckTratamientoDatos();
    }
    @Cuando("doy click en continuar")
    public void doy_click_en_continuar() {
        magnetoRegistrarPage.clickContinuarRegistro();
    }
    @Entonces("El sistema me indica el nombre de la vacante a la que estoy aplicando")
    public void el_sistema_me_indica_el_nombre_de_la_vacante_a_la_que_estoy_aplicando() {
        Assert.assertEquals("El nombre mostrado no corresponde a la vacante seleccionada.", "Estás postulando a: "+nombresVacantes.get(posVacante), magnetoRegistrarPage.obtenerNombreVacantePostulacion());

    }
}
