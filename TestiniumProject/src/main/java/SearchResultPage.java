import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SearchResultPage {

    private WebDriver driver;

    private final By productList = By.cssSelector("div[data-test-id='tree-container']");  //ürün çeşitlerini içeren conteiner
    private final By productListHorizontal = By.cssSelector("div[class='carousel-glZv6nYnxWVlQmiSkjNO']"); //yataydaki ürün çeşit filtresi
    private final By pcList = By.cssSelector("ul[id='1']");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getCategoryList() {
        WebElement categoryList = driver.findElement(productList);
        List<WebElement> category = categoryList.findElements(By.cssSelector("div[class='treeCategoryContent-XPVj5InCxOWIJtyTC35Z']"));

        for (WebElement altDiv : category) {

            if (altDiv.getText().equals("Dizüstü Bilgisayar Laptop")) {
                System.out.println(altDiv.getText());

                altDiv.click();
                //new WebDriverWait(driver, Duration.ofSeconds(5));

            }

        }
    }

    public boolean checkedCategoryPath() {
        boolean isCheckedUrunCesidi = false;

        WebElement pc_list = driver.findElement(productListHorizontal);
        List<WebElement> category_horizontal = pc_list.findElements(By.tagName("span"));

        for (WebElement alt : category_horizontal) {

            if (alt.getText().equals("Dizüstü Bilgisayar Laptop")) {
                System.out.println(alt.getText());
                isCheckedUrunCesidi = true;
            }
        }
        return isCheckedUrunCesidi;
    }

    public void randomSelectionPc() {

        WebElement pc_list = driver.findElement(pcList);
        List<WebElement> pc = pc_list.findElements(By.tagName("li"));

        // Liste boyutunu alarak rastgele bir sayı üretme
        int listSize = pc.size();
        Random random = new Random();
        int randomIndex = random.nextInt(listSize);

        // Rastgele seçilen li öğesini alıp üzerinde işlemler yapma
        WebElement randomPc = pc.get(randomIndex);

        randomPc.getAttribute("href");

        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //  String winHandleBefore = driver.getWindowHandle();

        randomPc.click();
    }

    public void switchURL(){

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                // Hedef pencereye geçiş yapın
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //driver.close();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL" + currentUrl);
    }

    public void getProductFeatures2(){

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
