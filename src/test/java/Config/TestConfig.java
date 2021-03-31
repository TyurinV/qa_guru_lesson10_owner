package Config;
import org.aeonbits.owner.Config;


@Config.Sources("classpath:${environment}.properties")
public interface TestConfig extends Config {

    @Key("remoteUrl")
    String webDriverUrl();

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("videoStorage")
    String videoStorage();

}
