package learn.avinash.j82ee;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures a JAX-RS endpoint.
 */
@ApplicationScoped
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {
}
