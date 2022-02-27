package com.violabs.apollo.domain.nodes

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class PoliticalParty(
  @Id @GeneratedValue val id: Long? = null,
  var name: String? = null,
  var affiliation: String? = null,
  var wikiLink: String? = null
)