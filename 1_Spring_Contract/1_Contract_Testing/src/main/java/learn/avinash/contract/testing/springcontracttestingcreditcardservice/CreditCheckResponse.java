package learn.avinash.contract.testing.springcontracttestingcreditcardservice;

public class CreditCheckResponse {
    private Score score;

    public enum Score {
        HIGH
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
