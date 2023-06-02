package specification.request;

import POJO.request.authorization.LogInRequestBody;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.constans.Endpoints;

public class LogIn {

    public Response logIn(String email, String password) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URI)
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .relaxedHTTPSValidation();

        LogInRequestBody requestBody = new LogInRequestBody(email, password);
        request.body(requestBody);
        return request.post(Endpoints.AUTH);
    }
}
