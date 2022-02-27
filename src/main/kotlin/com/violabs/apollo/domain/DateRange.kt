package com.violabs.apollo.domain

import java.time.LocalDate

class DateRange(var startDate: LocalDate, var endDate: LocalDate) {
  fun component1(): LocalDate = startDate
  fun component2(): LocalDate = endDate
}