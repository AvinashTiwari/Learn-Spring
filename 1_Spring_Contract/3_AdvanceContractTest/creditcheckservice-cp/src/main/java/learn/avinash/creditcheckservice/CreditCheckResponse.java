package learn.avinash.creditcheckservice;

import java.util.UUID;

public class CreditCheckResponse {
    private Score score;
    private final String uuid = UUID.randomUUID().toString();

    public CreditCheckResponse(Score score) {
        this.score = score;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public enum Score {
        HIGH, LOW
    }

    public String getUuid() {
        return uuid;
    }


}
