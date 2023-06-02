package helpers;

import POJO.response.create_booking.CreateBookingResponse;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import setup.constans.BookingDetails;

public class CustomAssert {

    SoftAssert softAssert = new SoftAssert();

    public void checkIfNewBookingCreatedCorrectly(Response response) {
        CreateBookingResponse responseBody = response.as(CreateBookingResponse.class);
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertTrue(response.time()< 3000,
                "Response time is more than 3 seconds!");
        softAssert.assertTrue(responseBody.getBookingid() > 0);
        softAssert.assertEquals(responseBody.getBooking().getFirstname(),
                BookingDetails.CREATE_FIRST_NAME,
                "User name is not matching!");
        softAssert.assertEquals(responseBody.getBooking().getTotalprice(),
                Integer.parseInt(BookingDetails.CREATE_PRICE),
                "Price not as expected");
        softAssert.assertEquals(responseBody.getBooking().getBookingdates().getCheckin(),
                BookingDetails.CREATE_CHECK_IN.replace(".", "-"),
                "CheckIn time is not matching!");
        softAssert.assertAll("These are the issues: ");
    }
}
