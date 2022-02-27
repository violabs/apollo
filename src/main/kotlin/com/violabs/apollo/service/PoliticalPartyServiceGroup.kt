package com.violabs.apollo.service

import com.violabs.apollo.domain.nodes.PoliticalParty
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service

interface PoliticalPartyRepository : ReactiveNeo4jRepository<PoliticalParty, Long>

@Service
class PoliticalPartyService(politicalPartyRepository: PoliticalPartyRepository) :
  DefaultService<PoliticalParty>,
  MainDefaultService<PoliticalParty>(politicalPartyRepository)