package data.handling;

import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.CreateBookingRequestBody;
import POJO.response.create_booking.CreateBookingResponse;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import specification.request.CreateBookingRequest;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataPreparation {

    CreateBookingRequest newBooking = new CreateBookingRequest();

    protected Response response;

    public int bookingForUpdateId;
    public int bookingForGetBooking;
    public int bookingForDeleteId;

    public List<Integer> bookingIdList;

    public DataPreparation(String token) {
        List<Integer> idList = new ArrayList<>();
        CreateBookingRequestBody requestBodyPrepareForUpdate = new CreateBookingRequestBody(BookingType.UPDATE);
        response = newBooking.create(requestBodyPrepareForUpdate, token);
        CreateBookingResponse responseBodyBookingForUpdate = response.as(CreateBookingResponse.class);
        this.bookingForUpdateId = responseBodyBookingForUpdate.getBookingid();
        idList.add(bookingForUpdateId);

        CreateBookingRequestBody requestBodyPrepareForGetList = new CreateBookingRequestBody(BookingType.READ);
        response = newBooking.create(requestBodyPrepareForGetList, token);
        CreateBookingResponse responseBodyBookingForRead = response.as(CreateBookingResponse.class);
        this.bookingForGetBooking = responseBodyBookingForRead.getBookingid();
        idList.add(bookingForGetBooking);

        CreateBookingRequestBody requestBodyPrepareForDelete = new CreateBookingRequestBody(BookingType.DELETE);
        response = newBooking.create(requestBodyPrepareForDelete, token);
        CreateBookingResponse responseBodyBookingForDelete = response.as(CreateBookingResponse.class);
        this.bookingForDeleteId = responseBodyBookingForDelete.getBookingid();
        idList.add(bookingForDeleteId);

        setBookingIdList(idList);
    }
}
