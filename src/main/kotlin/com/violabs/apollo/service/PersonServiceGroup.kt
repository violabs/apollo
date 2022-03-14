package com.violabs.apollo.service

import com.violabs.apollo.domain.nodes.Person
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

interface PersonRepository : ReactiveNeo4jRepository<Person, Long> {
  fun findByName(name: String): Flux<Person>
}

@Service
class PersonService(private val repository: PersonRepository) :
  DefaultService<Person>,
  MainDefaultService<Person>(repository) {
    fun findByName(name: String): Flux<Person> = repository.findByName(name)
  }