package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TelegramBotHelper {
    static String currentBotToken = "6161930810:AAGYrzHFYnBrw_ZLeT-LSGkcfyqQ4rtrsXo";
    static String currentChatId = "-1001891473243";
    public static String getUpdates(String token) {
        Response response = RestAssured.given()
                .param("offset", "1000")
                .when()
                .get("https://api.telegram.org/bot" + token + "/getUpdates");
        return response.getBody().asString();
    }

    public static void main(String[] args) {
        String updates = getUpdates(currentBotToken);
        System.out.println(updates);
    }
}


