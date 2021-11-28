package testing.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testing.voidmethods.MovieRecordServerStub;
import testing.voidmethods.MovieType;
import testing.voidmethods.Pricer;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefs {

    private MovieRecordServerStub movieRecordServer;
    private Pricer pricer;

    @Given("The movie record server exists")
    public void movieRecordServerExists() {
        movieRecordServer = new MovieRecordServerStub();
        pricer = new Pricer(movieRecordServer);
    }

    // TODO pass in enum
    @When("Pricer asks for data for id {string} film name {string} movie type {string} and amount {int}")
    public void movieRecordServerExists(String id, String filmName, String movieType, int amount) {
        final MovieType movieTypeEnum = MovieType.valueOf(movieType);
        pricer.receiveOrderRecord(id, filmName, movieTypeEnum, amount);
    }

    @Then("The price stored in movie record server is {float}")
    public void useTestRepository(float price) {
        assertThat(movieRecordServer.getPrice()).isEqualTo(price);
    }
}
