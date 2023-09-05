import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productpage;


    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BGE\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.hepsiburada.com/");

        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        //productpage = new ProductPage(driver);
    }

    @AfterAll
    public void tearDown(){
        //driver.quit();
    }
}
