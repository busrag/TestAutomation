import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private final By searchTextBox = By.cssSelector("input[placeholder='Ürün, kategori veya marka ara']");
    private final By searchButton = By.cssSelector("div[class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']");
    private final By cookieButton = By.cssSelector("button[id='onetrust-accept-btn-handler']");
    public HomePage(WebDriver driver){

        this.driver = driver;
    }


    public void setProductName(String productName){
        WebElement search_product = driver.findElement(searchTextBox);
        search_product.click();
        search_product.sendKeys(productName);
    }
    public String getProductName(){
        WebElement search_product = driver.findElement(searchTextBox);
        return search_product.getAttribute("value");
    }

    public void clickSearchButton(){
        WebElement search_button = driver.findElement(searchButton);
        search_button.click();
    }

    public void clickCookieButton(){
        WebElement cookie_button = driver.findElement(cookieButton);
        cookie_button.click();
    }
}
