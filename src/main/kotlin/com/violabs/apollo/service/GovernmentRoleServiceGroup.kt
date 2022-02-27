package com.violabs.apollo.service

import com.violabs.apollo.domain.nodes.GovernmentRole
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service

interface GovernmentRoleRepository : ReactiveNeo4jRepository<GovernmentRole, Long>

@Service
class GovernmentRoleService(repo: GovernmentRoleRepository) :
  DefaultService<GovernmentRole>,
  MainDefaultService<GovernmentRole>(repo)