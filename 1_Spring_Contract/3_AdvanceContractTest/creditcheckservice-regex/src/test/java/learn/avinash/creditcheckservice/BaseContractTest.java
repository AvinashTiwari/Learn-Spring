package learn.avinash.creditcheckservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {

    @Before
    public void setUp() {
        final CreditCheckService mock = mock(CreditCheckService.class);
        when(mock.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(CreditCheckResponse.Score.HIGH));
        when(mock.doCreditCheck(4444)).thenReturn(new CreditCheckResponse(CreditCheckResponse.Score.LOW));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(mock));
    }
}
