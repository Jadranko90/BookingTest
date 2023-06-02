import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.CreateBookingRequestBody;
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
        customAssert.checkIfNewBookingCreatedCorrectly(response);
    }

}
