package learn.avinash.springcontract.creditcheckservice;

public class CreditCheckRequest {
    private int citizenNumber;

    public int getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }
}
