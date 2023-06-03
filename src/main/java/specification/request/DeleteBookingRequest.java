package specification.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.constans.Endpoints;

public class DeleteBookingRequest {

    public Response delete (String token, int bookingId) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URI)
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .relaxedHTTPSValidation();
        return request.header("Cookie", token)
                .delete(Endpoints.GET_BOOKING , bookingId);
    }
}
