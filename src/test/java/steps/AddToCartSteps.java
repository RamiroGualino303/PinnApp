package steps;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Store;


public class AddToCartSteps {

    Store Store = new Store();
    
    @Given("^navego a la página de OpenCart$")
    public void navigateToWeb(){
        Store.navigateToStore();
       Assert.assertEquals("Your Store", Store.validateTxtYourStore()); // Valida estar en Home de la pagina
    }

    @When("^busco el producto iPhone$")
    public void SearchIphone (){
        Store.writeSearch("IPhone");
        Store.clickSearch();
        Assert.assertEquals("iPhone", Store.validateTxtSearchStore());  // Valida que se haya buscado correctamente
    }

    @And("^Selecciono el producto$")
    public void ClickProduct(){
        Store.clickProduct1();
    }

    @And("^agrego el producto al carrito$")
    public void AddToCartIphone(){
        Store.clickAddToCart();
        Assert.assertEquals("iPhone", Store.validateMsjSuccessProduct()); // Valida mensaje verde de success add cart iphone
        Assert.assertEquals("shopping cart", Store.validateMsjSuccessCart()); // Valida mensaje verde de success add cart

    }

    @Then("^el producto debería aparecer en el carrito$")
    public void validateResults(){
        Store.clickCart();
        Assert.assertEquals("1 item(s) - $123.20", Store.validateBtnCart());  // Valida que el boton del carrito la cantidad de productos seleccionados y el precio
        Assert.assertEquals("iPhone", Store.validateProductBtnCart1());        // Valida producto 1 en el boton carrito
        Assert.assertEquals("x 1", Store.validateTxtTotalCart());        // Valida cantidad de producto 1 en el carrito
        Store.clickViewCart();
        Assert.assertEquals("iPhone ***", Store.validateTxtViewCartProduct1());      // Valida nombre del producto del carrito
        Assert.assertEquals("$123.20", Store.validatePrice());           // Valida Precio del producto
       assertTrue("Se encotro el elemento Localizacion",Store.validateElementViewCartProduct1());// comprueba que el producto 1 este visible

    }
    
}
