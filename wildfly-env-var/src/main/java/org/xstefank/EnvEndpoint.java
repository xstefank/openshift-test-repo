package org.xstefank;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class EnvEndpoint {

    private static final String envName = "TEST_ENV";
    private static final Logger log = Logger.getLogger(EnvEndpoint.class);

    private final String testStaticEnv = readStaticEnv();

    @GET
    @Path("/get")
    public String getEnv() {
        log.info("System.getenv() " + System.getenv(envName));
        log.info("System.getProperty() " + System.getProperty(envName));

        log.info("TEST_STATIC_ENV=" + testStaticEnv);

        return System.getenv(envName);
    }

    private String readStaticEnv() {
        return System.getenv("TEST_STATIC_ENV");
    }
}
