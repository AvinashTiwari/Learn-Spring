package learn.avinash.drool.domain;

public class InvalidVisaApplication {
    private VisaApplication visaApplication;

    public InvalidVisaApplication(VisaApplication visaApplication) {
        this.visaApplication = visaApplication;
    }

    public VisaApplication getVisaApplication() {
        return visaApplication;
    }

    @Override
    public String toString() {
        return "Invalid" + visaApplication;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof InvalidVisaApplication
                && ((InvalidVisaApplication) obj).getVisaApplication().equals(visaApplication);
    }

    @Override
    public int hashCode() {
        return visaApplication.hashCode();
    }

}