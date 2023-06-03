package setup.constans;

import helpers.FileControlUtil;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Endpoints {
    public static final FileControlUtil fileControlURL;

    static {
        try {
            fileControlURL = new FileControlUtil(FileControlUtil.ENDPOINTS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static final String BASE_URI = fileControlURL.getValue("BASE_URL");
    public static final String AUTH = fileControlURL.getValue("AUTH");
    public static final String BOOKING = fileControlURL.getValue("BOOKING");
    public static final String GET_BOOKING = fileControlURL.getValue("GET_BOOKING");


}
