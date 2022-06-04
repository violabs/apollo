package com.violabs.apollo.service

import com.violabs.apollo.KSpock
import com.violabs.apollo.domain.nodes.GovernmentRole
import com.violabs.apollo.domain.nodes.Person
import com.violabs.apollo.domain.relationships.HeldTitleRelationship
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
class HeldTitleRelationshipServiceIntegrationTest : KSpock() {
  @Autowired
  private lateinit var personService: PersonService

  @Autowired
  private lateinit var governmentRoleService: GovernmentRoleService

  private final val presidentOfTheGalaxy = GovernmentRole(name = "President of the Galaxy")
  private final val chancellorOfMars = GovernmentRole(name = "Chancellor of Mars")

  private final val presidentHeldRelationship = HeldTitleRelationship(
    title = presidentOfTheGalaxy,
    startDate = "now"
  )

  private final val chancellorHeldRelationship = HeldTitleRelationship(
    title = chancellorOfMars,
    startDate = "1964"
  )

  private final val freshnessTheIncarnate = Person(
    name = "Freshness the Incarnate",
    governmentRoles = setOf(presidentHeldRelationship)
  )

  private final val xxooiiooxx = Person(
    name = "XxOoIIoOxX",
    governmentRoles = setOf(chancellorHeldRelationship)
  )

  private final val people = setOf(freshnessTheIncarnate, xxooiiooxx)

  @BeforeEach
  fun setup() {
    personService.deleteAll()
    governmentRoleService.deleteAll()
  }

  @Test
  fun `saving the relationship works correctly`() = testFlux<Person> {
    personService
      .saveAll(people)
      .blockLast()

    whenever {
      personService.findByName(freshnessTheIncarnate.name!!)
    }

    then { stepVerifier ->
      stepVerifier.expectNextMatches {
        val expectedRelationship: HeldTitleRelationship = freshnessTheIncarnate.governmentRoles!!.first()
        val actualRelationship: HeldTitleRelationship = it.governmentRoles!!.first()

        freshnessTheIncarnate.name == it.name &&
        expectedRelationship.startDate == actualRelationship.startDate &&
        expectedRelationship.title!!.name == actualRelationship.title!!.name
      }
    }
  }
}