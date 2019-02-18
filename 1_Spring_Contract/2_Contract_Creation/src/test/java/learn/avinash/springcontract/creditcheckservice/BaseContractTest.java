package learn.avinash.springcontract.creditcheckservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static learn.avinash.springcontract.creditcheckservice.CreditCheckResponse.Score.HIGH;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class BaseContractTest {

    @Before
    public void setup(){
        final CreditCheckService mock = mock(CreditCheckService.class);
        when(mock.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(mock));
    }
}
