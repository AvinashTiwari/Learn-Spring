package learn.avinash.drool.domain;

public class InvalidFamilyVisaApplication {
    private FamilyVisaApplication familyVisaApplication;

    public InvalidFamilyVisaApplication(FamilyVisaApplication familyVisaApplication) {
        this.familyVisaApplication = familyVisaApplication;
    }

    public FamilyVisaApplication getFamilyVisaApplication() {
        return familyVisaApplication;
    }

    @Override
    public String toString() {
        return "Invalid:" + familyVisaApplication;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof InvalidFamilyVisaApplication
                && ((InvalidFamilyVisaApplication) obj).getFamilyVisaApplication().equals(familyVisaApplication);
    }

    @Override
    public int hashCode() {
        return familyVisaApplication.hashCode();
    }

}
