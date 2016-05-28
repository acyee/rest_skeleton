package demo;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Anthony on 5/20/16.
 */

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(DemoResource.class);
    }

    @PostConstruct
    public void configureSwagger() {
        // Available at localhost:port/swagger.json
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setTitle("Spring Boot + Jersey + Swagger Example");
        config.setVersion("v1");
        config.setSchemes(new String[] { "http", "https" });
        config.setBasePath("/api");
        config.setResourcePackage("demo");
        config.setPrettyPrint(true);
        config.setScan(true);
    }
}