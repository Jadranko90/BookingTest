package data.handling;

import POJO.request.create_booking.BookingType;
import POJO.request.create_booking.BookingRequestBody;
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

    public int updateTestId;
    public int getTestId;
    public int deleteTestId;

    public List<Integer> bookingIdList;

    public DataPreparation(String token) {
        List<Integer> idList = new ArrayList<>();
        BookingRequestBody requestBodyPrepareForUpdate = new BookingRequestBody(BookingType.UPDATE);
        response = newBooking.create(requestBodyPrepareForUpdate, token);
        CreateBookingResponse responseBodyBookingForUpdate = response.as(CreateBookingResponse.class);
        this.updateTestId = responseBodyBookingForUpdate.getBookingid();
        idList.add(updateTestId);

        BookingRequestBody requestBodyPrepareForGetList = new BookingRequestBody(BookingType.READ);
        response = newBooking.create(requestBodyPrepareForGetList, token);
        CreateBookingResponse responseBodyBookingForRead = response.as(CreateBookingResponse.class);
        this.getTestId = responseBodyBookingForRead.getBookingid();
        idList.add(getTestId);

        BookingRequestBody requestBodyPrepareForDelete = new BookingRequestBody(BookingType.DELETE);
        response = newBooking.create(requestBodyPrepareForDelete, token);
        CreateBookingResponse responseBodyBookingForDelete = response.as(CreateBookingResponse.class);
        this.deleteTestId = responseBodyBookingForDelete.getBookingid();
        idList.add(deleteTestId);

        this.setBookingIdList(idList);
    }
}
