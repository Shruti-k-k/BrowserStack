package modules;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.TestData;
import payload.pojo;

import static io.restassured.RestAssured.given;
import static modules.WebPage.prop;
import static modules.WebPage.transList;


public class TranslateToEnglish {
    public static void Translate(){

        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Response response = null;
        for (pojo payload : TestData.getPayloads()) {
            RestAssured.baseURI = prop.getProperty("baseUrl");

            response = given()
                    .header("Content-Type", "application/json")
                    .header("x-rapidapi-key", prop.getProperty("x-rapidapi-key"))
                    .header("x-rapidapi-host", "rapid-translate-multi-traduction.p.rapidapi.com")
                    .body(payload)
                    .when()
                    .post()
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            String s = response.getBody().asString();
            transList.add(s);

            }
        System.out.println("Translated Titles:");
        HeaderAnalysis.Header();
    }
}
