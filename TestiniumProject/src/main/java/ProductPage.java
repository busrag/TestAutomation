import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class ProductPage {

    private WebDriver driver;

    private final By productFeatures = By.cssSelector("#product-name");
    private final By featuresContainer = By.cssSelector("div[id='productTechSpecContainer']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    //private final By deneme = By.cssSelector("a[class='all-properties']");


    public void getProductFeatures(){

        String currentUrl3 = driver.getCurrentUrl();
        System.out.println("CURRENT URL33333" + currentUrl3);

        WebElement ulElement = driver.findElement(By.cssSelector("ul[data-bind='foreach: keyFeatures']"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        for (WebElement liElement : liElements) {
            String liText = liElement.getText();
            System.out.println(liText);
        }

    }


}
