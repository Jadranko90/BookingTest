package helpers;

import POJO.response.authorization.LogInResponseBody;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import specification.request.LogIn;

@Getter
@Setter
public class TokenGenerator {

    private String token;

    public TokenGenerator() {
    }

    public TokenGenerator(String username, String pass) {
        this.token = accessToken(username, pass);
    }

    private String accessToken(String username, String pass) {
        LogIn logIn = new LogIn();
        Response response = logIn.logIn(username, pass);
        LogInResponseBody body = response.body().as(LogInResponseBody.class);

        return "token=" + body.getToken();
    }
}
