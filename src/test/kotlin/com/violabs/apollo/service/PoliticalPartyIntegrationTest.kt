package com.violabs.apollo.service

import com.violabs.apollo.domain.nodes.PoliticalParty
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
class PoliticalPartyIntegrationTest : StandardServiceIntegrationTest<PoliticalParty, PoliticalPartyService>() {
  @Autowired
  private lateinit var politicalPartyService: PoliticalPartyService

  private val animaniacsParty = PoliticalParty(name = "American Freedom Pool", affiliation = "US")
  private val falloutParty = PoliticalParty(name = "Free Watoga People's", affiliation = "US")
  private val illuminatusParty = PoliticalParty(name = "God's Lightning", affiliation = "US")
  private val corpoParty = PoliticalParty(name = "Corporatist", affiliation = "US")

  private val parties = setOf(animaniacsParty, falloutParty, illuminatusParty, corpoParty)

  @BeforeEach
  fun setup() {
    super.initializeTest(
      this.politicalPartyService,
      this.animaniacsParty,
      this.parties
    )
  }
}