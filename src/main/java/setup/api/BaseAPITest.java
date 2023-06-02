package setup.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;
import lombok.Setter;
import org.testng.asserts.SoftAssert;

@Getter
@Setter
public abstract class BaseAPITest {

    protected RequestSpecification request;
    protected ResponseSpecification responseSpecification;
    protected Response response;
    protected SoftAssert softAssert;

    public BaseAPITest() {
        this.softAssert = new SoftAssert();
    }

}
