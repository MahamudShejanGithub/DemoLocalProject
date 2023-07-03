import DataReader.JSONFileReader;
import Utilities.GenerateToken;
import Utilities.GenerateURL;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    private final Browser browser = AqualityServices.getBrowser();
    private final GenerateToken genarateToken = new GenerateToken();

    @BeforeTest
    public void goToURL() {
        browser.maximize();
        browser.goTo(GenerateURL.generateURL());
      //  genarateToken.setCookie();
        browser.refresh();
    }
    @AfterTest
    public void quit(){
        browser.quit();
    }
}
