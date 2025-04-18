package com.baedal.order.global.test;

import com.baedal.order.global.cleaner.PostgresCleaner;
import com.navercorp.fixturemonkey.FixtureMonkey;
import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
abstract public class IntegrationTest {

  @LocalServerPort
  protected int port;

  protected String baseUrl = "http://localhost:";

  @Autowired
  protected TestRestTemplate restTemplate;

  @Autowired
  private PostgresCleaner dataCleaner;

  @Autowired
  protected FixtureMonkey fixtureMonkey;

  protected Random random = new Random();

  @AfterEach
  void tearDown() {
    dataCleaner.clear();
  }
}
