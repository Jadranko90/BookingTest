import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.BookingRequestBody;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;


public class SmokeTest extends BaseAPITest {

    @Test
    public void bookNewReservation() {
        BookingRequestBody requestBody = new BookingRequestBody(BookingType.CREATE);
        response = newBooking.create(requestBody, token.getToken());
        customAssert.checkIfNewBookingCreatedCorrectly(response);
    }
    @Test
    public void checkBookingDetails() {
        response = singleBooking.checkDetails(token.getToken(), preparedData.getTestId);
        customAssert.checkIfGettingCorrectBooking(response);
    }
    @Test
    public void updateBookingDetails() {
        BookingRequestBody updateBookingBody = new BookingRequestBody(BookingType.CHANGED);
        response = updateBooking.change(updateBookingBody, token.getToken(), preparedData.updateTestId);
        customAssert.checkIfBookingIsUpdatedCorrectly(response);
    }

    @Test
    public void deleteBooking() {
        response = deleteBooking.delete(token.getToken(), preparedData.deleteTestId);
        softAssert.assertEquals(response.statusCode(), 200);
        customAssert.checkThatBookingIsDeletedFromDB(token.getToken(), preparedData.deleteTestId);
    }
}
