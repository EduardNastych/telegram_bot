package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class qwerty {
    public static void main(String[] args) {

        Response response = RestAssured.given()
                .param("chat_id", "alliance_ps_test_bot")
                .param("limit", "100") // Опціонально: кількість повідомлень, які необхідно отримати
                .when()
                .get("https://api.telegram.org/bot" + "6161930810:AAGYrzHFYnBrw_ZLeT-LSGkcfyqQ4rtrsXo" + "/getChannelHistory");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }
}
