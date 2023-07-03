package Utilities;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Cookie;

public class GenerateToken {
    private Browser browser = AqualityServices.getBrowser();
    private static final String uri= "http://localhost:8080/api";
    private static final String contentType="Content-Type";
    private static final String contentValue="application/json";
    private static final String variant="{\"variant\":3}";
    private static final String endPoint="/token/get";
    private static final String tokenName="token";
    private String getToken() {
        RestAssured.baseURI = uri;
        RequestSpecification request = RestAssured.given();
        request.header(contentType,contentValue );
        request.body(variant);
        Response response = request.post(endPoint);
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
        return responseBody;
    }
    public void setCookie(){
        Cookie cookie = new Cookie(tokenName,getToken());
        browser.getDriver().manage().addCookie(cookie);
    }
}