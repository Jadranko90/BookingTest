package POJO.request.create_booking;

import lombok.Getter;
import lombok.Setter;
import setup.constans.BookingDetails;

@Getter
@Setter
public class CreateBookingRequestBody {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public CreateBookingRequestBody() {
    }

    public CreateBookingRequestBody(BookingType bookingType) {
        switch (bookingType) {
            case CREATE -> {
                this.firstname = BookingDetails.CREATE_FIRST_NAME;
                this.lastname = BookingDetails.CREATE_LAST_NAME;
                this.totalprice = Integer.parseInt(BookingDetails.CREATE_PRICE);
                this.depositpaid = true;
                this.bookingdates = new BookingDates(
                        BookingDetails.CREATE_CHECK_IN,
                        BookingDetails.CREATE_CHECKOUT);
                this.additionalneeds = BookingDetails.CREATE_ADDITIONAL_NEEDS;
            }
            case UPDATE -> {
                this.firstname = BookingDetails.UPDATE_FIRST_NAME;
                this.lastname = BookingDetails.UPDATE_LAST_NAME;
                this.totalprice = Integer.parseInt(BookingDetails.UPDATE_PRICE);
                this.depositpaid = true;
                this.bookingdates = new BookingDates(
                        BookingDetails.UPDATE_CHECK_IN,
                        BookingDetails.UPDATE_CHECKOUT);
                this.bookingdates.setCheckin(BookingDetails.UPDATE_CHECK_IN);
                this.bookingdates.setCheckout(BookingDetails.UPDATE_CHECKOUT);
                this.additionalneeds = BookingDetails.UPDATE_ADDITIONAL_NEEDS;
            }
            case READ -> {
                this.firstname = BookingDetails.LIST_FIRST_NAME;
                this.lastname = BookingDetails.LIST_LAST_NAME;
                this.totalprice = Integer.parseInt(BookingDetails.LIST_PRICE);
                this.depositpaid = true;
                this.bookingdates = new BookingDates(
                        BookingDetails.LIST_CHECK_IN,
                        BookingDetails.LIST_CHECKOUT);
                this.bookingdates.setCheckin(BookingDetails.LIST_CHECK_IN);
                this.bookingdates.setCheckout(BookingDetails.LIST_CHECKOUT);
                this.additionalneeds = BookingDetails.LIST_ADDITIONAL_NEEDS;
            }
            case DELETE -> {
                this.firstname = BookingDetails.DELETE_FIRST_NAME;
                this.lastname = BookingDetails.DELETE_LAST_NAME;
                this.totalprice = Integer.parseInt(BookingDetails.DELETE_PRICE);
                this.depositpaid = true;
                this.bookingdates = new BookingDates(
                        BookingDetails.DELETE_CHECK_IN,
                        BookingDetails.DELETE_CHECKOUT);
                this.bookingdates.setCheckin(BookingDetails.DELETE_CHECK_IN);
                this.bookingdates.setCheckout(BookingDetails.DELETE_CHECKOUT);
                this.additionalneeds = BookingDetails.DELETE_ADDITIONAL_NEEDS;
            }
            default -> throw new RuntimeException("Type not defined correctly");
        }
    }
}
