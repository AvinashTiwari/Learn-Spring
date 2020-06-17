package learn.avinash.drool.domain;

public class ValidVisaApplication {
    private VisaApplication visaApplication;

    public ValidVisaApplication(VisaApplication visaApplication) {
        this.visaApplication = visaApplication;
    }

    public VisaApplication getVisaApplication() {
        return visaApplication;
    }


    @Override
    public String toString() {
        return "Valid" + visaApplication;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ValidVisaApplication
                && ((ValidVisaApplication) obj).getVisaApplication().equals(visaApplication);
    }

    @Override
    public int hashCode() {
        return visaApplication.hashCode();
    }
}