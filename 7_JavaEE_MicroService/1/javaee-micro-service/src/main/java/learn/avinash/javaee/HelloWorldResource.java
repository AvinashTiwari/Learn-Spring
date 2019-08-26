package learn.avinash.javaee;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static java.lang.System.getenv;
import static java.util.Optional.ofNullable;

@Path("/hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject helloWorld(){
        String hostname = ofNullable(getenv("HOSTNAME")).orElse("localhost");

        return Json.createObjectBuilder()
                .add("message", "Cloud Native application")
                .add("hostname", hostname)
                .build();
    }
}
