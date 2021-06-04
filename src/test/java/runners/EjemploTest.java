package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = {"src/test/resources/features/ejemplo.feature"},
        glue = {"steps"})
public class EjemploTest {

}