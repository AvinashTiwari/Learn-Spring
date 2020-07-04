package learn.avinash.drool.domain;

public class ValidPassport {
    private Passport passport;

    public ValidPassport(Passport passport) {
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Valid" + passport;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ValidPassport
                && ((ValidPassport) obj).getPassport().equals(passport);
    }

    @Override
    public int hashCode() {
        return passport.hashCode();
    }
}
