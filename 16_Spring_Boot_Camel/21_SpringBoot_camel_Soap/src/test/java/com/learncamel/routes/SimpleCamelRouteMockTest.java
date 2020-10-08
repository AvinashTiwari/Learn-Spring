package com.learncamel.routes;

import com.learncamel.domain.Country;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.spring.ws.SpringWebserviceConstants;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.camel.test.spring.DisableJmx;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by z001qgd on 1/13/18.
 */
@ActiveProfiles("mock")
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisableJmx(true)
public class SimpleCamelRouteMockTest extends CamelTestSupport{


    @Autowired
    private CamelContext context;

    @Autowired
    protected CamelContext createCamelContext() {
        return context;
    }

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ConsumerTemplate consumerTemplate;

    @Override
    protected RouteBuilder createRouteBuilder(){
        return new SoapCamelRoute();
    }

    @Autowired
    Environment environment;

    private String getCountrybyCountryCodeRequest = "<GetCountryByCountryCode xmlns=\"http://www.webserviceX.NET\">\n" +
            "      <CountryCode>GB</CountryCode>\n" +
            "    </GetCountryByCountryCode>";

    private String countryWebServiceUri = "http://www.webservicex.net/country.asmx";


    @Before
    public void setUp(){

    }

    @Test
    public void countryNameByCountryCode() throws Exception {
        Country country = (Country) producerTemplate.requestBodyAndHeader("direct:input", getCountrybyCountryCodeRequest,
                SpringWebserviceConstants.SPRING_WS_ENDPOINT_URI, countryWebServiceUri);


        //assertNotNull(result);
        assertEquals("gb", country.getCountrycode());

    }


}
