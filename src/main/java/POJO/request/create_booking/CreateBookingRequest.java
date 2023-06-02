package POJO.request.create_booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingRequest {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
