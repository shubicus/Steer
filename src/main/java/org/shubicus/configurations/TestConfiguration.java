package org.shubicus.configurations;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;


@LoadPolicy(LoadType.MERGE)
@Sources({"classpath:uitest.properties"})
public interface TestConfiguration extends Config {

    @Key("app.userName")
    String userName();

    @Key("app.password")
    String password();

    @DefaultValue("chrome")
    @Key("selenide.browser")
    String browser();

    @Key("app.url")
    String baseUrl();

    @DefaultValue("60000")
    @Key("selenide.pageLoadTimeout")
    int pageLoadTimeout();

    @DefaultValue("10000")
    @Key("selenide.timeout")
    int timeout();

    @DefaultValue("target/reports")
    @Key("selenide.reportsFolder")
    String reportFolder();

    @DefaultValue("true")
    @Key("selenide.headless")
    Boolean headless();
}

