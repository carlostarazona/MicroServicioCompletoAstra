package Service.Management.Service.Management.cucumber;

import Service.Management.Service.Management.ServiceManagementApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest(classes = ServiceManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {
    static Service.Management.Service.Management.cucumber.ResResults latestResponse = null;
    public static HttpStatus response;

    @Autowired
    protected RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8091/";

    void executeGet(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final Service.Management.Service.Management.cucumber.HeaderCallbackSettings requestCallback = new Service.Management.Service.Management.cucumber.HeaderCallbackSettings(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(BASE_URL + url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResults());
            } else {
                return (new Service.Management.Service.Management.cucumber.ResResults(response));
            }
        });
    }

    public void makePost(String url, Object body) throws IOException {
        if (body != null){
            HttpEntity<Object> request = new HttpEntity<>(body);
            response = restTemplate
                    .exchange(BASE_URL+url, HttpMethod.POST, request, String.class).getStatusCode();
        }
        else {
            response = HttpStatus.BAD_REQUEST;
        }


    }
    private static class ResponseResultErrorHandler implements ResponseErrorHandler {
        private Service.Management.Service.Management.cucumber.ResResults results = null;
        private Boolean hadError = false;

        private Service.Management.Service.Management.cucumber.ResResults getResults() {
            return results;
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            hadError = response.getRawStatusCode() >= 400;
            return hadError;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            results = new Service.Management.Service.Management.cucumber.ResResults(response);
        }
    }

}
