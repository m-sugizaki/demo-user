package com.example.api;

import org.junit.Test;
import io.restassured.RestAssured;

import static io.restassured.matcher.ResponseAwareMatcher.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserRestControllerIntegrationTest {

	private static String postJson = "{\"id\": 9, \"name\": \"Test Taro\", \"pass\": \"testtaro\"}";
	private static String putJson = "{\"id\": 9, \"name\": \"Update Taro\", \"pass\": \"updatetaro\"}";
	
    @Test
    public void メンバー一覧() {
        RestAssured.baseURI = "http://13.115.40.246:8081";
        given()
        .get("/users/")
        .then()
        	.body("id[0]", equalTo(1))
        	.body("name[0]", equalTo("杉崎　睦"))
        	.body("pass[0]", equalTo("sugisugi"))
        	.body("id[1]", equalTo(2))
        	.body("name[1]", equalTo("中森健"))
        	.body("pass[1]", equalTo("01234567"))
        	// .log().body()
        ;
    }

    @Test
    public void メンバー詳細() {
        RestAssured.baseURI = "http://13.115.40.246:8081";
        given()
        .get("/users/1")
        .then()
            .body("id", equalTo(1))
            .body("name", equalTo("杉崎　睦"))
            .body("pass", equalTo("sugisugi"))
         	// .log().body()
        ;
    }

    @Test
    public void メンバー登録() {
        RestAssured.baseURI = "http://13.115.40.246:8081";
        given()
        .contentType("application/json\r\n")
        .body(postJson) // Request Body の設定
        .post("/users")
        .then()
            .body("id", equalTo(9))
        	.body("name", equalTo("Test Taro"))
        	.body("pass", equalTo("testtaro"))
            // .log().body()
        ;
    }

    @Test
    public void メンバー更新() {
        RestAssured.baseURI = "http://13.115.40.246:8081";
        given()
        .contentType("application/json\r\n")
        .body(putJson) // Request Body の設定
        .put("/users/9")
        .then()
        	.body("id", equalTo(9))
        	.body("name", equalTo("Update Taro"))
        	.body("pass", equalTo("updatetaro"))
           	// .log().body()
        ;
    }

    @Test
    public void メンバー削除() {
        RestAssured.baseURI = "http://13.115.40.246:8081";
        given()
        .contentType("application/json\r\n")
        .delete("/users/9")
        .then()
        	.statusCode(204)
        	// .log().all()
        ;
    }
}
