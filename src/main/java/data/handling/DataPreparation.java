package data.handling;

import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.CreateBookingRequestBody;
import POJO.response.create_booking.CreateBookingResponse;
import helpers.TokenGenerator;
import io.restassured.response.Response;
import specification.request.CreateBookingRequest;

import static setup.constans.UserDetails.PASSWORD;
import static setup.constans.UserDetails.USERNAME;

public class DataPreparation {

    TokenGenerator token = new TokenGenerator(USERNAME, PASSWORD);
    CreateBookingRequest newBooking = new CreateBookingRequest();

    protected Response response;

    public int bookingForUpdateId;
    public int bookingForGetListId;
    public int bookingForDeleteId;

    public DataPreparation() {
        CreateBookingRequestBody requestBodyPrepareForUpdate = new CreateBookingRequestBody(BookingType.UPDATE);
        response = newBooking.create(requestBodyPrepareForUpdate, token.getToken());
        CreateBookingResponse responseBodyBookingForUpdate = response.as(CreateBookingResponse.class);
        this.bookingForUpdateId = responseBodyBookingForUpdate.getBookingid();

        CreateBookingRequestBody requestBodyPrepareForGetList = new CreateBookingRequestBody(BookingType.READ);
        response = newBooking.create(requestBodyPrepareForGetList, token.getToken());
        CreateBookingResponse responseBodyBookingForRead = response.as(CreateBookingResponse.class);
        this.bookingForGetListId= responseBodyBookingForRead.getBookingid();

        CreateBookingRequestBody requestBodyPrepareForDelete = new CreateBookingRequestBody(BookingType.DELETE);
        response = newBooking.create(requestBodyPrepareForDelete, token.getToken());
        CreateBookingResponse responseBodyBookingForDelete = response.as(CreateBookingResponse.class);
        this.bookingForDeleteId = responseBodyBookingForDelete.getBookingid();
    }
}
