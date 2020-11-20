package Service.Management.Service.Management.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/")
public class CucumberRunnerTest extends Service.Management.Service.Management.cucumber.SpringIntegrationTest {

}
