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


        tags ="@TC01"  //Comentar para ejecutar TC2 
        //tags ="@TC02"     //Descomentar para ejecutar TC2
)


public class TestRunner {    //EJECUTAR DESDE TERMINAL 'gradle test' Y GENERA EL REPORTE EN 
                            // URL : https://reports.cucumber.io/report-collections/4f183132-3b7a-4cc3-8deb-eadcb89ffebe
    @AfterClass
    public static void cleanDriver() {

        BasePage.closeBrowser();

    }
}

/*
 * Para ejecutar es recomendable tener instalado
 * JDK - Gradle 
 * Las extenciones
 * 1. Java Extension Pack
 * 2. Gradle For Java
 * 3. Gradle Language Support
 * 4.Cucumber
 * 5.Cucumber (Gherkin)
 * 6.Snippets And Syntax
 */