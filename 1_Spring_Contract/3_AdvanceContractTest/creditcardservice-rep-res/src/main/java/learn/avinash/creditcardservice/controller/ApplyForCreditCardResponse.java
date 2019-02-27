package learn.avinash.creditcardservice.controller;

public class ApplyForCreditCardResponse {
    private final Status status;
    private final String uuid;

    public ApplyForCreditCardResponse(Status status, String uuid) {

        this.status = status;
        this.uuid = uuid;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        DENIED, GRANTED
    }

    public String getUuid() {
        return uuid;
    }
}
