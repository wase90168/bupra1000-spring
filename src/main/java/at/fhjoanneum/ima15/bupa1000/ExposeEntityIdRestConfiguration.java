package at.fhjoanneum.ima15.bupa1000;


import at.fhjoanneum.ima15.bupa1000.model.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ExposeEntityIdRestConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Breastfeeding.class);
        config.exposeIdsFor(Category.class);
        config.exposeIdsFor(Dimension.class);
        config.exposeIdsFor(MR.class);
        config.exposeIdsFor(Person.class);
        config.exposeIdsFor(Person_Person.class);
        config.exposeIdsFor(Role.class);
        config.exposeIdsFor(Source.class);
        config.exposeIdsFor(State.class);
        config.exposeIdsFor(Type.class);
        config.exposeIdsFor(Uzer.class);
        config.exposeIdsFor(Value.class);

    }
}