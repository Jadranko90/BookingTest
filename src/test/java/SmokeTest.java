import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.CreateBookingRequestBody;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;


public class SmokeTest extends BaseAPITest {

    @Test
    public void bookNewReservation() {
        CreateBookingRequestBody requestBody = new CreateBookingRequestBody(BookingType.CREATE);
        response = newBooking.create(requestBody, token.getToken());
        customAssert.checkIfNewBookingCreatedCorrectly(response);
    }
    @Test
    public void checkBookingDetails() {
        response = singleBooking.checkDetails(token.getToken(), preparedData.bookingForGetBooking);
        customAssert.checkIfGettingCorrectBooking(response);
    }
    @Test
    public void updateBookingDetails() {
        CreateBookingRequestBody updateBookingBody = new CreateBookingRequestBody(BookingType.CHANGED);
        response = updateBooking.change(updateBookingBody, token.getToken(), preparedData.bookingForUpdateId);
        customAssert.checkIfBookingIsUpdatedCorrectly(response);
    }

    @Test
    public void deleteBooking() {
        response = deleteBooking.delete(token.getToken(), preparedData.bookingForDeleteId);
        softAssert.assertEquals(response.statusCode(), 200);
        customAssert.checkThatBookingIsDeletedFromDB(token.getToken(), preparedData.bookingForDeleteId);
    }
}
