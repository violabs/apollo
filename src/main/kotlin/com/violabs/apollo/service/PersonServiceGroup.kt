package com.violabs.apollo.service

import com.violabs.apollo.domain.Person
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PersonRepository : ReactiveNeo4jRepository<Person, Long>

@Service
class PersonService(private val repo: PersonRepository) {
  fun findById(id: Long): Mono<Person> {
    return repo.findById(id)
  }

  fun findAll(): Flux<Person> {
    return repo.findAll()
  }
}