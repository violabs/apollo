package com.violabs.apollo.service

import com.violabs.apollo.domain.nodes.PoliticalParty
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
class PoliticalPartyIntegrationTest {
  @Autowired
  lateinit var politicalPartyService: PoliticalPartyService

  @AfterEach
  fun teardown() {
    politicalPartyService.deleteAll()
  }

  @Test
  fun `save works`() {
    val party = PoliticalParty(name = "American Freedom Pool", affiliation = "US")

    val actual: Mono<PoliticalParty> = politicalPartyService.save(party)

    StepVerifier
      .create(actual)
      .expectNextMatches { it.name == "American Freedom Pool" && it.affiliation == "US" }
      .verifyComplete()
  }
}