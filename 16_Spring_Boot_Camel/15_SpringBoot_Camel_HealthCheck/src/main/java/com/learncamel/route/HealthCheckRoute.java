package com.learncamel.route;

import com.learncamel.alert.MailProcessor;
import com.learncamel.process.HealCheckProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by z001qgd on 2/11/18.
 */
@Component
public class HealthCheckRoute extends RouteBuilder {

    @Autowired
    HealCheckProcessor healCheckProcessor;

    @Autowired
    MailProcessor mailProcessor;

    @Override
    public void configure() throws Exception {

        from("{{healthRoute}}").routeId("healthRoute")
                .pollEnrich("http://localhost:8080/health")
                .process(healCheckProcessor)
                .choice()
                    .when(header("error").isEqualTo(true))
                    .process(mailProcessor);
        ;
    }
}
