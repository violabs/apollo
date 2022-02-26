package com.violabs.apollo.domain.relationships

import com.violabs.apollo.domain.Person
import org.springframework.data.neo4j.core.schema.*

@RelationshipProperties
class HeldTitleRelationship(
  @Id @GeneratedValue var id: Long? = null,
  @TargetNode var person: Person? = null,
  var startDate: String? = null,
  var endDate: String? = null,
  var timespan: String? = null,
  var changeReason: String? = null
)