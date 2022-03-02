package com.violabs.apollo.domain.nodes

import com.violabs.apollo.domain.NodeEntity
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class PoliticalParty(
  var name: String? = null,
  var affiliation: String? = null,
  var wikiLink: String? = null
) : NodeEntity {
  @Id @GeneratedValue override var id: Long? = null
}