package JsMethod;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.openqa.selenium.JavascriptExecutor;

public class JsScripts {
    Browser browser = AqualityServices.getBrowser();
    public void closePopUp(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("closePopUp();");
    }
}
