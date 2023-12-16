package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostBooking {

    String content ="";
    RequestSpecification reqSpec;
    Response res;

    @Given("User wants to make a reservation for a room")
    public void setBody() throws IOException {
        Path path = Paths.get("src/resources/BookingPayload.json");
        content = new String(Files.readAllBytes(path));
        System.out.println(content);
        reqSpec =
        given().
                contentType("application/json").
                body(content);

    }
    @When("Making the call")
    public void postBooking() throws IOException {
        res = reqSpec.
        when().
                post("http://localhost:8080/booking/");
    }

    @Then("Customer should successfully reserve the room")
    public void assertBooking() throws IOException {

        res.
        then().
                statusCode(201)
                .body("booking.firstname", equalTo("Jams"),
                        "booking.depositpaid", equalTo(true)).log().all();

    }
}
