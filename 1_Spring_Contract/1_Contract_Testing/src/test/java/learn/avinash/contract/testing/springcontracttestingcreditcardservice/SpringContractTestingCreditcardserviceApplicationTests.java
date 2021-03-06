package learn.avinash.contract.testing.springcontracttestingcreditcardservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids="learn.avinash.springcontract:creditcheckservice:+:stubs:8080",
workOffline = true)
public class SpringContractTestingCreditcardserviceApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void ShouldGrandApplicationWhenCreditScoreisHigh() throws Exception {
		mockMvc.perform(post("/credit-card-applications")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{"+
						"\"citizenNumber\":1234," +
						"\"cardType\":\"GOLD\""+
						"}"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().json(
						"{" +
								"\"status\":\"GRANTED\""+
								"}"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


	}

	@Test
	public void ShouldDenyApplicationWhenCreditScoreIslow() throws Exception {
		mockMvc.perform(post("/credit-card-applications")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{"+
						"\"citizenNumber\":4444," +
						"\"cardType\":\"GOLD\""+
						"}"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().json(
						"{" +
								"\"status\":\"DENIED\""+
								"}"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


	}

}

