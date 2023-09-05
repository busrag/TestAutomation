import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_Searching_Product extends BaseTest {

    @Test
    public void clickCookieButton(){
        homePage.clickCookieButton();
    }

    @Test
    public void setSearchBox(){
        homePage.setProductName("Bilgisayar");
        Assertions.assertEquals("Bilgisayar", homePage.getProductName(), "Farklı bir ürün arandı.");
    }

    @Test
    public void clickSearchButton(){
        homePage.clickSearchButton();
        System.out.println("Arama Butonuna Tıklandı");
    }

    @Test
    public void getCategoryList(){
        searchResultPage.getCategoryList();

        System.out.println("LİSTELENDİ");
        Assertions.assertTrue(searchResultPage.checkedCategoryPath(), "Ürün çeşidi görülemiyor.");
    }

}
