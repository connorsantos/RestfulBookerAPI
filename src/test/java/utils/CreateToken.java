package utils;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateToken {
    HashMap<String, String> hashMap = new HashMap<String, String>();

    @Test
    void createToken(){
        hashMap.put("username", "admin");
        hashMap.put("password", "password");
        String token =
        given()
            .contentType("application/json")
            .body(hashMap)
        .when()
            .post("https://automationintesting.online/auth/login")
            .getCookie("token");
        System.out.println(token);
    }


}
