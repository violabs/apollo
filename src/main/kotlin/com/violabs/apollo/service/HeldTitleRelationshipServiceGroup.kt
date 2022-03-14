package com.violabs.apollo.service

import com.violabs.apollo.domain.relationships.HeldTitleRelationship
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service

interface HeldTitleRelationshipRepository : ReactiveNeo4jRepository<HeldTitleRelationship, Long>

@Service
class HeldTitleRelationshipService(repo: HeldTitleRelationshipRepository) :
  DefaultService<HeldTitleRelationship>,
  MainDefaultService<HeldTitleRelationship>(repo)