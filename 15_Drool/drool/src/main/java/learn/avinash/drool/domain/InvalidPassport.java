package learn.avinash.drool.domain;

public class InvalidPassport {
    private Passport passport;

    public InvalidPassport(Passport passport) {
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Invalid" + passport;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof InvalidPassport
                && ((InvalidPassport) obj).getPassport().equals(passport);
    }

    @Override
    public int hashCode() {
        return passport.hashCode();
    }
}
