package helpers;

import POJO.response.create_booking.Booking;
import POJO.response.create_booking.CreateBookingResponse;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import setup.constans.BookingDetails;
import specification.request.GetSingleBookingRequest;

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

    public void checkIfGettingCorrectBooking(Response response){
        Booking responseBody = response.as(Booking.class);
        softAssert.assertEquals(response.statusCode(), 200,
                "Status code not 200");
        softAssert.assertEquals(responseBody.getTotalprice(),
                Integer.parseInt(BookingDetails.GET_PRICE),
                "Price not as expected");
        softAssert.assertEquals(responseBody.getAdditionalneeds(), BookingDetails.GET_ADDITIONAL_NEEDS,
                "Additional needs not as expected");
        softAssert.assertTrue(response.time() < 3000,
                "Response time longer than 3 seconds");
        softAssert.assertAll("These are the issues: ");
    }

    public void checkIfBookingIsUpdatedCorrectly(Response response) {
        Booking responseBody = response.as(Booking.class);
        softAssert.assertEquals(response.statusCode(), 200,
                "Status code not 200");
        softAssert.assertEquals(responseBody.getFirstname(), BookingDetails.CHANGED_FIRST_NAME,
                "First name not as expected");
        softAssert.assertEquals(responseBody.getAdditionalneeds(), BookingDetails.CHANGED_ADDITIONAL_NEEDS,
                "Additional needs not as expected");
        softAssert.assertTrue(response.time() < 3000,
                "Response time longer than 3 seconds");
    }

    public void checkThatBookingIsDeletedFromDB(String token, int id){
        GetSingleBookingRequest getBooking = new GetSingleBookingRequest();
        Response response = getBooking.checkDetails(token, id);
        softAssert.assertEquals(response.statusCode(), 404,
                "Status code not as expected");
        softAssert.assertEquals(response.statusLine(), "HTTP/1.1 404 Not Found",
                "Status line not as expected");
        softAssert.assertAll("Booking not deleted correctly");
    }
}
