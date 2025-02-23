package steps;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Store;

public class RemoveFromCartSteps {

    Store Store = new Store();
    
    @Given("^que estoy en la página principal de OpenCart$")
    public void navigateToWeb(){
        Store.navigateToStore();
        Assert.assertEquals("Your Store", Store.validateTxtYourStore()); // Valida estar en Home de la pagina
    }

    @When("^busco el producto Iphone$")
    public void SearchIphone (){
        Store.writeSearch("Iphone");
        Store.clickSearch();
        Assert.assertEquals("iPhone", Store.validateTxtSearchStore());  // Valida que se haya buscado correctamente
        Store.clickProduct1();
    }

    @And("^agrego el iphone al carrito$")
    public void AddToCartIphone(){
        Store.clickAddToCart();   
        Assert.assertEquals("iPhone", Store.validateMsjSuccessProduct()); // Valida mensaje verde de success add cart iphone
        Assert.assertEquals("shopping cart", Store.validateMsjSuccessCart()); // Valida mensaje verde de success add cart
        Assert.assertEquals("1 item(s) - $123.20", Store.validateBtnCart());  // Valida que el boton del carrito la cantidad de productos seleccionados y el precio
    }

    @And("^busco el producto Laptop$")
    public void ClickIphone(){
        Store.writeSearch("MacBook");
        Store.clickSearch();
        Assert.assertEquals("MacBook", Store.validateTxtSearchStore());  // Valida que se haya buscado correctamente
        Store.clickProduct1();
        
    }
    @And("^agrego Laptops al carrito$")
    public void AddToCartLaptops(){
        Store.clickAddToCart();  
        Assert.assertEquals("MacBook", Store.validateMsjSuccessProduct());   // Valida mensaje verde de success add cart MacBook
        Assert.assertEquals("shopping cart", Store.validateMsjSuccessCart());// Valida mensaje verde de success add cart
    }

    @And("^verifico que ambos productos estén en el carrito$")
    public void ValidateCart() throws InterruptedException{
        Store.clickCart();
        Assert.assertEquals("iPhone", Store.validateProductBtnCart1());        // Valida producto 1 en el carrito
        Assert.assertEquals("MacBook", Store.validateProductBtnCart2());        // Valida producto 2 en el carrito
        Store.clickViewCart();
        Assert.assertEquals("iPhone ***", Store.validateTxtViewCartProduct1()); // Valida producto 1 dentro del carrito
        Assert.assertEquals("MacBook ***\n" + //
                        "Reward Points: 600", Store.validateTxtViewCartProduct2());// Valida producto 2 dentro del carrito
        //Thread.sleep(10000);

    }

    @And("^elimino uno de los productos del carrito$")
    public void RemoveIphone() throws InterruptedException{
        Assert.assertEquals("2 item(s) - $725.20", Store.validateBtnCart()); // Valido que el carrito tenga 2 productos
        Store.clickRemoveProduct();
        Thread.sleep(2000);
    }

    @Then("^el producto eliminado no debería estar en el carrito$")
    public void validateResults()  {
        assertTrue("Se encotro el producto 1",Store.validateElementViewCartProduct1());// comprueba que el producto 1 este visible
        Assert.assertEquals("$602.00", Store.validatePrice());           // Valida Precio del producto
        Assert.assertEquals("1 item(s) - $602.00", Store.validateBtnCart()); // Valida que el carrito quede solo con la MacBook
       Assert.assertEquals("MacBook ***\n" + //
        "Reward Points: 600", Store.validateTxtViewCartProduct1()); // Valida que se haya eliminado el producto correcto
    }
    
}
