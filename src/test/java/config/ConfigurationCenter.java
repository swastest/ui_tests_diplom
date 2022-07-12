package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigurationCenter {
    public static DataBaseInterface configBD = ConfigFactory.create(DataBaseInterface.class, System.getProperties());
    public static EnvironmentConfigInterface configEnv = ConfigFactory.create(EnvironmentConfigInterface.class, System.getProperties());
    public static RemoteConfigInterface configRemote = ConfigFactory.create(RemoteConfigInterface.class, System.getProperties());
    public static TestDataInterface configTestData = ConfigFactory.create(TestDataInterface.class, System.getProperties());
}
