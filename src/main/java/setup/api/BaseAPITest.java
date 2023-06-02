package setup.api;

import POJO.request.create_booking.CreateBookingRequestBody;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;
import lombok.Setter;
import org.testng.asserts.SoftAssert;
import specification.request.CreateBookingRequest;

@Getter
@Setter
public abstract class BaseAPITest {

    protected RequestSpecification request;
    protected ResponseSpecification responseSpecification;
    protected Response response;
    protected SoftAssert softAssert;
    protected CreateBookingRequest newBooking;


    public BaseAPITest() {

        this.softAssert = new SoftAssert();
        this.newBooking = new CreateBookingRequest();
    }
}
