package com.violabs.apollo.service

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DefaultService<T> {
  fun findById(id: Long): Mono<T>
  fun findAll(): Flux<T>
  fun <S : T> save(node: S?): Mono<S>
  fun <S : T> saveAll(nodes: Set<S>): Flux<S>
  fun existsById(id: Long): Mono<Boolean>
  fun deleteAll()
  fun deleteById(id: Long): Mono<Boolean>
}

abstract class MainDefaultService<T>(protected val baseRepo: ReactiveNeo4jRepository<T, Long>) {
  fun findById(id: Long): Mono<T> = baseRepo.findById(id)
  fun findAll(): Flux<T> = baseRepo.findAll()

  fun <S : T> save(node: S?): Mono<S> =
    node
      ?.let(baseRepo::save)
      ?: Mono.empty()

  fun <S : T> saveAll(nodes: Set<S>): Flux<S> =
    Flux
      .fromIterable(nodes)
      .let(baseRepo::saveAll)

  fun existsById(id: Long): Mono<Boolean> = baseRepo.existsById(id)

  fun deleteAll() {
    baseRepo
      .deleteAll()
      .block()
  }

  fun deleteById(id: Long): Mono<Boolean> =
    baseRepo
      .existsById(id)
      .flatMap { this.deleteAndCheck(id, it) }

  private fun deleteAndCheck(id: Long, check: Boolean): Mono<Boolean> {
    if (!check) return Mono.just(false)

    return baseRepo
      .deleteById(id)
      .then(checkEntityDoesNotExistById(id))
  }

  private fun checkEntityDoesNotExistById(id: Long): Mono<Boolean> =
    baseRepo
      .existsById(id)
      .map(Boolean::not)
}