package com.violabs.apollo.service

import com.violabs.apollo.domain.nodes.GovernmentRole
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
class GovernmentRoleServiceIntegrationTest : StandardServiceIntegrationTest<GovernmentRole, GovernmentRoleService>() {
  @Autowired
  private lateinit var governmentRoleService: GovernmentRoleService

  private val captainRole = GovernmentRole(name = "Captain")
  private val firstMateRole = GovernmentRole(name = "First Mate")
  private val quarterMasterRole = GovernmentRole(name = "Quartermaster")
  private val boatswainRole = GovernmentRole(name = "Boatswain")

  private val roles = setOf(captainRole, firstMateRole, quarterMasterRole, boatswainRole)

  @BeforeEach
  fun setup() {
    super.initializeTest(
      this.governmentRoleService,
      this.boatswainRole,
      this.roles
    )
  }
}