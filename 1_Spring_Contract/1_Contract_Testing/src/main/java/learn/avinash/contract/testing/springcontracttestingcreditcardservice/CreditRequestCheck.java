package learn.avinash.contract.testing.springcontracttestingcreditcardservice;

public class CreditRequestCheck {
    private final int citizenNumber;

    public CreditRequestCheck(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public int getCitizenNumber() {
        return citizenNumber;
    }
}
