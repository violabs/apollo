package com.violabs.apollo.service

import com.violabs.apollo.domain.Person
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service

interface PersonRepository : ReactiveNeo4jRepository<Person, Long>

@Service
class PersonService(repo: PersonRepository) :
  DefaultService<Person>,
  MainDefaultService<Person>(repo)