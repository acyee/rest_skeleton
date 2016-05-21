package demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Anthony on 5/20/16.
 */

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(DemoResource.class);
    }
}