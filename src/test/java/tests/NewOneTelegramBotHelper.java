package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class NewOneTelegramBotHelper{
        public String getLastMessage(String token) {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .get("https://api.telegram.org/bot" + token + "/getUpdates");

            String lastMessage = response.getBody().asString();

            return lastMessage;
        }

    public static void main(String[] args) {
        NewOneTelegramBotHelper newOneTelegramBotHelper = new NewOneTelegramBotHelper();
        String lastMessage = newOneTelegramBotHelper.getLastMessage("6046897362:AAGphVAZpT2C5InFMoZ0reJnxHM3spL1mbw");
        System.out.println(lastMessage);
    }
    }
