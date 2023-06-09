package POJO.request.create_booking;

import lombok.Getter;
import lombok.Setter;
import setup.constans.BookingDetails;

@Getter
@Setter
public class BookingRequestBody {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;


    public BookingRequestBody(BookingType bookingType) {
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
                this.firstname = BookingDetails.GET_FIRST_NAME;
                this.lastname = BookingDetails.GET_LAST_NAME;
                this.totalprice = Integer.parseInt(BookingDetails.GET_PRICE);
                this.depositpaid = true;
                this.bookingdates = new BookingDates(
                        BookingDetails.GET_CHECK_IN,
                        BookingDetails.GET_CHECKOUT);
                this.bookingdates.setCheckin(BookingDetails.GET_CHECK_IN);
                this.bookingdates.setCheckout(BookingDetails.GET_CHECKOUT);
                this.additionalneeds = BookingDetails.GET_ADDITIONAL_NEEDS;
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
            case CHANGED -> {
                this.firstname = BookingDetails.CHANGED_FIRST_NAME;
                this.lastname = BookingDetails.CHANGED_LAST_NAME;
                this.totalprice = Integer.parseInt(BookingDetails.CHANGED_PRICE);
                this.depositpaid = true;
                this.bookingdates = new BookingDates(
                        BookingDetails.CHANGED_CHECK_IN,
                        BookingDetails.CHANGED_CHECKOUT);
                this.bookingdates.setCheckin(BookingDetails.CHANGED_CHECK_IN);
                this.bookingdates.setCheckout(BookingDetails.CHANGED_CHECKOUT);
                this.additionalneeds = BookingDetails.CHANGED_ADDITIONAL_NEEDS;
            }
            default -> throw new RuntimeException("Type not defined correctly");
        }
    }
}
