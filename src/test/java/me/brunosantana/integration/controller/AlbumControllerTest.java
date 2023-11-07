package me.brunosantana.integration.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.wiremock.integrations.testcontainers.WireMockContainer;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
class AlbumControllerTest {

  @LocalServerPort private Integer port;

  @Container
  static WireMockContainer wiremockServer =
      new WireMockContainer("wiremock/wiremock:2.35.0")
          .withMapping("photos-by-album", AlbumControllerTest.class, "mocks-config.json");

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("photos.api.base-url", wiremockServer::getBaseUrl);
  }

  @BeforeEach
  void setUp() {
    RestAssured.port = port;
  }

  @Test
  void shouldGetAlbumById() {
    Long albumId = 1L;

    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/albums/{albumId}", albumId)
        .then()
        .statusCode(200)
        .body("albumId", is(albumId.intValue()))
        .body("photos", hasSize(1));
  }
}
