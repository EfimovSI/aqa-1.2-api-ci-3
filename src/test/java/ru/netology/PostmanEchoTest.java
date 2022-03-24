package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldPostSomeData() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(  "\"name\": \"Иван\",\r\n" +
                        "\"patronymic\": \"Петрович\",\r\n" +
                        "\"surname\": \"Кузнецов\"\r\n" +
                        "\"birthday\": \"13.06.1999\",\r\n" +
                        "\"passport\": \"1111 № 123456\",\r\n" +
                        "\"phone\": \"+7 (999)-999-99-99\""
                        ) // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("\"name\": \"Иван\",\r\n\"patronymic\": \"Петрович\",\r\n\"surname\": \"Кузнецов\"\r\n\"birthday\": \"13.06.1999\",\r\n\"passport\": \"1111 № 123456\",\r\n\"phone\": \"+7 (999)-999-99-99\""))
        ;
    }
}
