package com.mysolutions.startrisk.controller;

import com.mysolutions.startrisk.StartRiskApplication;
import com.mysolutions.startrisk.entity.User;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = StartRiskApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class UserControllerTest {

	@LocalServerPort
	private int port;

	@Before
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

	@Test
	public void saysHello() {
		when()
			.get("/api/hello")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body(is(equalTo(UsersController.HELLO_TEXT)));
	}

	@Test
    public void addNewUserAndRetrieveItBack() {
        User rostyslavMazepa = new User("Rostyslav","Y.", "Mazepa", "rmazepa","MR", true);

        Long userId =
            given()
                .queryParam("firstName", "Rostyslav")
				.queryParam("middleName", "Y.")
                .queryParam("lastName", "Mazepa")
				.queryParam("username", "rmazepa")
				.queryParam("password", "MR")
				.queryParam("active", "1")
            .when()
                .post("/api/user")
            .then()
                .statusCode(is(HttpStatus.SC_CREATED))
                .extract()
                    .body().as(Long.class);

	    User responseUser =
            given()
                    .pathParam("id", userId)
                .when()
                    .get("/api/user/{id}")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .assertThat()
                        .extract().as(User.class);

	    // Did Norbert came back?
        assertThat(responseUser.getFirstName(), is("Rostyslav"));
        assertThat(responseUser.getLastName(), is("Mazepa"));
    }

}
