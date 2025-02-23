package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", //ruta de feature
        glue = "steps" ,   // Paquete donde tenemos nuestras clases definiendo steps
        plugin = { "pretty", "html:target/cucumber-reports" }, // Para Reporte


        //tags ="@AddToCart"  //Comentar para ejecutar TC2 
        tags ="@RemoveFromCart"     //Descomentar para ejecutar TC2
)


public class TestRunner {    //EJECUTAR DESDE TERMINAL 'gradle test' Y GENERA EL REPORTE EN 
                            // URL : https://reports.cucumber.io/report-collections/4f183132-3b7a-4cc3-8deb-eadcb89ffebe
    @AfterClass
    public static void cleanDriver() {

        BasePage.closeBrowser();

    }
}
