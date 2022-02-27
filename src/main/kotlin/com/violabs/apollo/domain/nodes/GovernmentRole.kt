package com.violabs.apollo.domain.nodes

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class GovernmentRole(
  @Id @GeneratedValue var id: Long? = null,
  var name: String? = null,
  var wikiLink: String? = null
)