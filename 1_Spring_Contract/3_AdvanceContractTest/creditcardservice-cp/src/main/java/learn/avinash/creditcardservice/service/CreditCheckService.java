package learn.avinash.creditcardservice.service;

import learn.avinash.creditcardservice.controller.ApplyForCreditCardRequest;
import learn.avinash.creditcardservice.controller.ApplyForCreditCardResponse;
import learn.avinash.creditcardservice.gateway.CreditCheckGateway;
import learn.avinash.creditcardservice.gateway.CreditCheckResponse;
import org.springframework.stereotype.Component;

import static learn.avinash.creditcardservice.controller.ApplyForCreditCardRequest.CardType.GOLD;
import static learn.avinash.creditcardservice.controller.ApplyForCreditCardResponse.Status.DENIED;
import static learn.avinash.creditcardservice.controller.ApplyForCreditCardResponse.Status.GRANTED;
import static learn.avinash.creditcardservice.gateway.CreditCheckResponse.Score.HIGH;
import static learn.avinash.creditcardservice.gateway.CreditCheckResponse.Score.LOW;

@Component
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen(ApplyForCreditCardRequest applyForCreditCardRequest) {

        final CreditCheckResponse creditCardRespone = creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());
        final  CreditCheckResponse.Score score = creditCardRespone.getScore();
        final String uuid = creditCardRespone.getUuid();

        if (applyForCreditCardRequest.getCardType() == GOLD) {
            if (score == HIGH) {
                return new ApplyForCreditCardResponse(GRANTED,uuid);
            } else if(score == LOW) {
                return new ApplyForCreditCardResponse(DENIED,uuid);
            }
        }

        throw new RuntimeException("Card and score not yet implemented");
    }
}
