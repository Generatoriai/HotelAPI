package lt.viko.eif.generatoriai.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.generatoriai.demo.api.CoordinatesAPI;
import lt.viko.eif.generatoriai.demo.controllers.HotelResourceController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Step definition class for cucumber testing of recourse controllers.
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
public class StepDefinitions {
    private ResponseEntity entity;
    private String actualAnswer;
    HotelResourceController hrc = new HotelResourceController();
    private String correctCity = "Vilnius";
    String responseString;

    @Given("Client sends a GET request")
    public void Client_sends_a_GET_request(){
        entity = hrc.getAllHotel("Vilnius");
    }

    @When("Sends GET HTTP request")
    public void Sends_GET_HTTP_request(){
        actualAnswer = String.valueOf(entity.getStatusCodeValue());
    }

    @Then("Client receives a valid HTTP response code {string}")
    public void Client_receives_a_valid_HTTP_response_code(String expectedAnswer){
        assertEquals(expectedAnswer, actualAnswer);
    }


    @Given("Client sends a GET request with a specified city")
    public void clientSendsAGETRequestWithASpecifiedCity() throws IOException {
        responseString = CoordinatesAPI.getResponse(correctCity);
    }

    @When("Sends HTTP GET request")
    public void sendsHTTPGETRequest() throws IOException, ParseException{
        actualAnswer = getResponse();
    }

    @Then("Client receives a correct output")
    public void clientReceivesACorrectOutput() {
        assertEquals(actualAnswer,correctCity);
    }

    String getResponse() throws IOException, ParseException {
        JSONParser parse = new JSONParser();
        JSONObject jsonObject = (JSONObject) parse.parse(CoordinatesAPI.getResponse(correctCity));

        JSONArray jsonarr_1 = (JSONArray) jsonObject.get("results");
        for (int i = 0; i < jsonarr_1.size(); i++) {
            System.out.println(jsonarr_1.get(i));
        }

        JSONObject listObject = (JSONObject) jsonarr_1.get(0);
        String city = String.valueOf(listObject.get("locality"));

        return city;
    }
}
