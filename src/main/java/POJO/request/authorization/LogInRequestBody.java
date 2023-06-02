package POJO.request.authorization;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInRequestBody {

    private String username;
    private String password;

    public LogInRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
