package com.violabs.apollo.domain.relationships

import com.violabs.apollo.domain.DateRange
import com.violabs.apollo.domain.nodes.GovernmentRole
import org.springframework.data.neo4j.core.schema.*

@RelationshipProperties
data class HeldTitleRelationship(
  @RelationshipId var id: Long? = null,
  @TargetNode var title: GovernmentRole? = null,
  var startDate: String? = null,
  var endDate: String? = null,
  var timespan: String? = null,
  var timespans: List<DateRange>? = null,
  var changeReason: String? = null
)