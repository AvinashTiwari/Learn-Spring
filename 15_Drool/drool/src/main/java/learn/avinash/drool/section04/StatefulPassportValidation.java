package learn.avinash.drool.section04;

import learn.avinash.drool.Common;
import learn.avinash.drool.domain.Passport;
import learn.avinash.drool.repository.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class StatefulPassportValidation {
    public static void main(final String[] args) {
        execute(Common.promptForStep(4, args, 1, 2));
    }


    static void execute(int step) {
        System.out.println("Running step " + step);
        KieContainer kieClasspathContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kieClasspathContainer.newKieSession("StatefulPassportValidationStep" + step);

        List<Passport> passports = ApplicationRepository.getPassports();
        passports.forEach(ksession::insert);


        System.out.println("==== DROOLS SESSION START ==== ");
        ksession.fireAllRules();
        ksession.dispose();
        System.out.println("==== DROOLS SESSION END ==== ");

        System.out.println("==== PASSPORTS AFTER DROOLS SESSION === ");
        passports.forEach(passport -> {
            System.out.println(passport + " verdict: " + passport.getValidation() + ", cause: " + passport.getCause());
        });


    }

}
