package org.drools.demo;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@QuarkusTest
public class RequestsTest {
    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testHelloEndpoint() throws Exception {
        final var JSON = """
                {
                    "requests": [
                        {"type": "type1"},
                        {"type": "type2"}
                    ]
                }
                """;
        final String response = given()
          .when()
          .body(JSON)
          .contentType(ContentType.JSON)
          .post("/results")
          .then()
          .statusCode(200)
          .extract()
          .asString();

        List<Request> resultValues = new ObjectMapper().readValue(response, new TypeReference<List<Request>>() {});
        assertThat(resultValues)
            .containsExactlyInAnyOrder(
                new Request("type1", true, "from a rule in rules1.drl"),
                new Request("type2", false, "from a rule in rules2.drl")
            );
    }

}