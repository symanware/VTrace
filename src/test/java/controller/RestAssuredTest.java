package controller;

;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import sample.VintraceApplication;

import static io.restassured.RestAssured.*;
import static java.lang.String.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest(classes = VintraceApplication.class)
@ContextConfiguration
public class RestAssuredTest {

    @Value("${integration.test.url}")
    private String testUrl;

    @Before
    public void setup() {
        RestAssured.baseURI = testUrl ;
    }

    @Test
    public void basicPingTest() {
        given().log().all().when().get("/wines/1").then().statusCode(200).body("", containsString("2016 Yarra Valley Pinot Noir"));
    }

}
