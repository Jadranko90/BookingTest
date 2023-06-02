package setup.constans;
import helpers.FileControlUtil;

public class UserDetails {

    public static final FileControlUtil fileControlUser;

    static {
        try {
            fileControlUser = new FileControlUtil(FileControlUtil.USER_DETAILS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final String USERNAME = fileControlUser.getValue("USERNAME");
    public static final String PASSWORD = fileControlUser.getValue("PASSWORD");
}
