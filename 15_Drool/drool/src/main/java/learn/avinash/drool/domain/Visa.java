package learn.avinash.drool.domain;

public class Visa {
    private String passportNumber;

    public Visa(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Visa[passport:" + passportNumber + "]";
    }
}
