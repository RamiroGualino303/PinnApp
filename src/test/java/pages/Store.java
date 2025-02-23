package pages;

public class Store extends BasePage {

    private String search = "//header/div[1]/div[1]/div[2]/div[1]/input[1]";
    private String ButtonSearch = "//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]";
    private String ButtonProduct1 = "//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]";
    private String ButtonAddToCart ="//button[@id='button-cart']";
    private String ButtonCart ="//header/div[1]/div[1]/div[3]/div[1]/button[1]";
    private String ButtonViewCart ="//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]/strong[1]";
    private String ButtonCart2 = "//header/div[1]/div[1]/div[3]/div[1]/button[1]";
    private String ButtonRemoveProduct = "//tbody/tr[1]/td[4]/div[1]/span[1]/button[2]";

    public Store(){
        super(driver);
    }
    
    public void navigateToStore(){
        navigateTo("http://opencart.abstracta.us/");
    }

    public void writeSearch(String criteria) {
        write(search, criteria);
    }

    public void clickRemoveProduct(){
        clickElement(ButtonRemoveProduct);
    }

    public void clickSearch(){
        clickElement(ButtonSearch);
    }

    public void clickProduct1(){
        clickElement(ButtonProduct1);
    }

    public void clickAddToCart(){
        clickElement(ButtonAddToCart);
    }

    public void clickCart(){
        clickElement(ButtonCart);
    }
    
    public void clickViewCart(){
        clickElement(ButtonViewCart);
    }

    public void clickCart2(){
        clickElement(ButtonCart2);
    }

    //Validaciones
                                        
    public String txtBtnCartProduct1 =  "//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]";                                    
    public String txtBtnCartProduct2 = "//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/table[1]/tbody[1]/tr[2]/td[2]/a[1]";
    public String txtPrice ="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]";
    public String BtnCart ="//header/div[1]/div[1]/div[3]/div[1]/button[1]";
    public String FotoIphone ="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]";
    public String QuantityCart = "//tbody/tr[1]/td[4]/div[1]/input[1]";
    private String MsjSuccessCart = "//a[contains(text(),'shopping cart')]";
    private String TxtYourStore = "//a[contains(text(),'Your Store')]";
    private String TxtSearchStore = "//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]";
    private String TxtTotalCart = "//td[contains(text(),'x 1')]";
    private String MsjSuccessProduct = "//body/div[@id='product-product']/div[1]/a[1]";
    private String TxtProductCart1 = "//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]";
    private String TxtProductCart2 = "//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]";

    public String validateProductBtnCart1(){
        return textFromElement(txtBtnCartProduct1);
    }

    public String validateProductBtnCart2(){
        return textFromElement(txtBtnCartProduct2);
    }


    public String validatePrice(){
        return textFromElement(txtPrice);
    }

    public String validateBtnCart(){
        return textFromElement(BtnCart);
    }

    public String validateFotoIphone(){
        return textFromElement(FotoIphone);
    }

    public String validateMsjSuccessCart(){
        return textFromElement(MsjSuccessCart);
    }

    public String validateMsjSuccessProduct(){
        return textFromElement(MsjSuccessProduct);
    }

    public String validateTxtYourStore(){
        return textFromElement(TxtYourStore);
    }

    public String validateTxtSearchStore(){
        return textFromElement(TxtSearchStore);
    }

    public String validateTxtTotalCart(){
        return textFromElement(TxtTotalCart);
    }

    public String validateTxtViewCartProduct1(){
        return textFromElement(TxtProductCart1);
    }

    public String validateTxtViewCartProduct2(){
        return textFromElement(TxtProductCart2);
    }

    public boolean validateElementViewCartProduct2(){
        return elementIsDisplayed(TxtProductCart2);
    }

    public boolean validateElementViewCartProduct1(){
        return elementIsDisplayed(TxtProductCart1);
    }

}

