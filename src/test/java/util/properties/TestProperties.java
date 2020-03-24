package util.properties;

import org.yaml.snakeyaml.Yaml;

public interface TestProperties {

    Config CONFIG = new Yaml().load( //TODO can be moved to some util.base test
            TestProperties.class.getClassLoader().getResourceAsStream("config.yml"));

}