package data.handling;

import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.CreateBookingRequestBody;
import POJO.response.create_booking.CreateBookingResponse;
import io.restassured.response.Response;
import specification.request.CreateBookingRequest;

public class DataPreparation {

    CreateBookingRequest newBooking = new CreateBookingRequest();

    protected Response response;

    public int bookingForUpdateId;
    public int bookingForGetListId;
    public int bookingForDeleteId;

    public DataPreparation(String token) {
        CreateBookingRequestBody requestBodyPrepareForUpdate = new CreateBookingRequestBody(BookingType.UPDATE);
        response = newBooking.create(requestBodyPrepareForUpdate, token);
        CreateBookingResponse responseBodyBookingForUpdate = response.as(CreateBookingResponse.class);
        this.bookingForUpdateId = responseBodyBookingForUpdate.getBookingid();

        CreateBookingRequestBody requestBodyPrepareForGetList = new CreateBookingRequestBody(BookingType.READ);
        response = newBooking.create(requestBodyPrepareForGetList, token);
        CreateBookingResponse responseBodyBookingForRead = response.as(CreateBookingResponse.class);
        this.bookingForGetListId= responseBodyBookingForRead.getBookingid();

        CreateBookingRequestBody requestBodyPrepareForDelete = new CreateBookingRequestBody(BookingType.DELETE);
        response = newBooking.create(requestBodyPrepareForDelete, token);
        CreateBookingResponse responseBodyBookingForDelete = response.as(CreateBookingResponse.class);
        this.bookingForDeleteId = responseBodyBookingForDelete.getBookingid();
    }
}
