package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class q {

    static String currentBotToken = "6161930810:AAGYrzHFYnBrw_ZLeT-LSGkcfyqQ4rtrsXo";

    public static String getUpdates(int offset, int limit) {
        Response response = RestAssured.given()
                .param("offset", offset)
                .param("limit", limit)
                .when()
                .get("https://api.telegram.org/bot" + currentBotToken + "/getUpdates");
        return response.getBody().asString();
    }

    public static void main(String[] args) {
        String updates = getUpdates(10, 100);
        System.out.println(updates);
    }
}
