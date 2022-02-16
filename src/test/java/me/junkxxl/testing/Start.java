package me.junkxxl.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

abstract class Start {
    static Config config;
    protected ObjectMapper mapper = new ObjectMapper();
    protected String url = config.getString("url.petclinic");

    @BeforeAll
    static void loadConfig() {
        config = ConfigFactory.load();
    }
}
