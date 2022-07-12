package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/testData.properties")
public interface TestDataInterface extends Config {
    String userActiveLogin();
    String userActivePassword();
    String userBlockLogin();
    String userBlockPassword();
    String userActiveFirstName();
    String userActiveLastName();
    String expectPhoneActiveUser();
    String userBlockFirstName();
    String userBlockLastName();
    String forgetUserLogin();
    String nonExistentUser();
}
