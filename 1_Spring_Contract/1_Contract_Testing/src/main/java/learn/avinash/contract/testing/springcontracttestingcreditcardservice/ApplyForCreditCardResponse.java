package learn.avinash.contract.testing.springcontracttestingcreditcardservice;

public class ApplyForCreditCardResponse {
    private final Status status;

    public ApplyForCreditCardResponse(Status status) {
        this.status =status;
    }

    public enum Status {
        GRANTED
    }

    public Status getStatus() {
        return status;
    }
}
