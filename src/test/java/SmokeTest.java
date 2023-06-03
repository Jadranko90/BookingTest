import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.CreateBookingRequestBody;
import POJO.response.create_booking.Booking;
import data.handling.DataPreparation;
import helpers.TokenGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.constans.BookingDetails;

import static setup.constans.UserDetails.PASSWORD;
import static setup.constans.UserDetails.USERNAME;

public class SmokeTest extends BaseAPITest {

    TokenGenerator token = new TokenGenerator(USERNAME, PASSWORD);

    DataPreparation dataPreparation = new DataPreparation(token.getToken());

    @Test
    public void bookNewReservation() {
        CreateBookingRequestBody requestBody = new CreateBookingRequestBody(BookingType.CREATE);
        response = newBooking.create(requestBody, token.getToken());
        customAssert.checkIfNewBookingCreatedCorrectly(response);
    }

    @Test
    public void checkBookingDetails() {
        response = singleBooking.checkDetails(token.getToken(), dataPreparation.bookingForGetBooking);
        Booking responseBody = response.as(Booking.class);
        Assert.assertEquals(responseBody.getTotalprice(), Integer.valueOf(BookingDetails.LIST_PRICE));
    }


}
