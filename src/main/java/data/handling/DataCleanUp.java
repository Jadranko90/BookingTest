package data.handling;

import specification.request.DeleteBookingRequest;

import java.util.List;

public class DataCleanUp {

    public void cleanUpTestData(List<Integer> bookingIdList, String token){
        DeleteBookingRequest booking = new DeleteBookingRequest();
        for (Integer i : bookingIdList) {
            booking.delete(token, i);
        }
    }
}
