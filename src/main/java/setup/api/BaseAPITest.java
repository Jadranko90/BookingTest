package setup.api;

import helpers.CustomAssert;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;
import lombok.Setter;
import org.testng.asserts.SoftAssert;
import specification.request.CreateBookingRequest;
import specification.request.GetSingleBookingRequest;

@Getter
@Setter
public abstract class BaseAPITest {

    protected RequestSpecification request;
    protected ResponseSpecification responseSpecification;
    protected Response response;
    protected SoftAssert softAssert;
    protected CreateBookingRequest newBooking;
    protected GetSingleBookingRequest singleBooking;
    protected CustomAssert customAssert;

    public BaseAPITest() {
        this.softAssert = new SoftAssert();
        this.newBooking = new CreateBookingRequest();
        this.customAssert = new CustomAssert();
        this.singleBooking = new GetSingleBookingRequest();
    }
}
