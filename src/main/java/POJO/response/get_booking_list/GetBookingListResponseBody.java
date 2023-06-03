package POJO.response.get_booking_list;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetBookingListResponseBody {

    private List<Integer> bookingid;
}
