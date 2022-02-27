package com.violabs.apollo.domain.relationships

import com.violabs.apollo.domain.DateRange
import com.violabs.apollo.domain.nodes.Person
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode

@RelationshipProperties
class IsPartOfRelationship(
  @Id @GeneratedValue var id: Long? = null,
  @TargetNode var person: Person? = null,
  var timespans: List<DateRange>? = null
)