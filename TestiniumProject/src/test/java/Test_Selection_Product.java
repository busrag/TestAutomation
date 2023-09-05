import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Test_Selection_Product extends Test_Searching_Product{

    @Test
    public void deneme(){
        System.out.println("denemelercee");
    }

    @Test
    public void randomSelectionPc(){

        searchResultPage.randomSelectionPc();
        System.out.println("RANDOM ELEMENT SEÇTİİİİİİ");
        searchResultPage.switchURL();
        searchResultPage.getProductFeatures2();

    }


}
