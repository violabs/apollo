package com.violabs.apollo.service

import com.violabs.apollo.KSpock
import com.violabs.apollo.domain.nodes.PoliticalParty
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.test.StepVerifier

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
class PoliticalPartyIntegrationTest : KSpock() {
  @Autowired
  private lateinit var politicalPartyService: PoliticalPartyService

  private val animaniacsParty = PoliticalParty(name = "American Freedom Pool", affiliation = "US")
  private val falloutParty = PoliticalParty(name = "Free Watoga People's", affiliation = "US")
  private val illuminatusParty = PoliticalParty(name = "God's Lightning", affiliation = "US")
  private val corpoParty = PoliticalParty(name = "Corporatist", affiliation = "US")

  private val parties = setOf(animaniacsParty, falloutParty, illuminatusParty, corpoParty)

  private val expectedNames = arrayOf(
    "American Freedom Pool",
    "Free Watoga People's",
    "God's Lightning",
    "Corporatist"
  )

  @AfterEach
  fun teardown() {
    politicalPartyService.deleteAll()
  }

  @Test
  fun `findById works`() = testMono<PoliticalParty> {
    val expected: PoliticalParty? =
      politicalPartyService
        .saveAll(parties)
        .blockLast()

    whenever { politicalPartyService.findById(expected!!.id!!) }

    then { it.checkPoliticalParty(1, expected!!.name!!) }
  }

  @Test
  fun `findAll works`() = testFlux<PoliticalParty> {
    given {
      politicalPartyService
        .saveAll(parties)
        .blockLast()
    }

    whenever { politicalPartyService.findAll() }

    then { it.checkPoliticalParty(4, *expectedNames) }
  }

  @Test
  fun `save works`() = testMono<PoliticalParty> {
    whenever { politicalPartyService.save(animaniacsParty) }

    then { it.checkPoliticalParty(1, "American Freedom Pool") }
  }

  @Test
  fun `save all works`() = testFlux<PoliticalParty> {
    whenever {
      politicalPartyService.saveAll(parties)
    }

    then { it.checkPoliticalParty(4, *expectedNames) }
  }

  @Test
  fun `existsById does not find existing`() = testMono<Boolean> {
    whenever { politicalPartyService.existsById(1L) }

    then { it.expectNext(false) }
  }

  @Test
  fun `existsById finds existing`() = testMono<Boolean> {
    val id: Long = saveForTests()

    whenever { politicalPartyService.existsById(id) }

    then { it.expectNext(true) }
  }

  @Test
  fun `deleteById does not delete if it does not exist`() = testMono<Boolean> {
    whenever { politicalPartyService.deleteById(1L) }

    then { it.expectNext(false) }
  }

  @Test
  fun `deleteById works`() = testMono<Boolean> {
    val id: Long = saveForTests()

    whenever { politicalPartyService.deleteById(id) }

    then { it.expectNext(true) }
  }

  private fun saveForTests(): Long =
    politicalPartyService
      .save(animaniacsParty)
      .block()
      ?.id
      ?: 0

  private fun StepVerifier.Step<PoliticalParty>.checkPoliticalParty(
    times: Int = 1,
    vararg expectedNames: String
  ): StepVerifier.Step<PoliticalParty> {
    (0 until times).forEach { _ ->
      this.expectNextMatches { expectedNames.contains(it.name) && it.affiliation == "US" }
    }

    return this
  }
}