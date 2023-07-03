package Utilities;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class HandlePopupText {
    public String popUpText(){
        return AqualityServices.getBrowser().getDriver().switchTo().alert().getText();
    }
}
