package com.violabs.apollo.controller

import com.violabs.apollo.domain.Person
import com.violabs.apollo.service.PersonService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/people")
class PersonController(personService: PersonService) :
  DefaultController<Person>(personService)