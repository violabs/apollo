package com.violabs.apollo.domain.nodes

import com.violabs.apollo.domain.relationships.Relationships
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Person(
  @Id @GeneratedValue var id: Long? = null,
  var name: String? = null,
  @Relationship(type = Relationships.HELD_TITLE, direction = Relationship.Direction.OUTGOING)
  val governmentRoles: Set<GovernmentRole>? = null,
  @Relationship(type = Relationships.IS_PART_OF, direction = Relationship.Direction.INCOMING)
  var birth: String? = null,
  var death: String? = null,
  var wikiLink: String? = null
)