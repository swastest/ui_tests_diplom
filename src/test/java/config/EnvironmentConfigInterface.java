package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/environment.properties")
public interface EnvironmentConfigInterface extends Config{
    String mainUrl();
}
