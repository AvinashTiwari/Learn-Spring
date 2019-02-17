package learn.avinash.contract.testing.springcontracttestingcreditcardservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CreditCardApplicationContoller {

    private final RestTemplate restTemplate;

    public CreditCardApplicationContoller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/credit-card-applications")
    public ApplyForCreditCardResponse applyForCreditCard(@RequestBody  final ApplyForCreditCardRequest appliedForCreditCardRequest){
        final int citizenNumber = appliedForCreditCardRequest.getCitizenNumber();
       final CreditCheckResponse creditCheckResponse =  restTemplate.postForObject("http://localhost:8080/credit-scores", new CreditRequestCheck(citizenNumber), CreditCheckResponse.class);
       if(creditCheckResponse.getScore() == CreditCheckResponse.Score.HIGH &&
               appliedForCreditCardRequest.getCardType() == ApplyForCreditCardRequest.CardType.GOLD){
           return new ApplyForCreditCardResponse(ApplyForCreditCardResponse.Status.GRANTED);

       }

       throw new RuntimeException("Card and score not yet implemented");



    }

}
