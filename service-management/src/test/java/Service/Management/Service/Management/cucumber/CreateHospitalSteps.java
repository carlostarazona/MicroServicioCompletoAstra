package Service.Management.Service.Management.cucumber;


import Service.Management.Service.Management.entities.Hospital;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CreateHospitalSteps extends SpringIntegrationTest {


    @Given("a Manager in the Hospitals view")
    public void a_manager_in_the_hospitals_view() {
    }

    @When("the Manager clicks the get button")
    public void the_manager_clicks_the_get_button() {
    }

    @When("make a get request to {string}")
    public void make_a_get_request_to(String string) throws IOException {
        executeGet(string);
    }

    @Then("the result received has a status code of {int}")
    public void the_result_received_has_a_status_code_of(Integer int1) {
    }


}
