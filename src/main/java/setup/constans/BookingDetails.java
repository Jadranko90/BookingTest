package setup.constans;

import helpers.FileControlUtil;

public class BookingDetails {

    public static final FileControlUtil fileControlBooking;

    static {
        try {
            fileControlBooking = new FileControlUtil(FileControlUtil.BOOKING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Data for create request
    public static final String CREATE_FIRST_NAME = fileControlBooking.getValue("CREATE_FIRST_NAME");
    public static final String CREATE_LAST_NAME = fileControlBooking.getValue("CREATE_LAST_NAME");
    public static final String CREATE_PRICE = fileControlBooking.getValue("CREATE_PRICE");
    public static final String CREATE_CHECK_IN = fileControlBooking.getValue("CREATE_CHECK_IN");
    public static final String CREATE_CHECKOUT = fileControlBooking.getValue("CREATE_CHECKOUT");
    public static final String CREATE_ADDITIONAL_NEEDS = fileControlBooking.getValue(
            "CREATE_ADDITIONAL_NEEDS");

    // Data for update request
    public static final String UPDATE_FIRST_NAME = fileControlBooking.getValue("UPDATE_FIRST_NAME");
    public static final String UPDATE_LAST_NAME = fileControlBooking.getValue("UPDATE_LAST_NAME");
    public static final String UPDATE_PRICE = fileControlBooking.getValue("UPDATE_PRICE");
    public static final String UPDATE_CHECK_IN = fileControlBooking.getValue("UPDATE_CHECK_IN");
    public static final String UPDATE_CHECKOUT = fileControlBooking.getValue("UPDATE_CHECKOUT");
    public static final String UPDATE_ADDITIONAL_NEEDS = fileControlBooking.getValue(
            "UPDATE_ADDITIONAL_NEEDS");

    // Data for get Users List
    public static final String LIST_FIRST_NAME= fileControlBooking.getValue("LIST_FIRST_NAME");
    public static final String LIST_LAST_NAME = fileControlBooking.getValue("LIST_LAST_NAME");
    public static final String LIST_PRICE = fileControlBooking.getValue("LIST_PRICE");
    public static final String LIST_CHECK_IN = fileControlBooking.getValue("LIST_CHECK_IN");
    public static final String LIST_CHECKOUT = fileControlBooking.getValue("LIST_CHECKOUT");
    public static final String LIST_ADDITIONAL_NEEDS = fileControlBooking.getValue(
            "LIST_ADDITIONAL_NEEDS");

    // Data for deleting
    public static final String DELETE_FIRST_NAME= fileControlBooking.getValue("DELETE_FIRST_NAME");
    public static final String DELETE_LAST_NAME = fileControlBooking.getValue("DELETE_LAST_NAME");
    public static final String DELETE_PRICE = fileControlBooking.getValue("DELETE_PRICE");
    public static final String DELETE_CHECK_IN = fileControlBooking.getValue("DELETE_CHECK_IN");
    public static final String DELETE_CHECKOUT = fileControlBooking.getValue("DELETE_CHECKOUT");
    public static final String DELETE_ADDITIONAL_NEEDS = fileControlBooking.getValue(
            "DELETE_ADDITIONAL_NEEDS");


}
