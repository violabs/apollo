package com.violabs.apollo.controller

import com.violabs.apollo.domain.Person
import com.violabs.apollo.service.PersonService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("api/people")
class PersonController(private val personService: PersonService) {

  @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE])
  fun fetchAllPeople(): Flux<Person> = personService.findAll()
}