package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class StepDefinitions {
    @Dado("es Given en inglés")
    public void es_given_en_inglés() {
        System.out.println("Se ejecuta el primer paso");
    }
    @Cuando("es When en inglés")
    public void es_when_en_inglés() {
        System.out.println("Se ejecuta el segundo paso");

    }
    @Entonces("es Then en inglés")
    public void es_then_en_inglés() {
        System.out.println("Se ejecuta el tercer paso");

    }
}
