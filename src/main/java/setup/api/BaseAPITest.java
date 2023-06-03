package setup.api;

import data.handling.DataCleanUp;
import data.handling.DataPreparation;
import helpers.CustomAssert;
import helpers.TokenGenerator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;
import specification.request.CreateBookingRequest;
import specification.request.DeleteBookingRequest;
import specification.request.GetSingleBookingRequest;
import specification.request.UpdateBookingRequest;

import static setup.constans.UserDetails.PASSWORD;
import static setup.constans.UserDetails.USERNAME;

@Getter
@Setter
public abstract class BaseAPITest {

    protected RequestSpecification request;
    protected ResponseSpecification responseSpecification;
    protected Response response;

    protected TokenGenerator token;
    protected DataPreparation preparedData;

    protected CreateBookingRequest newBooking;
    protected GetSingleBookingRequest singleBooking;
    protected UpdateBookingRequest updateBooking;
    protected DeleteBookingRequest deleteBooking;

    protected CustomAssert customAssert;
    protected SoftAssert softAssert;

    public BaseAPITest() {
        this.softAssert = new SoftAssert();
        this.newBooking = new CreateBookingRequest();
        this.customAssert = new CustomAssert();
        this.singleBooking = new GetSingleBookingRequest();
        this.updateBooking = new UpdateBookingRequest();
        this.deleteBooking = new DeleteBookingRequest();
        this.token = new TokenGenerator(USERNAME, PASSWORD);
        this.preparedData = new DataPreparation(token.getToken());
    }

    @AfterSuite
    public void cleanUp(){
        DataCleanUp data = new DataCleanUp();
        data.cleanUpTestData(preparedData.getBookingIdList(), token.getToken());
    }
}
