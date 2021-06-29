package fr.morandini.APISample.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories({"fr.morandini.APISample.repository"})
@EntityScan("fr.morandini.APISample.entity")
public class RepositoryConfiguration {
}
