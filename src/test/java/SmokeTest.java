import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.CreateBookingRequestBody;
import POJO.response.create_booking.CreateBookingResponse;
import helpers.TokenGenerator;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import static setup.constans.UserDetails.PASSWORD;
import static setup.constans.UserDetails.USERNAME;

public class SmokeTest extends BaseAPITest {

    TokenGenerator token = new TokenGenerator(USERNAME, PASSWORD);

    @Test
    public void bookNewReservation() {
        CreateBookingRequestBody requestBody = new CreateBookingRequestBody(BookingType.CREATE);
        response = newBooking.create(requestBody, token.getToken());
        CreateBookingResponse responseBody = response.as(CreateBookingResponse.class);
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(responseBody.getBooking().getFirstname(), "John");
        softAssert.assertAll();

    }

}
